package br.uefs.ecomp.bazar.util;

public class Iterator<T> implements Iterator<T> {
    private Iterator<T> iterator;

    public Iterator(Iterator<T> iterator) {
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