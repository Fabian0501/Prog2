package AB5;

import AB2.schlange;
import AB4.Ringpuffer;

import java.util.NoSuchElementException;

public class SchlangeMitRing <T> implements schlange<T> {

    Ringpuffer<T> ring;

    public SchlangeMitRing(int capacity){
        ring = new Ringpuffer<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return ring.isEmpty();
    }

    @Override
    public int size() {
        return ring.size();
    }

    @Override
    public int capacity() {
        return ring.capacity();
    }

    @Override
    public void insert(T a) throws IllegalStateException {
        ring.addFirst(a);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return ring.removeLast();
    }

    @Override
    public T front() throws NoSuchElementException {
        return ring.get(ring.getLast());
    }
}