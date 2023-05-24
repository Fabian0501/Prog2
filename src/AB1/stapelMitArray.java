package AB1;

import AB0.stapel;

import java.util.NoSuchElementException;

public class stapelMitArray implements stapel {
    private int[] arrayStapel;
    private int size = 0;

    /**
     * @param maxGroesse legt fest wie lang der erzeugte array sein soll
     */
    public stapelMitArray(int maxGroesse) {
        arrayStapel = new int[maxGroesse];
    }

    /**
     * @return das Elem. das sich an oberster Stelle befindet
     * @throws NoSuchElementException falls der array keine Elem. enthält
     */
    @Override
    public int top()throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Es wurden noch keine Elem. in das Array eingefügt");
        }
        int top = size -1;
        return arrayStapel[top];
    }


    @Override
    public boolean isEmpty() { // return wahrheitswert ob der array leer ist
        return size == 0;
    }

    @Override
    public int size() { // gibt die Anzahl der belegten plätze an
        return size;
    }

    @Override
    public int capacity() { // gibt die maximale capacity des arrays aus
        return arrayStapel.length;
    }

    /**
     * @param element wird in den array hinzugefügt
     * @throws IllegalStateException, falls der array seine maximale speicherkapazität erreicht hat
     */
    @Override
    public void insert(int element) throws IllegalStateException{
        if (size == arrayStapel.length) { // hier lieber array länge anstatt die methode capacity()
            throw new IllegalStateException("Der array hat die maximale speicherkapazität erreicht");
        }
        arrayStapel[size++] = element;
    }

    /**
     * @return das entfernte Elem.
     * @throws NoSuchElementException, falls noch keine Elem. in das Array eingefügt wurde
     */
    @Override
    public int remove() throws NoSuchElementException {
        int element = arrayStapel[--size];
        if (size < 0) {
            throw new IllegalStateException("Es wurden noch keine Elem. in das Array eingefügt");
        }
        return element;
    }


    /**
     * @param ref Referenz vom Typ Funktion, die beinhaltet, wie die werte innerhalb des stapels verändert werden sollen
     */
    public void applyToAll(Funktion ref){
        for (int i = 0; i < arrayStapel.length; i++){
            //System.out.println(arrayStapel[i]);
            arrayStapel[i] = ref.auswerten(arrayStapel[i]);
            //System.out.println(arrayStapel[i]);
        }
    }

//    public static void main(String[] args) {
//        stapelMitArray s = new stapelMitArray(10);
//        int[] array = {1,2,3,4,5,6,7,8,9,10};
//        for (int i : array){
//            s.insert(i);
//        }
//        s.applyToAll( (i -> i*i) );
//    }

}