package ejerciciosIA.Java.Anotaciones.ejercicio2;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Endpoint {
    String path();
    HTTPMethods method();
}

