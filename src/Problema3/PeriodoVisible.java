package Problema3;

import java.util.Objects;
public class PeriodoVisible {
  
    private String periodo;

    public PeriodoVisible(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    @Override
    public String toString() {
        return "PeriodoVisible{" +
                "periodoObservado='" + periodo + '\'' +
                '}';
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
}
