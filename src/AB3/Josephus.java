package AB3;

import AB3.RDVL;

public class Josephus {

    static RDVL<Integer> integerRDVL = new RDVL<>();

    public static Integer loese(int n , int k){
        for (int i = 1; i <= n; i++){
            integerRDVL.add(i);
        }

        for (int i = n; i > 1; i--){
            integerRDVL.next(k);
            integerRDVL.remove();
        }
//        System.out.println(integerRDVL.toString());
        return integerRDVL.element();
    }

    public static void main(String[] args) {
        System.out.println(loese(5, 2));
    }

}