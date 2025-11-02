package TP5.ejercicio3Repaso;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Servidor {
    String ip();
    int port();
    String loggingFile();
}
