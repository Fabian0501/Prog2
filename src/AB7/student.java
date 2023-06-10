package AB7;

import org.jetbrains.annotations.NotNull;

public class student extends person implements Comparable <student>{
    private int matr;

    public student(String name, String vorname, int matr) {
        super(name, vorname);
        this.matr = matr;
    }

    public int getMatr() {
        return matr;
    }

    @Override
    public String toString() {
        return super.toString() + " " + matr;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof student)) {
            return false;
        }
        student student = (student) other;
        return super.equals(student) && student.matr == this.matr;
    }

//    @Override
//    public int compareTo(@NotNull Object o) {
//        if ( ! (o instanceof student)){
//            throw new ClassCastException();
//        }
//        student ref = (student) o;
//        return Integer.compare(this.matr, ref.getMatr());
//    }

    @Override
    public int compareTo(@NotNull student other) {
        //Variante 1
        if (this.matr > other.getMatr()){
            return 1;
        } else if (this.matr < other.getMatr()) {
            return -1;

        }else return 0;

        //Variante 2: ACHTUNG bei zu großen int werten kann es zu einem Overflow kommen
        // return this.matr - other.getMatr(); //  x < 0 => this<other , x > 0 => this > other
    }


//    @Override
//    public int compareTo(Student student) {
////Variante 1
//        return this.matr - student.matr; kann overflow geben , wenn du große zahlen subtrahiert werden
//
//        //Variante 2
//        if (this.matr > student.matr){
//            return 1;
//        }
//        else if(this.matr < student.matr){
//            return -1;
//        }
//        else {
//            return 0;
//        }
//
//    }
}



//    //Klasse Boxer
//    public int compareTo(Boxer other){
//
////1. Vergleich Gewicht
//        int vergleich = this.Gewicht -other.Gewicht;
//
////2. Weitere Vergleiche wenn Gewicht gleich
//        if(vergleich ==0){
//            vergleich = this.getName().compareTo(other.getName());
////3. Vergleich wenn gleicher Nachname
//            if (vergleich == 0){
//                vergleich = this.getVorname().compareTo(other.getVorname());
//            }
//        }
//        return vergleich;

//    private int compareHelper(T o1, T o2){
//        return (comp == null) ? ((Comparable<T>)o1).compareTo(o2)
//                : comp.compare(o1,o2);