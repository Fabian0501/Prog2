import AB3.EVL_Zip;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class EVL_ZipTest {

    EVL_Zip<Integer> integerEVL_zip;
    EVL_Zip<Integer> integerEVL_zip1;


    @BeforeEach
    void init(){
        integerEVL_zip = new EVL_Zip<>();
        integerEVL_zip1 = new EVL_Zip<>();
    }

    @Test
    void zip_Beide_Leer() {
        assertThrows(IllegalStateException.class , () -> integerEVL_zip.zip(integerEVL_zip1));
    }

    @Test
    void zip_Other_Leer() {

        //Other leer
        for (int i = 0; i < 10; i++){
            integerEVL_zip.addLast(i);
        }
        integerEVL_zip.zip(integerEVL_zip1);
        System.out.println(integerEVL_zip.toString());
        System.out.println(integerEVL_zip1.toString());

    }
    @Test
    void zip_This_Leer() {

        //This leer
        for (int i = 0; i < 10; i++){
            integerEVL_zip1.addLast(i);
        }
        integerEVL_zip.zip(integerEVL_zip1);
        System.out.println(integerEVL_zip.toString());
        System.out.println(integerEVL_zip1.toString());
    }

    @Test
    void zip_Gleichlang() {
        for (int i = 0; i < 10; i++){
            integerEVL_zip.addLast(i);
            integerEVL_zip1.addLast(i);
        }
        integerEVL_zip.zip(integerEVL_zip1);
        System.out.println(integerEVL_zip);
    }
    @Test
    void zip_Eine_Länger() {
        for (int i = 1; i < 10; i++){
            if (i % 2 == 0 && i < 9){
                integerEVL_zip.addLast(i);
            }
            integerEVL_zip1.addLast(i);
        }
        System.out.println(integerEVL_zip);
        System.out.println(integerEVL_zip1);
        integerEVL_zip.zip(integerEVL_zip1);
        System.out.println(integerEVL_zip);
    }

    @Test
    void isEmpty() {
    }

    @Test
    void getFirst() {
    }

    @Test
    void getLast() {
    }

    @Test
    void addLast() {
    }

    @Test
    void removeLast() {
    }

    @Test
    void contains() {
    }

    @Test
    void size() {
    }

    @Test
    void testToString() {
    }
}