package TP2.ejerciciocuatro;

public class Rectangulo extends FiguraGeometrica {
    private int alto;
    private int ancho;

    public Rectangulo(){}

    public Rectangulo(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public void dibujar() {
        System.out.println("Se imprime un rectangulo de alto:" + alto + ", ancho:" + ancho + ", area:" + area() + " y color: " + this.getColor());
    }

    public int area() {
        return alto * ancho;
    }
}
