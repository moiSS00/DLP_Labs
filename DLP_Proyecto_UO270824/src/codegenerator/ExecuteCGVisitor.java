package codegenerator;

import ast.*;
import ast.Definition;
import ast.FunctDefinition;
import ast.VarDefinition;
import ast.Expression;
import ast.FunctType;
import ast.VoidType;

public class ExecuteCGVisitor extends AbstractCGVisitor {

    private ValueCGVisitor valueCGVisitor;
    private AddressCGVisitor addressCGVisitor;


    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);
        this.valueCGVisitor = new ValueCGVisitor(cg);
        this.addressCGVisitor = new AddressCGVisitor(cg, this.valueCGVisitor);
    }

    /*
    execute[[Program: program -> definition*]] () =
        for(Definition definition : definition*)
            if(definition instanceof VarDefinition)
                execute[[definition]] ()

         <call main>
         <halt>

         for(Definition definition : definition*)
            if(definition instanceof FunctDefinition)
                execute[[definition]] ()
    */
    @Override
    public Object visit(Program program, Object param) {

        for(Definition definition : program.getDefinitions()) {
            if(definition instanceof VarDefinition) {
                definition.accept(this, null);
            }
        }

        cg.mainInvocation();

        for(Definition definition : program.getDefinitions()) {
            if(definition instanceof FunctDefinition) {
                definition.accept(this, null);
            }
        }

        return null;
    }


    /*
    execute[[VarDefinition: definition -> name:string type]] () =
        <' >type name definition.offset
    */
    @Override
    public Object visit(VarDefinition varDefinition, Object param) {
        cg.comment(varDefinition.getType().toString() + " " + varDefinition.getName() +
                " (offset " + varDefinition.getOffset() + ")");
        return null;
    }

    /*
    execute[[FunctDefinition: definition -> type body:statements*]] () =
        functDefinition.name<:>

        for(VarDefinition parameter : type.parameters)
            execute[[parameter]] ()

        for(Statement statement : body)
            if(statement instanceof VarDefintion)
                execute[[statement]] ()

        <enter> functDefinition.bytesLocalsSum

        for(Statement statement : body)
            if(!(statement instanceof VarDefintion))
                execute[[statement]] ()

         if(type.returnType instanceof VoidType)
            <ret 0,>functDefinition.bytesLocalsSum<,>functDefinition.bytesParamsSum
    */
    @Override
    public Object visit(FunctDefinition functDefinition, Object param) {

        // Meta Informacion
        FunctType type = (FunctType) functDefinition.getType();
        cg.line(functDefinition);

        // Etiqueta de la funcion
        cg.label(functDefinition.getName());

        // Parámetros
        cg.comment("Parameters");
        for(VarDefinition varDefinition : type.getParameters()){
            varDefinition.accept(this, null);
        }

        // Variables locales
        cg.comment("Local variables");
        for(Statement statement : functDefinition.getBody()) {
            if(statement instanceof VarDefinition) {
                statement.accept(this, null);
            }
        }

        // Ejecutamos la función
        cg.enter(functDefinition.getLocalVariablesBytes());
        for (Statement statement : functDefinition.getBody()) {
            if(!(statement instanceof VarDefinition)) {
                statement.accept(this, functDefinition);
            }
        }

        // Si su tipo de retrono es void (no tiene return)
        if(type.getReturnType() instanceof VoidType) {
            cg.ret(0, functDefinition.getLocalVariablesBytes(), type.getParametersBytes());
        }

        return null;
    }

    /*
    execute[[FunctInvocation: statement -> expression expression*]] () =
        value[[(Expression)statement]] ()
        if (!((Expression)statement).type instanceof VoidType))
            <pop>((Expression)statement).type.suffix()
    */
    @Override
    public Object visit(FunctInvocation functInvocation, Object param) {

        // Metainformacion
        cg.line(functInvocation);

        // No hace falta el cast de la plantilla explicitamente
        // Al ejecutar la función como sentencia, no se puede recoger su valor,
        // por lo que hay que quitarlo de la pila para evitar corromperla.
        functInvocation.accept(valueCGVisitor, null);
        if(!(functInvocation.getType() instanceof VoidType)) {
            cg.pop(functInvocation.getType());
        }

        return null;
    }

    /*
    execute[[Assignment: statement -> left:expression right:expression]] () =
        address[[left]] ()
        value[[right]] ()
        right.type.suffix<2>left.type.suffix
        <store>left.type.suffix
    */
    @Override
    public Object visit(Assignment assignment, Object param) {
        cg.line(assignment);
        cg.comment("Assignment");
        assignment.getLeft().accept(addressCGVisitor, null);
        assignment.getRight().accept(valueCGVisitor, null);
        cg.a2b(assignment.getRight().getType(), assignment.getLeft().getType());
        cg.store(assignment.getLeft().getType());
        return null;
    }


    /*
    execute[[Print: statement -> expression*]] () =
        for(Expression expression : expression*)
            value[[expression]] ()
            <out>expression.type.suffix()
    */
    @Override
    public Object visit(Print print, Object param) {
        for(Expression expression : print.getExpressions()) {
            cg.line(print);
            cg.comment("Print");
            expression.accept(valueCGVisitor, null);
            cg.out(expression.getType());
        }
        return null;
    }

    /*
    execute[[Input: statement -> expression*]] () =
    for(Expression expression : expression*)
        address[[expression]] ()
        <in>expression.type.suffix()
        <store>expression.type.suffix()
    */
    @Override
    public Object visit(Input input, Object param) {
        for(Expression expression : input.getExpressions()) {
            cg.line(input);
            cg.comment("Input");
            expression.accept(addressCGVisitor, null);
            cg.in(expression.getType());
            cg.store(expression.getType());
        }
        return null;
    }

    /*
    execute[[While: statement -> condition:expression statement*]] () =
        String condition = cg.getNextLabel()
        String end = cg.getNextLabel()
        condition<:>
        value[[condition]] ()
        <jz >end
        for(Statement statement : statement*)
            execute[[statement]] ()
        <jmp >condition
        end<:>
    */
    @Override
    public Object visit(While w, Object param) {

        // Metainformacion
        cg.line(w);
        cg.comment("While");

        // Preparamos las etiquetas a usar
        String condition = cg.getNextLabel();
        String end = cg.getNextLabel();

        // Evaluamos la condicion del while
        cg.line(w.getCondition());
        cg.label(condition);
        w.getCondition().accept(valueCGVisitor, null);
        cg.jz(end);

        // Ejecutamos el while
        cg.comment("While body");
        for(Statement statement : w.getBody()) {
            statement.accept(this, null);
        }
        cg.jmp(condition);
        cg.label(end);

        return null;
    }

    /*
    execute[[Conditional: statement -> condition: expression statement1* statement2*]] () =
        String elseStart = cg.getNextLabel()
        String end = cg.getNextLabel()
        value[[condition]] ()
        <jz >else
        for(Statement statement : statement1*)
            execute[[statement]] ()
        <jmp >end
        else<:>
        for(Statement statement : statement2*)
            execute[[statement]] ()
        end<:>
     */
    @Override
    public Object visit(Conditional conditional, Object param) {

        // Metainformacion
        cg.line(conditional);
        cg.comment("If");

        // Preparamos las etiquetas a usar
        String elseStart = cg.getNextLabel();
        String end = cg.getNextLabel();

        // Evaluamos la condicion del if
        cg.line(conditional.getCondition());
        conditional.getCondition().accept(valueCGVisitor, null);
        cg.jz(elseStart);

        // Ejecutamos el condicional
        cg.comment("If body");
        for(Statement statement : conditional.getIfBody()) {
            statement.accept(this, null);
        }
        cg.jmp(end);
        cg.label(elseStart);
        cg.comment("Else body");
        for(Statement statement : conditional.getElseBody()) {
            statement.accept(this, null);
        }
        cg.label(end);

        return  null;
    }

    /*
    execute[[Return: statement -> expression]] (functDefinition) =
        value[[expression]] ()
        <ret>
            functDefinition.type.returnType.numberOfBytes() <,>
            functDefinition.bytesLocalSum <,>
            functDefinition.type.bytesParamsSum
    */
    @Override
    public Object visit(Return r, Object param) {

        // Metainformacion
        cg.line(r);
        cg.comment("Return");

        // Recogemos la definicion de la funcion donde esta el return
        FunctDefinition functDefinition = (FunctDefinition) param;

        // Ejecutamos el return
        r.getExpression().accept(valueCGVisitor, null);
        cg.ret(r.getExpression().getType().numberOfBytes(),
                functDefinition.getLocalVariablesBytes(),
                ((FunctType) functDefinition.getType()).getParametersBytes());

        return null;
    }

}
