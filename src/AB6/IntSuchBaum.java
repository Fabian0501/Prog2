package AB6;

import AB5.Folge;
import AB5.FolgeMitRing;

public class IntSuchBaum {

    Knoten root;

    public class Knoten {
        public Knoten left = null;
        public Knoten right = null;
        public Integer value;
        public Knoten(Integer value){
            this.value = value;
        }
    }

    public IntSuchBaum(){ //Konstruktor zur erstmaligen Initialisierung
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }

    public void insert(Integer value){
        if (isEmpty()){
            root = new Knoten(value);
        }
        else {
            insertHelper(root, value);
        }
    }
    private void insertHelper(Knoten current, Integer value){
        if (value == current.value){ //beim vergleich zwischen integer ist == oke, ansonsten equals verwenden
            return;
        }
        if (value > current.value){
            if (current.right == null){
                current.right = new Knoten(value);
            }else{
                insertHelper(current.right, value);
            }
        }else {
            if (current.left == null){
                current.left = new Knoten(value);
            }else {
                insertHelper(current.left, value);
            }
        }
    }


    public boolean contains(Integer value){
        if (isEmpty()){
            return false;
        }
        return containsHelper(root, value);
    }
    private boolean containsHelper(Knoten current, Integer value){
        if (value == current.value){
            return true;
        }
        if (value > current.value) {
            containsHelper(current.right, value);
        }
        if (value < current.value){
            containsHelper(current.left, value);
        }
        return false;
    }


    public String toString() {
        return toStringHelper(root);
    }
    private String toStringHelper( Knoten current) {
        if (current == null){
            return "";
        }
        return "(" + toStringHelper(current.left) + current.value + toStringHelper(current.right) + ")";
    }


    public int hoehe(){
        return hoeheHelper(root);
    }
    private int hoeheHelper(Knoten current){
        if (current != null){
            return Math.max(hoeheHelper(current.left) , hoeheHelper(current.right)) +1;
        }
        return 0;
    }

    public int hoehe2(){
        return hoeheHelper2(root);
    }
    private int hoeheHelper2(Knoten current){
        if (current == null)
            return 0;

        int leftHeight = hoeheHelper2(current.left);
        int rightHeight = hoeheHelper2(current.right);

        return Math.max(leftHeight,rightHeight) +1;
    }


    public int size(){
        if (root == null){
            return 0;
        }
        return sizeHelper(root);
    }
    private int sizeHelper(Knoten current){
        /*
          warum size = 1
          1) Wir wissen, durch die überprüfen oben in der size() methode, das root nicht null ist, somit gibt es ein element.
          2) size ist der rückgabe wert der methode, dh durch den rekursiven aufruf von sizeHelper() wird auch immer size zurückgegeben.

          was bringt das jetzt ...

          indem wir in rekursiven aufrufen size += sizeHelper() schreiben, können wir die anzahl der knoten bestimmen,
          denn durch 2) wissen wir das size der rückgabewert ist, somit wird auf unseres derzeitiges size immer size drauf addiert.
          dieses schema macht nichts anderes als <Gesamtanzahl der gefundenen Knoten> += <gefundener knoten (+=1)>
          dies machen wir für den linken-und-rechten Teilbaum

          wäre size 0 würde immer null rauskommen, wäre size = 2 würde die doppelte anzahl an bestehenden knoten rauskommen ...

          für size = 0 könnte man auch hinter den rekursiven aufrufen + 1 hinzufügen,
          allerdings wäre man dann bei anzahlAllerKnoten-1 und müsste in der obermethode return sizeHelper(root)+1 hinzufügen.
         */
        int size = 1;
        if (current != null){

            if (current.left != null) { // sucht den linken teilbaum ab
                size += sizeHelper(current.left); // size erhöht sich um die anzahl der knoten im linken teilbaum
            }

            if (current.right != null) { // sucht den rechten teilbaum ab
                size += sizeHelper(current.right); // size erhöht sich um die anzahl der knoten im rechten teilbaum
            }
        }
        return size;
    }

    public int size2(){
        if (root == null){
            return 0;
        }
        return sizeHelper2(root);
    }
    private int sizeHelper2(Knoten current){
        int size = 0;
        if (current != null){
            size++;
            size += sizeHelper2(current.left);
            size += sizeHelper2(current.right);
        }
        return size;
    }

    public Folge preorder(){
        Folge<Integer> folge = new FolgeMitRing<>(size());
        preorderHelper(root, folge);
        return folge;
    }
    private void preorderHelper(Knoten current, Folge ring){
        
        if (current != null){
            ring.insert(current.value);

            if (current.left != null){
                //stellt alle elemente dar, die unter einem Elternknoten das linke Kindknoten sind
                preorderHelper(current.left , ring);
            }

            if (current.right != null){
                //stellt alle elemente dar, die unter einem Elternknoten das rechte Kindknoten sind
                preorderHelper(current.right, ring);
            }
        }
    }

    public Folge inorder(){
        Folge<Integer> folge = new FolgeMitRing<>(size());
        inorderHelper(root,folge);
        return folge;
    }
    private void inorderHelper(Knoten current, Folge ring){
        if (current != null){

            if (current.left != null){
                inorderHelper(current.left , ring);
            }

            ring.insert(current.value);

            if (current.right != null){
                inorderHelper(current.right, ring);
            }
        }
    }

    public Folge postorder(){
        Folge<Integer> folge = new FolgeMitRing<>(size());
        postorderHelper(root, folge);
        return folge;
    }
    private void postorderHelper(Knoten current, Folge folge){
        if (current != null){
            if (current.left != null){
                postorderHelper(current.left , folge);
            }

            if (current.right != null){
                postorderHelper(current.right, folge);
            }
            folge.insert(current.value);
        }
    }

    public Folge breitensuche(){
        Folge<Integer> folge = new FolgeMitRing<>(size());
        breitensucheHelper(root,folge);
        return folge;
    }
    private void breitensucheHelper(Knoten current, Folge folge){

    }

    public static void main(String[] args) {
        IntSuchBaum baum = new IntSuchBaum();
        baum.insert(3);
        baum.insert(2);
        baum.insert(5);
        baum.insert(4);
        baum.insert(1);
        baum.insert(7);
        System.out.println(baum.toString());
        System.out.println(baum.hoehe());
        System.out.println(baum.hoehe2());
        System.out.println(baum.size());
        System.out.println(baum.postorder().toString());

    }
}