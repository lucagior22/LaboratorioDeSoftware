package TP5.ejercicio1;

@SuppressWarnings({"deprecation"})
public class TestAnotaciones {
    public static void main(String arg[]) throws Exception {
        new TestAnotaciones().testearYa();
    }
    public void testearYa() {
        TestDeprecated t2 = new TestDeprecated();
        t2.hacer();
    }
}

/*
* a) Se ejecuta el metodo "hacer" de TestDeprecated, por mas que haya un @Deprecated
* b) Si, estas anotaciones para el compilador no tienen efecto en la ejecución
* c) El scope, si se anota la clase todos los métodos suprimen las warnings, de anotar sólo un mét0do este es el único que suprime las warnings.
* */