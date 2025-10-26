package ejercicio4;

public class Alumno {

    private String apellido;
    private String nombre;
    private String legajo;
    private String dni;
    private int edad;
    private String materiaAprobada;
    private int nota;

    public Alumno(String apellido, String nombre, String legajo, String dni, int edad, String materiaAprobada, int nota) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.legajo = legajo;
        this.dni = dni;
        this.edad = edad;
        this.materiaAprobada = materiaAprobada;
        this.nota = nota;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMateriaAprobada() {
        return materiaAprobada;
    }

    public void setMateriaAprobada(String materiaAprobada) {
        this.materiaAprobada = materiaAprobada;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


}
