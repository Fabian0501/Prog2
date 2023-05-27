package AB5;

import AB4.Ringpuffer;

public class FolgeMitRing <T> implements Folge<T>{

    Ringpuffer<T> ringpuffer;

    public FolgeMitRing(int capacity){
        ringpuffer = new Ringpuffer<>(capacity);
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        return ringpuffer.get(pos);
    }

    @Override
    public void set(int pos, T element) throws IndexOutOfBoundsException {
        ringpuffer.set(pos,element);
    }


    /**
     * remove methode arbeitet mit verkleinerung des scopes anstatt die werte auf null zu setzten
     * @return erstes element im ring
     * @throws IndexOutOfBoundsException , über die aufgerufene methode, falls, ring leer sein sollte
     */
    @Override
    public T remove() throws IndexOutOfBoundsException {
        return ringpuffer.removeFirst();
    }


    /**
     * remove methode arbeitet mit verkleinerung des scopes anstatt die werte auf null zu setzten
     * @param pos gibt an, an welcher stelle im ring entfernt werden soll
     * @return Das entfernte Element an dem Index pos
     * @throws IndexOutOfBoundsException , über die aufgerufenen methode, falls der ring leer sein sollte
     */
    @Override
    public T remove(int pos) throws IndexOutOfBoundsException {
        T getValue = ringpuffer.get(pos); //checks indirect the correctness of pos

        if (pos == ringpuffer.getFirst())
            ringpuffer.removeFirst();

        if (pos == ringpuffer.getLast())
            ringpuffer.removeLast();

        for (int i = pos; i < size()-1; i++)
            set(i, get(i+1)); //values moved one index forward

        ringpuffer.moveLastBack();
        return getValue;
    }

    @Override
    public boolean isEmpty() {
        return ringpuffer.isEmpty();
    }

    @Override
    public int size() {
        return ringpuffer.size();
    }

    @Override
    public int capacity() {
        return ringpuffer.capacity();
    }

    @Override
    public void insert(T element) throws IndexOutOfBoundsException {
        ringpuffer.addLast(element);
    }

    @Override
    public void insert(int pos, T element) throws IndexOutOfBoundsException {
        if (! ringpuffer.freeSpaces())
            throw new IndexOutOfBoundsException("ring ist voll");

        //pos is equal to the index one bevor the actual first
        int indexBevorFirst = (ringpuffer.getFirst() + ringpuffer.capacity() -1) % ringpuffer.capacity();
        if (pos == indexBevorFirst)
            ringpuffer.addFirst(element);

        //pos is equal to the index one after the actual last
        int indexNextToLast = (ringpuffer.getLast() +1) % ringpuffer.capacity();
        if (pos == indexNextToLast)
            ringpuffer.addLast(element);

        //pos is between first and last where both are included
        T savedLast = ringpuffer.get(ringpuffer.getLast());
        for (int i = size()-1; i > pos; i--){
            set(i , get(i-1));
        }

        //...Pointer chance automatically through the method calls...

        ringpuffer.set(pos, element);
        ringpuffer.addLast(savedLast);
    }

    public int getFirst(){
        return ringpuffer.getFirst();
    }
    public int getLast(){
        return ringpuffer.getLast();
    }

    @Override
    public String toString(){
        return ringpuffer.toString();
    }

    public static void main(String[] args) {
        FolgeMitRing<Integer> ring = new FolgeMitRing<>(5);

        ring.insert(1);
        ring.insert(2);
        ring.insert(1,20);
        ring.insert(2,30);
        System.out.println(ring.toString());
        System.out.println("first: " + ring.getFirst());
        System.out.println("last: " + ring.getLast());

    }
}