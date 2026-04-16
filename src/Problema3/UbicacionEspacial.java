package Problema3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UbicacionEspacial implements Comparable<UbicacionEspacial> {

    private double latitud;
    private String hemisferioLatitud;
    private double longitud;
    private String hemisferioLongitud;

    public UbicacionEspacial(double latitud, String hemisferioLatitud, double longitud, String hemisferioLongitud) {
        this.latitud = latitud;
        this.hemisferioLatitud = hemisferioLatitud;
        this.longitud = longitud;
        this.hemisferioLongitud = hemisferioLongitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UbicacionEspacial that = (UbicacionEspacial) o;
        return Double.compare(latitud, that.latitud) == 0 &&
                Double.compare(longitud, that.longitud) == 0 && Objects.equals(hemisferioLatitud,
                that.hemisferioLatitud) && Objects.equals(hemisferioLongitud, that.hemisferioLongitud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, hemisferioLatitud, longitud, hemisferioLongitud);
    }

    @Override
    public int compareTo(UbicacionEspacial otra) {
        return Double.compare(this.latitud, otra.latitud);
    }

    @Override
    public String toString() {
        return "UbicacionEspacial{" +
                "latitud=" + latitud + "° " + hemisferioLatitud +
                ", longitud=" + longitud + "° " + hemisferioLongitud +
                '}';
    }
    public static void main(String[] args) {

        List<UbicacionEspacial> lista = new ArrayList<>();

        lista.add(new UbicacionEspacial(45, "Norte", 120, "Este"));
        lista.add(new UbicacionEspacial(30, "Sur", 100, "Oeste"));
        lista.add(new UbicacionEspacial(60, "Norte", 80, "Este"));


        Collections.sort(lista);
        System.out.println("Orden por latitud:");
        System.out.println(lista);


        Collections.sort(lista, new ComparadorUbicacionPorLongitud());
        System.out.println("Orden por longitud:");
        System.out.println(lista);
    }

}

