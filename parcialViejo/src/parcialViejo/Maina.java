package parcialViejo;

import java.util.Arrays;
import java.util.List;

public class Maina {
    public static void main(String[] args) {

// Creo el buscador


        // Armo lista de películas
        List<Pelicula> peliculas = Arrays.asList(
                new Pelicula("Matrix", 1999, "EEUU", ClasificacionEdad.mas13, 8.7, 1500, Arrays.asList(Genero.ACCION, Genero.CIENCIAFICCION)),
                new Pelicula("Titanic", 1997, "EEUU", ClasificacionEdad.ATP, 7.8, 2300, Arrays.asList(Genero.ROMANCE, Genero.DRAMA)),
                new Pelicula("El Señor de los Anillos", 2001, "NZ", ClasificacionEdad.mas13, 9.0, 3000, Arrays.asList(Genero.FANTASIA, Genero.ACCION)),
                new Pelicula("La La Land", 2016, "EEUU", ClasificacionEdad.mas13, 8.0, 1200, Arrays.asList(Genero.MUSICAL, Genero.ROMANCE)),
                new Pelicula("Inception", 2010, "EEUU", ClasificacionEdad.mas13, 8.8, 2800, Arrays.asList(Genero.ACCION, Genero.CIENCIAFICCION)),
                new Pelicula("Avengers", 2012, "EEUU", ClasificacionEdad.mas13, 8.1, 4000, Arrays.asList(Genero.ACCION, Genero.CIENCIAFICCION)),
                new Pelicula("Joker", 2019, "EEUU", ClasificacionEdad.mas16, 8.5, 2200, Arrays.asList(Genero.DRAMA, Genero.SUSPENSO)),
                new Pelicula("Toy Story", 1995, "EEUU", ClasificacionEdad.ATP, 8.3, 2700, Arrays.asList(Genero.COMEDIA, Genero.FANTASIA)),
                new Pelicula("Interstellar", 2014, "EEUU", ClasificacionEdad.mas13, 8.6, 3500, Arrays.asList(Genero.CIENCIAFICCION, Genero.DRAMA)),
                new Pelicula("Frozen", 2013, "EEUU", ClasificacionEdad.ATP, 7.5, 1800, Arrays.asList(Genero.MUSICAL, Genero.FANTASIA))
        );

        Buscador buscador = new Buscador(peliculas);

        // Uso directamente los enums como rango
        Valoracion val = Valoracion.DE7A10;
        Reproducciones rep = Reproducciones.MASDE1000;

        System.out.println("=== Resultados con ComparatorReproduccionesAsc ===");
        List<Pelicula> resultadoAsc = buscador.seleccionar(
                Genero.ACCION,
                ClasificacionEdad.mas13,
                val,
                rep,
                buscador.getComparatorRepAsc()
        );
        for (Pelicula p : resultadoAsc) {
            System.out.println(p.getTitulo() + " - Reproducciones: " + p.getReproducciones());
        }

        System.out.println("\n=== Resultados con ComparatorReproduccionesDesc ===");
        List<Pelicula> resultadoDesc = buscador.seleccionar(
                Genero.ACCION,
                ClasificacionEdad.mas13,
                val,
                rep,
                buscador.getComparatorRepDesc()
        );
        for (Pelicula p : resultadoDesc) {
            System.out.println(p.getTitulo() + " - Reproducciones: " + p.getReproducciones());
        }

    }
}
