package dev.matias.DolaresApp.model;

public enum Impuestos {
    PAIS(30.00),
    GANANCIAS(45.00),
    BIENES_PERSONALES(25.00);

    private Double totalImpuesto;

    Impuestos(Double totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    public Double getTotalImpuesto() {
        return totalImpuesto;
    }
}
