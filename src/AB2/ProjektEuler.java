package AB2;

public class ProjektEuler {
    public static int Euler(int wert1, int wert2 ,int grenze){
        int sumWert1 = 0; int sumWert2 = 0;

        int i = 1;
        while (wert1*i < grenze){
            sumWert1 += (3*i);
            //System.out.print(3*i + " ");
            i++;
        }
        //System.out.println();
        i=1;
        while (wert2*i < grenze){
            sumWert2 += (5*i);
            //System.out.print(5*i + " ");
            i++;
        }
        return sumWert1+sumWert2;
    }

    public static void main(String[] args) {
        System.out.println(Euler(3,5,1000));
//        System.out.println((int) 10/3);
    }
}