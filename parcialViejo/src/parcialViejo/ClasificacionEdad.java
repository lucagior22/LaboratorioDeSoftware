package parcialViejo;

public enum ClasificacionEdad {

    ATP("Apto para todo publico"),
    mas13("Apta mayores de trece anios"),
    mas16("Apta mayores de dieciseis anios"),
    mas18("Apta mayores de dieciocho anios");

    private final String descripcion;


    ClasificacionEdad(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }


}
