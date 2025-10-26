package ejercicioseis;

public class Estudiante {

    private String nombre;
    private String  apellido;
    private int edad;
    private String legajo;
    private int materiasAprobadas;

    public Estudiante(int edad, String nombre, String apellido, String legajo, int materiasAprobadas) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(int materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    @Override
    public String toString(){
        return nombre + " " + apellido + ", legajo " + legajo + ", " + edad + " años y " + materiasAprobadas + " materia/s aprobada/s";
    }

}
