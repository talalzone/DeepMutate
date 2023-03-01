// Generated from java-escape by ANTLR 4.11.1
package io.zenmake.deepmutate.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DeepMutateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DeepMutateParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(DeepMutateParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#projectDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjectDecl(DeepMutateParser.ProjectDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(DeepMutateParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#mutationDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMutationDecl(DeepMutateParser.MutationDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#matchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchStmt(DeepMutateParser.MatchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#whereStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereStmt(DeepMutateParser.WhereStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#setStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetStmt(DeepMutateParser.SetStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#insertStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStmt(DeepMutateParser.InsertStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#functionId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionId(DeepMutateParser.FunctionIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#mutationId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMutationId(DeepMutateParser.MutationIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#pattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPattern(DeepMutateParser.PatternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code consoleInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsoleInputConf(DeepMutateParser.ConsoleInputConfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code codeInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeInputConf(DeepMutateParser.CodeInputConfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fileInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileInputConf(DeepMutateParser.FileInputConfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dirInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirInputConf(DeepMutateParser.DirInputConfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#projectConf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjectConf(DeepMutateParser.ProjectConfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#outputConf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutputConf(DeepMutateParser.OutputConfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#mutationConf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMutationConf(DeepMutateParser.MutationConfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#conf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConf(DeepMutateParser.ConfContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeepMutateParser#strList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrList(DeepMutateParser.StrListContext ctx);
}