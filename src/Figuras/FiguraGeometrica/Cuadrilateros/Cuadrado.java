package Figuras.FiguraGeometrica.Cuadrilateros;

import Consola.Consola;
import Utilidades.UtileriaNumeros;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

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
     * @throws InvalidParameterException si el parámetro lado es null
     */
    public Cuadrado(final BigDecimal lado) throws InvalidParameterException {
        if(lado == null) {
            throw new InvalidParameterException("Clase Cuadrado: el parámetro lado en su constructor es null");
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
     * Devuelve un String con todas las características geométricas de un cuadrado en una línea.
     * Lados, perímetro y área
     * @return
     */
    @Override
    public String toString() {
        StringBuilder caracteristicas = new StringBuilder();
        caracteristicas.append("Cuadrado ");
        for(int i=0;i<this.lados.size();i++) {
            caracteristicas.append("Lado "+ i +": " + lados.get(i).toString() + " ");
        }
        caracteristicas.append("Perímetro: " + this.calcularPerimetro() + " ");
        caracteristicas.append("Área: " + this.calcularArea());

        return caracteristicas.toString();
    }

    /**
     * Devuelve el lado de la lista en la posición de index
     * @param index
     * @return
     * @throws InvalidParameterException si el index se sale del tamaño de la lista
     */
    public BigDecimal getLado(final int index) throws InvalidParameterException{
        if(index < 0 || index>lados.size()) {
            throw new InvalidParameterException("Clase Cuadrado: getLado(int index) su index es menor que 0 o se sale de la longitud de la lista");
        }
        return lados.get(index);
    }

    /**
     * Devuelve el tamaño de la lista 'lados'
     * @return
     */
    public int getSizeLados() {
        return lados.size();
    }
}
