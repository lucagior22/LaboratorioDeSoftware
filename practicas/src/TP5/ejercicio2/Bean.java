package TP5.ejercicio2;

import TP5.ejercicio2.Archivo.*;

@Archivo(nombre="MrBeanArchivo.txt")
public class Bean {

    @AlmacenarAtributo
    private String name = "Mr Bean";

    @AlmacenarAtributo
    private int age = 60;

    @AlmacenarAtributo
    private int iq = 40;

    private double luckPercentage = 100.0;
}
