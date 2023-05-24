
import AB3.EVL;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EVLTest {

    private EVL<Integer> integerEVL;
    private EVL<String> stringEVL;

    Integer[] integers = {1,2,3};
    String[] strings = {"clash","of","clans"};

    @BeforeEach
    void init(){
        integerEVL = new EVL<>();
        stringEVL = new EVL<>();

        for (Integer i : integers) integerEVL.addLast(i);
        for (String s : strings) stringEVL.addLast(s);
    }

    @Test
    void isEmpty() {
        assertFalse(integerEVL.isEmpty());
        assertFalse(stringEVL.isEmpty());
    }

    @Test
    void getFirst() {
        assertEquals(integers[0] , integerEVL.getFirst());
        assertEquals(strings[0] , stringEVL.getFirst());
    }

    @Test
    void getLast() {
        for (int i = 0; i < integers.length; i++){
            integerEVL.addLast(integers[i]);
            stringEVL.addLast(strings[i]);

            assertEquals(integerEVL.getLast() , integers[i]);
            assertEquals(stringEVL.getLast() , strings[i]);
        }
    }

    @Test
    void addLast() {
        for (int i = 0; i < integers.length; i++){
            integerEVL.addLast(integers[i]);
            stringEVL.addLast(strings[i]);

            assertEquals(integerEVL.getLast() , integers[i]);
            assertEquals(stringEVL.getLast() , strings[i]);
        }
    }

    @Test
    void removeLast() {
        for (int i = integers.length -1; i >= 0; i--){
            integerEVL.addLast(integers[i]);
            stringEVL.addLast(strings[i]);

            assertEquals(integers[i] , integerEVL.removeLast());
            assertEquals(strings[i] , stringEVL.removeLast());
        }
    }

    @Test
    void contains() {
        for (int i = 0; i < integers.length; i++){
            assertTrue(integerEVL.contains(integers[i]));
            assertTrue(stringEVL.contains(strings[i]));
        }
    }

    @Test
    void size() {
        assertEquals(integers.length , integerEVL.size());
    }

    @Test
    void testToString() {
        assertEquals("1-2-3" , integerEVL.toString());
    }
}