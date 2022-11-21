package com.ejer.utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Contiene la precisión de decimales que se utilizará a lo largo de la aplicación (PRECISION_DECIMALES)
 * Métodos para generar números aleatorios
 */
public class UtileriaNumeros {
    /**
     * Utilizada para poner por defecto el número mínimo que puede ser sacado al azar
     */
    public static final int NUMALEATORIO_MIN = 1;
    /**
     * Utilizada para poner por defecto el número máximo que puede ser sacado al azar
     */
    public static final int NUMALEATORIO_MAX = 10;
    /**
     * Número de decimales predeterminado
     */
    public static final int PRECISION_DECIMALES = 2;

    /**
     * Constructor privado
     * Utilizado para prevenir crear instancias de esta clase ya que sus métodos son todos estáticos
     */
    private UtileriaNumeros() {
    }

    /**
     * Devuelve un BigDecimal creado al azar contenido entre 'min' y 'max'.
     * El número estará redondeado al número de decimales indicados en 'precisión'
     * @param min
     * @param max
     * @param precision
     * @return
     */
    public static BigDecimal devolverNumRandom(int min, int max, int precision) {
        Random random = new Random();
        double num = (random.nextDouble()*(max-min))+min;
        return new BigDecimal(Double.toString(num)).setScale(precision, RoundingMode.HALF_UP);
    }
}