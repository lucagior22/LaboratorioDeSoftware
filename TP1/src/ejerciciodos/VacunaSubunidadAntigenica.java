package ejerciciodos;

import ejerciciouno.Vacuna;

public class VacunaSubunidadAntigenica extends Vacuna {

    int cantAntigenos;
    String tipoProceso;

    public VacunaSubunidadAntigenica(String marca, String paisOrigen, String enfermedad, int cantDosis, int cantAntigenos, String tipoProceso) {
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
