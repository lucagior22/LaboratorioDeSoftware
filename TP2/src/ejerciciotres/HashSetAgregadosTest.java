package ejerciciotres;

import java.util.ArrayList;

public class HashSetAgregadosTest {

    public static void main(String[] args) {

        HashSetAgregados<String> set = new HashSetAgregados<>(16, 0.75f);
        ArrayList<String> arreglo = new ArrayList<String>();

        arreglo.add("Hola");
        arreglo.add("Chau");

        set.addAll(arreglo);

        System.out.println(set);
        System.out.println(set.getCantidadAgregados());


    }
}
