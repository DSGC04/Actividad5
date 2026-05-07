package Problema1;

public class TemporadaInvalidaException extends Exception {
    public TemporadaInvalidaException(String temporada) {
        super("Temporada invalida: '" + temporada + "'. Debe ser Primavera, Verano, Otono o Invierno.");
    }
}

