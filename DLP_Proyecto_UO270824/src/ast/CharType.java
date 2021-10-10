package ast;

import errorhandler.ErrorType;
import visitor.Visitor;

public class CharType extends AbstractType {

    public CharType() {
        super(0 ,0);
    }

    @Override
    public String toString() {
        return "CharType";
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type canBeCastTo(Type other) {
        if(other instanceof  CharType || other instanceof ErrorType) {
            return other;
        }
        if(other instanceof IntType) {
            return new IntType();
        }
        if(other instanceof DoubleType) {
            return new DoubleType();
        }

        return null;
    }

    @Override
    public Type arithmetic(Type other) {
        if(other instanceof ErrorType) {
            return other;
        }
        if(other instanceof CharType) {
            return new IntType();
        }
        return null;
    }

    @Override
    public Type comparison(Type other) {
        if(other instanceof ErrorType) {
            return other;
        }
        if(other instanceof CharType) {
            return new IntType();
        }
        return null;
    }

    @Override
    public Type arithmetic() {
        return new IntType();
    }

    @Override
    public Type promotesTo(Type other) {
        if(other instanceof CharType || other instanceof ErrorType) {
            return other;
        }
        return null;
    }

    @Override
    public boolean isBuiltInType() {
        return true;
    }

    @Override
    public int numberOfBytes() { return 1; }

    @Override
    public char suffix() { return 'b'; }
}
