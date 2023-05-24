package AB4;

public class DynArray <T> {

    private T[] dynamischesFeld;
    private int belegtePlätze = 0;

    @SuppressWarnings("unchecked")
    public DynArray() {
        dynamischesFeld =  (T[]) new Object[1];
    }

    public int size(){
        return belegtePlätze;
    }

    public int capacity(){
        return dynamischesFeld.length;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int pos) throws IndexOutOfBoundsException{
        if ( (pos < 0 || pos >= size()) || pos >= belegtePlätze) {
            throw new IllegalArgumentException(pos + " ist kein gültiger wert für eine belegte pos");
        }
        return dynamischesFeld[pos];
    }

    public T set(int pos, T element) throws IndexOutOfBoundsException{
        T tmp = get(pos);   //prüft für mich die gültigkeit von pos und gibt den wert an der stelle pos an
        dynamischesFeld[--pos] = element;
        return tmp;
    }

    public void addFirst(T element){
        if (isEmpty()){ // erstes Element
            dynamischesFeld[belegtePlätze++] = element;
            return;
        }
        if (size() == capacity()){ //keine freien plätze → neuer array doppelter länge erstellen und aktuelle Werte übernehmen
            increase();
            moveBack();
            dynamischesFeld[0] = element;
            belegtePlätze++;
            return;
        }
        if (size() < capacity() && capacity() > 1){
            moveBack();
            dynamischesFeld[0] = element;
            belegtePlätze++;
        }
    }

    public void addLast(T element) {
        if (size() == capacity()){ // keine freien plätze mehr
            increase();
        }
        //Freie plätze hinten, deswegen normales einfügen
        dynamischesFeld[belegtePlätze++] = element;

    }

    public T removeFirst() throws IndexOutOfBoundsException{
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        T tmp = dynamischesFeld[0];
        moveForward(); //alle Elemente gehen im index eins weiter nach vorne

        decrease(); //potenzieller decrease

        belegtePlätze--;
        return tmp;
    }

    public T removeLast() throws IndexOutOfBoundsException{
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        T tmp = dynamischesFeld[--belegtePlätze];

        decrease(); //potenzieller decrease

        return tmp;
    }

    public String toString(){
        String s = "[";
        if (size() == 0){
            return "leer";
        }
        if (size() == 1){
            return "[" + dynamischesFeld[size() -1] + "]";
        }
        for (int i = 0; i < capacity() -1; i++){
            s += dynamischesFeld[i] + ", ";
        }
        return s += dynamischesFeld[capacity() -1] + "]";
    }


    // Hilfsmethoden

    @SuppressWarnings("unchecked")
    public void increase(){
        T[] tmp = (T[]) new Object[ 2 * capacity() ];
        if (capacity() >= 0) System.arraycopy(dynamischesFeld, 0, tmp, 0, capacity());
        dynamischesFeld = tmp;
    }

    @SuppressWarnings("unchecked")
    public void decrease(){
        if (size()*4 == capacity()){
            T[] tmpArray = dynamischesFeld;
            dynamischesFeld = (T[]) new Object[capacity() / 2];
            if (size() >= 0) System.arraycopy(tmpArray, 0, dynamischesFeld, 0, size());
        }
    }
    private void moveBack(){
        for (int i = size(); i > 0; i--){
            dynamischesFeld[i] = dynamischesFeld[i-1];
        }
    }

    private void moveForward(){
        for(int i = 0; i < size(); i++){
            dynamischesFeld[i] = dynamischesFeld[i+1];
        }
    }

    public T[] getFeld(){
        return dynamischesFeld;
    }
    public boolean freeSpaces() {
        return size() < capacity();
    }

}