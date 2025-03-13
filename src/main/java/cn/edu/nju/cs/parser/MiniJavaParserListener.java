// Generated from MiniJavaParser.g4 by ANTLR 4.13.2
package cn.edu.nju.cs.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(MiniJavaParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(MiniJavaParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MiniJavaParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MiniJavaParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MiniJavaParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MiniJavaParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx);
}