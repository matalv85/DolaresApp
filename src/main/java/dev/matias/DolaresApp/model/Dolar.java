package dev.matias.DolaresApp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Dolar{
    @Id
    @Temporal(TemporalType.DATE)
        private LocalDate date;
        private String tipo;
        private Double compra;
        private Double venta;

    public Dolar(String tipo, Double compra, Double venta) {
        this.tipo = tipo;
        this.compra = compra;
        this.venta = venta;
    }

    public Dolar(){

    }
    public Double getCompra() {
        return compra;
    }

    public Double getVenta() {
        return venta;
    }

    public void setCompra(Double compra) {
        this.compra = compra;
    }

    public void setVenta(Double venta) {
        this.venta = venta;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dolar{" +
                "tipo='" + tipo + '\'' +
                ", compra=" + compra +
                ", venta=" + venta +
                '}';
    }
}
