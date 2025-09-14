package TP3.ejerciciotres;

import java.util.Iterator;

public class TestSet {
    public static void main(String[] args) {
        StringConverterSet set = new StringConverterSet();

        Auto a1 = new Auto("Audi", "A3", 2020, "ABC123");
        Auto a2 = new Auto("BMW", "X5", 2018, "DEF456");
        Auto a3 = new Auto("Toyota", "Corolla", 2022, "GHI789");

        Persona p1 = new Persona("Juan", "Pérez", "12345678", 30);
        Persona p2 = new Persona("Ana", "García", "87654321", 25);
        Persona p3 = new Persona("Luis", "Martínez", "11223344", 40);

        set.add(a1);
        set.add(a2);
        set.add(a3);
        set.add(p1);
        set.add(p2);
        set.add(p3);

        for (Object o : set) {
            System.out.println("Next: " + o);
        }

    }
}
