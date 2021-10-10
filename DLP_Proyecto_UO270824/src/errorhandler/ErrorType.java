package errorhandler;

import ast.AbstractType;
import ast.Expression;
import ast.Type;
import visitor.Visitor;

import java.util.List;

public class ErrorType extends AbstractType {

    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        EH.getEH().addError(this);
    }

    @Override
    public String toString() {
        return "Error[" + getLine() + ":" + getColumn() + "]: " + message;
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }

    @Override
    public boolean isBuiltInType() {
        return true;
    }

    @Override
    public Type arithmetic(Type other) {
        return this;
    }

    @Override
    public Type arithmetic() {
        return this;
    }

    @Override
    public Type logic(Type other) {
        return this;
    }

    @Override
    public Type logic() {
        return this;
    }

    @Override
    public Type promotesTo(Type other) {
        return this;
    }

    @Override
    public Type canBeCastTo(Type other) {
        return this;
    }

    @Override
    public Type comparison(Type other) {
        return this;
    }

    @Override
    public Type squareBrackets(Type other) {
        return this;
    }

    @Override
    public Type dot(String name) {
        return this;
    }

    @Override
    public Type parenthesis(List<Expression> expressions) {
        return this;
    }
}
