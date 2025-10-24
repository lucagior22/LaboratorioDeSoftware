package TP6.ejercicio3;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Test3");
        try {
            System.out.println("Primer try");
            try {
                throw new Exception();
            } finally {
                System.out.println("Finally del 2º try");
            }
        } catch (Exception e) {
            System.out.println("Se capturó la Excepción ex del 1º Primer try");
        } finally {
            System.out.println("Finally del 1º try");
        }
    }
}

/*
    Test3
    Primer try
    Finally del 2º try
    Se capturó la Excepción ex del 1º Primer try
    Finally del 1º try
    ---
    Se ejecutan todos los prints, en el único lugar donde un print no se ejecutaría es luego del throw de la excepción
 */
