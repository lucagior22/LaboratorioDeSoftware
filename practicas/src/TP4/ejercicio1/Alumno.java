package TP4.ejercicio1;

public class Alumno implements Comparable{
    private int legajo;
    private String apellido;
    private String nombre;
    private long dni;

    public Alumno(int legajo, String apellido, String nombre, long dni) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "legajo=" + legajo +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Alumno a = (Alumno) o;

        return Integer.compare(this.legajo, a.legajo);
    }
}
