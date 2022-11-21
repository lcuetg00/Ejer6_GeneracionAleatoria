package com.ejer.figura;

import com.ejer.consola.Consola;

import java.math.BigDecimal;
import java.util.List;

/**
 * Clase para la implementación de objetos geométricos pertenecientes a los cuadriláteros.
 * Todos los cuadriláteros tienen en común:
 * -Tienen 4 lados
 * -Forma de cacular su perímetro.
 */public abstract class Cuadrilatero implements IFiguraGeometrica {
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
        if(this.lados == null) {
            throw new NullPointerException("Instancia Cuadrilátero: su lista de lados es null");
        }
        BigDecimal perimetro = BigDecimal.ZERO;
        for(int i=0;i<lados.size();i++) {
            BigDecimal ladoCuadrado = lados.get(i);
            if(ladoCuadrado == null) {
                throw new NullPointerException("Instancia Cuadrilátero: su lista de lados contiene null");
            }
            perimetro = perimetro.add(ladoCuadrado);
        }
        return perimetro;
    }

    /**
     * Devuelve las características del cuadrilátero en un String, con saltos de línea tras cada característica.
     * @return
     */
    @Override
    public String devolverMetadatos() {
        if(this.lados == null) {
            throw new NullPointerException("Instancia Cuadrilátero: su lista de lados es null");
        }
        StringBuilder caracteristicas = new StringBuilder();
        caracteristicas.append("Cuadrado" + Consola.RETORNO_CARRO);
        for(int i=0;i<this.lados.size();i++) {
            BigDecimal ladoCuadrado = lados.get(i);
            if(ladoCuadrado == null) {
                throw new NullPointerException("Instancia Cuadrilátero: su lista de lados contiene null");
            }
            caracteristicas.append("Lado "+ i +": " + ladoCuadrado + " cm" + Consola.RETORNO_CARRO);
        }
        caracteristicas.append("Perímetro: " + this.calcularPerimetro() + " cm" + Consola.RETORNO_CARRO);
        caracteristicas.append("Área: " + this.calcularArea() + " cm" + Consola.RETORNO_CARRO);

        return caracteristicas.toString();
    }

}
