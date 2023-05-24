package AB3;

import AB2.schlangeMitArray;
public class TimeTestSchlange {
    public static void main(String[] args) {
        schlangeMitArray<Integer> schlangeMitArray = new schlangeMitArray<>(100_000);
        SchlangeMItEVIL_first_Implementation<Integer> schlangeMItEVL = new SchlangeMItEVIL_first_Implementation<>();

        long start, finish, elapsed;

        start = System.currentTimeMillis();

         for (int i = 0; i < 100_000; i++){
//            schlangeMitArray.insert(i);
            schlangeMItEVL.insert(i);
        }
        for (int i = 0; i < 100_000; i++){
//            schlangeMitArray.remove();
            schlangeMItEVL.remove();
        }

        finish = System.currentTimeMillis();
        elapsed = finish - start;


        System.out.println(elapsed); // array 16975 , liste 21000
    }
}