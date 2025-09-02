package TP1.ejerciciotres;

public class VacunaSubunidadAntigenica extends Vacuna {
    private int cantAntigenos;
    private String tipoProceso;

    public VacunaSubunidadAntigenica(int cantAntigenos, String tipoProceso, String marca, String paisOrigen, String enfermedad, int cantDosis) {
        super(marca, paisOrigen, enfermedad, cantDosis);
        this.cantAntigenos = cantAntigenos;
        this.tipoProceso = tipoProceso;
    }

    public int getCantAntigenos() {
        return cantAntigenos;
    }

    public void setCantAntigenos(int cantAntigenos) {
        this.cantAntigenos = cantAntigenos;
    }

    public String getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(String tipoProceso) {
        this.tipoProceso = tipoProceso;
    }
}
