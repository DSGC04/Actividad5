package Problema2;

public class PrecioVentaInvalidoException extends Exception {
    public PrecioVentaInvalidoException(double precioVenta, double costoProduccion) {
        double min = costoProduccion * 1.05;
        double max = costoProduccion * 1.30;
        super("Precio de venta invalido: $" + precioVenta + "/ton. Debe estar entre $" +
                String.format("%.2f", min) + " (5% sobre costo) y $" +
                String.format("%.2f", max) + " (30% sobre costo).");
    }
}
