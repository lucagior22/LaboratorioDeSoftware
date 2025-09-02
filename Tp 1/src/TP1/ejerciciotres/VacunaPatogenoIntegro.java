package TP1.ejerciciotres;

public class VacunaPatogenoIntegro extends Vacuna {
    private String nombreVirus;

    public VacunaPatogenoIntegro(String nombreVirus, String marca, String paisOrigen, String enfermedad, int cantDosis) {
        super(marca, paisOrigen, enfermedad, cantDosis);
        this.nombreVirus = nombreVirus;
    }

    public String getNombreVirus() {
        return nombreVirus;
    }

    public void setNombreVirus(String nombreVirus) {
        this.nombreVirus = nombreVirus;
    }
}
