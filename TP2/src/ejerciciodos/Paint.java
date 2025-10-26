package ejerciciodos;

import ejerciciodos.Circulo;
import ejerciciodos.Rectangulo;

import java.util.ArrayList;

public class Paint {

    private FiguraGeometrica[] paleta;

    public Paint(){}

    public void setPaleta(FiguraGeometrica[] paleta){
        this.paleta = paleta;
    }

    public FiguraGeometrica[] getPaleta() {
        return paleta;
    }

    public void init(){
        Rectangulo rectangulo = new Rectangulo(3, 2);
        rectangulo.setColor("verde");
        Circulo circulo = new Circulo();
        circulo.setColor("azul");
        circulo.setRadio(2);
        Rectangulo rectangulo2 = new Rectangulo(10, 4);
        rectangulo.setColor("rojo");
        Circulo circulo2 = new Circulo();
        circulo2.setColor("amarillo");
        circulo2.setRadio(3);
        paleta = new FiguraGeometrica[]{rectangulo2, rectangulo, circulo2, circulo};
    }
}
