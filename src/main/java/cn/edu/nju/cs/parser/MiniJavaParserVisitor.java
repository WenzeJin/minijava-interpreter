// Generated from MiniJavaParser.g4 by ANTLR 4.13.2
package cn.edu.nju.cs.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(MiniJavaParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MiniJavaParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(MiniJavaParser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(MiniJavaParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx);
}