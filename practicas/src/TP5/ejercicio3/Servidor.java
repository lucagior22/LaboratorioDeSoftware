package TP5.ejercicio3;


import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Servidor {
    String direccion();
    int puerto();
    String archivo();
}
