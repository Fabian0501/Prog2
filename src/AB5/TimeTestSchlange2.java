package AB5;


import AB3.SchlangeMItEVIL_first_Implementation;
import AB3.SchlangeMitEVL;

public class TimeTestSchlange2 {

    public static void main(String[] args) {

        FolgeMitDynArray<Integer> folgeMitDynArray = new FolgeMitDynArray<>();
        SchlangeMitRing<Integer> schlangeMitRing = new SchlangeMitRing<>(100_000);
        SchlangeMItEVIL_first_Implementation<Integer> schlangeMItEVLFirstimplimentation = new SchlangeMItEVIL_first_Implementation<>();
        SchlangeMitEVL<Integer> schlangeMitEVL = new SchlangeMitEVL<>();


        Long start, finish, elapsed;


        //folgeMitDynArray
        start = System.currentTimeMillis();
        for (int i = 0; i < 100_000;i++){
            folgeMitDynArray.insert(i);
        }
        for (int i = 0; i < 100_000; i++){
            folgeMitDynArray.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("folgeMitDynArray: " + elapsed/60.0 + "s");

        //schlangeMitRing
        start = System.currentTimeMillis();
        for (int i = 0; i < 100_000;i++){
            schlangeMitRing.insert(i);
        }
        for (int i = 0; i < 100_000; i++){
            schlangeMitRing.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("schlangeMitRing: " + elapsed/60.0 + "s");


        //schlangeMitEVLFirstImplementation
        start = System.currentTimeMillis();
        for (int i = 0; i < 100_000;i++){
            schlangeMItEVLFirstimplimentation.insert(i);
        }
        for (int i = 0; i < 100_000; i++){
            schlangeMItEVLFirstimplimentation.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("schlangeMItEVLFirstImplementation: " + elapsed/60.0 + "s");


        //schlangeMitEVL
        start = System.currentTimeMillis();
        for (int i = 0; i < 100_000;i++){
            schlangeMitEVL.insert(i);
        }
        for (int i = 0; i < 100_000; i++){
            schlangeMitEVL.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("schlangeMItEVL: " + elapsed/60.0 + "s");

        /* bevor SchlangeMitEvl optimiert
        folgeMitDynArray: 282.4s
        schlangeMitRing: 0.05s
        schlangeMItEVLFirstImplementation: 277.85s
        schlangeMItEVL: 150.1s*/
        /*Nachdem SchlangeMitEVl optimiert
        folgeMitDynArray: 291.03333333333336s
        schlangeMitRing: 0.1s
        schlangeMItEVLFirstImplementation: 282.23333333333335s
        schlangeMItEVL: 0.16666666666666666s*/

    }

}