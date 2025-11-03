package ejerciciosIA.Java.Anotaciones.ejercicio1;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NotifyClient {
}
