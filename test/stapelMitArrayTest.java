import AB0.stapel;
import AB0.stapelMitArray;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class stapelMitArrayTest {
    @Test
    void topTest() throws NoSuchElementException{
        stapel stapel = new stapelMitArray(10);
        assertThrows(NoSuchElementException.class, stapel::top);
    }
    @Test
    void topTest2(){
        stapel stapel = new stapelMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i : array){
            stapel.insert(i);
        }
        assertEquals(array[array.length -1], stapel.top());
    }
    @Test
    void isEmptyTest(){
        stapel stapel = new stapelMitArray(10);
        assertTrue(stapel.isEmpty());
    }
    @Test
    void isEmptyTest2(){
        stapel stapel = new stapelMitArray(10);
        stapel.insert(1);
        assertFalse(stapel.isEmpty());
    }
    @Test
    void insertTest() throws IllegalStateException{
        stapel stapel = new stapelMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i : array){
            stapel.insert(i);
        }
        assertThrows(IllegalStateException.class, () -> stapel.insert(11));
    }
    @Test
    void removeTest(){
        stapel stapel = new stapelMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i : array){
            stapel.insert(i);
        }
        for (int i = stapel.size() -1; i >= 0; i--){
            assertEquals(array[array.length -(array.length-i)] , stapel.remove());
        }
    }
    @Test
    void removeTestTest(){
        stapel stapel = new stapelMitArray(10);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        for (int i : array){
            stapel.insert(i);
        }
        assertEquals(10,stapel.remove());
        assertEquals(9,stapel.remove());
        assertEquals(8,stapel.remove());
        assertEquals(7,stapel.remove());
        assertEquals(6,stapel.remove());
        assertEquals(5,stapel.remove());
        assertEquals(4,stapel.remove());
        assertEquals(3,stapel.remove());
        assertEquals(2,stapel.remove());
        assertEquals(1,stapel.remove());

    }
}