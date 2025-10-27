package ejercicio3;

import static ejercicio3.Servidor.*;

@Servidor(archivo = "res.txt", direccion = "127.0.0.1", puerto = 8080)
public class EjemploServidor {

    @Invocar
    public void metodo(){
        System.out.println("Este es un metodo");
    }
}
