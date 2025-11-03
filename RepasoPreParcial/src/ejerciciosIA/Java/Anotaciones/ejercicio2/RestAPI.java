package ejerciciosIA.Java.Anotaciones.ejercicio2;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RestAPI {
    String baseUrl() default "/api";
    int port();
    int maxConnections();
}
