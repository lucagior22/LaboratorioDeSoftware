package ejercicioocho;

public interface InstrumentoMusical {
    default void hacerSonar(){};
    void hacerSonar(Notas n, int duracion);
    String queEs();
    default void afinar(){}
    default void afinar(FrecuenciasDeLA f){}
}