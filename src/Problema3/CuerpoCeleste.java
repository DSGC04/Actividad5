package Problema3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.*;

public class CuerpoCeleste implements Comparable<CuerpoCeleste> {

    private String nombre;
    private String composicion;
    private double distanciaTierra;
    private String unidadTierra;
    private UbicacionEspacial ubicacion;

    public CuerpoCeleste(String nombre, String composicion, double distancia, String unidadTierra, UbicacionEspacial ubicacion) {
        this.nombre = nombre;
        this.composicion = composicion;
        this.distanciaTierra = distancia;
        this.unidadTierra = unidadTierra;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDistanciaTierra() {
        return distanciaTierra;
    }

    public UbicacionEspacial getUbicacion() {
        return ubicacion;
    }

    public double calcularDesplazamiento(UbicacionEspacial otraUbicacion) {

        double diferenciaLatitud = ubicacion.getLatitud() - otraUbicacion.getLatitud();
        double diferenciaLongitud = ubicacion.getLongitud() - otraUbicacion.getLongitud();

        return Math.sqrt((diferenciaLatitud * diferenciaLatitud) +
                (diferenciaLongitud * diferenciaLongitud));
    }

    @Override
    public String toString() {
        return "CuerpoCeleste{" +
                "nombre='" + nombre + '\'' +
                ", composicion='" + composicion + '\'' +
                ", distancia=" + distanciaTierra + " " + unidadTierra +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CuerpoCeleste)) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Double.compare(distanciaTierra, that.distanciaTierra) == 0 &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(composicion, that.composicion) &&
                Objects.equals(unidadTierra, that.unidadTierra) &&
                Objects.equals(ubicacion, that.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, composicion, distanciaTierra, unidadTierra, ubicacion);
    }

    @Override
    public int compareTo(CuerpoCeleste otro) {
        return Double.compare(this.distanciaTierra, otro.distanciaTierra);
    }

    public static void main(String[] args) {

        UbicacionEspacial u1 = new UbicacionEspacial(45, "Norte", 120, "Este");
        UbicacionEspacial u2 = new UbicacionEspacial(47, "Norte", 118, "Este");
        UbicacionEspacial u3 = new UbicacionEspacial(40, "Sur", 110, "Oeste");

        List<CuerpoCeleste> lista = new ArrayList<>();

        lista.add(new CuerpoCeleste("Estrella X", "Gases", 5000, "años luz", u1));
        lista.add(new CuerpoCeleste("Planeta Z", "Solido", 3000, "años luz", u2));
        lista.add(new CuerpoCeleste("Cometa Y", "Hielo", 8000, "años luz", u3));

        Collections.sort(lista);
        System.out.println("Orden por distancia:");
        System.out.println(lista);

        Collections.sort(lista, new ComparadorCuerpoPorNombre());
        System.out.println("Orden por nombre:");
        System.out.println(lista);

        double desplazamiento = lista.get(0).calcularDesplazamiento(u2);
        System.out.printf("Desplazamiento: %.2f\n", desplazamiento);
    }

}