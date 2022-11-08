package Figuras.FiguraGeometrica;
import java.math.BigDecimal;

/**
 * Interfaz para tratar a todas las figuras de la misma forma.
 * Les podemos pedir calcular su área y perímetro
 */
public interface FiguraGeometrica {
    public BigDecimal calcularPerimetro();
    public BigDecimal calcularArea();
    public String devolverMetadatos();

}
