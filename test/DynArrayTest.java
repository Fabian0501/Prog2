import AB4.DynArray;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    DynArray<Integer> integerDynArray;

    @BeforeEach
    void init(){
        integerDynArray = new DynArray<>();
    }

    @Test
    void size() {
        integerDynArray.addFirst(1);
        assertEquals(1 , integerDynArray.capacity());
        System.out.println(integerDynArray.toString());
        integerDynArray.addLast(2);
        System.out.println(integerDynArray.toString());

        assertEquals( 2,integerDynArray.size());
        integerDynArray.addFirst(3);
        assertEquals(4,integerDynArray.capacity());
        integerDynArray.addLast(4);
        System.out.println(integerDynArray.toString());

        assertEquals(4,integerDynArray.size());
        integerDynArray.addFirst(5);
        assertEquals(8,integerDynArray.capacity());
        System.out.println(integerDynArray.toString());
        integerDynArray.removeFirst();
        System.out.println(integerDynArray.toString());
        integerDynArray.removeLast();
        System.out.println(integerDynArray.toString());
        integerDynArray.removeLast();
        System.out.println(integerDynArray.toString());
        integerDynArray.addLast(2);
        System.out.println(integerDynArray.toString());
    }

    @Test
    void capacity() {
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