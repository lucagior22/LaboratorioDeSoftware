package ejerciciocinco;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack {

    private ArrayList items;

    public Stack(){
        items = new ArrayList<>();
    }

    public void push(Object item){
        this.items.addFirst(item);
    }

    public Object pop(){
        Object item = this.items.getFirst();
        this.items.removeFirst();
        return item;
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public Iterator iterator(){
        return new Iterator(){
            private int index = items.size() -1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Object next() {
                Object item = items.get(index);
                index--;
                return item;
            }
        };
    }


}
