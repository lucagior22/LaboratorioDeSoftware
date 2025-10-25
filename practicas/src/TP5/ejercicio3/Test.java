package TP5.ejercicio3;

@Servidor(
        direccion = "127.0.0.1", puerto = 8080, archivo = "testLogging.txt"
)
public class Test {

    @Invocar
    public void testMethod() {
        System.out.println("Se invocó testMethod");
    }
}
