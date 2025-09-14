package TP3.ejerciciotres;

public class Auto {
    private String marca;
    private String modelo;
    private Integer anio;
    private String patente;

    public Auto() {
    }

    public Auto(String marca, String modelo, Integer anio, String patente) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", patente='" + patente + '\'' +
                '}';
    }
}