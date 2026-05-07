package Problema1;

public class CostoProduccionExcedidoException extends Exception {
    public CostoProduccionExcedidoException(double costo, double limite) {
        super("El costo de produccion $" + costo + " excede el limite permitido de $" + limite + ".");
    }
}

