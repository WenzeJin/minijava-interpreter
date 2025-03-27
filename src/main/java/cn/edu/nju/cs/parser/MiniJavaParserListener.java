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
	 * Enter a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(MiniJavaParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(MiniJavaParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(MiniJavaParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(MiniJavaParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(MiniJavaParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(MiniJavaParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(MiniJavaParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(MiniJavaParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(MiniJavaParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(MiniJavaParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(MiniJavaParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(MiniJavaParser.FormalParameterContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(MiniJavaParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(MiniJavaParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(MiniJavaParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(MiniJavaParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MiniJavaParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MiniJavaParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(MiniJavaParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(MiniJavaParser.ExpressionListContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(MiniJavaParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(MiniJavaParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#createdName}.
	 * @param ctx the parse tree
	 */
	void enterCreatedName(MiniJavaParser.CreatedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#createdName}.
	 * @param ctx the parse tree
	 */
	void exitCreatedName(MiniJavaParser.CreatedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(MiniJavaParser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(MiniJavaParser.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#typeType}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(MiniJavaParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#typeType}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(MiniJavaParser.TypeTypeContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(MiniJavaParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(MiniJavaParser.ArgumentsContext ctx);
}