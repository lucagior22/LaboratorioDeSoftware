package ejercicio2;

// Imports necesarios para reflexión (Field) y manejo de archivos (Files, Paths, etc.)
import java.lang.reflect.Field;
import java.util.Objects;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Mapper {

    public static void main(String[] args) {
        // Instanciamos el objeto 'Bean' y obtenemos su objeto Class para la reflexión
        Bean bean = new Bean();
        Class<?> beanClass = bean.getClass();

        String nombre = beanClass.getAnnotation(Archivo.class).nombre();
        String fileName = !Objects.equals(nombre, "") ? nombre : beanClass.getSimpleName() + ".txt";

        StringBuilder contenido = new StringBuilder();

        // Agregar encabezado con el nombre de la clase
        contenido.append("<nombreClase>")
                .append(beanClass.getSimpleName())
                .append("</nombreClase>\n");


        for (Field f : beanClass.getDeclaredFields()){

            if(f.isAnnotationPresent(Archivo.AlmacenarAtributo.class)){

                try{
                    f.setAccessible(true);
                    String lineaAt = "<nombreAtributo>" + f.getName() + "</nombreAtributo>\n";
                    contenido.append("<nombreAtributo>")
                            .append(f.getName())
                            .append("</nombreAtributo>\n");
                }
                catch(Exception e){
                    System.out.println("Error en el siguiente campo:" + f.getName());
                }

            }

        }
        // Escribir el contenido en el archivo
        try {
            Files.writeString(Paths.get(fileName),
                    contenido.toString());
            System.out.println("Archivo generado: " + fileName);
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

    }

}
