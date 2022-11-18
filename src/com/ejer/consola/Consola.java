package com.ejer.consola;

import com.ejer.figura.Circulo;
import com.ejer.figura.IFiguraGeometrica;
import com.ejer.figura.Triangulo;
import com.ejer.figura.cuadrilatero.Cuadrado;
import com.ejer.utilidades.UtileriaNumeros;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 * Lee las entradas del usuario para realizar las operacones necesarias
 */
public class Consola {
    //Opciones del menú
    /**
     * Representa la opción de crear figuras en el menú
     */
    public static final int OPCIONCREAR = 1;
    /**
     * Representa la opción de salir en el menú
     */
    public static final int OPCIONSALIR = 2;

    //Formato de texto
    /**
     * Utilizada al imprimir por pantalla caracteres.
     * Hace que el texto escrito tengan un fondo verde.
     */
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    /**
     * Utilizada al imprimir por pantalla caracteres.
     * Hace que texto escrito tengan un fondo amarillo.
     */
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    /**
     * Utilizada al imprimir por pantalla caracteres.
     * Hace que texto escrito tengan un color rojo.
     */
    public static final String ANSI_RED = "\u001B[31m";
    /**
     * Utilizada al imprimir por pantalla caracteres.
     * Hace que texto escrito tengan un color azul.
     */
    public static final String ANSI_BLUE = "\u001B[34m";
    /**
     * Utilizada al imprimir por pantalla caracteres.
     * Hace que texto escrito tengan un color azul.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";
    /**
     * Utilizada al imprimir por pantalla caracteres.
     * Hace que texto escrito tenga el formato por defecto.
     */
    public static final String ANSI_RESET = "\u001B[0m";
    /**
     * Retorno de carro proporcionado por el sistema que se esté utilizando
     */
    public static final String RETORNO_CARRO = System.getProperty("line.separator");


    //Lista que almacenará lass figuras que se creen
    private final ArrayList<IFiguraGeometrica> figuras;


    /**
     * Contructor que crea la lista en la cual se almacenarán las figuras que se crearán.
     */
    public Consola() {
        figuras = new ArrayList<IFiguraGeometrica>();
    }

    /**
     * Inicia la interfaz de la consola.
     * Presenta el menú al usuario, lee sus entradas y realiza las operaciones necesarias
     */
    public void iniciarConsola() {
        Scanner scanner = new Scanner(System.in);
        //Almacenará la opción del menú que introducirá el usuario
        int opcion = 0;
        //Número de instancias Circulo a crear
        int numCirculos = 0;
        //Número de instancias Triangulo a crear
        int numTriangulos = 0;
        //Número de instancias Cuadrado a crear
        int numCuadrados = 0;

        System.out.println("Ejercicio 6: Generación Aleatoria");
        imprimirMenu();

        while (opcion != OPCIONSALIR) {
            try {
                //Leemos la operación que quiere realizar el usuario
                opcion = scanner.nextInt();

                switch (opcion) {
                    case OPCIONCREAR:
                        System.out.println("Inserte el número de circulos que desee crear");
                        numCirculos = scanner.nextInt();
                        System.out.println("Inserte el número de triángulos que desee crear");
                        numTriangulos = scanner.nextInt();
                        System.out.println("Inserte el número de cuadrados que desee crear");
                        numCuadrados = scanner.nextInt();
                        this.clearConsola();

                        //Creación de las instancias e insertado en la lista 'figuras'
                        for(int i=0;i<numCirculos;i++) {
                            this.insertarFiguraLista(new Circulo(UtileriaNumeros.NUMALEATORIO_MIN, UtileriaNumeros.NUMALEATORIO_MAX, UtileriaNumeros.NUMALEATORIO_MIN));
                        }
                        for(int i=0;i<numCuadrados;i++) {
                            this.insertarFiguraLista(new Cuadrado(UtileriaNumeros.NUMALEATORIO_MIN, UtileriaNumeros.NUMALEATORIO_MAX, UtileriaNumeros.NUMALEATORIO_MIN));
                        }
                        for(int i=0;i<numTriangulos;i++) {
                            this.insertarFiguraLista(new Triangulo(UtileriaNumeros.NUMALEATORIO_MIN, UtileriaNumeros.NUMALEATORIO_MAX, UtileriaNumeros.NUMALEATORIO_MIN));
                        }
                        for(IFiguraGeometrica figura : this.figuras) {
                            System.out.println("________________");
                            this.imprimirCaracteristicasFiguras(figura);
                        }
                        System.out.println("________________");
                        this.imprimirMenu();

                        break;

                    case OPCIONSALIR:
                        System.out.println(ANSI_GREEN_BACKGROUND + "Saliendo del programa" + ANSI_RESET);
                        break;

                    default:
                        this.clearConsola();
                        this.imprimirMenu();
                        System.out.println("ANSI_YELLOW_BACKGROUND + \"Opción tecleada incorrecta. Seleccione la primera o la segunda opción\" + ANSI_RESET");
                }
                //Borramos las figuras almacenadas
                this.limpiarFiguras();

            //Ocurre cuando metemos un caracter diferente a un número
            } catch (InputMismatchException e) {
                this.clearConsola();
                this.imprimirMenu();
                scanner.nextLine();
                System.out.println(ANSI_YELLOW_BACKGROUND + "Opción tecleada incorrecta. Seleccione una de las opciones disponibles" + ANSI_RESET);


            } catch (NullPointerException e){
                System.out.println(e.toString());
            }
        }
    }

