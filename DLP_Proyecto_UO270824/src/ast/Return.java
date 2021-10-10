package ast;

import visitor.Visitor;

public class Return extends AbstractStatement {

    private Expression expression;

    public Return(int line, int column, Expression expression) {
        super(line, column);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "Return{" +
                "expression=" + expression +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
