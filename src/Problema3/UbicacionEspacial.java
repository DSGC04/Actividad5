package Problema3;

import java.util.Objects;

public class UbicacionEspacial {

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
    public String toString() {
        return "UbicacionEspacial{" +
                "latitud=" + latitud + "° " + hemisferioLatitud +
                ", longitud=" + longitud + "° " + hemisferioLongitud +
                '}';
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
}

