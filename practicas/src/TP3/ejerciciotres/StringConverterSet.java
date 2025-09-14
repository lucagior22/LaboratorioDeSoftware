package TP3.ejerciciotres;

import java.util.*;

public class StringConverterSet extends AbstractSet implements Iterable {
    private Set set;

    public StringConverterSet() {
        set = new HashSet<>();
    }

    @Override
    public int size() {
        return set.size();
    }

    public boolean add(Object object) {
        set.add(object);
        return true;
    }

    public Iterator iterator() {
        return new IteratorStringAdapter();
    }

    private class IteratorStringAdapter implements Iterator {
        private int index = 0;
        private final Object[] array = set.toArray();

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public Object next() {
            Object object = array[index];
            index++;
            return object.toString();
        }
    }
}
