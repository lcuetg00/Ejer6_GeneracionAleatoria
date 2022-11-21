
import com.ejer.consola.Consola;
import com.ejer.figura.cuadrilatero.Cuadrado;


public class Main {

    public static void main(String[] args) {
        Cuadrado cuadrado = new Cuadrado(0,10,2);

        System.out.println(cuadrado);
        Consola consola = new Consola();
        consola.iniciarConsola();
    }
}