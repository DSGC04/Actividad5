package Problema3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainProblema3 {

    public static void main(String[] args) {

        List<CuerpoCeleste> cuerpos = new ArrayList<>();

        System.out.println("===== PRUEBA DE EXCEPCIONES - PROBLEMA 3 =====\n");

        System.out.println(">> Prueba: Latitud mayor a 180 grados");
        try {
            UbicacionEspacial u1 = new UbicacionEspacial(200.0, "Norte", 120.0, "Este");
        } catch (LatitudInvalidaException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }

        System.out.println("\n>> Prueba: Longitud mayor a 180 grados");
        try {
            UbicacionEspacial u2 = new UbicacionEspacial(45.0, "Norte", 190.0, "Oeste");
        } catch (LongitudInvalidaException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }

        System.out.println("\n>> Prueba: Latitud negativa");
        try {
            UbicacionEspacial u3 = new UbicacionEspacial(-10.0, "Sur", 80.0, "Este");
        } catch (LatitudInvalidaException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }

        System.out.println("\n>> Prueba: Mes invalido en el periodo observable");
        try {
            PeriodoVisible p1 = new PeriodoVisible("Enero - Decimembre");
        } catch (MesInvalidoException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }

        System.out.println("\n>> Prueba: Mes que no existe en el periodo");
        try {
            PeriodoVisible p2 = new PeriodoVisible("Floreal - Germinal");
        } catch (MesInvalidoException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        }

        System.out.println("\n===== CREACION CORRECTA DE CUERPOS CELESTES =====\n");
        try {
            UbicacionEspacial u1 = new UbicacionEspacial(45.0, "Norte", 120.0, "Este");
            UbicacionEspacial u2 = new UbicacionEspacial(47.0, "Norte", 118.0, "Este");
            UbicacionEspacial u3 = new UbicacionEspacial(40.0, "Sur", 110.0, "Oeste");

            CuerpoCeleste estrella = new CuerpoCeleste("Estrella X", "Gases", 5000.0, "años luz", u1);
            CuerpoCeleste planeta = new CuerpoCeleste("Planeta Z", "Solido", 3000.0, "años luz", u2);
            CuerpoCeleste cometa = new CuerpoCeleste("Cometa Y", "Hielo", 8000.0, "años luz", u3);

            PeriodoVisible p1 = new PeriodoVisible("Marzo - Mayo");
            PeriodoVisible p2 = new PeriodoVisible("Enero - Febrero");
            PeriodoVisible p3 = new PeriodoVisible("Junio - Agosto");

            estrella.agregarPeriodo(p1);
            planeta.agregarPeriodo(p2);
            cometa.agregarPeriodo(p3);

            cuerpos.add(estrella);
            cuerpos.add(planeta);
            cuerpos.add(cometa);

            Collections.sort(cuerpos);
            System.out.println("Cuerpos celestes (orden por distancia):");
            System.out.println(cuerpos);

            double desplazamiento = estrella.calcularDesplazamiento(u2);
            System.out.printf("%nDesplazamiento de Estrella X respecto a u2: %.2f grados%n", desplazamiento);

            List<PeriodoVisible> periodos = new ArrayList<>();
            periodos.add(p1);
            periodos.add(p2);
            periodos.add(p3);
            Collections.sort(periodos);
            System.out.println("\nPeriodos ordenados alfabeticamente: " + periodos);

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
