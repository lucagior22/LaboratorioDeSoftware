package ejerciciocinco;

import java.util.ArrayList;

public class Paint {

    private ArrayList<FiguraGeometrica> paleta = new ArrayList<FiguraGeometrica>();

    public Paint(){}

    public void setPaleta(ArrayList<FiguraGeometrica> paleta){
        this.paleta = paleta;
    }

    public ArrayList<FiguraGeometrica> getPaleta() {
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
        circulo.setColor("amarillo");
        circulo.setRadio(3);
        paleta.add(rectangulo);
        paleta.add(rectangulo2);
        paleta.add(circulo);
        paleta.add(circulo2);
    }
}
