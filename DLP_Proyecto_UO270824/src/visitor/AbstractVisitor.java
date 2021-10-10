package visitor;

import ast.*;
import ast.Definition;
import ast.FunctDefinition;
import ast.VarDefinition;
import errorhandler.ErrorType;

public abstract class AbstractVisitor implements Visitor {

    @Override
    public Object visit(Program program, Object param) {
        for(Definition d : program.getDefinitions()) {
            d.accept(this, param);
        }
        return null;
    }

    @Override
    public Object visit(VarDefinition varDefinition, Object param) {
        varDefinition.getType().accept(this, param);
        return null;
    }

    @Override
    public Object visit(FunctDefinition functDefinition, Object param) {
        functDefinition.getType().accept(this, param);
        for(Statement s : functDefinition.getBody()) {
            s.accept(this, param);
        }
        return null;
    }

    @Override
    public Object visit(While w, Object param) {
        w.getCondition().accept(this, param);
        for(Statement s : w.getBody()) {
            s.accept(this, param);
        }
        return null;
    }

    @Override
    public Object visit(Conditional conditional, Object param) {
        conditional.getCondition().accept(this, param);
        for(Statement s : conditional.getIfBody()) {
            s.accept(this, param);
        }
        for(Statement s : conditional.getElseBody()){
            s.accept(this, param);
        }
        return null;
    }

    @Override
    public Object visit(Assignment assignment, Object param) {
        assignment.getLeft().accept(this, param);
        assignment.getRight().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Print print, Object param) {
        for(Expression e : print.getExpressions()) {
            e.accept(this, param);
        }
        return param;
    }

    @Override
    public Object visit(Input input, Object param) {
        for(Expression e : input.getExpressions()) {
            e.accept(this, param);
        }
        return null;
    }

    @Override
    public Object visit(Return r, Object param) {
        r.getExpression().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        arithmetic.getLeft().accept(this,param);
        arithmetic.getRight().accept(this, param);
        return null;
    }

    @Override
    public Object visit(LogicalCondition logicalCondition, Object param) {
        logicalCondition.getLeft().accept(this, param);
        logicalCondition.getRight().accept(this, param);
        return null;
    }

    @Override
    public Object visit(BooleanCondition booleanCondition, Object param) {
        booleanCondition.getLeft().accept(this, param);
        booleanCondition.getRight().accept(this, param);
        return null;
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object param) {
        unaryMinus.getExpression().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Negation negation, Object param) {
        negation.getExpression().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Cast cast, Object param) {
        cast.getExpression().accept(this, param);
        return null;
    }

    @Override
    public Object visit(ArrayAccess arrayAccess, Object param) {
        arrayAccess.getExpression().accept(this, param);
        arrayAccess.getIndex().accept(this, param);
        return null;
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.getExpression().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Variable variable, Object param) {
        variable.setType(variable.getDefinition().getType());
        return null;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        return null;
    }

    @Override
    public Object visit(DoubleLiteral doubleLiteral, Object param) {
        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object param) {
        return null;
    }

    @Override
    public Object visit(FunctInvocation functInvocation, Object param) {
        functInvocation.getVariable().accept(this, param);
        for(Expression e : functInvocation.getArguments()) {
            e.accept(this, param);
        }
        return null;
    }

    @Override
    public Object visit(IntType intType, Object param) {
        return null;
    }

    @Override
    public Object visit(DoubleType doubleType, Object param) {
        return null;
    }

    @Override
    public Object visit(CharType charType, Object param) {
        return null;
    }

    @Override
    public Object visit(ArrayType arrayType, Object param) {
        return null;
    }

    @Override
    public Object visit(VoidType voidType, Object param) {
        return null;
    }

    @Override
    public Object visit(StructType structType, Object param) {
        for(RecordField r : structType.getRecordFields()) {
            r.accept(this, param);
        }
        return null;
    }

    @Override
    public Object visit(RecordField recordField, Object param) {
        recordField.getType().accept(this, param);
        return null;
    }

    @Override
    public Object visit(FunctType functType, Object param) {
        for(VarDefinition v : functType.getParameters()) {
            v.accept(this, param);
        }
        functType.getReturnType().accept(this, param);
        return null;
    }

    @Override
    public Object visit(ErrorType errorType, Object param) {
        return null;
    }
}
