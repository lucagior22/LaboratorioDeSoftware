package TP2.ejerciciocuatro;

import java.io.Serializable;

public abstract class FiguraGeometrica implements Serializable {
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
}
