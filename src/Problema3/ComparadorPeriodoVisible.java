package Problema3;
import java.util.Comparator;

public class ComparadorPeriodoVisible implements Comparator<PeriodoVisible> {

    @Override
    public int compare(PeriodoVisible p1, PeriodoVisible p2) {
        return Integer.compare(p1.getPeriodo().length(), p2.getPeriodo().length());
    }
}
