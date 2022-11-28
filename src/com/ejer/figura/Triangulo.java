package com.ejer.figura;

import com.ejer.consola.Consola;
import com.ejer.utilidades.UtileriaNumeros;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Creación y operaciones con triángulos
 * @author Luis Cueto
 */
public class Triangulo implements IFiguraGeometrica {
    /**
     * Representa el número de lados que tiene un triángulo
     */
    public static final int NUM_LADOS_TRIANGULO = 3;
    /**
     * Lista que contendrá los 3 lados de un triángulo
     */
    private ArrayList<BigDecimal> listLados;

    /**
     * Constructor de Triangulo para construirlo con valores aleatorios (con el minimo y el maximo pasado por parámetro).
     * Utiliza {@link UtileriaNumeros#generateDefaultNumerosDecimalesAleatorios()} para los dos primeros lados
     * Utiliza {@link UtileriaNumeros#generateNumerosDecimalesAleatorios(int, int)} para el tercer lado
     */
    public Triangulo() {
        listLados = new ArrayList<BigDecimal>();
        //Comprobar inecualidad de un triangulo
        BigDecimal lado1 = UtileriaNumeros.generateDefaultNumerosDecimalesAleatorios();
        this.listLados.add(lado1);
        BigDecimal lado2 = UtileriaNumeros.generateDefaultNumerosDecimalesAleatorios();
        this.listLados.add(lado2);

        BigDecimal diferencia = lado1.subtract(lado2).abs();
        BigDecimal lado3 = BigDecimal.ZERO;
        //Para que este triangulo exista, tiene que cumplir las Desigualdades de triángulo (Triangle Inequality)
        //La suma de cualquiera de sus lados, tienen que ser igual o mayor a su último lado
        //(lado3 < diferencia) || lado3 > lado1.add(lado2)
        while((diferencia.compareTo(lado3) == 1) || (lado3.compareTo(lado1.add(lado2)))==1) {
            lado3 = UtileriaNumeros.generateNumerosDecimalesAleatorios( lado1.add(lado2).intValue(), diferencia.intValue());
        }
        this.listLados.add(lado3);
    }

    /**
     * Devuelve el perímetro con la forma de calcularla para los triángulos
     * Perímetro = lado1 + lado2 + lado3
     * @return perímetro del triángulo
     */
    @Override
    public BigDecimal calcularPerimetro() {
        if(this.listLados == null) {
            throw new NullPointerException("Instancia de clase Triángulo: su lista de lados es null");
        }
        BigDecimal perimetro = new BigDecimal(0);
        for(int i = 0; i< listLados.size(); i++) {
            BigDecimal ladoTriangulo = listLados.get(i);
            if(ladoTriangulo == null) {
                throw new NullPointerException("Instancia de clase Triángulo: su lista de lados contiene null");
            }
            perimetro = perimetro.add(ladoTriangulo);
        }
        return perimetro;
    }

    /**
     * Devuelve el área con la forma de calcularla para los triángulos
     * Utiliza la formula de heron
     * Semiperimetro (S) = (lado1 + lado2 + lado3)/2
     * Área = squareroot(S * (S - lado1) (S - lado2) (S - lado3))
     * @return área del triángulo
     */
    @Override
    public BigDecimal calcularArea() {
        if(this.listLados == null) {
            throw new NullPointerException("Instancia de clase Triángulo: su lista de lados es null");
        }
        //El semiperimetro es la mitad del perímetro del triángulo
        BigDecimal semiperimetro = this.calcularPerimetro().divide(new BigDecimal("2"));
        BigDecimal area;
        area = semiperimetro;
        for(BigDecimal lado : this.listLados) {
            area = area.multiply((semiperimetro.subtract(lado)));
        }
        //Ya tenemos area = (S * (S - lado1) (S - lado2) (S - lado3))
        //Ahora realizamos su raiz cuadrada
        Double raiz = Math.sqrt(area.doubleValue());
        BigDecimal resultado = new BigDecimal(raiz.toString());
        resultado = resultado.setScale(IFiguraGeometrica.DEFAULT_PRECISION_DECIMALES, BigDecimal.ROUND_HALF_UP);
        return resultado;
    }

    /**
     * Devuelve las características de un triángulo en un string, con saltos de línea tras cada característica.
     * Lados, área, perímetro
     * @return string con los datos
     */
    @Override
    public String devolverMetadatos() {
        StringBuilder metadatos = new StringBuilder();
        if(this.listLados == null) {
            throw new NullPointerException("Instancia de clase Triángulo: su lista de lados es null");
        }
        metadatos.append("Triángulo" + Consola.RETORNO_CARRO);
        metadatos.append("Lados:" + Consola.RETORNO_CARRO);

        for(int i = 0; i<this.listLados.size(); i++) {
            BigDecimal ladoTriangulo = listLados.get(i);
            if(ladoTriangulo == null) {
                throw new NullPointerException("Instancia de clase Triángulo: su lista de lados contiene null");
            }
            metadatos.append("Lado "+ i +":" + ladoTriangulo + "cm" + Consola.RETORNO_CARRO);
        }
        metadatos.append("Perimetro: " + this.calcularPerimetro() + " cm" + Consola.RETORNO_CARRO);
        metadatos.append("Área: " + this.calcularArea() + " cm" + Consola.RETORNO_CARRO);

        return metadatos.toString();
    }

    /**
     * Devuelve un String con todas las características geométricas de un triángulo en una línea.
     * Lados, perímetro y área
     * @return
     */
    @Override
    public String toString() {
        if(this.listLados == null) {
            throw new NullPointerException("Instancia de clase Triángulo: su lista de lados es null");
        }
        StringBuilder caracteristicas = new StringBuilder();
        caracteristicas.append("Triangulo ");
        for(int i = 0; i<this.listLados.size(); i++) {
            caracteristicas.append("Lado "+ i +": " + ((listLados.get(i)) != null ? listLados.get(i).toString() : "Null") + " ");
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
        if(this.listLados == null) {
            throw new NullPointerException("Instancia de clase Triángulo: su lista de lados es null");
        }
        if(index < 0 || index> listLados.size()) {
            throw new InvalidParameterException("Clase Triangulo: getLado(int index) su index es menor que 0 o se sale de la longitud de la lista");
        }
        return listLados.get(index);
    }

    /**
     * Devuelve el tamaño de la lista 'lados'
     * @return
     */
    public int getSizeLados() {
        if(this.listLados == null) {
            throw new NullPointerException("Instancia de clase Triángulo: su lista de lados es null");
        }
        return listLados.size();
    }

}
