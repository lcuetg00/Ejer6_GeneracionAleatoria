package Figuras.FiguraGeometrica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;

import Consola.Consola;
import Utilidades.UtileriaNumeros;

/**
 * Creación y operaciones con círculos
 * -Calcular perímetro, área
 */
public class Circulo implements FiguraGeometrica{
    /**
     * Valor de PI utilizado para la clase Círculo
     */
    public static final BigDecimal piCirculo = new BigDecimal(Math.PI);
    private BigDecimal radio;
    private BigDecimal diametro;


    /**
     * Constructor de Circulo para construirlo con valores aleatorios (con el minimo y el maximo pasado por parámetro.
     * Los valores aleatorios estarán aproximandos a los decimales indicados en el parámetro "precision"
     * @param min
     * @param max
     * @param precision
     */
    public Circulo(final int min, final int max, final int precision) {
        this.radio = UtileriaNumeros.devolverNumRandom(min, max, precision);
        //El diámetro del círculo es el doble que el radio
        this.diametro = radio.multiply(new BigDecimal("2"));
    }

    /**
     * Constructor de círculo para construirlo con su radio.
     * A partir del radio crea el diámetro.
     * @param radio medida del radio del círculo a crear
     * @throws InvalidParameterException si el parámetro radio es null
     */
    public Circulo(final BigDecimal radio) throws InvalidParameterException{
        if(radio == null) {
            throw new InvalidParameterException("Error en la creación de una instancia de la clase Circulo. El parámetro radio es null");
        }
        this.radio = radio;
        this.diametro = radio.multiply(new BigDecimal(2));
    }

    /**
     * Devuelve el perímetro con la forma de calcularla para los círculos.
     * Perímetro = 2 * pi * r
     * @return perimetro
     */
    @Override
    public BigDecimal calcularPerimetro() {
        return this.radio.multiply(BigDecimal.valueOf(Math.PI)).multiply(new BigDecimal(2)).setScale(UtileriaNumeros.PRECISION_DECIMALES, RoundingMode.HALF_UP);
    }

    /**
     * Devuelve el área con la forma de calcularla para los círculos
     * Área = pi * r * r
     * @return area
     */
    @Override
    public BigDecimal calcularArea() {
        return this.radio.multiply(this.radio).multiply(piCirculo).setScale(UtileriaNumeros.PRECISION_DECIMALES, RoundingMode.HALF_UP);
    }

    @Override
    public String devolverMetadatos() {
        return null;
    }

    /**
     * Devuelve un String con todas las características geométricas de un círculos.
     * Radio, diámetro, perímetro y área
     * @return
     */
    @Override
    public String toString() {
        StringBuilder caracteristicas = new StringBuilder();
        caracteristicas.append("Círculo" + Consola.RETORNO_CARRO);
        caracteristicas.append("Radio: " + this.radio + " cm" + Consola.RETORNO_CARRO);
        caracteristicas.append("Diámetro: " + this.diametro + " cm" + Consola.RETORNO_CARRO);
        caracteristicas.append("Perimetro: " + this.calcularPerimetro() + " cm" + Consola.RETORNO_CARRO);
        caracteristicas.append("Área: " + this.calcularArea() + " cm" + Consola.RETORNO_CARRO);

        return caracteristicas.toString();
    }
}
