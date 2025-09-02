package TP1.ejerciciocinco;

import java.util.ArrayList;

public class Paint {
    private ArrayList<FiguraGeometrica> paleta = new ArrayList<>();

    public Paint() {}

    public void setPaleta(ArrayList<FiguraGeometrica> paleta) {
        this.paleta = paleta;
    }

    public ArrayList<FiguraGeometrica> getPaleta() {
        return paleta;
    }

    public void init() {
        Circulo circuloAzul = new Circulo();
        circuloAzul.setRadio(2);
        circuloAzul.setColor("azul");

        Circulo circuloAmarillo = new Circulo();
        circuloAmarillo.setRadio(3);
        circuloAmarillo.setColor("amarillo");

        Rectangulo rectanguloVerde = new Rectangulo(2, 3);
        rectanguloVerde.setColor("verde");

        Rectangulo rectanguloRojo = new Rectangulo(4, 10);
        rectanguloRojo.setColor("rojo");

        paleta.add(circuloAzul);
        paleta.add(circuloAmarillo);
        paleta.add(rectanguloRojo);
        paleta.add(rectanguloVerde);
    }
}
