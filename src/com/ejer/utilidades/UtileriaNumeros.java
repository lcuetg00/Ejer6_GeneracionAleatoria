package com.ejer.utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * Métodos para generar números aleatorios
 * @author Luis Cueto
 */
public class UtileriaNumeros {
    /**
     * Utilizada para poner por defecto el número mínimo que puede ser sacado al azar
     */
    public static final int DEFAULT_NUMALEATORIO_MIN = 1;
    /**
     * Utilizada para poner por defecto el número máximo que puede ser sacado al azar
     */
    public static final int DEFAULT_NUMALEATORIO_MAX = 10;
    /**
     * Número de decimales predeterminado
     */
    public static final int DEFAULT_PRECISION_DECIMALES = 2;

    /**
     * Constructor privado
     * Utilizado para prevenir crear instancias de esta clase ya que sus métodos son todos estáticos
     */
    private UtileriaNumeros() {
    }

    /**
     * Devuelve un BigDecimal creado al azar utilizando la clase Random contenido entre 'min' y 'max'.
     * El número estará redondeado al número de decimales indicados en 'precision'
     * Si 'precision' es <0, se utilizará {@link #DEFAULT_PRECISION_DECIMALES}
     * Utiliza {@link java.util.Random#Random} con el tiempo en nanosegundos como su semilla
     * @param min
     * @param max
     * @param precision
     * @return
     */
    public static BigDecimal generateNumerosDecimalesAleatorios(final int min, final int max, final int precision) {
        int auxPrecision = precision;
        if(precision < 0) {
            auxPrecision = DEFAULT_PRECISION_DECIMALES;
        }
        int auxMin;
        int auxMax;
        if(min < max) {
            auxMin = min;
            auxMax = max;
        } else {
            auxMin = max;
            auxMax = min;
        }
        Random random = new Random(System.nanoTime());
        double num = (random.nextDouble() * (auxMax - auxMin)) + auxMin;
        return new BigDecimal(Double.toString(num)).setScale(auxPrecision, RoundingMode.HALF_UP);
    }

    /**
     * Devuelve un BigDecimal creado al azar utilizando la clase Random contenido entre 'min' y 'max'.
     * El número estará redondeado al número de decimales indicados en 'precision'
     * Llama al constructor {@link #generateNumerosDecimalesAleatorios(int, int, int)}
     * Utiliza {@link #DEFAULT_PRECISION_DECIMALES}
     * Utiliza {@link java.util.Random#Random} con el tiempo en nanosegundos como su semilla
     * @param min
     * @param max
     * @return
     */
    public static BigDecimal generateNumerosDecimalesAleatorios(final int min, final int max) {
        return generateNumerosDecimalesAleatorios(min, max, DEFAULT_PRECISION_DECIMALES);
    }

    /**
     * Llama al método {@link #generateNumerosDecimalesAleatorios(int, int, int)}
     * Utiliza {@link #DEFAULT_NUMALEATORIO_MIN}, {@link #DEFAULT_NUMALEATORIO_MAX} y {@link #DEFAULT_PRECISION_DECIMALES}
     * Utiliza {@link java.util.Random#Random} con el tiempo en nanosegundos como su semilla
     * @return número decimal aleatorio entre los valores default que utiliza
     */
    public static BigDecimal generateDefaultNumerosDecimalesAleatorios() {
         return generateNumerosDecimalesAleatorios(DEFAULT_NUMALEATORIO_MIN, DEFAULT_NUMALEATORIO_MAX, DEFAULT_PRECISION_DECIMALES);
    }

}
