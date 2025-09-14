package TP3.ejerciciodos;

import java.util.Scanner;

import static TP3.ejerciciodos.InnerStatic.Circulo.*;

public class TestInner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        System.out.println("Ingrese el radio deseado: ");
        double radio = scanner.nextDouble();

        setRadio((double) radio);
        System.out.println("Area: " + getArea() + " | Longitud: " + getLongitudCircunsferencia());
        }
    }
}
