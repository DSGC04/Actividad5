package Problema1;

import java.util.*;
import java.util.Objects;

public class Prenda implements Comparable<Prenda> {

    private static final List<String> GENEROS_VALIDOS = Arrays.asList("Masculino", "Femenino", "Mixto");
    private static final List<String> TEMPORADAS_VALIDAS = Arrays.asList("Primavera", "Verano", "Otono", "Invierno");

    private String modelo;
    private String tela;
    private double costoProduccion;
    private String genero;
    private String temporada;
    private double limiteCosto;

    public Prenda(String modelo, String tela, double costoProduccion, String genero, String temporada, double limiteCosto)
            throws GeneroInvalidoException, TemporadaInvalidaException, CostoProduccionExcedidoException {

        validarGenero(genero);
        validarTemporada(temporada);
        validarCosto(costoProduccion, limiteCosto);

        this.modelo = modelo;
        this.tela = tela;
        this.costoProduccion = costoProduccion;
        this.genero = genero;
        this.temporada = temporada;
        this.limiteCosto = limiteCosto;
    }

    private void validarGenero(String genero) throws GeneroInvalidoException {
        if (!GENEROS_VALIDOS.contains(genero)) {
            throw new GeneroInvalidoException(genero);
        }
    }

    private void validarTemporada(String temporada) throws TemporadaInvalidaException {
        if (!TEMPORADAS_VALIDAS.contains(temporada)) {
            throw new TemporadaInvalidaException(temporada);
        }
    }

    private void validarCosto(double costo, double limite) throws CostoProduccionExcedidoException {
        if (costo > limite) {
            throw new CostoProduccionExcedidoException(costo, limite);
        }
    }

    public String getModelo() { return modelo; }
    public String getTela() { return tela; }
    public double getCostoProduccion() { return costoProduccion; }
    public String getGenero() { return genero; }
    public String getTemporada() { return temporada; }

    @Override
    public String toString() {
        return "Prenda{" +
                "modelo='" + modelo + '\'' +
                ", tela='" + tela + '\'' +
                ", costoProduccion=" + costoProduccion +
                ", genero='" + genero + '\'' +
                ", temporada='" + temporada + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prenda prenda = (Prenda) o;
        return Double.compare(costoProduccion, prenda.costoProduccion) == 0 &&
                Objects.equals(modelo, prenda.modelo) && Objects.equals(tela, prenda.tela) &&
                Objects.equals(genero, prenda.genero) && Objects.equals(temporada, prenda.temporada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, tela, costoProduccion, genero, temporada);
    }

    @Override
    public int compareTo(Prenda otra) {
        return Double.compare(this.costoProduccion, otra.costoProduccion);
    }
}


