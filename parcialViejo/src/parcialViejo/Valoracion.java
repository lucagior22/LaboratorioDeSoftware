package parcialViejo;

public enum Valoracion implements Rango{

    DE0A2("0.0-2.0", 0.0, 2.0),
    DE2A4("2.0-4.0", 2.0, 4.0),
    DE4A7("4.0-7.0", 4.0, 7.0),
    DE7A10("7.0-10.0", 7.0, 10.0);

    private final String valoracion;
    private final double min;
    private final double max;

    Valoracion(String valoracion, double min, double max) {
        this.valoracion = valoracion;
        this.min = min;
        this.max = max;
    }

    public String getValoracion() {
        return valoracion;
    }

    @Override
    public boolean enRango(Number n){
        return (min <= n.doubleValue()) && (max >= n.doubleValue());
    }

}
