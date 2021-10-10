grammar Pmm;

@header{
import ast.*;
import errorhandler.*;
}

//Análisis sintáctico. Comprobamos que los tokens siguen un orden / estructura correcto.
//Para ello, definiremos una gramática libre de contexto.

// program -> definition* mainFunction
program returns [Program ast]: {
            List<Definition> definitions = new ArrayList<Definition>();}
            (df=definition {definitions.addAll($df.ast);})*
            mf=mainFunction {definitions.add($mf.ast);}
            EOF {$ast = new Program(0,0,definitions);};

// definition -> (functionDefinition | variableDefinition)
definition returns [List<Definition> ast]: {
            List<Definition> definitions = new ArrayList<Definition>();}
            (fd=functionDefinition {definitions.add($fd.ast);}
            | vd=variableDefinition {definitions.addAll($vd.ast);})
            {$ast = definitions;};

// mainFunction -> 'def' 'main' '(' ')' ':' '{' (variableDefinition)* (statement)* '}'
mainFunction returns [FunctDefinition ast]: 'def' MAIN='main' '(' ')' ':' '{' {
            List<Statement> body = new ArrayList<Statement>();
            List<VarDefinition> parameters = new ArrayList<VarDefinition>();
            Type returnType = new VoidType();}
            (vd=variableDefinition { body.addAll($vd.ast); })* (st=statement { body.add($st.ast); })* '}'
            { $ast = new FunctDefinition($MAIN.getLine(), $MAIN.getCharPositionInLine() + 1,
            new FunctType($MAIN.getLine(), $MAIN.getCharPositionInLine() + 1, parameters, returnType),
            $MAIN.text, body); };

// functionDefinition -> 'def' ID '(' parameters? ')' ':' '{' (variableDefinition)* (statement)* '}'
functionDefinition returns [FunctDefinition ast]: 'def' ID {
            List<VarDefinition> parameters = new ArrayList<VarDefinition>();
            List<Statement> body = new ArrayList<Statement>();
            Type returnType = new VoidType(); }
            '(' (param=parameters {parameters.addAll($param.ast);})? ')'
            ':' (returnType=builtIntype {returnType = $returnType.ast;})?
            '{' (vd=variableDefinition { body.addAll($vd.ast); })* (st=statement {body.add($st.ast); })* '}'
            { $ast = new FunctDefinition(
            $ID.getLine(), $ID.getCharPositionInLine() + 1,
            new FunctType($ID.getLine(), $ID.getCharPositionInLine() + 1, parameters, returnType),
            $ID.text,body);};

// parameters -> ID ':' buildType (',' ID buildType)*
parameters returns [List<VarDefinition> ast]: id1=ID ':' bt1=builtIntype {
            List<VarDefinition> parameters = new ArrayList<VarDefinition>();
            parameters.add(new VarDefinition($id1.getLine(), $id1.getCharPositionInLine() + 1,
            $bt1.ast, $id1.text));
            }(','id2=ID ':' bt2=builtIntype {
            parameters.add(new VarDefinition($id2.getLine(), $id2.getCharPositionInLine() + 1,
            $bt2.ast, $id2.text));})* {$ast = parameters;};

// variableDefinition -> ids ':' type ';'
variableDefinition returns [List<VarDefinition> ast]: ids ':' tp=type ';' {
            List<VarDefinition> definitions = new ArrayList<VarDefinition>();
            for(Variable var : $ids.ast) {
                definitions.add(new VarDefinition(var.getLine(), var.getColumn(), $tp.ast, var.getName()));
            } $ast = definitions;};

//Regla auxiliar para poder encapsular la informacion y utilizarla en la regla variableDefinition
//Esto se hizo por problemas con el tipo.
// ids -> ID (',' ID)*
ids returns [List<Variable> ast]: id1=ID {
             List<Variable> variables = new ArrayList<Variable>();
            variables.add(new Variable($id1.getLine(), $id1.getCharPositionInLine() + 1, $id1.text));
            }(','id2=ID {
            variables.add(new Variable($id2.getLine(), $id2.getCharPositionInLine() + 1, $id2.text));})*
            { $ast = variables; };

