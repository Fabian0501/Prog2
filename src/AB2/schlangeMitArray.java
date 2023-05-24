package AB2;

import java.util.NoSuchElementException;

public class schlangeMitArray<T> implements schlange<T> { // das aktuelle element steht am Anfang = FIFO
    private T[] arraySchlange;
    private int size = 0;

    /**
     * @param maxGroesse legt die größe des erzeugten arrays fest
     */
    @SuppressWarnings("unchecked")
    public schlangeMitArray(int maxGroesse) {
        arraySchlange = (T[]) new Object[maxGroesse];
    }

    /**
     * @return das Elem. das sich am Anfang der Schlange befindet
     * @throws NoSuchElementException falls der array beim Aufruf der methode keine Elem. enthält
     */
    @Override
    public T front() throws NoSuchElementException {  // Methode aus interface schlange
        if (size == 0) {
            throw new NoSuchElementException("Es wurden noch keine Elem. in das Array eingefügt");
        }
        return arraySchlange[0];
    }

    @Override
    public boolean isEmpty() { // return wahrheitswert ob der array leer ist
        return size == 0;
    }

    @Override
    public int size() { // gibt die Anzahl der belegten felder aus
        return size;
    }


    @Override
    public int capacity() { // gibt die maximale capacity des arrays aus
        return arraySchlange.length;
    }

    /**
     * @param a neues Elem. das in den array hinzugefügt wird
     * @throws IllegalStateException falls der array keine freien plätze mehr hat
     */
    @Override
    public void insert(T a) throws IllegalStateException {
        if (size == arraySchlange.length){
            throw new IllegalStateException("Der array hat die maximale speicherkapazität erreicht");
        }
        arraySchlange[size++] = a;
    }

    /**
     * @return das entfernte Elem.
     * @throws NoSuchElementException falls dem array noch keine Elem. hinzugefügt wurden
     */
    @Override
    public T remove() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException("Es wurden noch keine Elem. in das Array eingefügt");
        }
        T element = arraySchlange[0];
        for (int i = 0; i < size-1; i++) { //alle werte innerhalb des arrays werden eine position nach vorne gesetzt
            arraySchlange[i] = arraySchlange[i+1];
        }
        --size;
        return element;
    }
}