

import AB3.SchlangeMItEVIL_first_Implementation;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMItEVLTest {

    private SchlangeMItEVIL_first_Implementation<Integer> integerSchlangeMItEVLFirstimplimentation;
    private Integer[] integers = {1,2,3,4,5};

    @BeforeEach
    void init(){
        integerSchlangeMItEVLFirstimplimentation = new SchlangeMItEVIL_first_Implementation<>();
        for (Integer i : integers) integerSchlangeMItEVLFirstimplimentation.insert(i);
    }

    @Test
    void isEmpty() {
        assertFalse(integerSchlangeMItEVLFirstimplimentation.isEmpty());
    }

    @Test
    void size() {
        for (int i = integers.length; i > 0; i--){
            assertEquals(integerSchlangeMItEVLFirstimplimentation.size() , i);
            integerSchlangeMItEVLFirstimplimentation.remove();
        }
    }

    @Test
    void capacity() {

    }

    @Test
    void insert() {
        for (Integer i : integers){
            integerSchlangeMItEVLFirstimplimentation.insert(i);
            assertEquals(integerSchlangeMItEVLFirstimplimentation.size() , 6);
            assertEquals(integerSchlangeMItEVLFirstimplimentation.remove() , i);
        }
    }

    @Test
    void remove() {
        for (Integer i : integers){
            integerSchlangeMItEVLFirstimplimentation.insert(i);
            assertEquals(integerSchlangeMItEVLFirstimplimentation.remove() , i);
        }
    }

    @Test
    void front() {
        assertEquals(integerSchlangeMItEVLFirstimplimentation.front() , 1);
    }
}