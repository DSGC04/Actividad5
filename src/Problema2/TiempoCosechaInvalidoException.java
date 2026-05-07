package Problema2;

public class TiempoCosechaInvalidoException extends Exception {
    public TiempoCosechaInvalidoException(int tiempo) {
        super("Tiempo de cosecha invalido: " + tiempo + ". Debe estar entre 1 y 6 periodos.");
    }
}