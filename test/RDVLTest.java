import AB3.RDVL;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class RDVLTest {

    RDVL<Integer> integerRDVL = new RDVL<>();
    RDVL<String> stringRDVL = new RDVL<>();

    Integer[] integers = {1,2,3};
    String[] strings = {"eins","zwei","drei"};

    @BeforeEach
    void init(){
        for (Integer i : integers) integerRDVL.add(i);
        for (String s : strings) stringRDVL.add(s);
    }

    @Test
    void isEmpty() {
        assertFalse(integerRDVL.isEmpty());
        assertFalse(stringRDVL.isEmpty());
    }

    @Test
    void size() {
        assertEquals(integers.length , integerRDVL.size());
    }

    @Test
    void add() {
        System.out.println(integerRDVL.toString());
        for (int i = 4; i <= 10; i++){
            integerRDVL.add(i);
            assertEquals(i , integerRDVL.getEntry().next.data);
            System.out.println(integerRDVL.toString());
        }
    }

    @Test
    void remove() {
        for (int i = 4; i <= 10; i++){
            integerRDVL.add(i);

        }
        for (int i = integerRDVL.size(); i > 0; i--){

            /*System.out.print(integerRDVL.getEntry().data + "  ");
            Integer tmp = integerRDVL.remove();
            System.out.println(tmp);*/

            assertEquals(integerRDVL.getEntry().data , integerRDVL.remove() , "das derzeitige entry ist ungleich zu dem entfernten objekt");

        }
        assertThrows(NullPointerException.class , () -> integerRDVL.element() ,"Exception wird nicht geworfen ,da die liste nicht vollständig geleert wurde"); // da alle elemente entfernt und entry auf null gesetzt wurde
    }

    @Test
    void element() {
    }

    @Test
    void next() {
        stringRDVL.next(3);
        assertEquals(stringRDVL.element() , "eins");
    }

    @Test
    void prev() {
        integerRDVL.next(4);
        assertEquals(3 , integerRDVL.getEntry().data);
    }
}