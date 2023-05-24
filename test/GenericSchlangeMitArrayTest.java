
import AB2.schlange;
import AB2.schlangeMitArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericSchlangeMitArrayTest {

    @Test
    void front() {
    }

    @Test
    void isEmpty() {
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
        schlange<Integer> integerschlange = new schlangeMitArray<>(10);
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i: array) integerschlange.insert(i);
        for (int i = 1; i < array.length; i++){
            assertEquals(i,integerschlange.remove());
        }

    }
    @Test
    void removeString(){
        schlange<String> stringschlange = new schlangeMitArray<>(10);
        String[] array = {"eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun","zehn"};
        for (String i : array) stringschlange.insert(i);
        for (int i = 0; i < array.length; i++){
            assertEquals(array[i] , stringschlange.remove());
        }
    }
}