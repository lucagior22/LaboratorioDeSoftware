package ejerciciodos;

import java.util.Scanner;

import static java.lang.Math.pow;

public class InnerStatic {

    static double PI = 3.1416;

    static class Circulo {

        static double radio;

        static {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el radio deseado: ");
            radio = scanner.nextDouble();
        }

        static double getArea() {
            double a = PI * pow(radio, 2);
            System.out.println("El area es: " + a);
            return a;
        }

        static double getLongitudCircunsferencia(){
            double l = 2 * PI * radio;
            System.out.println("La longitud es: " + l);
            return l;
        }

    }

}
