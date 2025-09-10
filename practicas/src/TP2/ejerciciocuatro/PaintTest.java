package TP2.ejerciciocuatro;

import java.io.*;

public class PaintTest {
    // No entendí bien la consigna, pero este main sirve para probar todo igualmente
    public static void main(String[] args)
    {
        Paint paint = new Paint();
        paint.init();

        paint.getPaleta().forEach((FiguraGeometrica f) -> {
            // closing streams
            try {
                FileOutputStream fos = new FileOutputStream(f.toString() + ".txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(f);

                FileInputStream fis = new FileInputStream(f.toString() + ".txt");

                ObjectInputStream ois = new ObjectInputStream(fis);
                FiguraGeometrica b = (FiguraGeometrica) ois.readObject();

                System.out.println("Deserializado: ");
                b.dibujar();

                oos.close();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
