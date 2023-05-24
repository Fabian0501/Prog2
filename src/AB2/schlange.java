package AB2;
import java.util.NoSuchElementException;

public interface schlange <T> extends puffer <T> {
    T front() throws NoSuchElementException; // -> liefert das vorderste Element der Schlange
                                            // java.Util.NoSuchElementException falls schlange leer ist
}