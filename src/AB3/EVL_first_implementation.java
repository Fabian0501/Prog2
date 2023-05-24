package AB3;

import java.util.NoSuchElementException;

public class EVL_first_implementation<T> {

    Listenelement first = null; // Zeiger auf das erste Element
    Listenelement last = null; //Zeiger auf das letzte Element
    int size = 0; // aktuelle länge der Liste

    class Listenelement{ //Listenelemente als innere Klasse → hier public um aus dem Test auf die daten zuzugreifen
        public T data;
        Listenelement next = null; // Zeiger auf das nächte Element

        Listenelement(T data){
            this.data = data;
        }
    }


    public boolean isEmpty(){
        return first == null;
    }

    public Listenelement getFirst() throws IllegalStateException{
        if (isEmpty()){
            throw new IllegalStateException("fehler meldung aus getFirst");
        }
        return first;
    }

    /**
     * @return das letzte Listen Element
     * @throws IllegalStateException, wenn noch kein ListenElement hinzugefügt wurde
     * <p>
     * Warum Listenobjekt als rückgabewert?
     * wenn die methode das letzte listen Objekt als rückgabewert hat, kann man sich bei ADD LAST den
     * Schleifen durchlauf sparen da man das letzte element der liste durch den Aufruf getLast erhält, dann muss man nur
     * noch die Zeiger richtig ändern und schon wurde ein neues listenelement am Ende hinzugefügt
     */

    public Listenelement getLast() throws IllegalStateException{
        if (isEmpty()){
            throw new IllegalStateException("fehlermeldung aus getLast");
        }
        return last;
    }

    public void addLast(T elem){
        Listenelement neuesListenElement = new Listenelement(elem);

        //Variante 1
        //getLast().next = neuesListenElement;

        //Variante 2
        if (size == 0){
            first = neuesListenElement;
        }else {
            Listenelement tmp = first;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = neuesListenElement;
        }
        size++;
    }

    public T removeLast() throws NoSuchElementException{

        //Sonderfall: Leere Liste
        if (size == 0) throw new NoSuchElementException();

        Listenelement tmp = first;

        //Sonderfall: Liste mit nur einem Element
        // ZEICHNEN ZUM VERSTÄNDNIS
        if (tmp.next == null){ //wenn das nachfolgende Elem. des ersten auf null zeigt
            first = null; //das erste Element wird wieder null gesetzt
            //System.out.println(tmp.data);
            return tmp.data; //die daten von tmp = erstes und einziges Element werden ausgegeben
        }

        //Normalfall: Liste mit mehreren Elementen → suche vorletztes Element
        while (tmp.next.next != null){ //wir suchen das vorletzte Element dh. es gibt mind. 2 Elem
            tmp = tmp.next; //objekt nimmt seinen vordermann an
        }
        size--;

        T d = tmp.next.data; //"data" des letzten elements werden in d gespeichert
        tmp.next = null; //der zeiger des vorletzten elements zeigt nun nicht mehr auf das letzte Elem. sondern auf null
        //System.out.println(d);
        return d; // der inhalt des letzten inhalts wird ausgegeben
    }

    public boolean contains(T e){

        //Sonderfall: Liste enthält keine Elemente
        if (size == 0){
            return false;
        }

        Listenelement tmp = first; //tmp objekt nimmt den zeiger des ersten elements an
        while (tmp.next != null){ //suche nach letztem element
            if (tmp.data == e){ //wenn die daten meines momentanen Elements = referenzwert
                return true;
            }
            tmp = tmp.next; // wenn der gesuchte inhalt nicht in dem element drinnen ist, gehe ein element weiter
        }
        return tmp.data == e; //hat das letzte element in der Liste den gesuchten Referenzwert
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        String s = "";
        Listenelement tmp = first;
        while (tmp.next != null){
            s += tmp.data + "-";
            tmp = tmp.next;
        }
        s += tmp.data;
        return s;
    }
}