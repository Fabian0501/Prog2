
import AB0.schlange;
import AB0.schlangeMitArray;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class SchlangeMitArrayTest {
    @Test
     void frontTest(){
        schlange s = new schlangeMitArray(10);
        assertThrows(NoSuchElementException.class, s::front);
    }
    @Test
    void frontTest2(){
        schlange s = new schlangeMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i : array){
            s.insert(i);
        }
        assertEquals(1,s.front());
    }
    @Test
    void isEmptyTest(){
        schlange s = new schlangeMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i : array){
            s.insert(i);
        }
        assertFalse(s.isEmpty());
    }
    @Test
    void isEmptyTest2(){
        schlange s = new schlangeMitArray(10);
        assertTrue(s.isEmpty());
    }
    @Test
    void sizeTest(){
        schlange s = new schlangeMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i : array){
            s.insert(i);
        }
        assertEquals(array.length,s.size());
    }
    @Test
    void sizeTest2(){
        schlange s = new schlangeMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < 5; i++){
            s.insert(array[i]);
        }
        assertEquals(5,s.size());
    }
    @Test
    void insertTest(){
        schlange s = new schlangeMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i : array){
            s.insert(i);
        }
        assertThrows(IllegalStateException.class, () -> s.insert(11));
    }
    @Test
    void removeTest(){
        schlange s = new schlangeMitArray(10);
        assertThrows(NoSuchElementException.class, s::remove);
    }
    @Test
    void removeTest2(){
        schlange s = new schlangeMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i : array){
            s.insert(i);
        }
        assertEquals(1,s.remove());
    }


}