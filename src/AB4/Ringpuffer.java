package AB4;

public class Ringpuffer <T> {

    private final T[] ring;
    private int belegteFelder = 0;


    private int first = -1; //entry
    private int last = -1;

    @SuppressWarnings("unchecked")
    //public für den Test, ansonsten kein konstruktor zugriff möglich und somit auch keine objekterstellung
    public Ringpuffer(int capacity) {
        ring = (T[]) new Object[capacity];
    }

    public int size() {
        return belegteFelder;
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public int capacity() {
        return ring.length;
    }

    public T get(int position) {
        //pos ist ein gültiger wert und der ring ist nicht leer
        if ((0 <= position && position < size()) && !isEmpty()) {
            return ring[(first + position) % capacity()];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public T set(int position, T element) {
        T altesElement = get(position); // prüft indirekt die gültigkeit von position
        ring[(first + position) % capacity()] = element;
        return altesElement;
    }

    public void addFirst(T element) { //rückgabewert wegen test
        if (isEmpty()) {
            ring[0] = element;
            first = last = 0;
        }
        else if (freeSpaces()) {
            int beforeFirst = (first + capacity() - 1) % capacity();
            first = beforeFirst;
            ring[beforeFirst] = element;
        }
        else {
            throw new IndexOutOfBoundsException("Ring ist voll");
        }
        belegteFelder++;
    }

    public void addLast(T element) { //rückgabewert über get() holen
        if (isEmpty()) {
            ring[0] = element;
            first = last = 0;
        }
        else if (freeSpaces()) {
            last = ++last % capacity();
            ring[last] = element;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        belegteFelder++;
    }

    public T removeFirst() {
        //...Das letzte element wird nicht gelöscht, sondern das zu entfernende element ist nun nicht mehr im scope...
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Ring ist Leer");
        }

        T previousFirst = ring[first];
        if (size() == 1) { //das letzte und einzige element wird entfernt
            first = last = -1; //somit ist kein Element mehr im Ring
        } else { //es gibt mehr als nur ein element im ring
            first = ++first % capacity();
        }
        belegteFelder--;
        return previousFirst;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Ring ist Leer");
        }
        T previousLast = ring[last];
        if (size() == 1) { //only one element inside the ring
            last = first = -1; //set last & first on their default values
        } else {
            last = (last + capacity() - 1) % capacity();
        }
        belegteFelder--;
        return previousLast;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }

    public boolean freeSpaces() {
        return size() < capacity();
    }


    private void moveFirstForward(){
        first = ++first % capacity();
    }
    private void moveFirstBack(){
        first = (first + capacity() -1) % capacity();
    }
    public void moveLastForward(){
        last = ++last % capacity();
    }
    public void moveLastBack(){
        last = (last + capacity() -1) % capacity();
    }

    public String toString() {
        String s = "";
        if (isEmpty()){
            return "[]";
        }
        for (int i = 0; i < capacity(); i++) {
            s += ring[i] + " ";
        }
        String neu = s.replace(" ", ",");
        String tmp = neu.substring(0, neu.length() - 1);
        return "[" + tmp + "]";
    }

    public static void main(String[] args) {
        Ringpuffer<Integer> ringpuffer = new Ringpuffer<>(5);
        ringpuffer.addLast(1);
        ringpuffer.addLast(2);
        ringpuffer.addLast(3);
        ringpuffer.removeFirst();
        System.out.println(ringpuffer.toString());
    }
}
