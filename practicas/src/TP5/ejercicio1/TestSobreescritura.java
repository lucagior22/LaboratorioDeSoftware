package TP5.ejercicio1;

public class TestSobreescritura {
    // @Override
    public String tostring() {
        return super.toString() + " Testeando: 'Override'";
    }
}

/*
    El Override tira: "Method does not override method from its superclass"
    Esto porque no encuentra un metodo en la superclase (Object) que tenga la misma firma.
*/