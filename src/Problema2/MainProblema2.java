package Problema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainProblema2 {

    public static void main(String[] args) {

        List<Fruta> frutas = new ArrayList<>();
        List<PeriodoDeCosecha> periodos = new ArrayList<>();

        System.out.println("===== PRUEBA DE EXCEPCIONES - PROBLEMA 2 =====\n");


        System.out.println(">> Prueba: Hectareas menor al minimo (0.5)");
        try {
            Fruta f1 = new Fruta("Fresa", 0.2, 500.0, 600.0, 10.0);
            frutas.add(f1);
        } catch (ExtensionTerrenoInvalidaException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }


        System.out.println("\n>> Prueba: Hectareas mayor al limite del objeto (5 ha)");
        try {
            Fruta f2 = new Fruta("Naranja", 8.0, 1000.0, 1200.0, 5.0);
            frutas.add(f2);
        } catch (ExtensionTerrenoInvalidaException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }


        System.out.println("\n>> Prueba: Precio de venta menor al 5% sobre el costo");
        try {
            Fruta f3 = new Fruta("Mango", 5.0, 2000.0, 2010.0, 10.0); // solo 0.5% sobre costo
            frutas.add(f3);
        } catch (PrecioVentaInvalidoException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }


        System.out.println("\n>> Prueba: Precio de venta mayor al 30% sobre el costo");
        try {
            Fruta f4 = new Fruta("Mango", 5.0, 2000.0, 3500.0, 10.0); // 75% sobre costo
            frutas.add(f4);
        } catch (PrecioVentaInvalidoException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }


        System.out.println("\n>> Prueba: Cantidad de cosecha por hectarea invalida (0.1 ton/ha)");
        try {
            Fruta fBase = new Fruta("Mango", 10.0, 2000.0, 2500.0, 10.0);
            PeriodoDeCosecha p1 = new PeriodoDeCosecha("Verano", 0.1, fBase);
            periodos.add(p1);
        } catch (CantidadCosechaInvalidaException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }


        System.out.println("\n>> Prueba: Agregar mas de 6 periodos de cosecha");
        try {
            Fruta fMango = new Fruta("Mango", 10.0, 2000.0, 2500.0, 10.0);
            for (int i = 1; i <= 7; i++) {
                fMango.agregarPeriodo(new PeriodoDeCosecha("Periodo " + i, 3.0, fMango));
            }
        } catch (TiempoCosechaInvalidoException e) {
            System.out.println("   [EXCEPCION CAPTURADA] " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Error inesperado: " + e.getMessage());
        }


        System.out.println("\n===== CREACION CORRECTA DE FRUTAS Y PERIODOS =====\n");
        try {
            Fruta mango = new Fruta("Mango", 10.0, 2000.0, 2500.0, 10.0);
            Fruta manzana = new Fruta("Manzana", 5.0, 1500.0, 1800.0, 10.0);
            Fruta platano = new Fruta("Platano", 8.0, 1800.0, 2200.0, 10.0);
            frutas.add(mango);
            frutas.add(manzana);
            frutas.add(platano);

            PeriodoDeCosecha p1 = new PeriodoDeCosecha("Verano", 3.0, mango);
            PeriodoDeCosecha p2 = new PeriodoDeCosecha("Primavera", 2.0, mango);
            PeriodoDeCosecha p3 = new PeriodoDeCosecha("Otono", 1.5, mango);
            mango.agregarPeriodo(p1);
            mango.agregarPeriodo(p2);
            mango.agregarPeriodo(p3);
            periodos.add(p1);
            periodos.add(p2);
            periodos.add(p3);

            Collections.sort(frutas);
            System.out.println("Frutas (orden por nombre): " + frutas);

            Collections.sort(periodos);
            System.out.println("Periodos del mango (orden por nombre): " + periodos);

            System.out.printf("%nPeriodo Verano:%n");
            System.out.printf("  Produccion total: %.2f toneladas%n", p1.produccionTotal());
            System.out.printf("  Costo de produccion: $%.2f%n", p1.costoProduccion());
            System.out.printf("  Ganancias estimadas: $%.2f%n", p1.gananciasEstimadas());

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}

