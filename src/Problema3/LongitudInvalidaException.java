package Problema3;

public class LongitudInvalidaException extends Exception {
    public LongitudInvalidaException(double longitud) {
        super("Longitud invalida: " + longitud + ". Los grados de longitud no pueden superar 180.");
    }
}
