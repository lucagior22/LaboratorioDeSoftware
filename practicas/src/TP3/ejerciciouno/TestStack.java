package TP3.ejerciciouno;

import java.util.Iterator;

public class TestStack {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push("Lorem");
        s.push("Ipsum");
        s.push("Dolor");
        s.push("Sit");
        s.push("Amet");

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
