package TP3.ejerciciocinco;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack implements Iterable{
    private ArrayList items;

    public Stack() {
        items = new ArrayList();
    }

    public void push(Object item) {
        items.addLast(item);
    }

    public Object pop() {
        Object item = items.getLast();
        items.remove(items.size() - 1);
        return item;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Iterator iterator() {
        return new Iterator() {
            private int index = items.size() - 1;

            public boolean hasNext() {
                return index >= 0;
            }

            public Object next() {
                Object item = items.get(index);
                index--;
                return item;
            }
        };
    }
}
