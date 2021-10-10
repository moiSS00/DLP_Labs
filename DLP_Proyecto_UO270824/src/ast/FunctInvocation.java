package ast;

import visitor.Visitor;

import java.util.List;

public class FunctInvocation extends AbstractExpression implements Statement {

    private Variable variable;
    private List<Expression> arguments;

    public FunctInvocation(int line, int column, Variable variable, List<Expression> arguments) {
        super(line, column);
        this.variable = variable;
        this.arguments = arguments;
    }

    public Variable getVariable() {
        return variable;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        return "FunctInvocation{" +
                "name='" + variable + '\'' +
                ", arguments=" + arguments +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
