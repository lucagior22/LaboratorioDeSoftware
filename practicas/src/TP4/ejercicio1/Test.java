package TP4.ejercicio1;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Materia materia = new Materia(new ArrayList<>(), "Laboratorio de SW");

        System.out.println("nomina: "+ materia.getNomina());

        materia.agregaAlumno(new Alumno(21099, "Messi", "Luca", 45806328));
        materia.agregaAlumno(new Alumno(21092, "Gomez", "Luca", 45806328));
        materia.agregaAlumno(new Alumno(21091, "Juarez", "Luca", 45806328));
        materia.agregaAlumno(new Alumno(21094, "Gonzalez", "Luca", 45806328));
        materia.agregaAlumno(new Alumno(21093, "Giordano", "Luca", 45806328));
        materia.agregaAlumno(new Alumno(21095, "Suarez", "Luca", 45806328));
        materia.agregaAlumno(new Alumno(21097, "Alvarez", "Luca", 45806328));
        materia.agregaAlumno(new Alumno(21098, "Martinez", "Luca", 45806328));
        materia.agregaAlumno(new Alumno(21096, "Rodriguez", "Luca", 45806328));
        materia.agregaAlumno(new Alumno(21090, "Ronaldo", "Luca", 45806328));

        System.out.println("nomina: "+ materia.getNomina());
    }
}
