package TP3.ejerciciodos;

import static java.lang.Math.pow;

class InnerStatic {
    static double PI = 3.1416;

    static class Circulo {
        static double radio;

        static void setRadio(double r) {
            radio = r;
        }

        static double getArea() {
            double a = PI * pow(radio, 2);
            System.out.println("El area con radio " + radio + " es: " + a);
            return a;
        }

        static double getLongitudCircunsferencia() {
            double l = 2 * PI * radio;
            System.out.println("La longitud con radio " + radio + " es: " + l);
            return l;
        }
    }
}
