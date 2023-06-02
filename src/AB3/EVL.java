package AB3;

public class EVL<T> {

    Listenelement first = null;     //Stellt das erste Listenobjekt dar
    Listenelement last = null;      //Stellt das letzte Listenobjekt dar
    int size = 0;

    class Listenelement{     //Innere Klasse die Objekte der Listenelemente erstellt
        public T data;
        Listenelement next = null;      //Stellt das nächte Listenelement dar. Default = null
        Listenelement(T data){
            this.data = data;
        }
    }

    public boolean isEmpty(){ return first == null; }

    public T getFirst() throws IllegalStateException{
        if (isEmpty()){
            throw new IllegalStateException();
        }
        return first.data;
    }

    public T getLast() throws IndexOutOfBoundsException{
        if (isEmpty()){
            throw new IndexOutOfBoundsException("liste ist leer");
        }
        return last.data;
    }

    //Zeichnung
    public void addLast(T elem){
        Listenelement listenelement = new Listenelement(elem);
        if (isEmpty()){
            first = listenelement;
        }
        else {
            last.next = listenelement;
        }
        last = listenelement;   //ausgelagert, da dies in if-und-else passieren würde
        size++;
    }
    public void addFirst(T elem){
        Listenelement listenelement = new Listenelement(elem);
        if (isEmpty()){
            first = last = listenelement;
        }
        else {
            Listenelement tmp = first;
            first = listenelement;
            first.next = tmp;
        }
        size++;
    }
    public T removeLast() throws IllegalStateException{
        if (isEmpty()){
            throw new IllegalStateException();
        }

        Listenelement läufer = first;   //Geht die ListenObjekte durch
        if (läufer.next == null){   //Liste hat nur ein Element
            first = null;
            last = null;
            size = 0;
            return läufer.data;
        }
        while (läufer.next.next != null){   //Liste bis zum vorletzten Element durchlaufen
            läufer = läufer.next;
        }

        /*
        Alternative für die while
        for (läufer = first; läufer.next.next != null; läufer = läufer.next);
        */

        T inhalt_Letztes_Element = läufer.next.data;
        läufer.next = null;
        last = läufer;
        size--;
        return inhalt_Letztes_Element;
    }

    public T removeFirst(){
        if (isEmpty()){
            throw new IllegalStateException();
        }
        Listenelement tmp;
        if (size() == 1){
            tmp = first;
            first = last = null;
            size = 0;
            return tmp.data;
        }
        T oldFirst = first.data;
        tmp = first.next;
        first.next = null;
        first = tmp;
        size--;
        return oldFirst;
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
            return "";
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
        EVL<Integer> evl = new EVL<>();
        Integer[] integers = {1,2,3,4,5};
        for (Integer i : integers) evl.addLast(i);
        System.out.println(evl.toString());
        evl.removeFirst();
        System.out.println(evl.toString());
        System.out.println(evl.first);
    }

}