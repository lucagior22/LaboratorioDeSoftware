package TP2.ejerciciotres;

import java.util.*;

public class HashSetAgregados<E> extends AbstractSet<E> {
    private int cantidadAgregados = 0;
    private Set<E> set;

    public HashSetAgregados(Set<E> set) {
        this.set = set;
    }

    public HashSetAgregados(int initCap, float loadFactor) {
        this.set = new HashSet<>(initCap, loadFactor);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean add(E e) {
        cantidadAgregados++;
        return set.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        cantidadAgregados += c.size();
        return set.addAll(c);
    }

    public int getCantidadAgregados() {
        return cantidadAgregados;
    }
}