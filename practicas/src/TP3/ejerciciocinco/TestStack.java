package TP3.ejerciciocinco;

import java.util.Iterator;

public class TestStack {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push("Uno");
        s.push("Dos");
        s.push("Tres");
        s.push("Cuatro");
        s.push("Cinco");

        System.out.println("Primer IT");
        Iterator it = s.iterator();
        while (it.hasNext()) {
            System.out.println("next: " + it.next());
        }

        System.out.println();

        System.out.println("Segundo IT");
        it = s.iterator();
        while (it.hasNext()) {
            System.out.println("next: " + it.next());
        }
    }
}
