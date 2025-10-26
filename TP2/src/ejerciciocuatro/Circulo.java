package ejerciciocuatro;


public class Circulo extends FiguraGeometrica {

    private int radio;

    public Circulo() {}

    public void dibujar(){
        System.out.println("Se dibuja un circulo de radio " + radio + " y de color " + super.getColor());
    }

    public int area(){
        return (int) Math.PI * radio * radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
}

