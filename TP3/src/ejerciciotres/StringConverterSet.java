package ejerciciotres;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringConverterSet<E> extends AbstractSet<E>{

    private Set set;

    public StringConverterSet(){
        set = new HashSet<>();
    }


    @Override
    public int size() {
        return set.size();
    }

    @Override
    public Iterator iterator() {
        return new IteratorStringAdapter();
    }

    public boolean add(Object object) {
        return set.add(object);
    }


    private class IteratorStringAdapter implements Iterator{

        int index = 0;
        private final Object[] array = set.toArray();

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public String next() {
            String item = (String) array[index];
            index++;
            return item;
        }
    }

}
