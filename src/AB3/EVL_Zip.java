package AB3;

public class EVL_Zip<T> {

    Listenelement first = null;
    Listenelement last = null;
    int size = 0;

    class Listenelement{
        public T data;
        Listenelement next = null;

        Listenelement(T data){
            this.data = data;
        }
    }

    public void zip(EVL_Zip<T> other) throws IllegalStateException{

        if (this.first == null && other.first == null){
            throw new IllegalStateException();
        }

        if (this.first == null){
            Listenelement läufer = other.first;
            while (läufer != null){
                this.addLast(läufer.data);
                läufer = läufer.next;

            }
            /*
            Other first und last muss hier null gesetzt werden, um Other zu löschen.
            Falls das nicht geschieht werden zwei identische Listen miteinander ver-Zip, da
                die if Bedingung in Z.24 alles aus other in this kopiert
             */
            other.first = null;
            other.last = null;
            return;
        }

//        if (other.first == null);  passiert original nix

        Listenelement index1 = this.first;
        Listenelement index2 = other.first;
        Listenelement tmp;

        while (index1 != null && index2 != null){
            //System.out.println(this.toString());
            tmp = index1.next;
            index1.next = index2;
            index1 = tmp;
            if (index1 != null){
                tmp = index2.next;
                index2.next = index1;
                index2 = tmp;
            }else {
                this.last = other.last;
            }
            /*System.out.println(other.toString());
            System.out.println(this.toString());
            System.out.println();*/
        }

        other.last = null;
        other.first = null;
//        System.out.println(this.toString());
    }

    public boolean isEmpty(){ return first == null; }

    public T getFirst() throws IllegalStateException{
        if (isEmpty()){
            throw new IllegalStateException();
        }
        return first.data;
    }

    public T getLast() throws IllegalStateException{
        if (isEmpty()){
            throw new IllegalStateException();
        }
        return last.data;
    }

    public void addLast(T elem){
        Listenelement listenelement = new Listenelement(elem);
        if (isEmpty()){
            first = last = listenelement;
//            last = listenelement;
        }
        else {
            last.next = listenelement;
            last = listenelement;
        }
        size++;
    }
    public T removeLast() throws IllegalStateException{
        if (isEmpty()){
            throw new IllegalStateException();
        }

        Listenelement läufer = first;
        if (läufer.next == null){
            first = last = null;
            return läufer.data;
        }
        while (läufer.next.next != null){
            läufer = läufer.next;
        }
        T inhaltLetztesElement = läufer.next.data;
        läufer.next = null;
        last = läufer;
        return inhaltLetztesElement;
    }
    public boolean contains(T gesuchtesElement){
        Listenelement läufer = first;
        while (läufer != null){
            if (läufer.data.equals(gesuchtesElement)){
                return true;
            }
            läufer = läufer.next;
        }
        return false;
    }
    public int size(){
        return size;
    }

    @Override
    public String toString() {
        Listenelement läufer = first;
        if (isEmpty()){
            return "leer";
        }
        return first.data + stringHelper(läufer.next);
    }
    private String stringHelper(Listenelement läufer){
        String s = "";
        if (läufer != null){
            s += "-" + läufer.data ;
            return s + stringHelper(läufer.next);
        }
        return s;
    }

    public static void main(String[] args) {
        EVL_Zip<Integer> integerEVL1 = new EVL_Zip<>();
        EVL_Zip<Integer> integerEVL2 = new EVL_Zip<>();
        Integer[] integers = {1,3};
        Integer[] integers1 = {2,4,6,8};
        for (Integer i : integers) integerEVL1.addLast(i);
        for (Integer i : integers1) integerEVL2.addLast(i);

        integerEVL1.zip(integerEVL2);

    }

}