import Consola.Consola;
import Figuras.FiguraGeometrica.Triangulo;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        //Consola consola = new Consola();
        //consola.iniciarConsola();

        Triangulo triangulo = new Triangulo(1,10,2);
        BigDecimal raiz = triangulo.calcularArea();
        System.out.println(triangulo);
        System.out.println(raiz);

    }
}