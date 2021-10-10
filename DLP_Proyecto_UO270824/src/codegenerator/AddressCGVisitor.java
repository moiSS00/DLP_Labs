package codegenerator;

import ast.*;
import ast.VarDefinition;
import ast.ArrayAccess;
import ast.FieldAccess;
import ast.Variable;
import ast.IntType;
import ast.StructType;

import java.util.List;

public class AddressCGVisitor extends AbstractCGVisitor {

    private ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator cg, ValueCGVisitor valueCGVisitor) {
        super(cg);
        this.valueCGVisitor = valueCGVisitor;
    }

    /*
    address[[ArrayAccess: expression -> exp:expression  index:expression]] () =
        address[[exp]] ()
        value[[index]] ()
        <pushi>expression.type.numberOfBytes()
        <muli>
        <addi>
    */
    @Override
    public Object visit(ArrayAccess arrayAccess, Object param) {
        arrayAccess.getExpression().accept(this, null);
        arrayAccess.getIndex().accept(valueCGVisitor, null);
        cg.pushi(arrayAccess.getType().numberOfBytes());
        cg.mul(new IntType());
        cg.add(new IntType());
        return null;
    }

    /*
    address[[FieldAccess: expression -> exp:expression field:string]] () =
        address[[exp]] ()
        <pushi>findRecordField(ID).offset
        <addi>
    */
    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.getExpression().accept(this, null);
        cg.pushi(findRecordField(fieldAccess).getOffset());
        cg.add(new IntType());
        return null;
    }


    private  RecordField findRecordField(FieldAccess fieldAccess) {
        StructType type = (StructType) fieldAccess.getExpression().getType();
        List<RecordField> fields = type.getRecordFields();
        for(RecordField field : fields) {
            if(field.getName().equals(fieldAccess.getField())) {
                return field;
            }
        }
        return null;
    }


    /*
    address[[Variable: expression -> name:string]] () =
    if(expression.definition.scope == 0)
        <pusha>expression.definition.offset
    else
        <push bp>
        <pushi>expression.definition.offset
        <addi>
    */
    @Override
    public Object visit(Variable variable, Object param) {
        VarDefinition definition = (VarDefinition) variable.getDefinition();
        if(definition.getScope() == 0) {
            cg.pusha(definition.getOffset());
        }
        else {
            cg.pushBP();
            cg.pushi(definition.getOffset());
            cg.add(new IntType());
        }
        return null;
    }
}
