package TP3.ejerciciotres;

import java.util.Objects;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private Integer edad;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String dni, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                '}';
    }
}
