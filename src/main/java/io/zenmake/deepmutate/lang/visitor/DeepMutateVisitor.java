package io.zenmake.deepmutate.lang.visitor;

import io.zenmake.deepmutate.gen.DeepMutateParser;
import io.zenmake.deepmutate.gen.DeepMutateParserBaseVisitor;
import io.zenmake.deepmutate.lang.types.conf.InputConf;
import io.zenmake.deepmutate.lang.types.conf.MutationConf;
import io.zenmake.deepmutate.lang.types.conf.OutputConf;
import io.zenmake.deepmutate.lang.types.conf.ProjectConf;
import io.zenmake.deepmutate.lang.types.cu.DeepMutateCU;
import io.zenmake.deepmutate.lang.types.declaration.FunctionDecl;
import io.zenmake.deepmutate.lang.types.declaration.MutationDecl;
import io.zenmake.deepmutate.lang.types.declaration.ProjectDecl;
import io.zenmake.deepmutate.lang.types.statement.InsertStmt;
import io.zenmake.deepmutate.lang.types.statement.MatchStmt;
import io.zenmake.deepmutate.lang.types.statement.UpdateStmt;
import io.zenmake.deepmutate.lang.types.statement.WhereStmt;
import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Talal Ahmed on 29/01/2023
 */
public class DeepMutateVisitor extends DeepMutateParserBaseVisitor<Object> {

    private static final Logger log = LoggerFactory.getLogger(DeepMutateVisitor.class);

    // Incremental index for generating project's input path/content id's as soon as they are visited
    private static int index;

    // DeepMutate Compilation Unit (CU)
    private final DeepMutateCU deepMutateCU;

    public DeepMutateVisitor() {
        this.deepMutateCU = new DeepMutateCU();
    }


    @Override
    public Object visitParse(DeepMutateParser.ParseContext ctx) {
        var projectDeclList = ctx.projectDecl()
                .stream()
                .map(x -> (ProjectDecl) visit(x))
                .toList();

        this.deepMutateCU.setProjectDeclList(projectDeclList);
        log.debug("DeepMutate is ready.");

        return this.deepMutateCU;
    }

    @Override
    public Object visitProjectDecl(DeepMutateParser.ProjectDeclContext ctx) {
        var inputConf = (InputConf) visit(ctx.inputConf());
        log.debug("Found input configurations: {}", inputConf);

        var projectConf = (ProjectConf) visit(ctx.projectConf());
        log.debug("Found project configurations: {} ", projectConf);

        var outputConf = (OutputConf) visit(ctx.outputConf());
        log.debug("Found output configurations: {} ", outputConf);

        var funcList = ctx.functionDecl().stream().map(fn -> (FunctionDecl) visit(fn)).toList();
        log.debug("Found '{}' mutation functions.", funcList.size());

        var projectDecl = new ProjectDecl();
        projectDecl.setInputConf(inputConf);
        projectDecl.setProjectConf(projectConf);
        projectDecl.setOutputConf(outputConf);
        projectDecl.setFunctionDeclList(funcList);

        return projectDecl;
    }

    @Override
    public Object visitConsoleInputConf(DeepMutateParser.ConsoleInputConfContext ctx) {
        var type = ctx.type.getText();
        var contents = new ArrayList<String>(); // Code content will be read at a later phase

        var contentMap = contents.stream().collect(Collectors.toMap(x -> generateId(type), Function.identity()));

        var conf = new InputConf();
        conf.addType(type);
        conf.addContent(contentMap);

        return conf;
    }

    @Override
    public Object visitCodeInputConf(DeepMutateParser.CodeInputConfContext ctx) {
        var type = ctx.type.getText();
        var contents = notNull(ctx.val)
                ? List.of(ctx.val.getText())
                : (List<String>) visit(ctx.strList());

        var contentMap = contents.stream().collect(Collectors.toMap(x -> generateId(type), Function.identity()));

        var conf = new InputConf();
        conf.addType(type);
        conf.addContent(contentMap);

        return conf;
    }

    @Override
    public Object visitFileInputConf(DeepMutateParser.FileInputConfContext ctx) {
        var type = ctx.type.getText();
        var paths = notNull(ctx.val)
                ? List.of(ctx.val.getText())
                : (List<String>) visit(ctx.strList());

        var contentMap = paths.stream().collect(Collectors.toMap(x -> generateId(type), Function.identity()));

        var conf = new InputConf();
        conf.addType(type);
        conf.addContent(contentMap);

        return conf;
    }

