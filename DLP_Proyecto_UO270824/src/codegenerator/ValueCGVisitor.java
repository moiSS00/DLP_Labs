package codegenerator;

import ast.*;
import ast.IntType;

public class ValueCGVisitor extends AbstractCGVisitor {

    private AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cg) {
        super(cg);
        this.addressCGVisitor = new AddressCGVisitor(cg, this);
    }

    /*
    value[[FunctInvocation: exp1:expression -> variable:expression expression*]] () =
        for(Expression arg : expression*)
            value[[arg]] ()
        <call> variable.name
    */
    @Override
    public Object visit(FunctInvocation functInvocation, Object param) {
        for(Expression arg : functInvocation.getArguments()){
            arg.accept(this, null);
        }
        cg.call(functInvocation.getVariable().getName());
        return null;
    }

    /*
    value[[Arithmetic: expression -> left:expression operation:string right:expression]] () =
        value[[left]] ()
        left.type.suffix<2>expression.type.suffix
        value[[right]] ()
        right.type.suffix<2>expression.type.suffix
        arithmetic(operation, expression.type)
    */
    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        arithmetic.getLeft().accept(this, null);
        cg.a2b(arithmetic.getLeft().getType(), arithmetic.getType());
        arithmetic.getRight().accept(this, null);
        cg.a2b(arithmetic.getRight().getType(), arithmetic.getType());
        switch (arithmetic.getOperation()) {
            case "+": cg.add(arithmetic.getType()); break;
            case "-": cg.sub(arithmetic.getType()); break;
            case "/": cg.div(arithmetic.getType()); break;
            case "*": cg.mul(arithmetic.getType()); break;
            case "%": cg.mod(arithmetic.getType()); break;
        }
        return null;
    }

    /*
    value[[LogicalCondition: expression -> left:expression operation:string right:expression]] () =
        value[[left]] ()
        left.type.suffix<2>expression.type.suffix
        value[[right]] ()
        right.type.suffix<2>expression.type.suffix
        logicalCondition(operation, expression.type)
    */
    @Override
    public Object visit(LogicalCondition logicalCondition, Object param) {
        logicalCondition.getLeft().accept(this, null);
        cg.a2b(logicalCondition.getType(), logicalCondition.getType());
        logicalCondition.getRight().accept(this, null);
        cg.a2b(logicalCondition.getRight().getType(), logicalCondition.getType());
        switch (logicalCondition.getOperation()) {
            case ">": cg.greaterThan(logicalCondition.getType()); break;
            case "<": cg.lessThan(logicalCondition.getType()); break;
            case ">=": cg.greaterEqualThan(logicalCondition.getType()); break;
            case "<=": cg.lessEqualThan(logicalCondition.getType()); break;
            case "==": cg.equal(logicalCondition.getType()); break;
            case "!=": cg.notEqual(logicalCondition.getType()); break;
        }
        return null;
    }

    /*
    value[[BooleanCondition: expression -> left:expression operation:string right:expression]] () =
        value[[left]] ()
        left.type.suffix<2>expression.type.suffix
        value[[right]] ()
        right.type.suffix<2>expression.type.suffix
        booleanCondition(operation)
    */
    @Override
    public Object visit(BooleanCondition booleanCondition, Object param) {
        booleanCondition.getLeft().accept(this, null);
        cg.a2b(booleanCondition.getLeft().getType(), booleanCondition.getType());
        booleanCondition.getRight().accept(this, null);
        cg.a2b(booleanCondition.getRight().getType(), booleanCondition.getType());
        switch (booleanCondition.getOperation()) {
            case "&&": cg.and(); break;
            case "||": cg.or(); break;
        }
        return null;
    }

    /*
    value[[UnaryMinus: expression -> exp:expression]] () =
        <pushi> 0
        <i2>expression.type
        value[[exp]] ()
        exp.type.suffix<2>expression.type
        <sub>expression.type.suffix
    */
    @Override
    public Object visit(UnaryMinus unaryMinus, Object param) {
        cg.pushi(0);
        cg.a2b(new IntType(), unaryMinus.getType());
        unaryMinus.getExpression().accept(this, null);
        cg.sub(unaryMinus.getType());
        return null;
    }

    /*
    value[[Negation: expression -> exp:expression]] () =
        value[[exp]] ()
        exp.type.suffix<2>expression.type
        <not>
    */
    @Override
    public Object visit(Negation negation, Object param) {
        negation.getExpression().accept(this, null);
        cg.a2b(negation.getExpression().getType(), negation.getType());
        cg.not();
        return null;
    }

    /*
    value[[Cast: expression -> castTo:type  exp:expression]] () =
        value[[exp]] ()
        exp.type.suffix<2>castTo.type.suffix
    */
    @Override
    public Object visit(Cast cast, Object param) {
        cast.getExpression().accept(this, null);
        cg.a2b(cast.getExpression().getType(), cast.getType());
        return null;
    }

    /*
    value[[ArrayAccess: expression -> exp:expression  index:expression]] () =
        address[[expression]] ()
        <load>expression.type.suffix
    */
    @Override
    public Object visit(ArrayAccess arrayAccess, Object param) {
        arrayAccess.accept(addressCGVisitor, null);
        cg.load(arrayAccess.getType());
        return null;
    }

    /*
    value[[FieldAccess: expression -> exp:expression field:string]] () =
        address[[expression]] ()
        <load>expression.type.suffix
    */
    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.accept(addressCGVisitor, null);
        cg.load(fieldAccess.getType());
        return null;
    }

    /*
    value[[Variable: expression -> name:string]] () =
        address[[expression]] ()
        <load>expression.type.suffix
    */
    @Override
    public Object visit(Variable variable, Object param) {
        variable.accept(addressCGVisitor, null);
        cg.load(variable.getType());
        return null;
    }

    /*
    value[[IntLiteral: expression -> value:int]] () =
        <pushi>value
    */
    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        cg.pushi(intLiteral.getValue());
        return null;
    }

    /*
    value[[DoubleLiteral: expression -> value:double]] () =
        <pushf>value
    */
    @Override
    public Object visit(DoubleLiteral doubleLiteral, Object param) {
        cg.pushf(doubleLiteral.getValue());
        return null;
    }

    /*
    value[[CharLiteral: expression -> value:char]] () =
        <pushb>value
    */
    @Override
    public Object visit(CharLiteral charLiteral, Object param) {
        cg.pushb(charLiteral.getValue());
        return null;
    }

}
