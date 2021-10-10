package ast;

import visitor.Visitor;

import java.util.List;

public class Conditional extends AbstractStatement {

    private Expression condition;
    private List<Statement> ifBody;
    private List<Statement> elseBody;

    public Conditional(
            int line, int column, Expression condition, List<Statement> ifBody, List<Statement> elseBody) {
        super(line, column);
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    @Override
    public String toString() {
        return "Conditional{" +
                "condition=" + condition +
                ", ifBody=" + ifBody +
                ", elseBody=" + elseBody +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
