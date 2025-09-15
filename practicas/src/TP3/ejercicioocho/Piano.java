package TP3.ejercicioocho;

public class Piano implements InstrumentoMusical{

    @Override
    public void hacerSonar() {
        System.out.println("Suena piano sin nota definida");
    }

    @Override
    public void hacerSonar(Notas n, int duracion) {
        System.out.println("Suena piano en " + n + " con " + duracion + " de duración");
    }

    @Override
    public String queEs() {
        return "Piano";
    }

    @Override
    public void afinar() {
        InstrumentoMusical.super.afinar();
    }

    @Override
    public void afinar(FrecuenciasDeLA f) {
        InstrumentoMusical.super.afinar(f);
    }
}
