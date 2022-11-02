package Figuras.FiguraGeometrica.Cuadrilateros;

import Utilidades.Utileria;

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
    public Cuadrado(int min, int max, int precision) {
        lados = new ArrayList<BigDecimal>();
        BigDecimal lado = Utileria.devolverNumRandom(min, max, precision);
        for(int i=0;i<Cuadrilateros.NUM_LADOS_CUADRILATERO;i++) {
            this.lados.add(lado);
        }
    }

    /**
     * Contructor para construir un Cuadrado con una lista de 4 lados iguales.
     * @param listaLados
     * @throws NullPointerException si la listaLados es null
     * @throws IllegalArgumentException si listaLados tiene más de 4 o menos de 4 lados.
     *                                  si hay al menos un BigDecimal de la lista diferente al otro
     *
     */
    public Cuadrado(ArrayList<BigDecimal> listaLados) throws NullPointerException, IllegalArgumentException {
        if(listaLados == null) {
            throw new NullPointerException("Error en la creación de una instancia de la clase Cuadrado, la lista de lados es null");
        } else if(listaLados.size() != NUM_LADOS_CUADRILATERO) {
            throw new IllegalArgumentException("Error en la creación de una instancia de la clase Cuadrado. La lista de lados no contiene 4 lados");
        }
        //Comprobamos si todos los lados son iguales:
        BigDecimal ladoCuadrado = listaLados.get(0);
        for(int i=0;i<listaLados.size();i++) {
            if(ladoCuadrado != listaLados.get(i)) { // No son todos iguales
                throw new IllegalArgumentException("Error en la creación de una isntancia de la clase Cuadrado, los 4 lados no son iguales");
            }
        }

        this.lados = lados;
    }

    /**
     * Constructor para construir un cuadrado con un solo lado.
     * Añade ese lado 4 veces a la lista de lados.
     * @param lado lado del cuadrado
     */
    public Cuadrado(BigDecimal lado) {
        if(lado == null) {
            throw new NullPointerException("El parámetro lado de la clase Cuadrado es null");
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
        return ladoCuadrado.multiply(ladoCuadrado).setScale(Utileria.PRECISION_DECIMALES, RoundingMode.HALF_UP);
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
            caracteristicas.append("Lado "+ i +":" + lados.get(i).toString() + "cm\n");

        }
        caracteristicas.append("Perimetro: " + this.calcularPerimetro() + " cm\n");
        caracteristicas.append("Área: " + this.calcularArea() + " cm\n");

        return caracteristicas.toString();
    }
}
