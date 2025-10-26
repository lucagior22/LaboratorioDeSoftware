package ejercicio1;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        Materia materia = new Materia("Programación I");

        // Agregar 10 alumnos
        for (int i = 1; i <= 10; i++) {
            Alumno alumno = new Alumno(
                    "Apellido" + i,
                    "Nombre" + i,
                    "1000" + (i % 10),
                    String.valueOf(4000000 + (i  % 10))
            );
            materia.agregarAlumno(alumno);
        }

        // Imprimir la lista de alumnos
        System.out.println("Lista de alumnos en la materia " + materia.getAlumnos().size() + ":");

        for (Alumno a : materia.getAlumnos()) {
            System.out.println(
                    a.getLegajo() + " - " + a.getApellido() + ", " + a.getNombre() + " (DNI: " + a.getDni() + ")"
            );

        }
    }
}