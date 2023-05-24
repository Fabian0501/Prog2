package AB3;


public class RDVL <T> {


    Listenelement entry = null;
    int size = 0;

    public class Listenelement{
        public T data;      // public für späteren zugriff aus dem Testordner
        public Listenelement next = null;
        public Listenelement prev = null;

        public Listenelement(T data){
            this.data = data;
        }
    }

    public boolean isEmpty(){
        return entry == null;
    }
    public int size(){
        return size;
    }

    public Listenelement getEntry(){
        return entry;
    }

    //TODO Siehe Zeichnung
    public void add(T elem){
        Listenelement listenelement = new Listenelement(elem);
        if (isEmpty()){
            entry = listenelement;
            entry.next = listenelement;
            entry.prev = listenelement;
            /*
            VORSICHTIG mit entry = entry.next = entry.prev = listenelement;
            hier werden allen variablem Werte zugewiesen, hier sorgt eine nullPointerException
            wenn aber alle werte NULL bekommen würden wäre das kein problem
             */
        }
        else {
            entry.next.prev = listenelement; // 3 zu 4
            listenelement.next = entry.next; // 4 zu 3
            listenelement.prev = entry; // 4 zu 1
            entry.next = listenelement; // 1 zu 4

           /* listenelement.next = entry.prev;
            listenelement.prev = entry;
            entry.prev.prev = listenelement;
            entry.next = listenelement;*/
        }
        size++;
    }

    //TODO Siehe Zeichnung
    public T remove() throws NullPointerException{
        if (isEmpty()){
            throw new NullPointerException();
        }
        if (size == 1){
            T elementData = entry.data;
            entry.next = entry.prev = entry = null;
            size--;
            return elementData;
        }
        entry.prev.next = entry.next; // 1 zu 4
        entry.next.prev = entry.prev; // 4 zu 2
        T result = entry.data;
        Listenelement tmp = entry.next;
        entry.next = entry.prev = null; // ehemalige wege von 4 zu 1 und von 1 zu 4
        entry = tmp;
        size--;
        return result;
    }

    public T element(){
        return entry.data;
    }

    public void next(int s){
        //System.out.println(entry.data); // start punkt
        for (int i = 0; i < s; i++){
            entry = entry.next;
            //System.out.println(entry.data);
        }
    }

    public void prev(int s){
        for (int i = 0; i < s; i++){
            entry = entry.prev;
        }
    }

    public String toString(){
        String s = "";
        int count = 0;
        Listenelement tmp = entry;
        while (count < size() -1){
            s += tmp.data + " ";
            tmp = tmp.next;
            count++;
        }
        return s + tmp.data;
    }

}