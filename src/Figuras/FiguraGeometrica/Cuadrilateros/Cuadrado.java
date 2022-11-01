package Figuras.FiguraGeometrica.Cuadrilateros;

import java.math.BigDecimal;

public class Cuadrado extends Cuadrilateros {

    /**
     * Constructor para construir un cuadrado con un solo lado.
     * Añade ese lado a la lista de lados.
     * @param lado
     */
    public Cuadrado(BigDecimal lado) {
        if(lado == null) {
            throw new NullPointerException("El parámetr lado de la clase Cuadrado es null");
        }
        this.lados.add(lado);
    }

    /**
     * Devuelve el área con la forma de calcularla del cuadrado
     * @return
     */
    @Override
    public BigDecimal calcularArea() {
        BigDecimal area;
        return null;
    }
}
