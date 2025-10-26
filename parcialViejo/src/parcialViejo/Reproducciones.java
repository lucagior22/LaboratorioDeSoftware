package parcialViejo;

public enum Reproducciones implements Rango{

    MENOSDE10("10 <", 0, 99),
    DE10A99("10-99", 10, 99),
    DE100A499("100-499", 100, 499),
    DE500A999("500-999", 500, 999),
    MASDE1000(">1000", 1000, Integer.MAX_VALUE);

    private String reproducciones;
    private int min;
    private int max;

    Reproducciones(String reproducciones, int min, int max) {
        this.reproducciones = reproducciones;
        this.min = min;
        this.max = max;
    }

    public String getReproducciones() {
        return reproducciones;
    }

    @Override
    public boolean enRango(Number n) {
        return (min <= n.intValue()) && (max >= n.intValue());
    }
}
