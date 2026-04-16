package Problema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PeriodoDeCosecha implements Comparable<PeriodoDeCosecha>  {

    private String nombrePeriodo;
    private double cantidadToneladas;
    private Fruta fruta;

    public PeriodoDeCosecha(String periodo, double toneladasPorHectarea, Fruta fruta) {
        this.nombrePeriodo = periodo;
        this.cantidadToneladas = toneladasPorHectarea;
        this.fruta = fruta;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public double getCantidadToneladas() {
        return cantidadToneladas;
    }

    public Fruta getFruta() {
        return fruta;
    }

    public double produccionTotal() {
        return fruta.getHectareas() * cantidadToneladas;
    }

    public double costoProduccion() {
        return produccionTotal() * fruta.getCostoProduccionTon();
    }

    public double gananciasEstimadas() {

        double ingreso = produccionTotal() * fruta.getPrecioVentaTon();

        return ingreso - costoProduccion();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PeriodoDeCosecha that = (PeriodoDeCosecha) o;
        return Double.compare(cantidadToneladas, that.cantidadToneladas) == 0 &&
                Objects.equals(nombrePeriodo, that.nombrePeriodo) && Objects.equals(fruta, that.fruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrePeriodo, cantidadToneladas, fruta);
    }

    @Override
    public int compareTo(PeriodoDeCosecha otro) {
        return this.nombrePeriodo.compareTo(otro.nombrePeriodo);
    }

    @Override
    public String toString() {
        return "PeriodoDeCosecha{" +
                "periodo='" + nombrePeriodo + '\'' +
                ", produccionEstimada=" + cantidadToneladas + " ton/ha" +
                '}';
    }

    public static void main(String[] args) {

        Fruta fruta = new Fruta("Mango", 10, 500, 900);

        List<PeriodoDeCosecha> lista = new ArrayList<>();

        lista.add(new PeriodoDeCosecha("Verano", 3, fruta));
        lista.add(new PeriodoDeCosecha("Primavera", 2, fruta));
        lista.add(new PeriodoDeCosecha("Otoño", 1.5, fruta));


        Collections.sort(lista);
        System.out.println("Orden por periodo:");
        System.out.println(lista);


        Collections.sort(lista, new ComparadorPeriodoPorToneladas());
        System.out.println("Orden por toneladas:");
        System.out.println(lista);
    }

}
