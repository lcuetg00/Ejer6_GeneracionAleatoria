package Figuras.FiguraGeometrica;

import Utilidades.UtileriaNumeros;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.math.MathContext;

/**
 * Creación y operaciones con triángulos
 * -Calcular perímetro, área
 */
public class Triangulo implements FiguraGeometrica{
    /**
     * Representa el número de lados que tiene un triángulo
     */
    public static final int NUM_LADOS_TRIANGULO = 3;
    /**
     * Lista que contendrá los 3 lados de un triángulo
     */
    private ArrayList<BigDecimal> lados;

    /**
     * Constructor de Triangulo para construirlo con valores aleatorios (con el minimo y el maximo pasado por parámetro).
     * Los valores aleatorios estarán aproximandos a los decimales indicados en el parámetro "precision".
     * En la lista 'lados', el primer lado será su base.
     * @param min
     * @param max
     * @param precision
     */
    public Triangulo(int min, int max, int precision) {
        lados = new ArrayList<BigDecimal>();
        for(int i=0;i<NUM_LADOS_TRIANGULO;i++) {
            this.lados.add(UtileriaNumeros.devolverNumRandom(min, max, precision));
        }
    }
/*
    /**
     * Constructor para crear una instancia Triangulo con una lista de lados
     * La lista debe de contener 3 lados
     * @param listaLados lista con todos los lados del triángulo
     * @param altura altura del triángulo en cuanto a la base argumentada
     * @param base medida de la base del triángulo
     * @throws IllegalArgumentException Si la lista contene menos de 3 lados o más de 3 lados
     */
    public Triangulo(ArrayList<BigDecimal> listaLados, BigDecimal altura, BigDecimal base) throws NullPointerException, IllegalArgumentException{
        if((listaLados == null) || (altura == null) || (base == null) || (listaLados.size() != NUM_LADOS_TRIANGULO)) {
            throw new IllegalArgumentException("Error en la creación de una instancia de la clase Triangulo, uno de sus parámetros es null o la lista de lados no contiene 3 lados");
        }

        //this.lados = listaLados;
        //this.altura=altura;
    }

    /**
     * Devuelve el perímetro con la forma de calcularla para los triángulos
     * Perímetro = lado1 + lado2 + lado3
     * @return perímetro del triángulo
     */
    @Override
    public BigDecimal calcularPerimetro() {
        BigDecimal perimetro = new BigDecimal(0);
        for(int i=0;i<lados.size();i++) {
            perimetro = perimetro.add(lados.get(i));
        }
        return perimetro;
    }

    /**
     * Devuelve el área con la forma de calcularla para los triángulos
     * Utiliza la formula de heron
     * Semiperimetro (S) = (lado1 + lado2 + lado3)/2
     * Área = squareroot(S * (S - lado1) (S - lado2) (S - lado3))
     * @return area del triángulo
     */
    @Override
    public BigDecimal calcularArea() {
        //El semiperimetro es la mitad del perímetro del triángulo
        BigDecimal semiperimetro = this.calcularPerimetro().divide(new BigDecimal("2"));
        BigDecimal area;
        area = semiperimetro;
        for(BigDecimal lado : this.lados) {
            area = area.multiply((semiperimetro.subtract(lado)));
        }
        //area = area.pow(-2);
        return area;
    }

    @Override
    public String devolverMetadatos() {
        return null;
    }

    /**
     * Devuelve todas las características del Triángulo:
     * Lado base y altura
     * Lista de lados
     * Perímetro y área
     * @return
     */
    @Override
    public String toString() {
        StringBuilder caracteristicas = new StringBuilder();
        if((lados == null) || (base == null) || (altura == null)) {
            throw new NullPointerException("Clase Triandulo toString: al menos un parámetro es igual a null");
        }
        caracteristicas.append("Triángulo\n");
        caracteristicas.append("Lados:\n");
        caracteristicas.append("Su lado base: " + base.toString() + "cm\n");
        caracteristicas.append("La altura de la base: " + altura.toString() + " cm\n");

        for(int i=0;i<this.lados.size();i++) {
            caracteristicas.append("Lado "+ i +":" + lados.get(i).toString() + "cm\n");

        }
        caracteristicas.append("Perimetro: " + this.calcularPerimetro() + " cm\n");
        caracteristicas.append("Área: " + this.calcularArea() + " cm\n");

        return caracteristicas.toString();
    }
}
