package ejerciciosIA.Java.Anotaciones.ejercicio1;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NotificationServer {
    int port() default 8080;
    String logFile() default "notifications.log";
}
