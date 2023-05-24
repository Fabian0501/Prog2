package AB3;

import AB2.schlange;
import AB3.EVL_first_implementation;

import java.util.NoSuchElementException;

public class SchlangeMItEVIL_first_Implementation<T> implements schlange <T>{

    private EVL_first_implementation<T> tevl;

    public SchlangeMItEVIL_first_Implementation(){
        tevl = new EVL_first_implementation<>();
    }

    @Override
    public boolean isEmpty() {
        return tevl.size() == 0;
    }

    @Override
    public int size() {
        return tevl.size();
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void insert(T a) throws IllegalStateException {
        //Exception muss hier nicht geworfen werden, da es keine Begrenzung für eine liste gibt
        tevl.addLast(a);
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (size() == 0){
            throw new NoSuchElementException("keine elem. vorhanden");
        }
        return tevl.removeLast();
    }

    @Override
    public T front() throws NoSuchElementException {
        if (size() == 0){
            throw new NoSuchElementException("keine elem. vorhanden");
        }
        return tevl.removeLast();
    }
}