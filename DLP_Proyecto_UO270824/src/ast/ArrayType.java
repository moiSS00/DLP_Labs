package ast;

import errorhandler.ErrorType;
import visitor.Visitor;

public class ArrayType extends AbstractType {

    private Type of;
    private int size;

    public ArrayType(int line, int column, Type of, int size) {
        super(line, column);
        this.of = of;
        this.size = size;
    }

    public Type getOf() {
        return of;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayType[" +
                "of=" + of +
                ",size=" + size +
                ']';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type squareBrackets(Type other) {
        if(other instanceof ErrorType) {
            return other;
        }
        if(other instanceof IntType) {
            return of;
        }
        return null;
    }

    @Override
    public int numberOfBytes() { return size * of.numberOfBytes(); }
}
