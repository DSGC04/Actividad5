package Problema2;

import java.util.Objects;
public class Fruta {

    private String nombreFruta;
    private double hectareas;
    private double costoProduccionTon;
    private double precioVentaTon;

    public Fruta(String nombre, double hectareas, double costoProduccionTon, double precioVentaTon) {
        this.nombreFruta = nombre;
        this.hectareas = hectareas;
        this.costoProduccionTon = costoProduccionTon;
        this.precioVentaTon = precioVentaTon;
    }

    public String getNombre() {
        return nombreFruta;
    }

    public double getHectareas() {
        return hectareas;
    }

    public double getCostoProduccionTon() {
        return costoProduccionTon;
    }

    public double getPrecioVentaTon() {
        return precioVentaTon;
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "nombre='" + nombreFruta + '\'' +
                ", hectareasCultivadas=" + hectareas + " ha" +
                ", costoProduccionPorTonelada=$" + costoProduccionTon +
                ", precioVentaPorTonelada=$" + precioVentaTon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fruta fruta = (Fruta) o;
        return Double.compare(hectareas, fruta.hectareas) == 0 &&
                Double.compare(costoProduccionTon, fruta.costoProduccionTon) == 0 &&
                Double.compare(precioVentaTon, fruta.precioVentaTon) == 0 && Objects.equals
                (nombreFruta, fruta.nombreFruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreFruta, hectareas, costoProduccionTon, precioVentaTon);
    }
}
