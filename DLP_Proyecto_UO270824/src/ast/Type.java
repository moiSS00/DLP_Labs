package ast;

import java.util.List;

public interface Type extends ASTNode {

    /**
     * Responde a la pregunta ¿ El tipo que invoca a este método es un tipo básico ?.
     * Usado en el tipo función para comprobar que el tipo de los parámetros y el tipo de retorno
     * sean tipos básicos.
     * Los tipos básicos / simples son -> entero, double, char.
     * @return True si el tipo de los parámetros y el tipo de retorno son tipos básicos,
     * false en caso contrario.
     */
    boolean isBuiltInType();

    /**
     * Responde a la pregunta ¿ Eres un tipo lógico ?.
     * Un tipo lógico es aquel que se puede interpretar como un booleano.
     * Tipos lógicos -> entero
     * Usado en las condiciones del if y del while.
     * @return True si es un tipo lógico, false en caso contrario.
     */
    boolean isLogical();

    /**
     * Responde a la pregunta ¿ Se puede hacer operaciones aritméticas entre el tipo que invoca a
     * este método y el tipo que se pasa como parámetro ?
     * Los operandos tendrían que ser del mismo tipo y también debemos poder hacer operaciones
     * aritméticas con ellos.
     * Usado en las operaciones aritméticas binarias.
     * Los tipos operables son -> entero, real, char
     * ¡ OJO ! Los tipo char se pueden sumar entre ellos dando un resultado entero.
     * @return Si lo anteriormente mencionado se cumple, se devuelve el tipo resultante de la
     * operación si los tipos son compatibles, null en caso contrario.
     */
    Type arithmetic(Type other);

    /**
     * Responde a la pregunta ¿ Se pueden hacer operaciones aritméticas unarias con el tipo que
     * invoca a este método ?.
     * El tipo que llama a este método debería ser "operable" -> entero, real, char.
     * Usado en las operaciones aritméticas unarias.
     * ¡ OJO ! Se puede operar con los tipos char dando un resultado entero.
     * @return Si lo anteriormente mencionado se cumple, se devuelve el tipo resultante de la
     * operación si el tipo que invoca a este método es operarable, null en caso contrario.
     */
    Type arithmetic();

    /**
     * Responde a la pregunta ¿ Se puede hacer comparaciones booleanas entre el tipo que invoca a
     * este método y el tipo que se pasa como parámetro ?
     * Los operandos tendrían que ser del mismo tipo también debemos poder hacer operaciones
     * booleanas con ellos (tienen que ser de un tipo "booleano").
     * Usado en las condiciones booleanas.
     * ¡ OJO ! Ambos lados de la comparación booleana deben de ser enteros.
     * ¡ OJO ! El resultado de una condición booleana siempre será entero.
     * @return Si lo anteriormente mencionado se cumple, el tipo resultante de la operación
     * si los tipos son compatibles, null en caso contrario.
     */
    Type logic(Type other);

    /**
     * Responde a la pregunta ¿ Se pueden hacer condiciones booleanas unarias con el tipo que
     * invoca a este método ?.
     * Usado en las condiciones booleanas unarias.
     * ¡ OJO ! El tipo que llama a este método debe de ser booleano.
     * El tipo que simula a los booleanos es el entero.
     * @return Si lo anteriormente mencionado se cumple, el tipo resultante de la operación
     * si el tipo que invoca a este método es "booleano", null en caso contrario.
     */
    Type logic();

    /**
     * Responde a la pregunta ¿ Se puede asignar al tipo que se pasa como parámetro (izquierda de la
     * asignación) el tipo que invoca a este método (derecha de la asignación) ?
     * Usado en las asignaciones.
     * ¡ OJO ! El tipo tiene que ser el mismo y asignable (array con array es error).
     * El que llama al método es el tipo de la parte derecha de la asignación y el parámetro recibido
     * es el tipo de la parte izquierda.
     * @return Si lo anteriormente mencionado se cumple, se devuelve el tipo resultante
     * de la asignación, null en caso contrario.
     */
    Type promotesTo(Type other);

    /**
     * Responde a la pregunta ¿ El tipo que
     * invoca a este método puede ser casteado al tipo que paso como parámetro ?.
     * Usado en los casts.
     * Los casts permitidos son:
     *  (char) char -> char
     *  (int) char -> int
     *  (int) double -> int
     *  (int) int -> int
     *  (double) char -> double
     *  (double) int -> double
     *  (double) double -> double
     * @return El tipo resultante del cast si se puede hacer, null en caso contrario.
     */
    Type canBeCastTo(Type other);

    /**
     * Responde a la pregunta ¿ Se puede hacer comparaciones lógicas entre el tipo que invoca a
     * este método y el tipo que se pasa como parámetro ?
     * Los operandos tendrían que ser del mismo tipo también debemos poder hacer operaciones
     * condicionales con ellos.
     * Usado en las condiciones lógicas.
     * Los tipos con los que se pueden hacer operaciones lógicas son -> entero, real, char
     * ¡ OJO ! El resultado de una condición lógica siempre será entero.
     * @return Si lo anteriomente mencionado se cumple, el tipo resultante de la operación si
     * los tipos son compatibles, null en caso contrario.
     */
    Type comparison(Type other);

    /**
     * Responde a la pregunta ¿ El tipo que invoca a este método es un array
     * (solucionado por polimorfismo) y el tipo que paso como parámetro (sería el índice)
     * es de tipo entero ?
     * Usado en los accesos a array.
     * ¡ OJO ! Este método solo lo implementa el tipo array.
     * @return Si lo anteriomente mencionado se cumple, el tipo resultante del acceso a array,
     * null en caso contrario.
     */
    Type squareBrackets(Type other);

    /**
     * Responde a la pregunta ¿ El tipo que invoca a este método es un struct (solucionado
     * por polimorfismo) y tiene el campo que paso como parámetro ?
     * Usado en los accesos a struct.
     * ¡ OJO ! Este método solo lo implementa el tipo struct.
     * @return Si lo anteriomente mencionado se cumple, el tipo resultante del acceso a struct,
     * null en caso contrario.
     */
    Type dot(String name);

    /**
     * Responde a la pregunta ¿ El tipo que invoca a este método es un tipo función
     * (solucionado por polimorfismo) y el número de parámetros y el tipo de estos son correctos ?
     * Usado en las invoaciones a función.
     * Para que el tipo de los parámetros sea correcto debe promover (promotesTo) al definido en
     * la función.
     * ¡ OJO ! Este método solo lo implementa el tipo funcion.
     * @return Si lo anteriomente mencionado se cumple, se devuelve el tipo de retorno de la función,
     * null en caso contrario.
     */
    Type parenthesis(List<Expression> expressions);

    /**
     * Devuelve el peso del tipo que llama a este método.
     * @return Peso del tipo que llama al método.
     */
    int numberOfBytes();

    /**
     * Devuelve el sufijo que representa al tipo que llama a este método.
     * @return Sufijo del tipo que llama al método.
     */
    char suffix();
}
