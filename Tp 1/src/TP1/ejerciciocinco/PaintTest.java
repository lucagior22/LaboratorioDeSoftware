package TP1.ejerciciocinco;

public class PaintTest {
    // No entendí bien la consigna, pero este main sirve para probar todo igualmente
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.init();

        paint.getPaleta().stream().forEach(figuraGeometrica -> {
            figuraGeometrica.area();

            if (figuraGeometrica instanceof Circulo){
                System.out.println("Radio de circulo: " + ((Circulo) figuraGeometrica).getRadio());
            }

            System.out.println("Area de figura: " + figuraGeometrica.area());

            figuraGeometrica.dibujar();
        });
    }
}
