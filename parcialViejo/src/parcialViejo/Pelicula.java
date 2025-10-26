package parcialViejo;


import java.util.ArrayList;
import java.util.List;

public class Pelicula {

    private String titulo;
    private int anio;
    private String pais;
    private ClasificacionEdad clasificacionEdad;
    private double valoracion;
    private int reproducciones;
    private List<Genero> generos = new ArrayList<Genero>();

    public Pelicula(String titulo, int anio, String pais, ClasificacionEdad clasificacionEdad, double valoracion, int reproducciones, List<Genero> generos) {
        this.titulo = titulo;
        this.anio = anio;
        this.pais = pais;
        this.clasificacionEdad = clasificacionEdad;
        this.reproducciones = reproducciones;
        this.valoracion = valoracion;
        this.generos = generos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPais() {
        return pais;
    }

    public double getValoracion() {
        return valoracion;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ClasificacionEdad getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(ClasificacionEdad clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
}
