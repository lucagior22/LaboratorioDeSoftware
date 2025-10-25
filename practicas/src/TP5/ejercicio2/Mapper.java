package TP5.ejercicio2;

// Imports necesarios para reflexión (Field) y manejo de archivos (Files, Paths, etc.)
import java.lang.reflect.Field;
import java.util.Objects;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class Mapper {
    public static void main(String[] args) {

        // Instanciamos el objeto 'Bean' y obtenemos su objeto Class para la reflexión
        Bean bean = new Bean();
        Class<?> beanClass = bean.getClass();

        // Leemos la anotación @Archivo de la clase para obtener el nombre deseado
        String nombre = beanClass.getAnnotation(Archivo.class).nombre();

        // Determinamos el nombre final. Si la anotación no provee uno, usamos el nombre de la clase.
        String fileName = !Objects.equals(nombre, "") ? nombre : beanClass.getSimpleName() + ".txt";

        // Usamos un StringBuilder para construir eficientemente el contenido del archivo
        StringBuilder fileContents = new StringBuilder();

        // Añadimos la etiqueta de apertura con el nombre de la clase
        fileContents.append("<nombreClase>" + beanClass.getSimpleName() + "</nombreClase>\n");

        // Iteramos sobre todos los campos (atributos) declarados en la clase
        for (Field field : beanClass.getDeclaredFields()) {

            // Verificamos si el campo está anotado con @AlmacenarAtributo
            if (field.isAnnotationPresent(Archivo.AlmacenarAtributo.class)) {

                try {
                    // Hacemos el campo accesible (necesario si es 'private')
                    field.setAccessible(true);

                    // Obtenemos el nombre del campo y su valor, y los añadimos al contenido
                    fileContents.append("<nombreAtributo>" + field.getName() + "</nombreAtributo>\n");
                    fileContents.append("<nombreValor>" + field.get(bean).toString() + "</nombreValor>\n");

                } catch (IllegalAccessException a) {
                    // Manejamos el error si no pudimos acceder al campo
                    System.out.println("Error de acceso en el campo: " + field.getName());
                }
            }
        }

        // Bloque final para escribir el contenido generado en el archivo físico
        try {
            // Escribimos el String completo en el archivo, usando codificación UTF-8
            Files.write(
                    Paths.get(fileName),
                    fileContents.toString().getBytes(StandardCharsets.UTF_8)
            );

            System.out.println("Archivo '" + fileName + "' creado exitosamente.");

        } catch (IOException e) {
            // Manejamos cualquier error que ocurra durante la escritura del archivo
            System.err.println("Error al escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}