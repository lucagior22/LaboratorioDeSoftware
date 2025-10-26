package ejerciciodos;
import ejerciciouno.Vacuna;

public class VacunaGenetica extends Vacuna{

    int tempMin;
    int tempMax;

    public VacunaGenetica(String marca, String paisOrigen, String enfermedad, int cantDosis, int tempMin, int tempMax) {
        super(marca, paisOrigen, enfermedad, cantDosis);
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }
}
