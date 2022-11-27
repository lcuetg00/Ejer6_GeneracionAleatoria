package com.ejer.figura;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import com.ejer.consola.Consola;
import com.ejer.utilidades.UtileriaNumeros;

/**
 * Creación y operaciones con círculos
 * @author Luis Cueto
 */
public class Circulo implements IFiguraGeometrica {
    /**
     * Valor de PI utilizado para la clase Círculo
     * Utiliza {@link Math#PI}
     */
    public static final BigDecimal piCirculo = new BigDecimal(Math.PI);
    /**
     * Valor que representa el radio del círculo
     */
    private BigDecimal radio;
    /**
     * Valor que representa el diámetro del círculo
     */
    private BigDecimal diametro;


    /**
     * Constructor de Circulo para construirlo con valores aleatorios
     * Utiliza {@link UtileriaNumeros#generateDefaultNumerosDecimalesAleatorios()} para crear un número decimal para su radio
     * Llama a {@link #Circulo(BigDecimal)}
     */
    public Circulo() {
        this(UtileriaNumeros.generateDefaultNumerosDecimalesAleatorios());
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
        if(this.radio == null) {
            throw new NullPointerException("Instancia de clase Círculo: su variable 'radio' es null");
        }
        return this.radio.multiply(piCirculo).multiply(new BigDecimal("2")).setScale(IFiguraGeometrica.DEFAULT_PRECISION_DECIMALES, RoundingMode.HALF_UP);
    }

    /**
     * Devuelve el área con la forma de calcularla para los círculos
     * Área = pi * r * r
     * @return area
     */
    @Override
    public BigDecimal calcularArea() {
        if(this.radio == null) {
            throw new NullPointerException("Instancia de clase Círculo: su variable 'radio' es null");
        }
        return this.radio.multiply(this.radio).multiply(piCirculo).setScale(IFiguraGeometrica.DEFAULT_PRECISION_DECIMALES, RoundingMode.HALF_UP);
    }


    /**
     * Devuelve las características de un circulo en un string, con saltos de línea tras cada característica.
     * Radio, diámetro, perímetro y área.
     * @return string con los datos
     */
    @Override
    public String devolverMetadatos() {
        if(this.radio == null || this.diametro == null) {
            throw new NullPointerException("Instancia de clase Círculo: alguna de sus variables es null");
        }
        StringBuilder caracteristicas = new StringBuilder();
        caracteristicas.append("Círculo" + Consola.RETORNO_CARRO);
        if(this.radio == null) {
            throw new NullPointerException("Instancia de clase Círculo: su radio es null");
        }
        caracteristicas.append("Radio: " + this.radio + " cm" + Consola.RETORNO_CARRO);
        if(this.diametro == null) {
            throw new NullPointerException("Instancia de clase Círculo: su diametro es null");
        }
        caracteristicas.append("Diámetro: " + this.diametro + " cm" + Consola.RETORNO_CARRO);
        caracteristicas.append("Perímetro: " + this.calcularPerimetro() + " cm" + Consola.RETORNO_CARRO);
        caracteristicas.append("Área: " + this.calcularArea() + " cm" + Consola.RETORNO_CARRO);

        return caracteristicas.toString();

    }

    /**
     * Devuelve la variable radio del círculo
     * @return
     */
    public BigDecimal getRadio() {
        return radio;
    }

    /**
     * Devuelve la variable diámetro del círculo
     * @return
     */
    public BigDecimal getDiametro() {
        return diametro;
    }

    /**
     * Devuelve un String con todas las características del círculo en una sola línea
     * Radio, diámetro, perímetro y área
     * @return
     */
    @Override
    public String toString() {
        if(this.radio == null || this.diametro == null) {
            throw new NullPointerException("Instancia de clase Círculo: alguna de sus variables es null");
        }
        StringBuilder caracteristicas = new StringBuilder();
        caracteristicas.append("Círculo ");
        caracteristicas.append("Radio: " + ((this.radio) != null ? this.radio : "Null") + " ");
        caracteristicas.append("Diámetro: " + ((this.diametro) != null ? this.diametro : "Null") + " ");
        caracteristicas.append("Perimetro: " + this.calcularPerimetro() + " ");
        caracteristicas.append("Área: " + this.calcularArea() + " ");
        return caracteristicas.toString();
    }
}
