package Figuras.FiguraGeometrica.Cuadrilateros;

import Consola.Consola;
import Utilidades.UtileriaNumeros;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Cuadrado extends Cuadrilateros {

    /**
     * Constructor de Cuadrado para construirlo con valores aleatorios (con el minimo y el maximo pasado por parámetro).
     * Los valores aleatorios estarán aproximandos a los decimales indicados en el parámetro "precision".
     * @param min
     * @param max
     * @param precision
     */
    public Cuadrado(final int min, final int max, final int precision) {
        lados = new ArrayList<BigDecimal>();
        BigDecimal lado = UtileriaNumeros.devolverNumRandom(min, max, precision);
        for(int i=0;i<Cuadrilateros.NUM_LADOS_CUADRILATERO;i++) {
            this.lados.add(lado);
        }
    }

    /**
     * Constructor para construir un cuadrado con un solo lado.
     * Añade ese lado 4 veces a la lista de lados.
     * @param lado lado del cuadrado
     */
    public Cuadrado(BigDecimal lado) {
        if(lado == null) {
            throw new NullPointerException("Clase Cuadrado: el parámetro lado en su constructor es null");
        }
        for(int i=0;i<NUM_LADOS_CUADRILATERO;i++) {
            this.lados.add(lado);
        }
    }

    /**
     * Devuelve el área con la forma de calcularla del cuadrado
     * Area = lado * lado
     * @return area del cuadrado
     */
    @Override
    public BigDecimal calcularArea() {
        BigDecimal ladoCuadrado = lados.get(0);
        return ladoCuadrado.multiply(ladoCuadrado).setScale(UtileriaNumeros.PRECISION_DECIMALES, RoundingMode.HALF_UP);
    }

    /**
     * Devuelve un String con todas las características geométricas de un cuadrado.
     * Lados, perímetro y área
     * @return
     */
    @Override
    public String toString() {
        StringBuilder caracteristicas = new StringBuilder();
        if(lados == null) {
            throw new NullPointerException("Clase cuadrado toString: la lista de lados está vacía");
        }
        caracteristicas.append("Cuadrado\n");
        for(int i=0;i<this.lados.size();i++) {
            caracteristicas.append("Lado "+ i +": " + lados.get(i).toString() + "cm" + Consola.RETORNO_CARRO);

        }
        caracteristicas.append("Perimetro: " + this.calcularPerimetro() + " cm" + Consola.RETORNO_CARRO);
        caracteristicas.append("Área: " + this.calcularArea() + " cm" + Consola.RETORNO_CARRO);

        return caracteristicas.toString();
    }
}
