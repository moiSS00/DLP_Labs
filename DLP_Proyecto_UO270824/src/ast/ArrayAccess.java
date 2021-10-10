package ast;

import visitor.Visitor;

public class ArrayAccess extends AbstractExpression {

    private Expression expression;
    private Expression index;

    public ArrayAccess(int line, int column, Expression expression, Expression index) {
        super(line, column);
        this.expression = expression;
        this.index = index;
    }

    public Expression getExpression() {
        return expression;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "ArrayAccess{" +
                "expression=" + expression +
                ", index=" + index +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
