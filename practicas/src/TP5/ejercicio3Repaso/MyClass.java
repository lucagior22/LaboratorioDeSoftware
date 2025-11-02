package TP5.ejercicio3Repaso;

@Servidor(ip = "127.0.0.1", port = 8080, loggingFile = "serverLogging.txt")
public class MyClass {
    String myAttribute1;
    int myAttribute2;

    public void myMethod() {
        System.out.println("MyMethod");
    }

    @Invocar
    public int myMethod2() {
        System.out.println("MyMethod2");
        return 2;
    }

    @Invocar
    public boolean myMethod3() {
        System.out.println("MyMethod3");
        return true;
    }
}
