// Generated from C:/Users/Moises/Desktop/UNIVERSIDAD/TERCERO/2 CUATRIMESTRE/DLP/Laboratorio/DLP_Proyecto_UO270824/src/parser\Pmm.g4 by ANTLR 4.9.1
package parser;

import ast.*;
import errorhandler.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PmmParser}.
 */
public interface PmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(PmmParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void enterMainFunction(PmmParser.MainFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#mainFunction}.
	 * @param ctx the parse tree
	 */
	void exitMainFunction(PmmParser.MainFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(PmmParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(PmmParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(PmmParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(PmmParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(PmmParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(PmmParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#ids}.
	 * @param ctx the parse tree
	 */
	void enterIds(PmmParser.IdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#ids}.
	 * @param ctx the parse tree
	 */
	void exitIds(PmmParser.IdsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void enterFunctionInvocation(PmmParser.FunctionInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#functionInvocation}.
	 * @param ctx the parse tree
	 */
	void exitFunctionInvocation(PmmParser.FunctionInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(PmmParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(PmmParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(PmmParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(PmmParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#builtIntype}.
	 * @param ctx the parse tree
	 */
	void enterBuiltIntype(PmmParser.BuiltIntypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#builtIntype}.
	 * @param ctx the parse tree
	 */
	void exitBuiltIntype(PmmParser.BuiltIntypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#complexType}.
	 * @param ctx the parse tree
	 */
	void enterComplexType(PmmParser.ComplexTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#complexType}.
	 * @param ctx the parse tree
	 */
	void exitComplexType(PmmParser.ComplexTypeContext ctx);
}