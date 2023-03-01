package io.zenmake.deepmutate.plugins.lang.java.mutate.semantic;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.nodeTypes.NodeWithSimpleName;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import io.zenmake.deepmutate.lang.types.declaration.FunctionDecl;
import io.zenmake.deepmutate.lang.types.declaration.ProjectDecl;
import io.zenmake.deepmutate.plugins.common.interfaces.InputReader;
import io.zenmake.deepmutate.plugins.common.interfaces.MutationWriter;
import io.zenmake.deepmutate.plugins.common.interfaces.Mutator;
import io.zenmake.deepmutate.plugins.common.model.Codebase;
import io.zenmake.deepmutate.plugins.common.model.Mutation;
import io.zenmake.deepmutate.plugins.lang.java.domain.ast.JavaNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Talal Ahmed on 29/01/2023
 */
public class SemanticMutator implements Mutator {

    private static final Logger log = LoggerFactory.getLogger(SemanticMutator.class);

    private static final String MUTATION_TYPE_SEMANTIC = "semantic";

    // Added for the sake of code completeness, so parser can parse
    private static final String MUTATION_CLOSURE_CLASS_NAME = "_x_MutationClosureClass";
    private static final String MUTATION_CLOSURE_METHOD_NAME = "_x_Method";
    private static final String MUTATION_CLOSURE_FORMAT = "class " + MUTATION_CLOSURE_CLASS_NAME + " {" + " void " + MUTATION_CLOSURE_METHOD_NAME + "() { %s } }";

    private static final String DEFAULT_SKIP_NODE_PREFIX = "_x_";

    private record MatchStmtAst(String stmt, CompilationUnit ast, List<JavaNode> nodes) {
    }

    private record UpdateStmtAst(String stmt, CompilationUnit ast, List<JavaNode> nodes) {
    }

    private record WhereStmtAst(String stmt, CompilationUnit ast, List<JavaNode> nodes) {
    }

    private record InsertStmtAst(String stmt, CompilationUnit ast, List<JavaNode> nodes) {
    }

    private record MutationStmtAst(String id,
                                   MatchStmtAst matchStmtAst,
                                   List<UpdateStmtAst> updateStmtAsts,
                                   List<InsertStmtAst> insertStmtAsts,
                                   WhereStmtAst whereStmtAst) {
    }

    private final InputReader reader;
    private final MutationWriter writer;

