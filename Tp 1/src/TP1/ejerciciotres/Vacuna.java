package TP1.ejerciciotres;

public class Vacuna {

    private String marca;
    private String paisOrigen;
    private String enfermedad;
    private int cantDosis;

    public Vacuna(String marca, String paisOrigen, String enfermedad, int cantDosis) {
        this.marca = marca;
        this.paisOrigen = paisOrigen;
        this.enfermedad = enfermedad;
        this.cantDosis = cantDosis;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int getCantDosis() {
        return cantDosis;
    }

    public void setCantDosis(int cantDosis) {
       this.cantDosis = cantDosis;
   }


    @Override
    public boolean equals(Object o){
        boolean isEqual;
        Vacuna vacuna = (Vacuna) o;
        isEqual = (this.marca.equals(vacuna.marca));
        isEqual = isEqual && (this.paisOrigen.equals(vacuna.paisOrigen));
        isEqual = isEqual && (this.enfermedad.equals(vacuna.enfermedad));
        isEqual = isEqual && (this.cantDosis == vacuna.cantDosis);
        return isEqual;
    }

//    @Override
//    public String toString() {
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("Vacuna:");
//        buffer.append("marca= '").append(marca).append('\'');
//        buffer.append("paisOrigen= '").append(paisOrigen).append('\'');
//        buffer.append("enfermedad= '").append(enfermedad).append('\'');
//        buffer.append("cantDosis= '").append(cantDosis).append('\'');
//        return buffer.toString();
//    }

}
