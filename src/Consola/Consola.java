package Consola;

import Figuras.FiguraGeometrica.Circulo;
import Figuras.FiguraGeometrica.Cuadrilateros.Cuadrado;
import Figuras.FiguraGeometrica.FiguraGeometrica;
import Figuras.FiguraGeometrica.Triangulo;
import Utilidades.Utileria;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario
 * Lee las entradas del usuario para realizar las operacones necesarias
 */
public class Consola {
    //Opciones del menú
    public static final int OPCIONCREAR = 1;
    public static final int OPCIONSALIR = 2;

    //Formato de texto
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m"; //Para que el texto tenga un fondo verde
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m"; //Para que el texto tenga un fondo amarillo
    public static final String ANSI_RESET = "\u001B[0m"; //Para devolver el texto a la normalidad

    public ArrayList<FiguraGeometrica> figuras; //Lista que almacenará lass figuras que se creen


    /**
     * Contructor que crea la lista en la cual se almacenarán las figuras que se crearán.
     */
    public Consola() {
        figuras = new ArrayList<FiguraGeometrica>();
    }



    /**
     * Inicia la interfaz de la consola.
     * Presenta el menú al usuario, lee sus entradas y realiza las operaciones necesarias
     */
    public void iniciarConsola() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; //Almacenará la opción del menú que introducirá el usuario

        int numCirculos = 0; //Número de instancias Circulo a crear
        int numTriangulos = 0; //Número de instancias Triangulo a crear
        int numCuadrados = 0; //Número de instancias Cuadrado a crear

        System.out.println("Ejercicio 6: Generación Aleatoria");
        imprimirMenu();

        while (opcion != OPCIONSALIR) {
            try {
                opcion = scanner.nextInt(); //Leemos la operación que quiere realizar el usuario

                switch (opcion) {
                    case OPCIONCREAR:
                        System.out.println("Inserte el número de circulos que desee crear");
                        numCirculos = scanner.nextInt();
                        System.out.println("Inserte el número de triángulos que desee crear");
                        numTriangulos = scanner.nextInt();
                        System.out.println("Inserte el número de cuadrados que desee crear");
                        numCuadrados = scanner.nextInt();
                        this.clearConsola();
                        this.crearCirculos(numCirculos);
                        this.crearCuadrados(numCuadrados);
                        this.crearTriangulos(numTriangulos);
                        System.out.println(this.devolverCaracteristicasFiguras());
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

                this.limpiarFiguras(); //Borramos las figuras almacenadas


            } catch (InputMismatchException e) { //Ocurre cuando metemos un caracter dierente a un número
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

    /**
     *
     * @return String con las características de todas las figuras geométricas creadas
     */
    public  String devolverCaracteristicasFiguras()
    {
        StringBuilder textoFinal = new StringBuilder();

        for(int i=0;i<this.figuras.size();i++) {
            textoFinal.append("_____________\n");
            textoFinal.append(figuras.get(i));
        }
        textoFinal.append("_____________\n");


        return textoFinal.toString();
    }

    /**
     * Limpia el texto que aparece en la consola
     */
    public void clearConsola() {
        try {
            final String os = System.getProperty("os.name");

            if(os.contains("Windows")) { //Para sistemas de Windows
                //Para windos, ejecutamos el interpretador de lineas 'cmd'
                //Luego le decimos que ejecute el comando '/c cls'
                //Conectamos el output de ese comando con inheritIO() para limpiar la consola en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            //Probarlo en otros sistemas operativos
            //else { //Para cualquier otro sistema operativo
            //    Runtime.getRuntime().exec("clear");
            //}
        }
        catch (final Exception e) { //Error producido en la entrada o salida
            System.out.println(e.toString());
        }
    }

    /**
     * Limpia la lista creada para almacenar las figuras creadas
     */
    public void limpiarFiguras() {
        this.figuras = new ArrayList<FiguraGeometrica>();
    }

    /**
     * Crea y añade a la lista figuras el número de circulos en numCirculos.
     * Los circulos tendrán valores aleatorios para sus características
     * @param numCirculos
     */
    public void crearCirculos(int numCirculos) {
        for(int i=0;i<numCirculos;i++) {
            this.figuras.add(new Circulo(Utileria.NUMALEATORIO_MIN, Utileria.NUMALEATORIO_MAX, Utileria.PRECISION_DECIMALES));
        }

    }

    /**
     * Crea y añade a la lista figuras el número de triángulos en numTriangulos.
     * Los triangulos tendrán valores aleatorios para sus características
     * @param numTriangulos
     */
    public void crearTriangulos(int numTriangulos) {
        for(int i=0;i<numTriangulos;i++) {
            this.figuras.add(new Triangulo(Utileria.NUMALEATORIO_MIN,Utileria.NUMALEATORIO_MAX,Utileria.PRECISION_DECIMALES));
        }

    }

    /**
     * Crea y añade a la lista figuras el número de cuadrados en numCuadrados.
     * Los cuadrados tendrán valores aleatorios para sus características
     * @param numCuadrados
     */
    public void crearCuadrados(int numCuadrados) {
        for(int i=0;i<numCuadrados;i++) {
            this.figuras.add(new Cuadrado(Utileria.NUMALEATORIO_MIN,Utileria.NUMALEATORIO_MAX,Utileria.PRECISION_DECIMALES));
        }

    }
}
