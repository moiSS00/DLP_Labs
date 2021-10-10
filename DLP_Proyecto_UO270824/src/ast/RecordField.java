package ast;

import visitor.Visitor;

public class RecordField extends AbstractASTNode implements ASTNode {

    private String name;
    private int offset;
    private Type type;

    public RecordField(int line, int column, String name, Type type) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getOffset() {
        return offset;
    }

    public Type getType() {
        return type;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "RecordField{" +
                "name='" + name + '\'' +
                ", offset=" + offset +
                ", type=" + type +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }
}