    /**
     * Imprime el menú de opciones
     */
    public void imprimirMenu() {
        System.out.println("___________________");
        System.out.println("1) Crear Figuras");
        System.out.println("2) Salir");
        System.out.println("___________________");

    }

    public void imprimirCaracteristicasFiguras(final IFiguraGeometrica figura) {
        switch(figura.getClass().getSimpleName()) {
            case "Circulo":
                System.out.println(ANSI_RED + "Circulo" + ANSI_RESET);
                Circulo circulo = ((Circulo) figura);
                System.out.println("Radio: " + ANSI_GREEN_BACKGROUND + circulo.getRadio() + " cm" + ANSI_RESET);
                System.out.println("Diámetro: " + ANSI_GREEN_BACKGROUND + circulo.getDiametro() + " cm" + ANSI_RESET);
                System.out.println("Perímetro: " + ANSI_GREEN_BACKGROUND + circulo.calcularPerimetro() + " cm" + ANSI_RESET);
                System.out.println("Área: " + ANSI_GREEN_BACKGROUND + circulo.calcularArea() + " cm" + ANSI_RESET);
                break;

            case "Triangulo":
                System.out.println(ANSI_BLUE +"Triángulo" + ANSI_RESET);
                Triangulo triangulo = ((Triangulo) figura);
                for(int i=0;i < triangulo.getSizeLados();i++) {
                    System.out.println("Lado "+ i +": " + ANSI_GREEN_BACKGROUND + triangulo.getLado(i) + "cm" + ANSI_RESET);
                }
                System.out.println("Perímetro: " + ANSI_GREEN_BACKGROUND + triangulo.calcularPerimetro() + " cm" + ANSI_RESET);
                System.out.println("Área: " + ANSI_GREEN_BACKGROUND + triangulo.calcularArea() + " cm" + ANSI_RESET);
                break;

            case "Cuadrado":
                System.out.println(ANSI_YELLOW + "Cuadrado" + ANSI_RESET);
                Cuadrado cuadrado = ((Cuadrado) figura);
                for(int i=0;i < cuadrado.getSizeLados();i++) {
                    System.out.println("Lado "+ i +": " + ANSI_GREEN_BACKGROUND + cuadrado.getLado(i) + " cm" + ANSI_RESET);
                }
                System.out.println("Perímetro: " + ANSI_GREEN_BACKGROUND +cuadrado.calcularPerimetro() + " cm" + ANSI_RESET);
                System.out.println("Área: " + ANSI_GREEN_BACKGROUND + cuadrado.calcularArea() + " cm" + ANSI_RESET);
                break;

            default:
                System.out.println("No hay características para esta figura");
                break;
        }

    }

    /**
     * Limpia la lista creada (esta almacena las figuras creadas)
     */
    public void limpiarFiguras() {
        this.figuras.clear();
    }

    /**
     * Inserta en 'lista' una IFiguraGeometrica
     * @param figura
     * @throws InvalidParameterException
     */
    public void insertarFiguraLista(final IFiguraGeometrica figura) throws InvalidParameterException {
        if(figura == null) {
            throw new InvalidParameterException("Clase Consola: insertarFiguraLista: la figura introducida es null");
        }
        this.figuras.add(figura);
    }

    /**
     * Limpia el texto que aparece en la consola
     */
    public void clearConsola() {
        try {
            final String os = System.getProperty("os.name");

            if(os.contains("Windows")) {
                //Para sistemas de Windows
                //Para windows, ejecutamos el interpretador de lineas 'cmd'
                //Luego le decimos que ejecute el comando '/c cls'
                //Conectamos el output de ese comando con inheritIO() para limpiar la consola en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            //Probarlo en otros sistemas operativos
            //else { //Para cualquier otro sistema operativo
            //    Runtime.getRuntime().exec("clear");
            //}
        }
        //Error producido en la entrada o salida
        catch (final Exception e) {
            System.out.println(e.toString());
        }
    }

}
