package ast;

import visitor.Visitor;

import java.util.List;

public class Print extends AbstractStatement {

    private List<Expression> expressions;

    public Print(int line, int column, List<Expression> expressions) {
        super(line, column);
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    @Override
    public String toString() {
        return "Print{" +
                "expressions=" + expressions +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
