
import AB2.stapel;
import AB2.stapelMitArray;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GenericStapelMitArrayTest {

    /**
     * klassen Objekte
     */
    private stapel<Integer> stapelInteger;
    private stapel<Character> stapelCharacter;
    private stapel<Double> stapelDouble;

    /**
     *  arrays der jewailigen klassen Objekte
     */
    private Integer[] integerArray;
    private Character[] characterArray;
    private Double[] doublesArray;

    @BeforeEach
    void initialisieren(){
        Random random = new Random(); int länge = random.nextInt(5,10 +1);

        //Klassen objekt initialisierung
        stapelInteger = new stapelMitArray<>(länge);
        stapelCharacter = new stapelMitArray<>(länge);
        stapelDouble = new stapelMitArray<>(länge);

        // Array innerhalb der klassen initialisiert
        integerArray = new Integer[länge];
        characterArray = new Character[länge];
        doublesArray = new Double[länge];

        Character[] character = {'a', 'b', 'c', 'd', 'e' , 't' , 'z' , '=' , '9' , 'ß'};

        // arrays bekommen werte
        for (int i = 0; i < länge; i++){
            integerArray[i] = random.nextInt(1,100 +1);
            characterArray[i] = character[i];
            doublesArray[i] = random.nextDouble(1,100 +1);

            stapelInteger.insert(integerArray[i]);
            stapelCharacter.insert(characterArray[i]);
            stapelDouble.insert(doublesArray[i]);
        }

    }

    @Test
    void topInteger() {
        assertEquals(stapelInteger.top() , integerArray[stapelInteger.size() -1]);
    }
    @Test
    void topCharacter(){
        assertEquals(stapelCharacter.top() , characterArray[stapelCharacter.size() -1]);
    }
    @Test
    void topDouble(){
        assertEquals(stapelDouble.top() , doublesArray[stapelDouble.size() -1]);
    }

    @Test
    void isEmpty() {
        assertFalse(stapelInteger.isEmpty());
        assertFalse(stapelCharacter.isEmpty());
        assertFalse(stapelDouble.isEmpty());
    }

    @Test
    void size() {
    }

    @Test
    void capacity() {
    }

    @Test
    void insert() {
    }

    @Test
    void removeInteger() {
        for (int i = 0; i < integerArray.length; i++){
            assertEquals(stapelInteger.remove() , integerArray[integerArray.length -1 -i]);
        }
    }
    @Test
    void removeCharacter(){
        for (int i = 0; i < characterArray.length; i++){
            assertEquals(stapelCharacter.remove() , characterArray[characterArray.length -1 -i]);
        }
    }

}