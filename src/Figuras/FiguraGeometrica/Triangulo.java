package Figuras.FiguraGeometrica;

import Consola.Consola;
import Utilidades.UtileriaNumeros;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Creación y operaciones con triángulos
 * -Calcular perímetro, área
 */
public class Triangulo implements IFiguraGeometrica {
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
    public Triangulo(final int min, final int max, final int precision) {
        lados = new ArrayList<BigDecimal>();
        //Comprobar inecualidad de un triangulo
        BigDecimal lado1 = UtileriaNumeros.devolverNumRandom(min, max, precision);
        this.lados.add(lado1);
        BigDecimal lado2 = UtileriaNumeros.devolverNumRandom(min, max, precision);
        this.lados.add(lado2);
        //Para que este triangulo exista, tiene que cumplir las Desigualdades de triángulo (Triangle Inequality)
        //La suma de dos de sus lados, tienen que ser igual o mayor a su último lado
        //lado1 + lado2 >= lado3
        //Si lado1 + lado2 = lado3, su area seria 0
        //lado 3 debe de cumplir: lado1 + lado3 >= lado 2 && lado2 + lado3 >= lado1
        //BigDecimal lado3 = UtileriaNumeros.devolverNumRandom(0,30,2);
        //this.lados.add(lado3);
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
        //Ya tenemos area = (S * (S - lado1) (S - lado2) (S - lado3))
        //Ahora realizamos su raiz cuadrada

        Double raiz = Math.sqrt(area.doubleValue());
        /*
        boolean terminado = false;
        BigDecimal raiz = BigDecimal.ZERO;
        BigDecimal redondeoRaizCuadrada = new BigDecimal("0.0000000001");
        BigDecimal x = area;
        while(terminado == false) {
            raiz = new BigDecimal("0.5").multiply(x.add(area.divide(x)));

            if(raiz.abs().subtract(x.abs()).compareTo(redondeoRaizCuadrada) == 1) {
                terminado = true;
            } else {
                x = raiz;
            }
        }
        */
        BigDecimal resultado = new BigDecimal(raiz.toString());
        resultado = resultado.setScale(UtileriaNumeros.PRECISION_DECIMALES, BigDecimal.ROUND_HALF_UP);
        return resultado;
    }

    @Override
    public String devolverMetadatos() {
        StringBuilder metadatos = new StringBuilder();
        if((lados == null)) {
            throw new NullPointerException("Clase Triandulo toString: la lista de lados es numm");
        }
        metadatos.append("Triángulo" + Consola.RETORNO_CARRO);
        metadatos.append("Lados:" + Consola.RETORNO_CARRO);

        for(int i=0;i<this.lados.size();i++) {
            metadatos.append("Lado "+ i +":" + lados.get(i).toString() + "cm" + Consola.RETORNO_CARRO);
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
        StringBuilder caracteristicas = new StringBuilder();
        caracteristicas.append("Triangulo ");
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
            throw new InvalidParameterException("Clase Triangulo: getLado(int index) su index es menor que 0 o se sale de la longitud de la lista");
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
