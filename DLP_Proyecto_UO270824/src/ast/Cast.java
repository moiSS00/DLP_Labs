package ast;

import visitor.Visitor;

public class Cast extends AbstractExpression {

    private Type castTo;
    private Expression expression;

    public Cast(int line, int column, Type castTo, Expression expression) {
        super(line, column);
        this.castTo = castTo;
        this.expression = expression;
    }

    public Type getCastTo() {
        return castTo;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "castTo=" + castTo +
                ", expression=" + expression +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
