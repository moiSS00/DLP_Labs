package ast;

import visitor.Visitor;

import java.util.List;

public class StructType extends AbstractType {

    private List<RecordField> recordFields;

    public StructType(int line, int column, List<RecordField> recordFields) {
        super(line, column);
        this.recordFields = recordFields;
    }

    public List<RecordField> getRecordFields() {
        return recordFields;
    }

    @Override
    public String toString() {
        return "StructType";
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type dot(String name) {
        for(RecordField rf : recordFields) {
            if(rf.getName().equals(name)) {
                return rf.getType();
            }
        }
        return null;
    }

    @Override
    public int numberOfBytes() {
        int bytes = 0;
        for(RecordField rf : recordFields) {
            bytes += rf.getType().numberOfBytes();
        }
        return bytes;
    }
}
