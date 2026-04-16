package Problema2;

import java.util.Objects;
import java.util.*;
public class Fruta implements Comparable<Fruta> {

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
                ", hectareas=" + hectareas +
                ", costoProduccionTon=" + costoProduccionTon +
                ", precioVentaTon=" + precioVentaTon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruta)) return false;
        Fruta fruta = (Fruta) o;
        return Double.compare(hectareas, fruta.hectareas) == 0 &&
                Double.compare(costoProduccionTon, fruta.costoProduccionTon) == 0 &&
                Double.compare(precioVentaTon, fruta.precioVentaTon) == 0 &&
                Objects.equals(nombreFruta, fruta.nombreFruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreFruta, hectareas, costoProduccionTon, precioVentaTon);
    }

    @Override
    public int compareTo(Fruta otra) {
        return this.nombreFruta.compareTo(otra.nombreFruta);
    }

    public static void main(String[] args) {

        List<Fruta> lista = new ArrayList<>();

        lista.add(new Fruta("Mango", 10, 2000, 3500));
        lista.add(new Fruta("Manzana", 5, 1500, 3000));
        lista.add(new Fruta("Plátano", 8, 1800, 3200));

        Collections.sort(lista);
        System.out.println("Orden por nombre:");
        System.out.println(lista);

        Collections.sort(lista, new ComparadorFrutaPorHectareas());
        System.out.println("Orden por hectareas:");
        System.out.println(lista);
    }
}

