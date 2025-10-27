package ejercicio2;

import static ejercicio2.Archivo.*;

@Archivo(nombre = "bean.txt")
public class Bean {

    @AlmacenarAtributo
    private String valor = "Default1";
    @AlmacenarAtributo
    private Integer valor2 = 20;
    @AlmacenarAtributo
    private Float valor3 = 30.20f;
    private Float valor4 = 30.20f;
}
