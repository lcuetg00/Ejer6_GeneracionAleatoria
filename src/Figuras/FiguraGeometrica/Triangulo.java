package Figuras.FiguraGeometrica;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Creación y operaciones con triángulos
 * -Calcular perímetro, área
 */
public class Triangulo implements FiguraGeometrica{
    ArrayList<BigDecimal> lados;

    /**
     * Constructor para crear una instancia Triangulo con una lista de lados
     * La lista debe de contener 3 lados
     * @param lados
     * @throws NullPointerException Si la lista argumentada es null
     * @throws IllegalArgumentException Si la lista contene menos de 3 lados o más de 3 lados
     */
    public Triangulo(BigDecimal[] lados) throws NullPointerException, IllegalArgumentException{
        if(lados == null) {
            throw new NullPointerException("Error en la creación de una instancia de la clase Triangulo. La lista de lados es null");
        } else if(lados.length != 3) {
            throw new IllegalArgumentException("Error en la creación de una instancia de la clase Triangulo. La lista de lados no contiene 3 lados");
        }

        lados = lados;
    }

    /**
     * Devuelve el perímetro con la forma de calcularla para los triángulos
     * @return
     */
    @Override
    public BigDecimal calcularPerimetro() {
        return null;
    }
    /**
     * Devuelve el área con la forma de calcularla para los triángulos
     * @return
     */
    @Override
    public BigDecimal calcularArea() {
        return null;
    }
}
