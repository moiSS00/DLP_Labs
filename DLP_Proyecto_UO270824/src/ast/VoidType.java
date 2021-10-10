package ast;

import visitor.Visitor;

public class VoidType extends AbstractType {

    public VoidType() {
        super(0, 0);
    }

    @Override
    public String toString() {
        return "VoidType";
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }

    @Override
    public boolean isBuiltInType() {
        return true;
    }

}
