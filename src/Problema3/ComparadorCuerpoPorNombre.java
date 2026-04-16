package Problema3;
import java.util.Comparator;

public class ComparadorCuerpoPorNombre implements Comparator<CuerpoCeleste> {

    @Override
    public int compare(CuerpoCeleste c1, CuerpoCeleste c2) {
        return c1.getNombre().compareTo(c2.getNombre());
    }
}
