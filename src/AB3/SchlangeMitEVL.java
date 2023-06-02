package AB3;

import AB2.schlange;
import AB3.EVL;

import java.util.NoSuchElementException;

public class SchlangeMitEVL<T> implements schlange<T> {

    EVL<T> evl;

    public SchlangeMitEVL(){
        evl = new EVL<>();
    }

    @Override
    public boolean isEmpty() {
        return evl.isEmpty();
    }

    @Override
    public int size() {
        return evl.size();
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }
    @Override
    public T front() throws NoSuchElementException {
        return evl.getFirst(); //...Value and not the Position
    }



    /**
     * Um das prinzip der Schlange umzusetzen, muss insert und remove an unterschiedlichen stellen passieren,
     * DH. entweder insertFirst und removeLast    oder    insertLast und removeFirst
     *
     * Da wir bei der einfach verkettetet liste, um last zu entfernen, einmal die gesamte liste bis zum vorletzten element durchgehen müssen
     * wäre es deutlich effektiver die herangehensweise zu ändern.
     * ==> addLast und removeFirst, denn so haben wir Zugriff auf alle benötigten werte und brauchen KEINE schleife
     *
     * @insert ==> addLast
     * @remove ==> removeFirst
     */
    @Override
    public void insert(T a) throws IllegalStateException{
        evl.addLast(a);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return evl.removeFirst();
    }

    public String toString(){
        return evl.toString();
    }

    public static void main(String[] args) {
        SchlangeMitEVL<Integer> schlange = new SchlangeMitEVL<>();
        for (int i = 1 ; i <= 5; i++){
            schlange.insert(i);
        }
        System.out.println(schlange.toString());
        schlange.remove();
        System.out.println(schlange.toString());
        System.out.println(schlange.front());
    }


}