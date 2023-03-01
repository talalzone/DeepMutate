// Generated from java-escape by ANTLR 4.11.1
package io.zenmake.deepmutate.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DeepMutateParser}.
 */
public interface DeepMutateParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(DeepMutateParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(DeepMutateParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#projectDecl}.
	 * @param ctx the parse tree
	 */
	void enterProjectDecl(DeepMutateParser.ProjectDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#projectDecl}.
	 * @param ctx the parse tree
	 */
	void exitProjectDecl(DeepMutateParser.ProjectDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(DeepMutateParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(DeepMutateParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#mutationDecl}.
	 * @param ctx the parse tree
	 */
	void enterMutationDecl(DeepMutateParser.MutationDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#mutationDecl}.
	 * @param ctx the parse tree
	 */
	void exitMutationDecl(DeepMutateParser.MutationDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#matchStmt}.
	 * @param ctx the parse tree
	 */
	void enterMatchStmt(DeepMutateParser.MatchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#matchStmt}.
	 * @param ctx the parse tree
	 */
	void exitMatchStmt(DeepMutateParser.MatchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#whereStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhereStmt(DeepMutateParser.WhereStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#whereStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhereStmt(DeepMutateParser.WhereStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#setStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetStmt(DeepMutateParser.SetStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#setStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetStmt(DeepMutateParser.SetStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#insertStmt}.
	 * @param ctx the parse tree
	 */
	void enterInsertStmt(DeepMutateParser.InsertStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#insertStmt}.
	 * @param ctx the parse tree
	 */
	void exitInsertStmt(DeepMutateParser.InsertStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#functionId}.
	 * @param ctx the parse tree
	 */
	void enterFunctionId(DeepMutateParser.FunctionIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#functionId}.
	 * @param ctx the parse tree
	 */
	void exitFunctionId(DeepMutateParser.FunctionIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#mutationId}.
	 * @param ctx the parse tree
	 */
	void enterMutationId(DeepMutateParser.MutationIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#mutationId}.
	 * @param ctx the parse tree
	 */
	void exitMutationId(DeepMutateParser.MutationIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(DeepMutateParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(DeepMutateParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by the {@code consoleInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 */
	void enterConsoleInputConf(DeepMutateParser.ConsoleInputConfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code consoleInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 */
	void exitConsoleInputConf(DeepMutateParser.ConsoleInputConfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codeInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 */
	void enterCodeInputConf(DeepMutateParser.CodeInputConfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codeInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 */
	void exitCodeInputConf(DeepMutateParser.CodeInputConfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fileInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 */
	void enterFileInputConf(DeepMutateParser.FileInputConfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fileInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 */
	void exitFileInputConf(DeepMutateParser.FileInputConfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dirInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 */
	void enterDirInputConf(DeepMutateParser.DirInputConfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dirInputConf}
	 * labeled alternative in {@link DeepMutateParser#inputConf}.
	 * @param ctx the parse tree
	 */
	void exitDirInputConf(DeepMutateParser.DirInputConfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#projectConf}.
	 * @param ctx the parse tree
	 */
	void enterProjectConf(DeepMutateParser.ProjectConfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#projectConf}.
	 * @param ctx the parse tree
	 */
	void exitProjectConf(DeepMutateParser.ProjectConfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#outputConf}.
	 * @param ctx the parse tree
	 */
	void enterOutputConf(DeepMutateParser.OutputConfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#outputConf}.
	 * @param ctx the parse tree
	 */
	void exitOutputConf(DeepMutateParser.OutputConfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#mutationConf}.
	 * @param ctx the parse tree
	 */
	void enterMutationConf(DeepMutateParser.MutationConfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#mutationConf}.
	 * @param ctx the parse tree
	 */
	void exitMutationConf(DeepMutateParser.MutationConfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#conf}.
	 * @param ctx the parse tree
	 */
	void enterConf(DeepMutateParser.ConfContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#conf}.
	 * @param ctx the parse tree
	 */
	void exitConf(DeepMutateParser.ConfContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeepMutateParser#strList}.
	 * @param ctx the parse tree
	 */
	void enterStrList(DeepMutateParser.StrListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeepMutateParser#strList}.
	 * @param ctx the parse tree
	 */
	void exitStrList(DeepMutateParser.StrListContext ctx);
}