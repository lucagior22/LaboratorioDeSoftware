package TP3.ejercicioocho;

public enum FrecuenciasDeLA {
    ISO(440), CAMARA(444), RENACIMIENTO(446), ORGANO(480);

    private int hz;

    FrecuenciasDeLA(int hz) {
        this.hz = hz;
    }
}
