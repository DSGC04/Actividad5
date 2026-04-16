package Problema2;
import java.util.Objects;
public class PeriodoDeCosecha {
  
    private String nombrePeriodo;
    private double cantidadToneladas;
    private Fruta fruta;

    public PeriodoDeCosecha(String periodo, double toneladasPorHectarea, Fruta fruta) {
        this.nombrePeriodo = periodo;
        this.cantidadToneladas = toneladasPorHectarea;
        this.fruta = fruta;
    }

    public double produccionTotal() {
        return fruta.getHectareas() * cantidadToneladas;
    }

    public double costoProduccion() {
        return produccionTotal() * fruta.getCostoProduccionTon();
    }

    public double gananciasEstimadas() {

        double ingreso = produccionTotal() * fruta.getPrecioVentaTon();

        return ingreso - costoProduccion();
    }

    @Override
    public String toString() {
        return "PeriodoDeCosecha{" +
                "periodo='" + nombrePeriodo + '\'' +
                ", produccionEstimada=" + cantidadToneladas + " ton/ha" +
                '}';
    }

    public static void main(String[] args) {

        Fruta fruta = new Fruta(
                "Mango",
                10,
                500,
                900
        );

        PeriodoDeCosecha periodo = new PeriodoDeCosecha(
                "Primavera",
                2,
                fruta
        );

        System.out.println(fruta);
        System.out.println(periodo);

        System.out.printf("Produccion total estimada: %.2f toneladas\n", periodo.produccionTotal());
        System.out.printf("Costo total de produccion: $%.2f\n", periodo.costoProduccion());
        System.out.printf("Ganancia estimada: $%.2f\n", periodo.gananciasEstimadas());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PeriodoDeCosecha that = (PeriodoDeCosecha) o;
        return Double.compare(cantidadToneladas, that.cantidadToneladas) == 0 &&
                Objects.equals(nombrePeriodo, that.nombrePeriodo) && Objects.equals(fruta, that.fruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrePeriodo, cantidadToneladas, fruta);
    }
}
