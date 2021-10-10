package ast;

import visitor.Visitor;

public class Negation extends AbstractExpression {

    private Expression expression;

    public Negation(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "Negation{" +
                "expression=" + expression +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
