package AB2;

;

public interface stapel<T> extends puffer<T> {
    T top(); // -> liefert das aktuell oberste element des Stapels
                // java.Util.NoSuchElementException falls der stapel leer ist
}