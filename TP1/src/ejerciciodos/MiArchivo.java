package ejerciciodos;
import java.io.File;

public class MiArchivo extends File{
    public MiArchivo(String pathname) {
        super(pathname);
        System.out.println("Mi Archivo instanciado") ;
    }
}
