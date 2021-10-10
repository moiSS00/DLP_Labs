package visitor;

import ast.*;
import ast.FunctDefinition;
import ast.VarDefinition;
import errorhandler.ErrorType;

public interface Visitor {
    Object visit(Program program, Object param);
    Object visit(VarDefinition varDefinition, Object param);
    Object visit(FunctDefinition functDefinition, Object param);
    Object visit(While w, Object param);
    Object visit(Conditional conditional, Object param);
    Object visit(Assignment assignment, Object param);
    Object visit(Print print, Object param);
    Object visit(Input input, Object param);
    Object visit(Return r, Object param);
    Object visit(Arithmetic arithmetic, Object param);
    Object visit(LogicalCondition logicalCondition, Object param);
    Object visit(BooleanCondition booleanCondition, Object param);
    Object visit(UnaryMinus unaryMinus, Object param);
    Object visit(Negation negation, Object param);
    Object visit(Cast cast, Object param);
    Object visit(ArrayAccess arrayAccess, Object param);
    Object visit(FieldAccess fieldAccess, Object param);
    Object visit(Variable variable, Object param);
    Object visit(IntLiteral intLiteral, Object param);
    Object visit(DoubleLiteral doubleLiteral, Object param);
    Object visit(CharLiteral charLiteral, Object param);
    Object visit(FunctInvocation functInvocation, Object param);
    Object visit(IntType intType, Object param);
    Object visit(DoubleType doubleType, Object param);
    Object visit(CharType charType, Object param);
    Object visit(ArrayType arrayType, Object param);
    Object visit(VoidType voidType, Object param);
    Object visit(StructType structType, Object param);
    Object visit(RecordField recordField, Object param);
    Object visit(FunctType functType, Object param);
    Object visit(ErrorType errorType, Object param);
}
