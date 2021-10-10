package semantic;

import ast.*;
import ast.FunctDefinition;
import ast.VarDefinition;
import errorhandler.ErrorType;
import visitor.AbstractVisitor;

public class TypeCheckingVisitor extends AbstractVisitor {

    // Visitor usado para la fase de inferencia dentro del análisis semántico
    // Se comprueban todos los errores relacionados con los tipos


    // DEFINICIONES

    @Override
    public Object visit(FunctDefinition functDefinition, Object param) {
        Object returnType = functDefinition.getType().accept(this, param);
        for(Statement s : functDefinition.getBody()) {
            s.accept(this, returnType);
        }
        return null;
    }

    // SENTENCIAS

    @Override
    public Object visit(Return r, Object param) {

        r.getExpression().accept(this, param);

        // Comprobamos si el tipo que se está retornando puede ser promovido
        // (de igual tipo en este caso) al tipo de retorno de la función
        if(r.getExpression().getType().promotesTo((Type) param) == null) {
            new ErrorType(r.getLine(), r.getColumn(),
                    "El tipo retornado ('" + r.getExpression().getType().toString()
                            + "') no coincide con el tipo de retorno de la función ('"
                            + param.toString() + "').");
        }

        return null;
    }

    @Override
    public Object visit(Input input, Object param) {
        for(Expression e : input.getExpressions()) {
            e.accept(this, param);
        }
        for(Expression e : input.getExpressions()) {
            if(!e.getLValue()) {
                new ErrorType(input.getLine(), input.getColumn(), "Se esperaba un LValue");
            }
        }
        return null;
    }

    @Override
    public Object visit(Assignment assignment, Object param) {
        assignment.getLeft().accept(this, param);
        assignment.getRight().accept(this, param);

        // Se comprueba si lo que hay a la derecha se puede asignar a la izquierda. Fijarse que
        // es la parte derecha quien evalua a la parte izquierda.
        if(assignment.getRight().getType().promotesTo(assignment.getLeft().getType()) == null) {
            new ErrorType(assignment.getLine(), assignment.getColumn(),
                    "No se puede asignar un tipo '" +
                            assignment.getRight().getType().toString() + "' a un tipo '" +
                            assignment.getLeft().getType().toString() + "'.");
        }

        if(!assignment.getLeft().getLValue()) {
            new ErrorType(assignment.getLine(), assignment.getColumn(), "Se esperaba un LValue");
        }
        return null;
    }

    @Override
    public Object visit(While w, Object param) {
        w.getCondition().accept(this, param);

        // Si la condición no es lógica, le asignamos el tipo error.
        if(!w.getCondition().getType().isLogical()) {
            w.getCondition().setType(
                    new ErrorType(w.getCondition().getLine(), w.getCondition().getColumn(),
                            "La condición del bucle while no es válida.")
            );
        }

        for(Statement s : w.getBody()) {
            s.accept(this, param);
        }
        return null;
    }

    @Override
    public Object visit(Conditional conditional, Object param) {
        conditional.getCondition().accept(this, param);

        // Si la condición no es lógica, le asignamos el tipo error.
        if(!conditional.getCondition().getType().isLogical()) {
            conditional.getCondition().setType(
                    new ErrorType(conditional.getCondition().getLine(),
                            conditional.getCondition().getColumn(),
                            "La condición del condicional no es válida.")
            );
        }

        for(Statement s : conditional.getIfBody()) {
            s.accept(this, param);
        }
        for(Statement s : conditional.getElseBody()){
            s.accept(this, param);
        }
        return null;
    }


    // EXPRESIONES

    @Override
    public Object visit(UnaryMinus unaryMinus, Object param) {
        unaryMinus.getExpression().accept(this, param);

        // Comprobamos que podemos aplicar el operador '-' a la expresión
        unaryMinus.setType(unaryMinus.getExpression().getType().arithmetic());
        if(unaryMinus.getType() == null) {
            unaryMinus.setType(
                    new ErrorType(unaryMinus.getLine(), unaryMinus.getColumn(),
                            "No se puede hacer la operación '-' de " +
                                    "un tipo '" + unaryMinus.getExpression().toString() + "'.")
            );
        }

        unaryMinus.setLValue(false);
        return null;
    }

