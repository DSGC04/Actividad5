package Problema1;

public class NumeroPiezasInvalidoException extends Exception {
    public NumeroPiezasInvalidoException(int numeroPiezas) {
        super("Numero de piezas invalido: " + numeroPiezas + ". Debe estar entre 50 y 350.");
    }
}
