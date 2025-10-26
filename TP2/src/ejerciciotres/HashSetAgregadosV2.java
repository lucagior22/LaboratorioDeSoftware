package ejerciciotres;

import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;

public class HashSetAgregadosV2<E> implements Set<E> {

    private HashSet<E> base = new HashSet<>();
    private int cantidadAgregados = 0;

    public boolean add(E e) {
        boolean agregado = base.add(e);
        if (agregado) cantidadAgregados++;
        return agregado;
    }

    public boolean addAll(Collection<? extends E> c) {
        int inicial = base.size();
        boolean resultado = base.addAll(c);
        cantidadAgregados += base.size() - inicial;
        return resultado;
    }

    @Override
    public int size() { return base.size(); }

    @Override
    public boolean isEmpty() { return base.isEmpty(); }

    @Override
    public boolean contains(Object o) { return base.contains(o); }

    @Override
    public Iterator<E> iterator() { return base.iterator(); }

    @Override
    public boolean remove(Object o) { return base.remove(o); }

    @Override
    public void clear() { base.clear(); }

    @Override
    public boolean containsAll(Collection<?> c) { return base.containsAll(c); }

    @Override
    public boolean removeAll(Collection<?> c) { return base.removeAll(c); }

    @Override
    public boolean retainAll(Collection<?> c) { return base.retainAll(c); }

    @Override
    public Object[] toArray() {
        return base.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return base.toArray(ts);
    }

    public int getCantidadAgregados() { return cantidadAgregados; }
}
