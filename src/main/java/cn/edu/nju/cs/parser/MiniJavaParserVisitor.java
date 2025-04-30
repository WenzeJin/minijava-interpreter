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
	 * Visit a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parentClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentClassDeclaration(MiniJavaParser.ParentClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(MiniJavaParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDeclaration(MiniJavaParser.ClassBodyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDeclaration(MiniJavaParser.FieldDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(MiniJavaParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(MiniJavaParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(MiniJavaParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitializer(MiniJavaParser.ArrayInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(MiniJavaParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(MiniJavaParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(MiniJavaParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MiniJavaParser.LiteralContext ctx);
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
	 * Visit a parse tree produced by {@link MiniJavaParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MiniJavaParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(MiniJavaParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(MiniJavaParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(MiniJavaParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(MiniJavaParser.ExpressionListContext ctx);
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
	 * Visit a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreator(MiniJavaParser.CreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#createdName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatedName(MiniJavaParser.CreatedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#classCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassCreatorRest(MiniJavaParser.ClassCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreatorRest(MiniJavaParser.ArrayCreatorRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#typeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeType(MiniJavaParser.TypeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(MiniJavaParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(MiniJavaParser.ArgumentsContext ctx);
}