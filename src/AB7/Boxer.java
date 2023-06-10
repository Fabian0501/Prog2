package AB7;

import org.jetbrains.annotations.NotNull;

public class Boxer extends person implements Comparable<Boxer> {
    private int gewicht;

    public Boxer(String name, String vorname, int gewicht) {
        super(name,vorname);
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString() {
        return super.toString() + " " + gewicht;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Boxer)) {
            return false;
        }
        Boxer boxer = (Boxer) other;
        return super.equals(boxer) && boxer.gewicht == this.gewicht;
    }

//    @Override
//    public int compareTo(@NotNull Object o) {
//        if ( ! (o instanceof Boxer)){
//            throw new ClassCastException();
//        }
//        Boxer ref = (Boxer) o;
//        int gewichtComp = this.gewicht
//        //TODO fertig machen einmal elwis und einmal mit methoden
//        return 0;
//    }

    @Override
    public int compareTo(@NotNull Boxer boxer) {
        int gewichtComp = Integer.compare(this.gewicht, boxer.gewicht);
        int nameComp = stringCompareTo(this.getName(), boxer.getName());
        return 0;
    }
    private int stringCompareTo(String a, String b){
        if (a.equals(b)){
            return 0;
        }
        int i = 0;
        while (true){
            if (i < a.length() && i < b.length()){
                if (a.charAt(i) < b.charAt(i)){
                    return -1; //a < b lexikographisch
                }
                if (a.charAt(i) > b.charAt(i)){
                    return 1; // a > b lexikographisch
                }
            }
            if (i >= a.length() && i < b.length()){ //a ist zu Ende und b noch nicht
                return -1; // a < b anhand der länge
            }
            if (i < a.length() && i >= b.length()){ // i noch in a aber i hat b verlassen
                return 1; // a > b
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Boxer b = new Boxer("fabian","ratschuweit",85);
        System.out.println(b.stringCompareTo("ab","aa"));
    }
}