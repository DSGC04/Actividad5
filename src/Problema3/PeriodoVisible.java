package Problema3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PeriodoVisible implements Comparable<PeriodoVisible> {

    private String periodo;

    public PeriodoVisible(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PeriodoVisible that = (PeriodoVisible) o;
        return Objects.equals(periodo, that.periodo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(periodo);
    }
    @Override
    public int compareTo(PeriodoVisible otro) {
        return this.periodo.compareTo(otro.periodo);
    }

    @Override
    public String toString() {
        return "PeriodoVisible{" +
                "periodoObservado='" + periodo + '\'' +
                '}';
    }
    public static void main(String[] args) {

        List<PeriodoVisible> lista = new ArrayList<>();

        lista.add(new PeriodoVisible("Marzo - Mayo"));
        lista.add(new PeriodoVisible("Enero - Febrero"));
        lista.add(new PeriodoVisible("Junio - Agosto"));


        Collections.sort(lista);
        System.out.println("Orden por periodo:");
        System.out.println(lista);

        Collections.sort(lista, new ComparadorPeriodoVisible());
        System.out.println("Orden por longitud del texto:");
        System.out.println(lista);
    }


}