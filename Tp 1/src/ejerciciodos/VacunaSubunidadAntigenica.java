package ejerciciodos;

public class VacunaSubunidadAntigenica extends Vacuna {
    private int cantAntigenos;
    private String tipoProceso;

    public VacunaSubunidadAntigenica(int cantAntigenos, String tipoProceso) {
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
