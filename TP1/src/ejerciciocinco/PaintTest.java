package ejerciciocinco;

public class PaintTest {

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.init();

        paint.getPaleta().stream().forEach(figuraGeometrica -> {

            if(figuraGeometrica instanceof Circulo){
                System.out.println("Radio de circulo: " + ((Circulo) figuraGeometrica).getRadio());
            }

            System.out.println("Area de figura: " + figuraGeometrica.area());

            figuraGeometrica.dibujar();

        });

    }
}
