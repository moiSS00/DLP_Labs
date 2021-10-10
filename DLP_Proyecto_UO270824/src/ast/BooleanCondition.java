package ast;

import visitor.Visitor;

public class BooleanCondition extends AbstractExpression {

    private String operation;
    private Expression left;
    private  Expression right;


    public BooleanCondition(
            int line, int column, Expression left, String operation, Expression right) {
        super(line, column);
        this.left = left;
        this.operation = operation;
        this.right = right;
    }

    public String getOperation() {
        return operation;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "BooleanCondition{" +
                "operation='" + operation + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
