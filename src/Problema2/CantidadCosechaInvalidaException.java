package Problema2;

public class CantidadCosechaInvalidaException extends Exception {
    public CantidadCosechaInvalidaException(double cantidad) {
        super("Cantidad estimada de cosecha invalida: " + cantidad + " ton/ha. Debe estar entre 0.5 y 200.");
    }
}
