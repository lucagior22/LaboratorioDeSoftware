package TP3.ejercicioocho;

public enum Notas {
    DO("C"), RE("D"), MI("E"), FA("F"), SOL("G"), LA("A"), SI("B");

    private String cifradoAmericano;

    Notas(String cifradoAmericano) {
        this.cifradoAmericano = cifradoAmericano;
    }
}
