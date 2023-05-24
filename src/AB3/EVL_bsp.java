package AB3;

public class EVL_bsp <T> {

    Listenelement first = null; // Zeiger auf das erste Element
    int size = 0; // aktuelle länge der Liste

    class Listenelement{ //Listenelemente als innere Klasse
        T data;
        Listenelement next = null; // Zeiger auf das nächte Element

        Listenelement(T data){
            this.data = data;
        }
    }

    public void appendLast(T obj){
        Listenelement listenelement = new Listenelement(obj);
        if (size == 0){
            first = listenelement;
        }else {
            Listenelement tmp = first;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = listenelement;
        }
        size++;
    }

}



