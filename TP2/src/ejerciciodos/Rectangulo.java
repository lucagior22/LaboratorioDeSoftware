package ejerciciodos;

public class Rectangulo extends FiguraGeometrica{

    private int ancho;
    private int alto;

    public Rectangulo(){}


    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public void dibujar(){
        System.out.println("Se dibuja un rectangulo de ancho " + ancho +", alto " + alto + " y color " + super.getColor());
    }

    public int area(){
        return ancho * alto;
    }

}
