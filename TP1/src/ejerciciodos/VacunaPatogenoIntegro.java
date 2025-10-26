package ejerciciodos;

import ejerciciouno.Vacuna;

public class VacunaPatogenoIntegro extends Vacuna {

    String nombreVirusPatogeno;

    public VacunaPatogenoIntegro(String marca, String paisOrigen, String enfermedad, int cantDosis, String nombreVirusPatogeno) {
        super(marca, paisOrigen, enfermedad, cantDosis);
        this.nombreVirusPatogeno = nombreVirusPatogeno;
    }
}
