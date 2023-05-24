package AB5;

import AB4.DynArray;

public class FolgeMitDynArray<T> implements Folge<T>{


    DynArray<T> dynArray;

    public FolgeMitDynArray(){
        dynArray = new DynArray<>();
    }


    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        return dynArray.get(pos);
    }

    @Override
    public void set(int pos, T element) throws IndexOutOfBoundsException {
        dynArray.set(pos, element);
    }

    @Override
    public T remove() throws IndexOutOfBoundsException {
        return dynArray.removeFirst();
    }

    @Override
    public T remove(int pos) throws IndexOutOfBoundsException {
        if (dynArray.isEmpty())
            throw new IndexOutOfBoundsException("feld ist leer");

        T removedValue = dynArray.get(pos); //check indirect the value of pos through get

        if (pos == 0) // remove first element
            dynArray.removeFirst();

        if (pos == size()-1) // remove last element
            dynArray.removeLast();

        // removed value is between first and last
        for (int i = pos; i < size(); i++){
            dynArray.getFeld()[i] = dynArray.getFeld()[i+1];
        }


        return removedValue;
    }

    @Override
    public boolean isEmpty() {
        return dynArray.isEmpty();
    }

    @Override
    public int size() {
        return dynArray.size();
    }

    @Override
    public int capacity() {
        return dynArray.capacity();
    }

    @Override
    public void insert(T element) throws IndexOutOfBoundsException {
        dynArray.addLast(element);
    }

    @Override
    public void insert(int pos, T element) throws IndexOutOfBoundsException {
        if (! dynArray.freeSpaces())
            throw new IndexOutOfBoundsException("feld ist voll");

        dynArray.get(pos); //check if pos in correct range, if not exception

        if (pos == 0) //insert first
            dynArray.addFirst(element);

        if (pos == size() -1) //insert last
            dynArray.addLast(element);

        for (int i = size(); i > pos; i--){ //insert between first and last
            dynArray.getFeld()[i] = dynArray.getFeld()[i-1]; // values moved one index back
        }
        dynArray.getFeld()[pos] = element;
    }

    @Override
    public String toString(){
        return dynArray.toString();
    }

    public static void main(String[] args) {
        FolgeMitDynArray<Integer> folgeMitDynArray = new FolgeMitDynArray<>();

        folgeMitDynArray.insert(1);
        folgeMitDynArray.insert(2);
        folgeMitDynArray.insert(3);
        folgeMitDynArray.insert(1,23);
        System.out.println(folgeMitDynArray.toString());

        folgeMitDynArray.remove(1);
        System.out.println(folgeMitDynArray.toString());
        folgeMitDynArray.remove();
        System.out.println(folgeMitDynArray.toString());

        System.gc();


//        System.out.println(folgeMitDynArray.get(3));


    }
}