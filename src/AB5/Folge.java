package AB5;

import AB2.puffer;
import AB4.Ringpuffer;


public interface Folge<T> extends puffer<T> {

    /*
    Geerbten Methoden aus Puffer

    boolean isEmpty();  -> wahrheitswert ob der speicher leer ist

    int size();  -> liefert die Anzahl der belegten Speicherplätze

    int capacity();  ->  liefert die maximale größe des speichers

    void insert(T a) throws IllegalStateException;  -> fügt das übergebene Elem. in den speicher ein
                                                      java.lang.IllegalStateException falls speicher voll ist

    T remove() throws NoSuchElementException;  -> entnimmt ein Elem. aus dem speicher
                                                java.util.NoSuchElementException falls speicher leer

     */

    T get( int pos) throws IndexOutOfBoundsException;
    //gibt den wert an der stelle pos aus, wenn diese pos belegt ist

    void set(int pos, T element) throws IndexOutOfBoundsException;
    //Überschreibt das Element an Index pos und gibt den alten wert zurück

    T remove() throws IndexOutOfBoundsException;
    //entfernt das erste element

    T remove(int pos) throws IndexOutOfBoundsException;
    //Das element an der Position pos wird entfernt und alle nachfolgenden elemente rutschen nach

    void insert(T element) throws IndexOutOfBoundsException;
    //fügt ein Element am Ende der Folge ein

    void insert(int pos, T element) throws IndexOutOfBoundsException;
    //Fügt das element an pos ein

}