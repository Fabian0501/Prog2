import AB4.Ringpuffer;
import AB4.Temperatursensor;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class TemperatursensorTest {


    Temperatursensor messung;

    @BeforeEach
    void init() {
        messung = new Temperatursensor();
    }

    @Test
    void neueMessung() {
        Ringpuffer<Float> ring = messung.getSpeicher();
        float f = 1.0F;
        for (int i = 0; i < 24*3; i++){
            messung.neueMessung(f++);
            if (i % 10 == 0 && i > 0){
                System.out.println("first: " + ring.getFirst());
                System.out.println("last: " + ring.getLast());
                System.out.println(ring.toString());
                System.out.println(messung.aktuelleMessung());
                System.out.println();
            }
        }
        messung.reset();
        System.out.println(messung.getSpeicher().getFirst());
        System.out.println(messung.getSpeicher().getLast());
        System.out.println(messung.getSpeicher().size());
    }

    @Test
    void aktuelleMessungException() {
        assertEquals(Float.NaN, messung.aktuelleMessung());
    }
    @Test
    void aktuelleMessung() {
        float f = 1.0F;
        for (int i = 0; i < 24*3; i++){
            var value = f++;
            messung.neueMessung(value);
            if (i % 10 == 0 && i > 0){
                System.out.println(messung.getSpeicher().toString());
                System.out.println(messung.aktuelleMessung());
            }

        }
    }

    @Test
    void durchschnittsTemperatur() {
    }
}