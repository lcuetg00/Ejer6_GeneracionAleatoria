package Figuras.FiguraGeometrica;

import java.math.BigDecimal;

/**
 * Creación y operaciones con círculos
 * -Calcular perímetro, área
 */
public class Circulo implements FiguraGeometrica{
    BigDecimal radio;
    BigDecimal diametro;

    /**
     * Constructor de círculo para construirlo con su radio.
     * A partir del radio crea el diámetro.
     * @param radio
     * @throws NullPointerException
     */
    public Circulo(BigDecimal radio) throws NullPointerException{
        if(radio == null) {
            throw new NullPointerException("Error en la creación de una instancia de la clase Circulo. El parámetro radio es null");
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
        return this.radio.multiply(BigDecimal.valueOf(Math.PI)).multiply(new BigDecimal(2));
    }

    /**
     * Devuelve el área con la forma de calcularla para los círculos
     * Área = pi * r * r
     * @return area
     */
    @Override
    public BigDecimal calcularArea() {
        return this.radio.multiply(this.radio).multiply(BigDecimal.valueOf(Math.PI));
    }
}
