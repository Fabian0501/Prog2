package AB2;

import java.util.NoSuchElementException;

public interface puffer <T>{

    boolean isEmpty(); // -> wahrheitswert ob der speicher leer ist

    int size(); // -> liefert die Anzahl der belegten Speicherplätze

    int capacity(); // ->  liefert die maximale größe des speichers

    void insert(T a) throws IllegalStateException; // -> fügt das übergebene Elem. in den speicher ein
                                                     // java.lang.IllegalStateException falls speicher voll ist

    T remove() throws NoSuchElementException; // -> entnimmt ein Elem. aus dem speicher
                                                // java.util.NoSuchElementException falls speicher leer
    
}