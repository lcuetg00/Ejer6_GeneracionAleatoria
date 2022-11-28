package com.ejer.figura;
import java.math.BigDecimal;

/**
 * Interfaz para tratar a todas las figuras de la misma forma.
 * @author Luis Cueto
 */
public interface IFiguraGeometrica {
    public static final int DEFAULT_PRECISION_DECIMALES = 2;
    public BigDecimal calcularPerimetro();
    public BigDecimal calcularArea();
    public String devolverMetadatos();

}
