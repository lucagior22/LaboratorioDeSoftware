package TP4.ejercicio1;

import java.util.Comparator;
import java.util.List;

public class Materia {
    private List<Alumno> nomina;
    private String nombre;

    public Materia(List<Alumno> nomina, String nombre) {
        this.nomina = nomina;
        this.nombre = nombre;
    }

    public boolean agregaAlumno(Alumno a) {
        boolean couldAdd = nomina.add(a);
        nomina.sort(new Comparator<Alumno>() {
            @Override
            public int compare(Alumno o1, Alumno o2) {
                return o1.compareTo(o2);
            }
        });
        return couldAdd;
    }

    public List<Alumno> getNomina() {
        return nomina;
    }

    public void setNomina(List<Alumno> nomina) {
        this.nomina = nomina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
