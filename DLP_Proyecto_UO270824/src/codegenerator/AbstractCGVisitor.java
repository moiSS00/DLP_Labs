package codegenerator;

import ast.*;
import ast.FunctDefinition;
import ast.VarDefinition;
import errorhandler.ErrorType;
import visitor.Visitor;

public abstract class AbstractCGVisitor implements Visitor {

    protected CodeGenerator cg;

    /*
        ExecuteCGVisitor -> Program, Definitions, Statements
        AddressCGVisitor -> LValues
        ValueCGVisitor -> Expressions
    */
    public AbstractCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    @Override
    public Object visit(Program program, Object param) {
        throw new IllegalStateException("Plantilla de program no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(VarDefinition varDefinition, Object param) {
        throw new IllegalStateException("Plantilla de varDefinition no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(FunctDefinition functDefinition, Object param) {
        throw new IllegalStateException("Plantilla de functDefinition no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(While w, Object param) {
        throw new IllegalStateException("Plantilla de while no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(Conditional conditional, Object param) {
        throw new IllegalStateException("Plantilla de conditional no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(Assignment assignment, Object param) {
        throw new IllegalStateException("Plantilla de assigment no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(Print print, Object param) {
        throw new IllegalStateException("Plantilla de print no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(Input input, Object param) {
        throw new IllegalStateException("Plantilla de input no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(Return r, Object param) {
        throw new IllegalStateException("Plantilla de return no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        throw new IllegalStateException("Plantilla de arithmetic no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(LogicalCondition logicalCondition, Object param) {
        throw new IllegalStateException("Plantilla de logicalCondition no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(BooleanCondition booleanCondition, Object param) {
        throw new IllegalStateException("Plantilla de booleanCondition no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object param) {
        throw new IllegalStateException("Plantilla de unaryMinus no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(Negation negation, Object param) {
        throw new IllegalStateException("Plantilla de negation no definida: " +
                this.getClass().getName());    }

    @Override
    public Object visit(Cast cast, Object param) {
        throw new IllegalStateException("Plantilla de cast no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(ArrayAccess arrayAccess, Object param) {
        throw new IllegalStateException("Plantilla de program no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        throw new IllegalStateException("Plantilla de fieldAccess no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(Variable variable, Object param) {
        throw new IllegalStateException("Plantilla de variable no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        throw new IllegalStateException("Plantilla de intLiteral no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(DoubleLiteral doubleLiteral, Object param) {
        throw new IllegalStateException("Plantilla de doubleLiteral no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object param) {
        throw new IllegalStateException("Plantilla de charLiteral no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(FunctInvocation functInvocation, Object param) {
        throw new IllegalStateException("Plantilla de functInvocation no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(IntType intType, Object param) {
        throw new IllegalStateException("Plantilla de intType no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(DoubleType doubleType, Object param) {
        throw new IllegalStateException("Plantilla de doubleType no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(CharType charType, Object param) {
        throw new IllegalStateException("Plantilla de charType no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(ArrayType arrayType, Object param) {
        throw new IllegalStateException("Plantilla de arrayType no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(VoidType voidType, Object param) {
        throw new IllegalStateException("Plantilla de voidType no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(StructType structType, Object param) {
        throw new IllegalStateException("Plantilla de structType no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(RecordField recordField, Object param) {
        throw new IllegalStateException("Plantilla de recordField no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(FunctType functType, Object param) {
        throw new IllegalStateException("Plantilla de functType no definida: " +
                this.getClass().getName());
    }

    @Override
    public Object visit(ErrorType errorType, Object param) {
        throw new IllegalStateException("Plantilla de errorType no definida: " +
                this.getClass().getName());
    }

}