// functionInvocation -> ID '(' expressions? ')'
functionInvocation returns [FunctInvocation ast]: ID { List<Expression> expressions =
            new ArrayList<Expression>(); }'(' (arg=expressions { expressions = $arg.ast;})? ')' {
            Variable name = new Variable($ID.getLine(), $ID.getCharPositionInLine(), $ID.text);
            $ast = new FunctInvocation($ID.getLine(), $ID.getCharPositionInLine() + 1,
            name, expressions);
            };

// expressions -> expression (',' expression)*
expressions returns [List<Expression> ast]: exp1=expression {
            List<Expression> expressions = new ArrayList<Expression>();
            expressions.add($exp1.ast); }(','exp2=expression {
            expressions.add($exp2.ast);
            })* { $ast = expressions;};


// statement -> expression '=' expression ';'
                // | 'print'  expressions ';'
                // | 'input' expressions ';'
                // | 'return' expression ';'
                // | 'if' expression ':' body ('else' body)?
                // | 'while' expression ':' body
                // | functionInvocation ';'
statement returns [Statement ast]: left=expression '=' right=expression ';' {
            $ast = new Assignment($left.ast.getLine(),$left.ast.getColumn(),
            $left.ast,$right.ast);}
            | PRINT='print' exps=expressions ';' {
            $ast = new Print($PRINT.getLine(), $PRINT.getCharPositionInLine(), $exps.ast);}
            | INPUT='input' exps=expressions  ';' {
            $ast = new Input($INPUT.getLine(), $INPUT.getCharPositionInLine(), $exps.ast);}
            | RETURN='return' exp=expression ';' {
            $ast = new Return($RETURN.getLine(), $RETURN.getCharPositionInLine() + 1, $exp.ast);}
            | {List<Statement> elseBody = new ArrayList<Statement>();}
            IF='if' condition=expression ':' bd1=body ('else' bd2=body {elseBody = $bd2.ast;})? {
            $ast = new Conditional($IF.getLine(), $IF.getCharPositionInLine() + 1,
            $condition.ast, $bd1.ast, elseBody); }
            | WHILE='while' condition=expression ':' bd=body  {
            $ast = new While($WHILE.getLine(), $WHILE.getCharPositionInLine() + 1,
            $condition.ast, $bd.ast);}
            | fi=functionInvocation ';' { $ast = $fi.ast; };

//Regla auxiliar usada por el condicional y por el while. Permite omitir las llaves si el cuerpo solo esta
//formado por una unica sentencia.
// body -> '{' statment* '}' | statement
body returns [List<Statement> ast]: '{' {List<Statement> body = new ArrayList<Statement>();}
            (st1=statement {body.add($st1.ast);})* '}' {$ast = body;}
            | st2=statement {List<Statement> body = new ArrayList<Statement>();
            body.add($st2.ast);$ast = body;};

// expression -> INT_CONSTANT
            // | REAL_CONSTANT
            // | CHAR_CONSTANT
            // | functionInvocation
            // | '(' expression ')'
            // | expression '[' expression ']'
            // | expression '.' ID
            // | '(' builtIntype ')' expression
            // | '-' expression
            // | '!' expression
            // | expression ('*' | '/' | '%') expression
            // | expression ('+' | '-' ) expression
            // | expression ('>' | '>=' | '<' | '<=' | '==' | '!=') expression
            // | expression ('&&' | '||' ) expression
