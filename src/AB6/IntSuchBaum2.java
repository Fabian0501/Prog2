package AB6;

public class IntSuchBaum2 {

    Knoten root;
    class Knoten{
        public Knoten left = null;
        public Knoten right = null;
        public int value;
        public Knoten(int data){
            value = data;
        }
    }
    public IntSuchBaum2(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public void insert(Integer value){
        if (isEmpty()){
            root = new Knoten(value);
        }
        insertHelper(root,value);
    }
    private void insertHelper(Knoten current, Integer value){
        if (current == null) {
            current = new Knoten(value);
            /*
            woher wissen wir das der Knoten der null ist auch der richtige knoten ist, um den wert abzulegen?

            wir gehen, den baum von oben nach unten durch beginnend bei root und enden bei null
            wir gehen nach links, wenn unser wert kleiner ist als der in dem knoten und nach rechts, wenn er größer ist

            wenn wir das schema wiederholen kommen wir an einem knoten am Ende des baums an der null ist,
            da wir die ganze Zeit die regeln des baumes nicht verletzt haben, muss dieser freie knoten auch der knoten sein,
            beidem der wert eingefügt werden soll
            */
        }
        if (current.value == value) { //wenn der einzufügende wert schon enthalten ist, passiert nichts
            return;
        }

        //Schema, nachdem wir den baum rekursiv durchgehen, entsprechend den gegeben regeln
        if (value > current.value) {
            insertHelper(current.right, value); //gehe nach rechts, wenn mein wert größer als der im Knoten ist
        }
        if (value < current.value) {
            insertHelper(current.left, value); //gehe nach links, wenn mein wert kleiner als der im Knoten ist
        }
    }

    public boolean contains(Integer value){
        return containsHelper(root, value);
    }
    private boolean containsHelper(Knoten current ,Integer value){
        if (current.value == value) // == ist oke beim Vergleichen von Integer, bei Double lieber equals verwenden
            return true; // der gesuchte wert ist im baum enthalten

        //Regeln zum Durchgehen des baums
        if (value > current.value) containsHelper(current.right, value);
        if (value < current.value) containsHelper(current.left, value);
        return false; //der gesuchte wert wurde nicht gefunden
    }

     public String toString(){
        return toStringHelper(root);
     }
     private String toStringHelper(Knoten current){
        if (current == null){ // soll wie in der aufgabe beschrieben nichts dem String hinzugefügt werden
            return "";
        }
        else { // der besuchte knoten ist nicht leer
            // das schema in dem die toString ausgabe sein soll
            return "(" + toStringHelper(current.left) + current.value + toStringHelper(current.right) + ")";
        }
     }

     public int hoehe(){
        if (root == null){
            return 0;
        }
        return hoeheHelper(root);
     }
     private int hoeheHelper(Knoten current){
        int hoehe = 1;
        if (current != null){
            return hoehe += Math.max(hoeheHelper(current.left) , hoeheHelper(current.right)) +1;
        }
        return hoehe;
     }

     public int size(){
        if (root == null){
            return 0;
        }
        return sizeHelper(root);
     }
     private int sizeHelper(Knoten current){
        int size = 1;
        if (current != null){
            size += sizeHelper(current.left) + sizeHelper(current.right);
        }
        return size;
     }


    public static void main(String[] args) {
        IntSuchBaum baum = new IntSuchBaum();
        baum.insert(10);
        baum.insert(5);
        baum.insert(15);
        baum.insert(13);
        baum.insert(12);
        System.out.println(baum.toString());
        System.out.println(baum.hoehe());
        System.out.println(baum.size());
    }
}
