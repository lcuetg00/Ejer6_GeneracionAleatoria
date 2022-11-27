package com.ejer.figura;
import java.math.BigDecimal;

/**
 * Interfaz para tratar a todas las figuras de la misma forma.
 * Les podemos pedir calcular su área y perímetro
 */
public interface IFiguraGeometrica {
    public static final int DEFAULT_PRECISION_DECIMALES = 2;
    public BigDecimal calcularPerimetro();
    public BigDecimal calcularArea();
    public String devolverMetadatos();

}
