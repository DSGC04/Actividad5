package Problema1;

import java.time.LocalDate;
import java.util.Objects;
import java.util.*;

public class Lote implements Comparable<Lote> {

    private static final int MIN_PIEZAS = 50;
    private static final int MAX_PIEZAS = 350;

    private int numeroLote;
    private int numeroPiezas;
    private LocalDate fechaFabricacion;
    private Prenda prenda;

    public Lote(int numeroLote, int numeroPiezas, LocalDate fechaFabricacion, Prenda prenda)
            throws NumeroPiezasInvalidoException {

        validarNumeroPiezas(numeroPiezas);

        this.numeroLote = numeroLote;
        this.numeroPiezas = numeroPiezas;
        this.fechaFabricacion = fechaFabricacion;
        this.prenda = prenda;
    }

    private void validarNumeroPiezas(int piezas) throws NumeroPiezasInvalidoException {
        if (piezas < MIN_PIEZAS || piezas > MAX_PIEZAS) {
            throw new NumeroPiezasInvalidoException(piezas);
        }
    }

    public double calcularCostoProduccion() {
        return prenda.getCostoProduccion() * numeroPiezas;
    }

    public double calcularMontoRecuperacion() {

        double precioPorPieza = prenda.getCostoProduccion() * 1.15;
        return precioPorPieza * numeroPiezas;
    }

    public double calcularMontoRecuperacionLoteCompleto() {

        double precioPorPieza = prenda.getCostoProduccion() * 1.05;
        return precioPorPieza * numeroPiezas;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "numeroLote=" + numeroLote +
                ", numeroPiezas=" + numeroPiezas +
                ", fechaFabricacion=" + fechaFabricacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lote lote = (Lote) o;
        return numeroLote == lote.numeroLote && numeroPiezas == lote.numeroPiezas &&
                Objects.equals(fechaFabricacion, lote.fechaFabricacion) &&
                Objects.equals(prenda, lote.prenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroLote, numeroPiezas, fechaFabricacion, prenda);
    }

    @Override
    public int compareTo(Lote otro) {
        return Integer.compare(this.numeroLote, otro.numeroLote);
    }
}


