package ast;

import visitor.Visitor;

public class VarDefinition extends AbstractDefinition implements Statement {

    private int offset;

    public VarDefinition(int line, int column, Type type, String name) {
        super(line, column, type, name);
    }


    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "VarDefinition{" +
                "name=" + getName() +
                ", scope=" + getScope() +
                ", offset=" + offset +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
