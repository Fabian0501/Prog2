package AB0;
import java.util.NoSuchElementException;

public interface schlange extends puffer {
    int front() throws NoSuchElementException; // -> liefert das vorderste Element der Schlange
                // java.Util.NoSuchElementException falls schlange leer ist
}