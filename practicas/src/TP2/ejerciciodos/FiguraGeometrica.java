package TP2.ejerciciodos;

public abstract class FiguraGeometrica implements Comparable {
    private String color;

    public FiguraGeometrica(){}

    public abstract void dibujar();

    public abstract int area();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int compareTo(Object o) {
        FiguraGeometrica f = (FiguraGeometrica) o;

        if (this.area() > f.area()) {
            return 1;
        } else if (this.area() < f.area() ) {
            return -1;
        } else {
            return 0;
        }
    }
}
