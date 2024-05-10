package br.uefs.ecomp.bazar.util;

import java.util.Iterator;

public class Iterador<T> implements Iterator<T> {
    private Iterator<T> iterator;

    public Iterador(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
    
    public boolean temProximo() {
        return hasNext();
    }

    @Override
    public T next() {
        return iterator.next();
    }
    
    public T proximo() {
        return iterator.next();
    }

    @Override
    public void remove() {
        iterator.remove();
    }

    public Iterator<T> getIterator() {
        return iterator;
    }

}