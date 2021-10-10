package ast;

import java.util.List;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }


    @Override
    public Type dot(String name) {
        return null;
    }

    @Override
    public Type squareBrackets(Type other) {
        return null;
    }

    @Override
    public Type canBeCastTo(Type other) {
        return null;
    }

    @Override
    public Type arithmetic(Type other) {
        return null;
    }

    @Override
    public Type comparison(Type other) {
        return null;
    }

    @Override
    public Type logic(Type other) {
        return null;
    }

    @Override
    public Type logic() {
        return null;
    }


    @Override
    public boolean isLogical() {
        return false;
    }


    @Override
    public Type arithmetic() {
        return null;
    }


    @Override
    public Type promotesTo(Type other) {
        return null;
    }


    @Override
    public boolean isBuiltInType() {
        return false;
    }


    @Override
    public Type parenthesis(List<Expression> expressions) {
        return null;
    }


    @Override
    public int numberOfBytes() { return 0; }


    @Override
    public char suffix() {
        throw new IllegalStateException("Se esta intentando representar " +
            "un tipo de dato que no se debe representar a bajo nivel.");
    }

}