    @Override
    public Object visit(Negation negation, Object param) {
        negation.getExpression().accept(this, param);

        // Comprobamos que podemos aplicar el operador '!' a la expresión
        negation.setType(negation.getExpression().getType().logic());
        if(negation.getType() == null) {
            negation.setType(
                    new ErrorType(negation.getLine(), negation.getColumn(),
                            "No se puede hacer la negación '!' de " +
                                    "un tipo '" + negation.getExpression().getType().toString() + "'.")
            );
        }

        negation.setLValue(false);
        return null;
    }

    @Override
    public Object visit(BooleanCondition booleanCondition, Object param) {
        booleanCondition.getLeft().accept(this, param);
        booleanCondition.getRight().accept(this, param);

        // Preguntamos si la izquierda puede compararse con el tipo
        // de la derecha. El tipo de la condicion booleana quedará establecido
        // tanto si es correcto como si no. OJO, simulamos los valores booleanos
        // con enteros
        booleanCondition.setType(booleanCondition.getLeft().getType().logic(
                booleanCondition.getRight().getType()));
        if(booleanCondition.getType() == null) {
            booleanCondition.setType(
                    new ErrorType(booleanCondition.getLine(),booleanCondition.getColumn(),
                            "No se puede hacer la comparación booleana '" +
                                    booleanCondition.getOperation() + "' con los tipos '" +
                                    booleanCondition.getLeft().getType().toString() + "' y '"
                                    + booleanCondition.getRight().getType().toString() + "'.")
            );
        }

        booleanCondition.setLValue(false);
        return null;
    }

    @Override
    public Object visit(LogicalCondition logicalCondition, Object param) {
        logicalCondition.getLeft().accept(this, param);
        logicalCondition.getRight().accept(this, param);

        // Preguntamos si la izquierda puede compararse con el tipo
        // de la derecha. El tipo de la condicion logica quedará establecido
        // tanto si es correcto como si no. OJO, simulamos los valores booleanos
        // con enteros
        logicalCondition.setType(logicalCondition.getLeft().getType().comparison(
                logicalCondition.getRight().getType()));
        if(logicalCondition.getType() == null) {
            logicalCondition.setType(
                    new ErrorType(logicalCondition.getLine(), logicalCondition.getColumn(),
                            "No se puede hacer la comparación lógica '" +
                                    logicalCondition.getOperation() + "' con los tipos '" +
                                    logicalCondition.getLeft().getType().toString() + "' y '"
                                    + logicalCondition.getRight().getType().toString() + "'.")
            );
        }

        logicalCondition.setLValue(false);
        return null;
    }


    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        arithmetic.getLeft().accept(this,param);
        arithmetic.getRight().accept(this, param);

        // Preguntamos si la izquierda puede realizar operaciones con el tipo
        // de la derecha. El tipo de la expresión aritmetica quedará establecido
        // tanto si es correcto como si no.
        arithmetic.setType(arithmetic.getLeft().getType().arithmetic(arithmetic.getRight().getType()));
        if(arithmetic.getType() == null) {
            arithmetic.setType(new ErrorType(
                    arithmetic.getLine(), arithmetic.getColumn(),
                    "No se puede hacer la operación aritmética'" + arithmetic.getOperation() +
                            "' con los tipos '" + arithmetic.getLeft().getType().toString() +
                            "' y '" + arithmetic.getRight().getType().toString() + "'."
            ));
        }

