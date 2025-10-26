package ejerciciocuatro;

import ejerciciocuatro.Circulo;
import ejerciciocuatro.Paint;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(new FileOutputStream("persona.dat"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                out.writeObject(figuraGeometrica);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
