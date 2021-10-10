package semantic;

import ast.*;
import ast.Definition;
import ast.FunctDefinition;
import ast.VarDefinition;
import ast.Expression;
import ast.Variable;
import ast.Statement;
import errorhandler.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

import java.util.ArrayList;

public class IdentificationVisitor extends AbstractVisitor {

    // Visitor usado para la fase de identificación dentro del análisis semántico
    // Los errores a comprobar son:
    //  Símbolo no definido
    //  Símbolo ya definido

    private SymbolTable symbolTable;

    @Override
    public Object visit(Program program, Object param) {

        // Iniciamos la tabla de símbolos
        symbolTable = new SymbolTable();

        // Recorremos el programa
        for(Definition d : program.getDefinitions()) {
            d.accept(this, param);
        }

        // Borramos la tabla de símbolos una vez finalizado el recorrido del programa
        symbolTable.reset();
        return null;
    }

    @Override
    public Object visit(VarDefinition varDefinition, Object param) {

        // Propagamos
        varDefinition.getType().accept(this, param);

        // Establecemos el scope de la definición de variable.
        // En este caso, será el scope actual manejado por la tabla de símbolos
        varDefinition.setScope(symbolTable.getScope());

        // Hacemos comprobaciones.
        // Si la variable no está definida, se inserta en la tabla de símbolos.
        // Si la variable ya está definida, se crea un nuevo error.
        if(symbolTable.findInCurrentScope(varDefinition.getName()) == null) {
            symbolTable.insert(varDefinition);
        }
        else {
            new ErrorType(varDefinition.getLine(), varDefinition.getColumn(),
                    "Variable '" + varDefinition.getName() + "' ya definida.");
        }

        return null;
    }

    @Override
    public Object visit(FunctDefinition functDefinition, Object param) {

        // Calculamos atributo scope / ámbito
        // El scope / ámbito de las funciones siempre es 0 (global)
        functDefinition.setScope(0);

        // Hacemos comprobaciones.
        // Si la función no está definida, se inserta en la tabla de símbolos.
        // Si la función ya está definida, se crea un nuevo error.
        if(symbolTable.findInCurrentScope(functDefinition.getName()) == null) {
            symbolTable.insert(functDefinition);
        }
        else {
            new ErrorType(functDefinition.getLine(), functDefinition.getColumn(),
                    "Función '" + functDefinition.getName() + "' ya definida.");
        }

        // Al entrar en la función, creamos un nuevo map para pasar a scope 1 (local).
        symbolTable.set();

        // Propagamos
        functDefinition.getType().accept(this, param);
        for(Statement s : functDefinition.getBody()) {
            s.accept(this, param);
        }

        // Al salir de la función, eliminamos el último map para volver a scope 0 (global).
        symbolTable.reset();

        return null;
    }

    @Override
    public Object visit(Variable variable, Object param) {

        // Hacemos comprobaciones
        // Si la variable está definida, se asocia la correspondiente definición de variable.
        // Si la variable no está definida, se crea un nuevo error.
        String name = variable.getName();
        Definition finded = symbolTable.find(name);
        if(finded != null) {
            variable.setDefinition(finded);
        }
        else {
            ErrorType error = new ErrorType(variable.getLine(), variable.getColumn(),
                    "Variable '" + name + "' no está definida.");
            variable.setDefinition(
                    new VarDefinition(variable.getLine(), variable.getColumn(),
                            error, variable.getName())
            );
        }
        return null;
    }

    @Override
    public Object visit(FunctInvocation functInvocation, Object param) {

        // Hacemos comprobaciones
        // Si la función está definida, se asocia la correspondiente definición de variable.
        // Si la función no está definida, se crea un nuevo error.
        String name = functInvocation.getVariable().getName();
        Definition finded = symbolTable.find(name);
        if(finded != null) {
            functInvocation.getVariable().setDefinition(finded);
        } else {
            ErrorType error = new ErrorType(functInvocation.getLine(), functInvocation.getColumn(),
                    "Función '" + name + "' no está definida.");
            functInvocation.getVariable().setDefinition(
                    new FunctDefinition(functInvocation.getLine(), functInvocation.getColumn(),
                            error, functInvocation.getVariable().getName(), new ArrayList<Statement>())
            );
        }

        // Propagamos
        functInvocation.getVariable().accept(this, param);
        for(Expression e : functInvocation.getArguments()) {
            e.accept(this, null);
        }

        return null;
    }
}
