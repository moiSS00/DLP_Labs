package ast;

import errorhandler.ErrorType;
import visitor.Visitor;

public class IntType extends AbstractType {

    public IntType() {
        super(0, 0);
    }

    @Override
    public String toString() {
        return "IntType";
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }


    @Override
    public Type canBeCastTo(Type other) {
        if(other instanceof  IntType || other instanceof ErrorType) {
            return other;
        }
        if(other instanceof DoubleType) {
            return new DoubleType();
        }
        if(other instanceof CharType) {
            return new CharType();
        }

        return null;
    }

    @Override
    public Type arithmetic(Type other) {
        if(other instanceof IntType || other instanceof ErrorType) {
            return other;
        }
        return null;
    }

    @Override
    public Type comparison(Type other) {
        if(other instanceof IntType || other instanceof ErrorType) {
            return other;
        }
        return null;
    }

    @Override
    public Type logic(Type other) {
        if(other instanceof IntType || other instanceof ErrorType) {
            return other;
        }
        return null;
    }

    @Override
    public Type logic() {
        return this;
    }

    @Override
    public boolean isLogical() {
        return true;
    }

    @Override
    public Type arithmetic() {
        return this;
    }

    @Override
    public Type promotesTo(Type other) {
        if(other instanceof IntType || other instanceof ErrorType) {
            return other;
        }
        return null;
    }

    @Override
    public boolean isBuiltInType() {
        return true;
    }

    @Override
    public int numberOfBytes() { return 2; }

    @Override
    public char suffix() { return 'i'; }

}
