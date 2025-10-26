package ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Materia {

    private String nombre;
    private List<Alumno> nomina = new ArrayList<Alumno>();

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public boolean agregarAlumno(Alumno a){
        return this.nomina.add(a);
    }

    public List<Alumno> getAlumnos(){
        return this.nomina;
    }

}
