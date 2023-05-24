import AB2.Paar;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PaarTest {


    static Paar<Integer , Integer> integerIntegerPaar;
    static Paar<Integer , String> integerStringPaar1;
    static Paar<Integer , String> integerStringPaar2;

    @BeforeEach
    void initialisieren(){
        integerIntegerPaar = new Paar<>(12 , 45);
        integerStringPaar1 = new Paar<>(21, "05.01.2001");
        integerStringPaar2 = new Paar<>(21 , "05.01.2001");
    }

    @Test
    void getErstes() {
        assertEquals(12 , integerIntegerPaar.getErstes());
        assertEquals(21, integerStringPaar1.getErstes());
    }

    @Test
    void getZweites() {
        assertEquals(45, integerIntegerPaar.getZweites());
        assertEquals("05.01.2001", integerStringPaar1.getZweites());
    }

    @Test
    void setErstes() {
        assertEquals(integerIntegerPaar.getErstes(), integerIntegerPaar.setErstes(13));
        assertEquals(integerStringPaar1.getErstes(), integerStringPaar1.setErstes(22));
    }

    @Test
    void setZweites() {
        assertEquals(integerIntegerPaar.getZweites() ,integerIntegerPaar.setZweites(46));
        assertEquals(integerStringPaar1.getZweites(),integerStringPaar1.setZweites("30.04.2003"));
    }

    @Test
    void setBeide() {
        integerIntegerPaar.setBeide(14,47);
        assertEquals(integerIntegerPaar.getErstes(),14);
        assertEquals(integerIntegerPaar.getZweites(), 47);

        integerStringPaar1.setBeide(23 , "05.06.1978");
        assertEquals(integerStringPaar1.getErstes(), 23);
        assertEquals(integerStringPaar1.getZweites(),"05.06.1978");
    }

    @Test
    void testEquals() {
        assertTrue(integerStringPaar1.equals(integerStringPaar2));
        assertTrue(integerIntegerPaar.equals(integerIntegerPaar));
    }

    @Test
    void testToString() {
        assertEquals("( 12, 45 )" , integerIntegerPaar.toString() );
        assertEquals("( 21, 05.01.2001 )" , integerStringPaar1.toString());

    }
}