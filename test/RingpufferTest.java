import AB4.Ringpuffer;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RingpufferTest {

    Ringpuffer<Integer> intPuffer;

    @BeforeEach
    void init(){
        intPuffer = new Ringpuffer<>(4);
    }

    @Test
    void size() {
        for (int i = 0; i < intPuffer.capacity(); i++){
            intPuffer.addFirst(i+1);
            assertEquals(i+1, intPuffer.size() );
        }
        for (int i = intPuffer.capacity(); i > 0; i--){
            intPuffer.removeFirst();
            assertEquals(i-1 , intPuffer.size());
        }
        assertTrue(intPuffer.isEmpty());
        assertEquals(0, intPuffer.size());
    }

    @Test
    void isEmpty() {
        assertTrue(intPuffer.isEmpty());
        intPuffer.addFirst(1);
        assertFalse(intPuffer.isEmpty());
    }

    @Test
    void capacity() {

        intPuffer.addLast(1);
        System.out.println(intPuffer.toString());


        /*System.out.println(intPuffer.toString());
        intPuffer.addFirst(1);
        intPuffer.addFirst(2);
        System.out.println(intPuffer.toString());
        System.out.println("first: " + intPuffer.getFirst());
        System.out.println("last: " + intPuffer.getLast());
        System.out.println(intPuffer.addLast(11));
        System.out.println(intPuffer.toString());
        System.out.println();
        System.out.println(intPuffer.removeFirst());
        System.out.println(intPuffer.toString());
        System.out.println("first: " + intPuffer.getFirst());
        System.out.println("last: " + intPuffer.getLast());
        System.out.println();
        intPuffer.addLast(12);
        System.out.println(intPuffer.toString());
        System.out.println("first: " + intPuffer.getFirst());
        System.out.println("last: " + intPuffer.getLast());
        System.out.println();
        intPuffer.addLast(13);
        System.out.println(intPuffer.toString());
        System.out.println("first: " + intPuffer.getFirst());
        System.out.println("last: " + intPuffer.getLast());
        System.out.println();*/
    }

    @Test
    void get() {

    }

    @Test
    void set() {
    }

    @Test
    void addFirst() {

    }

    @Test
    void addLast() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeLast() {
    }
}