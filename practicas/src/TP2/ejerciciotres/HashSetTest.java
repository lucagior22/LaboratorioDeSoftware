package TP2.ejerciciotres;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSetAgregados<String> h = new HashSetAgregados<String>(new TreeSet<String>());

        System.out.println(h.add("Hola"));

        System.out.println(h.getCantidadAgregados());

        ArrayList<String> a = new ArrayList<String>();
        a.add("Mundo");
        a.add("Tuyo");
        a.add("Chico");
        a.add("Scarface");

        System.out.println(h.addAll(a));
        System.out.println("Se espera 5, se obtuvo ->:" + h.getCantidadAgregados());
    }
}
