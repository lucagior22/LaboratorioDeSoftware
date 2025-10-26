package ejerciciodos;

import java.util.Arrays;
import java.util.Comparator;

public class PaintTest {

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.init();
        FiguraGeometrica[] paleta = paint.getPaleta();

        System.out.println("Orden actual: ");
        Arrays.stream(paint.getPaleta()).forEach(figura -> figura.dibujar());

        Arrays.sort(paleta, (f1, f2) -> Integer.compare(f1.area(), f2.area()));
        System.out.println("\nOrden por área: ");
        Arrays.stream(paleta).forEach(figura -> figura.dibujar());
    }
}
