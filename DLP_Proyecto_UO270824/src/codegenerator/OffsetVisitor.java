package codegenerator;

import ast.*;
import ast.FunctDefinition;
import ast.VarDefinition;
import ast.Statement;
import ast.FunctType;
import ast.StructType;
import visitor.AbstractVisitor;

public class OffsetVisitor extends AbstractVisitor {

    // Offset actual para variables globales
    private int globalOffset = 0;

    // Offset actual para variables locales
    private int localOffset = 0;

    @Override
    public Object visit(VarDefinition varDefinition, Object param) {
        varDefinition.getType().accept(this, null);

        if(varDefinition.getScope() == 0) { // Variable global
            varDefinition.setOffset(globalOffset);
            globalOffset += varDefinition.getType().numberOfBytes();
        }
        else { // Variable local
            localOffset -= varDefinition.getType().numberOfBytes();
            varDefinition.setOffset(localOffset);
        }

        return null;
    }

    @Override
    public Object visit(FunctDefinition functDefinition, Object param) {
        functDefinition.getType().accept(this, null);
        for(Statement s : functDefinition.getBody()) {
            s.accept(this, null);
        }
        functDefinition.setLocalVariablesBytes(-1 * localOffset);
        localOffset = 0;
        return null;
    }

    @Override
    public Object visit(StructType structType, Object param) {
        int fieldOffset = 0;
        for(RecordField r : structType.getRecordFields()) {
            r.accept(this, null);
            r.setOffset(fieldOffset);
            fieldOffset += r.getType().numberOfBytes();
        }
        return null;
    }

    @Override
    public Object visit(FunctType functType, Object param) {
        int paramOffset = 4;
        // No propagamos a los parámetros para evitar comprobaciones para
        // identificar entre variable local y parámetro
        for(int i = functType.getParameters().size() - 1; i >= 0; i--) {
            functType.getParameters().get(i).setOffset(paramOffset);
            paramOffset += functType.getParameters().get(i).getType().numberOfBytes();
            functType.setParametersBytes(functType.getParametersBytes() +
                    functType.getParameters().get(i).getType().numberOfBytes());
        }
        functType.getReturnType().accept(this, null);
        return null;
    }
}
