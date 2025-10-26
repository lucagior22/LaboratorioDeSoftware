package ejercicioocho;

public class FitoPaez {
    private static FitoPaez instance = null;
    private Piano piano = new Piano();

    private FitoPaez() {}

    public static FitoPaez getInstance() {
        if (instance == null) {
            instance = new FitoPaez();
        }

        return instance;
    }

    public void tocarCancion(Notas[] notas, int[] duraciones) {
        if (notas.length != duraciones.length) {
            System.out.println("Los arreglos de notas y duraciones no tienen la misma cantidad de elementos");
        }

        for (int i = 0; i < notas.length; i++) {
            piano.hacerSonar(notas[i], duraciones[i]);
        }
    }

    public static void main(String[] args) {
        FitoPaez fito = FitoPaez.getInstance();

        Notas[] notas = {
                Notas.LA,
                Notas.SOL,
                Notas.FA,
                Notas.SI,
                Notas.LA,
                Notas.FA
        };

        int[] duraciones = {
                4,
                6,
                2,
                4,
                6,
                2,
        };

        fito.tocarCancion(notas, duraciones);
    }
}
