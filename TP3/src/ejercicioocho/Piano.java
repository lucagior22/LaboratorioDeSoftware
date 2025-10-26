package ejercicioocho;

public class Piano implements InstrumentoMusical{


    @Override
    public void hacerSonar(Notas n, int duracion) {
        System.out.println("Suena piano en " + n + " con " + duracion + " de duración");
    }

    @Override
    public String queEs() {
        return "Piano";
    }

    @Override
    public void afinar(FrecuenciasDeLA f) {
        System.out.println("Se afina el piano en: " + f.getHz());
    }
}
