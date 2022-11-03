package Figuras.FiguraGeometrica.Cuadrilateros;
import Figuras.FiguraGeometrica.FiguraGeometrica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la implementación de objetos geométricos pertenecientes a los cuadriláteros.
 * Todos los cuadriláteros tienen en común:
 * -Tienen 4 lados
 * -Forma de cacular su perímetro.
 */public abstract class Cuadrilateros implements FiguraGeometrica {
    //Lista que contendrá los 4 lados de un cuadrilátero
    protected ArrayList<BigDecimal> lados;
    /**
     * Representa el número de lados que tiene un cuadrilátero
     */
    public static final int NUM_LADOS_CUADRILATERO = 4;

    //Implementamos el método común en todos los cuadriláteros, la forma de calcular su perímetro
    /**
     * Devuelve el perímetro con la forma de calcularla para los cuadriláteros
     * Perímetro = suma de todos sus lados
     * @return
     */
    @Override
    public BigDecimal calcularPerimetro() {
        BigDecimal perimetro = BigDecimal.ZERO;
        for(int i=0;i<lados.size();i++) {
            perimetro = perimetro.add(lados.get(i));
        }
        return perimetro;
    }



}
