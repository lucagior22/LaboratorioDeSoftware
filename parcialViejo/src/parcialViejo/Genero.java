package parcialViejo;

public enum Genero {

    ACCION("Accion"),
    CIENCIAFICCION("Ciencia ficcion"),
    COMEDIA("Comedia"),
    DRAMA("Drama"),
    FANTASIA("Fantasia"),
    MUSICAL("Musical"),
    ROMANCE("Romance"),
    SUSPENSO("Suspenso");

    private final String nombre;

    Genero(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
