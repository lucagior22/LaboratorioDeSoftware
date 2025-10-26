package parcialViejo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Buscador {

    private List<Pelicula> peliculas = new ArrayList<Pelicula>();
    private static ComparatorReproduccionesAsc compRepAsc;
    private static ComparatorReproduccionesDesc compRepDesc;

    public Buscador(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public ComparatorReproduccionesAsc getComparatorRepAsc(){
        if (compRepAsc == null){
            compRepAsc = new ComparatorReproduccionesAsc();
        }

        return compRepAsc;
    }

    public ComparatorReproduccionesDesc getComparatorRepDesc(){
        if (compRepDesc == null){
            compRepDesc = new ComparatorReproduccionesDesc();
        }

        return compRepDesc;
    }

    public List<Pelicula> seleccionar(Genero g, ClasificacionEdad ce, Valoracion valoracion, Reproducciones reproducciones, Comparator<Pelicula> comp){
        List<Pelicula> pelisFiltradas = new ArrayList<Pelicula>();

        for(Pelicula p: peliculas){
            if(p.getGeneros().contains(g) && (p.getClasificacionEdad().equals(ce)) &&(valoracion.enRango(p.getValoracion())) && (reproducciones.enRango(p.getReproducciones()))){
                pelisFiltradas.add(p);
            }
        }

        pelisFiltradas.sort(comp);
        return pelisFiltradas;
    }

    public static class ComparatorReproduccionesAsc implements Comparator<Pelicula>{

        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return Integer.compare(p1.getReproducciones(), p2.getReproducciones());
        }
    }

    public static class ComparatorReproduccionesDesc implements Comparator<Pelicula>{

        @Override
        public int compare(Pelicula p1, Pelicula p2) {
            return Integer.compare(p2.getReproducciones(), p1.getReproducciones());
        }
    }

}
