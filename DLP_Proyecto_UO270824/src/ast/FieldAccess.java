package ast;

import visitor.Visitor;

public class FieldAccess extends AbstractExpression {

    private String field;
    private Expression expression;

    public FieldAccess(int line, int column, Expression expression, String field) {
        super(line, column);
        this.expression = expression;
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "FieldAccess{" +
                "field='" + field + '\'' +
                ", expression=" + expression +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