        arithmetic.setLValue(false);
        return null;
    }

    @Override
    public Object visit(Cast cast, Object param) {
        cast.getExpression().accept(this, param);

        // Comprobamos si la parte derecha puede ser casteada al tipo de la
        // parte izquierda.
        cast.setType(cast.getExpression().getType().canBeCastTo(cast.getCastTo()));
        if(cast.getType() == null) {
            cast.setType(
                    new ErrorType(cast.getLine(),cast.getColumn(), "El tipo '" +
                            cast.getExpression().getType().toString() + "' no puede ser " +
                            "casteado al tipo '" + cast.getType().toString() + "'.")
            );
        }

        cast.setLValue(false);
        return null;
    }

    @Override
    public Object visit(ArrayAccess arrayAccess, Object param) {
        arrayAccess.getExpression().accept(this, param);
        arrayAccess.getIndex().accept(this, param);

        // Comprobamos que el índice del acceso a array sea de tipo entero.
        // Por el polimorfismo ya se sabe que la parte izquierda es de tipo array.
        arrayAccess.setType(arrayAccess.getExpression().getType().squareBrackets(arrayAccess.getIndex().getType()));
        if(arrayAccess.getType() == null) {
            arrayAccess.setType(
                    new ErrorType(arrayAccess.getLine(),arrayAccess.getColumn(),
                            "Acceso a array incorrecto.")
            );
        }

        arrayAccess.setLValue(true);
        return null;
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.getExpression().accept(this, param);

        // Comprobamos que el campo de la derecha al que intentamos acceder existe en el struct
        // de la izquierda
        // Por el polimorfismo ya se sabe que la parte izquierda es de tipo struct.
        fieldAccess.setType(fieldAccess.getExpression().getType().dot(fieldAccess.getField()));
        if(fieldAccess.getType() == null) {
            fieldAccess.setType(
                    new ErrorType(fieldAccess.getLine(),fieldAccess.getColumn(),
                            "El campo '" + fieldAccess.getField() + "' no existe " +
                                    "en el struct.")
            );
        }

        fieldAccess.setLValue(true);
        return null;
    }

    @Override
    public Object visit(Variable variable, Object param) {
        variable.setLValue(true);
        // Inferimos el tipo de la variable a través de su definición
        variable.setType(variable.getDefinition().getType());
        return null;
    }

    // El tipo de los literales se calcularía directamente

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        intLiteral.setLValue(false);
        intLiteral.setType(new IntType());
        return null;
    }

    @Override
    public Object visit(DoubleLiteral doubleLiteral, Object param) {
        doubleLiteral.setLValue(false);
        doubleLiteral.setType(new DoubleType());
        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object param) {
        charLiteral.setLValue(false);
        charLiteral.setType(new CharType());
        return null;
    }

    // EXPRESION Y SENTENCIA

    @Override
    public Object visit(FunctInvocation functInvocation, Object param) {
        functInvocation.getVariable().accept(this, param);
        for(Expression e : functInvocation.getArguments()) {
            e.accept(this, param);
        }

        // Comprobamos que el número de parámetros sea el correcto
        // Comprobamos que los tipos de las expresiones pasadas sea compatible con los
        // tipos de los parámetros formales de la definición de la función.
        // Por el polimorfismo ya se sabe que la parte izquierda es de tipo funcion ya
        // que este es el único tipo que implementa el método parenthesis.
        functInvocation.setType(
                functInvocation.getVariable().getDefinition().getType().parenthesis(
                        functInvocation.getArguments()
                )
        );
        if(functInvocation.getType() == null) {
            functInvocation.setType(
                    new ErrorType(functInvocation.getLine(),functInvocation.getColumn(),
                            "Paso de parámetros erroneos a la función '" +
                                    functInvocation.getVariable().getName() + "'.")
            );
        }

        functInvocation.setLValue(false);
        return null;
    }

    // TIPOS

    @Override
    public Object visit(FunctType functType, Object param) {
        for(VarDefinition v : functType.getParameters()) {
            v.accept(this, param);
        }
        functType.getReturnType().accept(this, param);

        // Comprobamos que los parametros y el tipo de retorno sean tipos simples
        for(VarDefinition v: functType.getParameters()) {
            if(!v.getType().isBuiltInType()) {
                new ErrorType(functType.getLine(), functType.getColumn(),
                        "El tipo '" + v.getType().toString() +
                                "' del parámetro '" + v.getName() + "' no es de tipo simple.");
            }
        }

        if(!functType.getReturnType().isBuiltInType()) {
            new ErrorType(functType.getLine(), functType.getColumn(),
                    "El tipo de retorno '" + functType.getReturnType().toString() +
                            "' de la función no es de tipo simple.");
        }

        return functType.getReturnType();
    }

}
