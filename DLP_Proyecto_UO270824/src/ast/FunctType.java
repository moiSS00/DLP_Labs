package ast;

import visitor.Visitor;

import java.util.List;

public class FunctType extends AbstractType {

    private List<VarDefinition> parameters;
    private Type returnType;

    // Sumatorio del tamaño de los tipos de los parámetros
    private int parametersBytes;

    public FunctType(int line, int column, List<VarDefinition> parameters, Type returnType) {
        super(line, column);
        this.parameters = parameters;
        this.returnType = returnType;
        this.parametersBytes = 0;
    }

    public List<VarDefinition> getParameters() {
        return parameters;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        return "FunctType{" +
                "parameters=" + parameters +
                ", returnType=" + returnType +
                '}';
    }

    public void setParametersBytes(int parametersBytes) {
        this.parametersBytes = parametersBytes;
    }

    public int getParametersBytes() {
        return parametersBytes;
    }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return visitor.visit(this, param);
    }

    @Override
    public Type parenthesis(List<Expression> expressions) {

        // Comprobamos que el número de parámetros sea el correcto
        if(parameters.size() != expressions.size()) {
            return null;
        }

        // Comprobamos que los tipos de las expresiones pasadas sea compatible con los
        // tipos de los parámetros formales de la definición de la función.
        for(int i =0; i < parameters.size(); i++) {
            if(expressions.get(i).getType().promotesTo(parameters.get(i).getType()) == null) {
                return null;
            }
        }

        // Si sale bien, retornamos el tipo de retorno de la funion
        return returnType;
    }
}