    @Override
    public Object visitDirInputConf(DeepMutateParser.DirInputConfContext ctx) {
        var type = ctx.type.getText();
        var build = ctx.build.getText();
        var paths = notNull(ctx.val)
                ? List.of(ctx.val.getText())
                : (List<String>) visit(ctx.strList());

        var contentMap = paths.stream().collect(Collectors.toMap(x -> generateId(type), Function.identity()));

        var conf = new InputConf();
        conf.addType(type);
        conf.addBuild(build);
        conf.addContent(contentMap);

        return conf;
    }

    @Override
    public Object visitProjectConf(DeepMutateParser.ProjectConfContext ctx) {
        var confList = (List) ctx.conf()
                .stream()
                .map(this::visit)
                .toList();

        var projectConf = new ProjectConf();
        projectConf.add(confList);

        return projectConf;
    }

    @Override
    public Object visitOutputConf(DeepMutateParser.OutputConfContext ctx) {
        var confList = (List) ctx.conf()
                .stream()
                .map(this::visit)
                .toList();

        var outputConf = new OutputConf();
        outputConf.add(confList);

        return outputConf;
    }

    @Override
    public Object visitFunctionDecl(DeepMutateParser.FunctionDeclContext ctx) {
        var funcId = (String) visit(ctx.functionId());
        var declList = ctx.mutationDecl()
                .stream()
                .map(x -> (MutationDecl) visit(x))
                .toList();

        var decl = new FunctionDecl();
        decl.setFuncId(funcId);
        decl.setMutationDeclList(declList);

        return decl;
    }

    @Override
    public Object visitMutationDecl(DeepMutateParser.MutationDeclContext ctx) {
        var id = notNull(ctx.mutationId()) ? (String) visit(ctx.mutationId()) : null;
        var conf = notNull(ctx.mutationConf()) ? (MutationConf) visit(ctx.mutationConf()) : null;
        var matchStmt = notNull(ctx.matchStmt()) ? (MatchStmt) visit(ctx.matchStmt()) : null;
        var whereStmt = notNull(ctx.whereStmt()) ? (WhereStmt) visit(ctx.whereStmt()) : null;
        var updateStmtList = notNull(ctx.setStmt()) ? ctx.setStmt().stream().map(x -> (UpdateStmt) visit(x)).toList() : null;
        var insertStmtList = notNull(ctx.insertStmt()) ? ctx.insertStmt().stream().map(x -> (InsertStmt) visit(x)).toList() : null;

        var decl = new MutationDecl();
        decl.setId(id);
        decl.setConf(conf);
        decl.setMatchStmt(matchStmt);
        decl.setWhereStmt(whereStmt);
        decl.setUpdateStmtList(updateStmtList);
        decl.setInsertStatementList(insertStmtList);

        return decl;
    }

    @Override
    public Object visitMutationConf(DeepMutateParser.MutationConfContext ctx) {
        var confList = (List) ctx.conf()
                .stream()
                .map(this::visit)
                .toList();

        var mutationConf = new MutationConf();
        mutationConf.add(confList);

        return mutationConf;
    }

    @Override
    public Object visitMatchStmt(DeepMutateParser.MatchStmtContext ctx) {
        var pattern = (String) visit(ctx.pattern());
        var stmt = new MatchStmt(pattern);
        return stmt;
    }

    @Override
    public Object visitWhereStmt(DeepMutateParser.WhereStmtContext ctx) {
        var pattern = (String) visit(ctx.pattern());
        var stmt = new WhereStmt(pattern);
        return stmt;
    }

    @Override
    public Object visitSetStmt(DeepMutateParser.SetStmtContext ctx) {
        var pattern = (String) visit(ctx.pattern());
        var stmt = new UpdateStmt(pattern); // Calling 'set' as 'UpdateStatement'
        return stmt;
    }

    @Override
    public Object visitInsertStmt(DeepMutateParser.InsertStmtContext ctx) {
        var pattern = (String) visit(ctx.pattern());
        var stmt = new InsertStmt(pattern);
        return stmt;
    }

    @Override
    public Object visitMutationId(DeepMutateParser.MutationIdContext ctx) {
        var id = ctx.getText();
        return id;
    }

    @Override
    public Object visitFunctionId(DeepMutateParser.FunctionIdContext ctx) {
        var id = ctx.getText();
        return id;
    }

    @Override
    public Object visitPattern(DeepMutateParser.PatternContext ctx) {
        var pattern = ctx.getText();
        return pattern;
    }

    @Override
    public Object visitConf(DeepMutateParser.ConfContext ctx) {
        var key = ctx.key.getText();
        var value = ctx.val.getText();
        return Map.of(key, value);
    }

    @Override
    public Object visitStrList(DeepMutateParser.StrListContext ctx) {
        var list = ctx.list.stream().map(Token::getText).toList();
        return list;
    }

    private static String generateId(String type) {
        return type + "-" + index++;
    }

    private static boolean notNull(Object o) {
        return o != null;
    }

}
