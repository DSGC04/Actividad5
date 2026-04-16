package Problema1;

import java.util.Objects;
import java.time.LocalDate;
import java.util.Objects;

public class Prenda {
  
        private String modelo;
        private String tela;
        private double costoProduccion;
        private String genero;
        private String temporada;

        public Prenda(String modelo, String tela, double costoProduccion, String genero, String temporada) {
            this.modelo = modelo;
            this.tela = tela;
            this.costoProduccion = costoProduccion;
            this.genero = genero;
            this.temporada = temporada;
        }

        public String getModelo() {
            return modelo;
        }

        public String getTela() {
            return tela;
        }

        public double getCostoProduccion() {
            return costoProduccion;
        }

        public String getGenero() {
            return genero;
        }

        public String getTemporada() {
            return temporada;
        }

        public double calcularPrecioVenta() {
            return costoProduccion * 1.15;
        }

        @Override
        public String toString() {
            return "Prenda{" +
                    "modelo='" + modelo + '\'' +
                    ", tela='" + tela + '\'' +
                    ", costoProduccionPorPieza=$" + costoProduccion +
                    ", genero='" + genero + '\'' +
                    ", temporada='" + temporada + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Problema1.Prenda prenda = (Problema1.Prenda) o;
            return Double.compare(costoProduccion, prenda.costoProduccion) == 0 &&
                    Objects.equals(modelo, prenda.modelo) && Objects.equals(tela, prenda.tela) &&
                    Objects.equals(genero, prenda.genero) && Objects.equals(temporada, prenda.temporada);
        }

        @Override
        public int hashCode() {
            return Objects.hash(modelo, tela, costoProduccion, genero, temporada);
        }

}
