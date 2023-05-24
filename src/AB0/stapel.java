package AB0;

public interface stapel extends puffer{
    int top(); // -> liefert das aktuell oberste element des Stapels
                // java.Util.NoSuchElementException falls der stapel leer ist
}