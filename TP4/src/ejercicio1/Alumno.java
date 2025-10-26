package ejercicio1;

public class Alumno {

    private String apellido;
    private String nombre;
    private String legajo;
    private String dni;

    public Alumno(String apellido, String nombre, String legajo, String dni) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.legajo = legajo;
        this.dni = dni;
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

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
