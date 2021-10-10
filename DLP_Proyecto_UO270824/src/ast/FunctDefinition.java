package ast;

import visitor.Visitor;

import java.util.List;

public class FunctDefinition extends AbstractDefinition {

    private List<Statement> body;

    // Sumatorio del tamaño de los tipos de las variables locales
    private int localVariablesBytes;

    public FunctDefinition(int line, int column, Type type, String name, List<Statement> body) {
        super(line, column, type, name);
        this.body = body;
        this.localVariablesBytes = 0;
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "FunctDefinition{" +
                "name=" + getName() +
                ", body=" + body +
                '}';
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }

    public void setLocalVariablesBytes(int localVariablesBytes) {
        this.localVariablesBytes = localVariablesBytes;
    }

    public int getLocalVariablesBytes() {
        return localVariablesBytes;
    }

}
