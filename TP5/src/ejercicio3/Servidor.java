package ejercicio3;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//  Indica que la clase funcionara como servidor HTTP
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Servidor {

        String direccion() default "0.0.0.0";
        int puerto() default 80;
        String archivo() default "default.txt";


        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Invocar{
        }

}
