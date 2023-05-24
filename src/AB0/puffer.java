package AB0;

import java.util.NoSuchElementException;

public interface puffer {

    boolean isEmpty(); // -> wahrheitswert ob der speicher leer ist

    int size(); // -> liefert die Anzahl der belegten Speicherplätze

    int capacity(); // ->  liefert die maximale größe des speichers

    void insert(int a) throws IllegalStateException; // -> fügt das übergebene Elem. in den speicher ein
                                                     // java.lang.IllegalStateException falls speicher voll ist

    int remove() throws NoSuchElementException; // -> entnimmt ein Elem. aus dem speicher
                                                // java.util.NoSuchElementException falls speicher leer
    
}