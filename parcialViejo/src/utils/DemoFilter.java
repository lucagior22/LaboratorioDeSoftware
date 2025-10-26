import java.util.*;
import java.util.stream.*;

public class DemoFilter {

    static class Persona {
        String nombre;
        int edad;

        Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public String toString() {
            return nombre + " (" + edad + ")";
        }
    }

    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Sofia", 15),
                new Persona("Pedro", 22),
                new Persona("Ana", 19),
                new Persona("Lucas", 30),
                new Persona("Santiago", 17),
                new Persona("Paula", 25),
                new Persona("Juana", 40),
                new Persona("Pablo", 28),
                new Persona("Lucia", 12),
                new Persona("Andres", 33)
        );

        // 1. Filtrar por una condición simple
        System.out.println("Mayores de 18:");
        personas.stream()
                .filter(p -> p.edad >= 18)
                .forEach(System.out::println);

        // 2. Filtrar por condición de texto
        System.out.println("\nNombres que empiezan con 'P':");
        personas.stream()
                .filter(p -> p.nombre.startsWith("P"))
                .forEach(System.out::println);

        // 3. Encadenar varios filter
        System.out.println("\nMayores de 20 cuyo nombre empieza con 'L':");
        personas.stream()
                .filter(p -> p.edad > 20)
                .filter(p -> p.nombre.startsWith("L"))
                .forEach(System.out::println);

        // 4. Filtrar usando expresiones regulares
        System.out.println("\nNombres que terminan con 'a':");
        personas.stream()
                .filter(p -> p.nombre.matches(".*a$"))
                .forEach(System.out::println);

        // 5. Filtrar con una condición de negación
        System.out.println("\nTodos menos los menores de edad:");
        personas.stream()
                .filter(p -> !(p.edad < 18))
                .forEach(System.out::println);

        // 6. Filtrar por condición "compuesta"
        System.out.println("\nEntre 20 y 30 años:");
        personas.stream()
                .filter(p -> p.edad >= 20 && p.edad <= 30)
                .forEach(System.out::println);
    }


}