package Figuras.FiguraGeometrica.Cuadrilateros;
import Consola.Consola;
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
    /**
     * Lista que contendrá los 4 lados de un cuadrilátero
     */
    protected List<BigDecimal> lados;
    /**
     * Representa el número de lados que tiene un cuadrilátero
     */
    public static final int NUM_LADOS_CUADRILATERO = 4;

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

    /**
     * Devuelve las características del cuadrilátero en un String, con saltos de línea tras cada característica.
     * @return
     */
    @Override
    public String devolverMetadatos() {
        StringBuilder caracteristicas = new StringBuilder();
        caracteristicas.append("Cuadrado" + Consola.RETORNO_CARRO);
        for(int i=0;i<this.lados.size();i++) {
            caracteristicas.append("Lado "+ i +": " + lados.get(i).toString() + " cm" + Consola.RETORNO_CARRO);
        }
        caracteristicas.append("Perímetro: " + this.calcularPerimetro() + " cm" + Consola.RETORNO_CARRO);
        caracteristicas.append("Área: " + this.calcularArea() + " cm" + Consola.RETORNO_CARRO);

        return caracteristicas.toString();
    }




}
