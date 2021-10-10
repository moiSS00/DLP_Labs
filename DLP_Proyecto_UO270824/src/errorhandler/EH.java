package errorhandler;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class EH {

    // Se sigue el patrón singleton para tener una sola instancia

    private List<ErrorType> errors;
    private static EH EH;

    private EH() {
        this.errors = new ArrayList<ErrorType>();
    }

    public static EH getEH() {
        if(EH == null){
            EH = new EH();
        }
        return EH;
    }

    /**
     * Comprueba si ha habido algún error
     * @return True si hubo errores, false en caso contrario
     */
    public boolean hasErrors() {
        return errors.size() > 0;
    }

    /**
     * Muestra los errores.
     * Recibe la saldia en la que se imprimiran los errores.
     */
    public void showErrors(PrintStream out) {
        for(ErrorType error : errors) {
            out.println(error.toString());
        }
    }

    /**
     * Añade un error.
     * Recibe el error a añadir.
     */
    public void addError(ErrorType error) {
        errors.add(error);
    }

}
