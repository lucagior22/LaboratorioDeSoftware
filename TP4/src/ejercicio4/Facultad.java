package ejercicio4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Facultad {

    private List<Alumno> alumnos = new ArrayList<>();

    public Alumno mayorNota(){

        return this.alumnos.stream()
                .max((a1, a2) -> Integer.compare(a1.getNota(), a2.getNota()))
                .orElse(null);
    }

    public Alumno tomoElcursoLabo(){

        return this.alumnos.stream()
                .filter(a -> (Objects.equals(a.getMateriaAprobada(), "Laboratorio de Software")))
                .findFirst()
                .orElse(null);

    }

    public void ordenarPorNotaClase(){

        this.alumnos.sort(new Comparator<Alumno>() {
            @Override
            public int compare(Alumno a1, Alumno a2) {
                return Integer.compare(a2.getNota(), a1.getNota());
            }
        });

    }

    public void ordenarPorNotaFuncion(){

        this.alumnos.sort((a1, a2) -> Integer.compare(a2.getNota(), a1.getNota()));

    }



}
