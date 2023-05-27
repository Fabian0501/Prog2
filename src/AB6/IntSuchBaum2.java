package AB6;

import AB5.Folge;
import AB5.FolgeMitRing;

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
            // wir durchlaufen den linken und rechten teilbaums jedes knotens und fügen die inhalte dieser knoten in einen string zsm.
            return "(" + toStringHelper(current.left) + current.value + toStringHelper(current.right) + ")";
        }
     }

     public int hoehe(){
        if (isEmpty()){
            return 0;
        }
        return hoeheHelper(root);
     }
     private int hoeheHelper(Knoten current){
        int hoehe = 1;
        if (current != null){
            return hoehe += Math.max(hoeheHelper(current.left) , hoeheHelper(current.right)) +1;
            /**
             * wir gehen zuerst den gesamten linken teilbaum herunter und addieren jedes Mal 1 für eine ebene die wir tierfer gehen.
             * das selbe machen wir für den rechten teilbaum.
             * Am ende vergleichen wir die längen der beiden teilbäume, nehmen den längeren und addieren 1 dazu.
             * diese letzte eins die dazu addiert wird, steht für die ebene root.
             */
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

     public Folge preorder(){
        if (isEmpty()){
            return new FolgeMitRing(0);
        }
        return preorderHelper(root);
     }
     private Folge preorderHelper(Knoten current){
        Folge<Integer> folge = new FolgeMitRing<>(size());
        if (current != null){ //wenn mein betrachteter knoten nicht null --> knoten wert in den ring einfügen
            folge.insert(current.value);
        }
        preorderHelper(current.left); // betrachte den linken Teilbaum rekursiv
        preorderHelper(current.right); // betrachte den rechten Teilbaum rekursiv

        return folge;
     }

     public Folge inorder(){
        if (isEmpty()){
            return new FolgeMitRing(0);
        }
        return inorderHelper(root);
     }
     private Folge inorderHelper(Knoten current){
         Folge<Integer> folge = new FolgeMitRing<>(size());
         inorderHelper(current.left); // betrachte den linken Teilbaum rekursiv
         if (current != null){ //wenn mein betrachteter knoten nicht null --> knoten wert in den ring einfügen
             folge.insert(current.value);
         }
         inorderHelper(current.right); // betrachte den rechten Teilbaum rekursiv
         return folge;
     }

     public Folge postorder(){
        if (isEmpty()){
            return new FolgeMitRing(0);
        }
        return postorderHelper(root);
     }
     private Folge postorderHelper(Knoten current){
        Folge<Integer> folge = new FolgeMitRing<>(size());
        postorderHelper(current.left); // betrachte den linken Teilbaum rekursiv
        postorderHelper(current.right); // betrachte den rechten Teilbaum rekursiv
        if (current != null){ //wenn mein betrachteter knoten nicht null --> knoten wert in den ring einfügen
            folge.insert(current.value);
        }
        return folge;
     }

    public static void main(String[] args) {
        IntSuchBaum baum = new IntSuchBaum();
        baum.insert(3);
        baum.insert(2);
        baum.insert(1);
        baum.insert(5);
        baum.insert(4);
        baum.insert(7);
        System.out.println(baum.toString());
        System.out.println(baum.hoehe());
        System.out.println(baum.size());
        System.out.println(baum.preorder().toString());
        System.out.println(baum.inorder().toString());
        System.out.println(baum.postorder().toString());
    }
}