expression returns [Expression ast]: INT_CONSTANT { $ast = new IntLiteral($INT_CONSTANT.getLine(),
            $INT_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToInt($INT_CONSTANT.text)); }
            | REAL_CONSTANT { $ast = new DoubleLiteral($REAL_CONSTANT.getLine(),
            $REAL_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToReal($REAL_CONSTANT.text));}
            | CHAR_CONSTANT { $ast = new CharLiteral($CHAR_CONSTANT.getLine(),
            $CHAR_CONSTANT.getCharPositionInLine() + 1, LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
            | ID { $ast = new Variable($ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text);}
            | fi=functionInvocation { $ast = $fi.ast; }
            | '(' exp=expression ')' { $ast = $exp.ast;}
            | exp=expression '[' index=expression ']' {
            $ast = new ArrayAccess($exp.ast.getLine(), $exp.ast.getColumn(),
            $exp.ast, $index.ast);}
            | exp=expression '.' ID {
            $ast = new FieldAccess($exp.ast.getLine(), $exp.ast.getColumn(),
            $exp.ast, $ID.text);}
            | '(' castTo=builtIntype ')' exp=expression {
            $ast = new Cast($castTo.ast.getLine(), $castTo.ast.getColumn(),
            $castTo.ast, $exp.ast);}
            | '-' exp=expression {
            $ast = new UnaryMinus($exp.ast.getLine(), $exp.ast.getColumn(),
            $exp.ast);}
            | '!' exp=expression {
            $ast = new Negation($exp.ast.getLine(), $exp.ast.getColumn(),
            $exp.ast);}
            | left=expression OP=('*'|'/'|'%') right=expression {
            $ast = new Arithmetic($left.ast.getLine(), $left.ast.getColumn(),
            $left.ast, $OP.text, $right.ast);}
            | left=expression OP=('+'|'-') right=expression {
            $ast = new Arithmetic($left.ast.getLine(), $left.ast.getColumn(),
            $left.ast, $OP.text, $right.ast);}
            | left=expression OP=('>'|'>='|'<'|'<='|'!='|'==') right=expression {
            $ast = new LogicalCondition($left.ast.getLine(), $left.ast.getColumn(),
            $left.ast, $OP.text, $right.ast);}
            | left=expression OP=('&&'|'||') right=expression {
            $ast = new BooleanCondition($left.ast.getLine(), $left.ast.getColumn(),
            $left.ast, $OP.text, $right.ast);};

// type -> (buildIntType | complexType)
type returns [Type ast]: (bt=builtIntype {$ast = $bt.ast;} | ct=complexType { $ast = $ct.ast;} );

// buildIntType -> 'int' | 'double' | 'char'
builtIntype returns [Type ast]: INT='int' { $ast = new IntType(); }
            | DOUBLE='double' { $ast = new DoubleType(); }
            | CHAR='char' { $ast = new CharType(); };

// complexType -> 'struct' '{' variableDefinition* '}' | '[' INT_CONSTANT ']' type
complexType returns [Type ast]: STRUCT='struct' '{' {
            List<RecordField> fields = new ArrayList<RecordField>(); }
            (fds=variableDefinition {
            for(VarDefinition vr : $fds.ast) {
                for (RecordField rf : fields) {
                    if (rf.getName().equals(vr.getName())) {
                        new ErrorType(vr.getLine(),vr.getColumn(),
                        "Campo '" + rf.getName() + "' duplicado en el struct.");
                        break;
                    }
                }
                RecordField field = new RecordField(vr.getLine(), vr.getColumn(),
                    vr.getName(), vr.getType());
                fields.add(field);
            }
            })* {$ast = new StructType(
            $STRUCT.getLine(), $STRUCT.getCharPositionInLine() + 1, fields);}'}'
            | '[' INT_CONSTANT ']' tp=type { $ast = new ArrayType(
            $INT_CONSTANT.getLine(), $INT_CONSTANT.getCharPositionInLine() + 1,
            $tp.ast,  LexerHelper.lexemeToInt($INT_CONSTANT.text));};

//Análisis léxico: Comprobar que todas las palabras / cadenas individuales de nuestro programa son correctas.
//Para ello, se definen una serie de patrones con expresiones regulares.

// Exponente
fragment
EXPONENT: [Ee]'-'?INT_CONSTANT;

// Letra mayúscula / minúscula
fragment
LETTER: [A-Za-z];

// Espacios en blanco / tabuladores / saltos de línea
WHITE_SPACE: [ \n\r\t]+ -> skip;

// Comentarios de una línea
ONE_LINE_COMMENT: '#' .*? ('\n' | EOF) -> skip;

// Comentario de múltiples líneas
MULTIPLE_LINE_COMMENT: '"""' .*? '"""' -> skip;

// Constante entera
INT_CONSTANT: '0' | [1-9][0-9]*;

// Constante real
REAL_CONSTANT: INT_CONSTANT '.' INT_CONSTANT EXPONENT?
    | INT_CONSTANT EXPONENT
    | INT_CONSTANT '.' EXPONENT?
    | '.' INT_CONSTANT;

// Constante carácter
CHAR_CONSTANT: '\'' . '\'' | '\'\\'[nt]'\'' | '\'\\'INT_CONSTANT'\'';

// Identificador
ID: (LETTER | '_') (LETTER | [0-9] | '_')*;













