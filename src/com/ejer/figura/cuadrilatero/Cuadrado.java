package com.ejer.figura.cuadrilatero;

import com.ejer.figura.Cuadrilatero;
import com.ejer.utilidades.UtileriaNumeros;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Creación y operaciones con cuadrados
 * @author Luis Cueto
 */

public class Cuadrado extends Cuadrilatero {

    /**
     * Constructor de Cuadrado para construirlo con valores aleatorios
     * Utiliza {@link UtileriaNumeros#generateDefaultNumerosDecimalesAleatorios()} para crear un número para sus lados
     * Utiliza {@link Cuadrilatero#NUM_LADOS_CUADRILATERO} para su número de lados
     * Llama a {@link #Cuadrado(BigDecimal)}
     */
    public Cuadrado() {
        this(UtileriaNumeros.generateDefaultNumerosDecimalesAleatorios());
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
        this.listaLados = new ArrayList<BigDecimal>();
        for(int i=0;i<NUM_LADOS_CUADRILATERO;i++) {
            this.listaLados.add(lado);
        }
    }

    /**
     * Devuelve el área con la forma de calcularla del cuadrado
     * Area = lado * lado
     * Redondea el área con {@link #DEFAULT_PRECISION_DECIMALES}
     * @return área del cuadrado
     */
    @Override
    public BigDecimal calcularArea() {
        if(this.listaLados == null) {
            throw new NullPointerException("Instancia de clase Cuadrado: su lista de lados es null");
        }
        BigDecimal ladoCuadrado = listaLados.get(0);
        if(ladoCuadrado == null) {
            throw new NullPointerException("Instancia de clase Cuadrado: su lista de lados contiene null");
        }
        return ladoCuadrado.multiply(ladoCuadrado).setScale(this.DEFAULT_PRECISION_DECIMALES, RoundingMode.HALF_UP);
    }

    /**
     * Devuelve un String con todas las características geométricas de un cuadrado en una línea.
     * Lados, perímetro y área
     * @return
     */
    @Override
    public String toString() {
        if(this.listaLados == null) {
            throw new NullPointerException("Instancia de clase Cuadrado: su lista de lados es null");
        }
        StringBuilder caracteristicas = new StringBuilder();
        caracteristicas.append("Cuadrado ");
        for(int i = 0; i<this.listaLados.size(); i++) {
            caracteristicas.append("Lado "+ i +": " + ((listaLados.get(i)) != null ? listaLados.get(i).toString() : "Null") + " ");
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
        if(this.listaLados == null) {
            throw new NullPointerException("Instancia de clase Cuadrado: su lista de lados es null");
        }
        if(index < 0 || index> listaLados.size()) {
            throw new InvalidParameterException("Clase Cuadrado: getLado(int index) su index es menor que 0 o se sale de la longitud de la lista");
        }
        return listaLados.get(index);
    }

    /**
     * Devuelve el tamaño de la lista que contiene sus aldos
     * @return
     */
    public int getSizeLados() {
        if(this.listaLados == null) {
            throw new NullPointerException("Instancia de clase Cuadrado: su lista de lados es null");
        }
        return listaLados.size();
    }
}
