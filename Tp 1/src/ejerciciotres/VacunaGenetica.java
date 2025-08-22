package ejerciciotres;

public class VacunaGenetica extends Vacuna{
    private float temperaturaMinima;
    private float temperaturaMaxima;

    public VacunaGenetica(float temperaturaMinima, float temperaturaMaxima, String marca, String paisOrigen, String enfermedad, int cantDosis) {
        super(marca, paisOrigen, enfermedad, cantDosis);
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public float getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(float temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public float getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(float temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }
}
