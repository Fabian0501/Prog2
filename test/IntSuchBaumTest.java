import AB6.IntSuchBaum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchBaumTest {

    IntSuchBaum baum;

    @BeforeEach
    void init(){
        baum = new IntSuchBaum();
    }

    @Test
    void isEmpty() {

    }

    @Test
    void insert() {
        baum.insert(6);
        System.out.println(baum.toString());
        baum.insert(4);
        System.out.println(baum.toString());
        baum.insert(9);
        System.out.println(baum.toString());
        baum.insert(1);
        System.out.println(baum.toString());
        baum.insert(7);
        System.out.println(baum.toString());
        baum.insert(10);
        System.out.println(baum.toString());
        baum.insert(8);
        System.out.println(baum.toString());
    }

    @Test
    void contains() {
        baum.insert(6);
        baum.insert(4);
        baum.insert(9);
        baum.insert(1);
        baum.insert(7);
        assertTrue(baum.contains(9));
        assertFalse(baum.contains(10));
    }

    @Test
    void testToString() {
        baum.insert (3);
        baum.insert (2);
        baum.insert (5);
        baum.insert (4);
        baum.insert (1);
        baum.insert (7);

        assertEquals("(((1)2)3((4)5(7)))", baum.toString());
    }

    @Test
    void hoehe() {

        baum.insert(5);
        baum.insert(4);
        baum.insert(3);
        baum.insert(2);
        baum.insert(1);
        assertEquals(5, baum.hoehe());
        assertEquals(5, baum.hoehe2());

        IntSuchBaum baum2 = new IntSuchBaum();
        baum2.insert(6);
        baum2.insert(4);
        baum2.insert(1);
        baum2.insert(9);
        baum2.insert(7);
        baum2.insert(10);
        baum2.insert(8);
        assertEquals(4,baum2.hoehe());
        assertEquals(4, baum2.hoehe2());

    }

    @Test
    void hoehe2() {
    }

    @Test
    void size() {
        baum.insert(5);
        baum.insert(4);
        baum.insert(3);
        baum.insert(2);
        baum.insert(1);
        assertEquals(5, baum.size());
        assertEquals(5, baum.size2());

        IntSuchBaum baum2 = new IntSuchBaum();
        baum2.insert(6);
        baum2.insert(4);
        baum2.insert(1);
        baum2.insert(9);
        baum2.insert(7);
        baum2.insert(10);
        baum2.insert(8);
        assertEquals(7, baum2.size());
        assertEquals(7,baum2.size2());
    }

    @Test
    void size2() {
    }

    @Test
    void preorder() {
        baum.insert(3);
        baum.insert(2);
        baum.insert(1);
        baum.insert(5);
        baum.insert(4);
        baum.insert(7);
        assertEquals("[3,2,1,5,4,7]", baum.preorder().toString());
    }

    @Test
    void inorder() {

        baum.insert(3);
        baum.insert(2);
        baum.insert(1);
        baum.insert(5);
        baum.insert(4);
        baum.insert(7);
        assertEquals("[1,2,3,4,5,7]", baum.inorder().toString());

    }

    @Test
    void postorder() {

        baum.insert(3);
        baum.insert(2);
        baum.insert(1);
        baum.insert(5);
        baum.insert(4);
        baum.insert(7);
        assertEquals("[1,2,4,7,5,3]", baum.postorder().toString());

    }

    @Test
    void breitensuche() {

        baum.insert(3);
        baum.insert(2);
        baum.insert(1);
        baum.insert(5);
        baum.insert(4);
        baum.insert(7);
        assertEquals("[3,2,5,1,4,7]", baum.breitensuche().toString());

    }

    @Test
    void remove() {


        baum.insert(6);
        baum.insert(4);
        baum.insert(9);
        baum.insert(1);
        baum.insert(7);
        baum.insert(10);
        baum.insert(8);
        System.out.println(baum.toString());
        baum.remove(9);
        System.out.println(baum.toString());
        baum.remove(8);
        System.out.println(baum.toString());
        baum.remove(10);
        System.out.println(baum.toString());
        baum.remove(4);
        System.out.println(baum.toString());
        baum.remove(1);
        System.out.println(baum.toString());
        baum.remove(7);
        System.out.println(baum.toString());


        System.out.println();
        System.out.println();
        System.out.println();


        //Test für die root entfernungen
        IntSuchBaum baum2 = new IntSuchBaum();
        baum2.insert(6);
        baum2.insert(4);
        baum2.insert(1);
        baum2.insert(9);
        baum2.insert(7);
        baum2.insert(10);
        baum2.insert(8);
        System.out.println(baum2.toString());
        baum2.remove(6);
        System.out.println(baum2.toString());
        baum2.remove(7);
        System.out.println(baum2.toString());
        baum2.remove(8);
        System.out.println(baum2.toString());
        baum2.remove(4);
        System.out.println(baum2.toString());
        baum2.remove(1);
        System.out.println(baum2.toString());
        baum2.remove(9);
        System.out.println(baum2.toString());
        baum2.remove(10);
        System.out.println(baum2.toString()); // leerer String




    }

}