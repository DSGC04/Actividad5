package Problema2;

public class ExtensionTerrenoInvalidaException extends Exception {
    public ExtensionTerrenoInvalidaException(double hectareas, double limiteMaximo) {
        super("Extension de terreno invalida: " + hectareas + " ha. Debe estar entre 0.5 y " + limiteMaximo + " ha.");
    }
}