    private SemanticMutator(InputReader reader, MutationWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static SemanticMutator create(InputReader reader, MutationWriter writer) {
        return new SemanticMutator(reader, writer);
    }

    @Override
    public void mutate(ProjectDecl project) {
        // Initialize mutations: parse and create ASTs, flattened ASTs etc
        var mutationStmtAsts = compile(project.getFunctionDeclList());

        // Iterate on codebase
        for (Codebase codebase : reader) {
            log.debug("Searching patterns in: {}", codebase.getFilePath());

            // Fetch input (code class) and create AST
            var inputAst = parse(codebase.getContent());

            // Apply mutations to each input AST
            for (var stmt : mutationStmtAsts) {
                log.debug("Matching mutation pattern: {}", stmt.id());

                // Taking first node to be the parent node for pattern matching of input AST
                var matchParentNode = stmt.matchStmtAst().nodes().get(0).getClazz();
                var matchedPatterns = inputAst.findAll(matchParentNode, Node.TreeTraversal.PREORDER);

                log.debug("Matched '{}' pattern instances in input AST", matchedPatterns.size());

                for (var matchedPattern : matchedPatterns) {
                    // Flatten matched pattern AST: this creates a list of all child nodes
                    var matchedNodes = new ArrayList<JavaNode>();
                    ((Node) matchedPattern).walk(Node.TreeTraversal.PREORDER, node -> matchedNodes.add(JavaNode.from(node)));

                    // Compare matched nodes with mutation's nodes and replace with update statement nodes
                    var index = Collections.indexOfSubList(matchedNodes, stmt.matchStmtAst.nodes);
                    if (index != -1) {
                        var subNodeList = matchedNodes.subList(index, stmt.matchStmtAst.nodes.size());
                        // Perform updates
                        for (var update : stmt.updateStmtAsts) {
                            for (int i = 0; i < Math.min(subNodeList.size(), update.nodes.size()); i++) {
                                var src = subNodeList.get(i).getNode();
                                var target = update.nodes.get(i).getNode();

                                keepVarNames(src, target);
                                src.replace(target);
                            }

                            // Create & Write mutation
                            var mData = createMutation(codebase, stmt, inputAst, matchedNodes.get(0));
                            writer.write(mData);

                            log.debug("Generated: {}", mData);
                        }
                    }
                }
            }
        }

        writer.close();
    }

    private ArrayList<MutationStmtAst> compile(List<FunctionDecl> functionDeclList) {
        var mutationAsts = new ArrayList<MutationStmtAst>();

        for (var fn : functionDeclList) {
            log.debug("Using mutation function: {}", fn.getFuncId());

            for (int i = 0; i < fn.getMutationDeclList().size(); i++) {
                var decl = fn.getMutationDeclList().get(i);

                // Take declarator function with mutation statement# as name if identifier is not provided
                var mutationId = decl.getId() != null ? decl.getId() : fn.getFuncId() + "_" + i;

                if (!decl.getConf().isActive()) {
                    log.debug("Skipping mutation: {}", mutationId);
                } else {
                    log.debug("Compiling mutation: {}", mutationId);

                    var matchPattern = decl.getMatchStmt().getPattern();
                    var matchPatternAst = parse(String.format(MUTATION_CLOSURE_FORMAT, matchPattern));
                    var matchPatternNodes = flattenAst(matchPatternAst);
                    var match = new MatchStmtAst(matchPattern, matchPatternAst, matchPatternNodes);

                    var updates = decl.getUpdateStmtList()
                            .stream()
                            .map(x -> {
                                var updatePattern = x.getPattern();
                                var updatePatternAst = parse(String.format(MUTATION_CLOSURE_FORMAT, updatePattern));
                                var updatePatternNodes = flattenAst(updatePatternAst);
                                return new UpdateStmtAst(x.getPattern(), updatePatternAst, updatePatternNodes);
                            })
                            .toList();

                    // TODO: handle insert statements
                    var inserts = decl.getInsertStmtList()
                            .stream()
                            .map(x -> {
                                var insertPattern = x.getPattern();
                                var insertPatternAst = parse(String.format(MUTATION_CLOSURE_FORMAT, insertPattern));
                                var insertPatternNodes = flattenAst(insertPatternAst);
                                return new InsertStmtAst(insertPattern, insertPatternAst, insertPatternNodes);
                            })
                            .toList();

                    // TODO: Handle where statement
                    WhereStmtAst where = null;
                    if (decl.getWhereStmt() != null) {
                        var wherePattern = decl.getWhereStmt().getPattern();
                        var wherePatternAst = parse(String.format(MUTATION_CLOSURE_FORMAT, wherePattern));
                        var wherePatternNodes = flattenAst(wherePatternAst);
                        where = new WhereStmtAst(decl.getWhereStmt().getPattern(), wherePatternAst, wherePatternNodes);
                    }

                    var mutation = new MutationStmtAst(decl.getId(), match, updates, inserts, where);
                    mutationAsts.add(mutation);
                }
            }
        }

        return mutationAsts;
    }

    private CompilationUnit parse(String code) {
        var typeSolver = new CombinedTypeSolver(new ReflectionTypeSolver());
        var symbolSolver = new JavaSymbolSolver(typeSolver);

        StaticJavaParser.getParserConfiguration().setSymbolResolver(symbolSolver);

        return StaticJavaParser.parse(code);
    }

    private List<JavaNode> flattenAst(CompilationUnit cu) {
        var flattened = new ArrayList<JavaNode>();

        // Walk AST, create a linear node list and skip certain nodes having name prefix '_x_' (default)
        cu.walk(Node.TreeTraversal.PREORDER, node -> {
            if (node instanceof CompilationUnit x) {
                log.debug("Skipping AST node: {} ", x);
            } else if (node instanceof NodeWithSimpleName<?> x) {
                skipOrAdd(x.getNameAsString(), node, flattened);
            } else if (node instanceof SimpleName x) {
                skipOrAdd(x.getId(), node, flattened);
            } else if (node.getParentNode().isPresent() && node.getParentNode().get() instanceof NodeWithSimpleName<?> x) {
                skipOrAdd(x.getNameAsString(), node, flattened);
            } else {
                flattened.add(JavaNode.from(node));
            }
        });

        return flattened;
    }

    private void skipOrAdd(String name, Node node, ArrayList<JavaNode> flattened) {
        if (name.startsWith(DEFAULT_SKIP_NODE_PREFIX)) {
            log.debug("Skipping AST node: {} ", name);
        } else {
            flattened.add(JavaNode.from(node));
        }
    }

    private void keepVarNames(Node src, Node target) {
        if (src instanceof VariableDeclarator x && target instanceof VariableDeclarator y) {
            y.setName(x.getName());
        } else if (src instanceof SimpleName x && target instanceof SimpleName y) {
            y.setId(x.getId());
        }
    }

    private Mutation createMutation(Codebase codebase, MutationStmtAst stmt, CompilationUnit mutatedAst, JavaNode mutatedRootNode) {
        var m = new Mutation();

        m.setId(null); // ID to be auto generated
        m.setMutationId(stmt.id);
        m.setCodebaseId(codebase.getId());
        m.setInputType(codebase.getType());
        m.setMutationType(MUTATION_TYPE_SEMANTIC);

        var sourceCode = Codebase.from(codebase, codebase.getContent());
        m.setSourceCode(sourceCode);

        var mutatedCode = Codebase.from(codebase, mutatedAst.toString());
        m.setMutatedCode(mutatedCode);

        var line = mutatedRootNode.getNode().getRange().get().begin.line; //TODO: add range instead
        m.setLine(line);

        var match = stmt.matchStmtAst.stmt;
        var where = stmt.whereStmtAst != null ? stmt.whereStmtAst.stmt : null;
        var updates = stmt.updateStmtAsts.stream().map(x -> x.stmt).toList();
        var inserts = stmt.insertStmtAsts.stream().map(x -> x.stmt).toList();

        var pattern = new Mutation.Pattern(match, where, updates, inserts);
        m.setPattern(pattern);

        m.setStatus(Mutation.STATUS_MUTATION_COMPLETE);

        return m;
    }
}
