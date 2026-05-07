package Problema3;
import java.util.Arrays;
import java.util.List;

public class MesInvalidoException extends Exception {

    private static final List<String> MESES_VALIDOS = Arrays.asList(
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    );

    public MesInvalidoException(String mes) {
        super("Mes invalido en el periodo: '" + mes + "'. Meses validos: " + MESES_VALIDOS);
    }

    public static List<String> getMesesValidos() {
        return MESES_VALIDOS;
    }
}

