package TP2.ejerciciodos;

import java.util.ArrayList;

public class PaintTest {
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.init();

        ArrayList<FiguraGeometrica> paleta = paint.getPaleta();

        System.out.println("Orden actual:");
        paleta.forEach(f -> {
            f.dibujar();
        });

        System.out.println();
        paleta.sort(null);

        System.out.println("Orden modificado:");
        paleta.forEach(f -> {
            f.dibujar();
        });

    }
}
