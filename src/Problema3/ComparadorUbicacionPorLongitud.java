package Problema3;
import java.util.Comparator;

public class ComparadorUbicacionPorLongitud implements Comparator<UbicacionEspacial> {

    @Override
    public int compare(UbicacionEspacial u1, UbicacionEspacial u2) {
        return Double.compare(u1.getLongitud(), u2.getLongitud());
    }
}
