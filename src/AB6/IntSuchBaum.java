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


    public void insert(Integer data){
        if (isEmpty()){
            root = new Knoten(data);
        }
        if (! contains(data))
        {
            if (data > root.value) //...data must be placed on the right node...
            {
                if (root.right == null){ //...check if the right node of my current node is empty...
                    root.right = new Knoten(data);
                }
                else { //...right node of my current node isn't empty...
                    insertHelper(data, root.right);
                }
            }
            if (data < root.value) //...data must be placed on  the left node...
            {
                if (root.left == null) { //...check if the left node of my current node is empty...
                    root.left = new Knoten(data);
                }
                else { //...left node of my current node isn't empty
                    insertHelper(data, root.left);
                }
            }
        }
    }
    private void insertHelper(Integer data,Knoten current){
        if (data > current.value) //...data must be placed on the right node...
        {
            if (current.right == null){ //...check if the right node of my current is empty...
                current.right = new Knoten(data); //...new node added
            }
            else { //...right node isn't empty...
                insertHelper(data, current.right); //...move to the next right node and check again...
            }
        }
        else{ //...data is smaller than current.value, so data must be placed on the left node...
            if (current.left == null){ //...check if the left node of my current is empty...
                current.left = new Knoten(data); //...new node added
            }
            else { //...left node isn't empty...
                insertHelper(data, current.left); //...move to the next left node and check again...
            }
        }
    }


    public boolean contains(Integer data){
        if (! isEmpty())
        {
            if (data.equals(root.value))
            {
                return true;
            }
            //TODO kommentar für &&... schrieben
            if (data > root.value && root.right != null){  //...data is on the right side of the node...
                containsHelper(data, root.right);
            }
            else if (data < root.value && root.left != null){ //...data is on the left side of the node...
                containsHelper(data, root.left);
            }
        }
        return false;
    }
    private boolean containsHelper(Integer value, Knoten current){
        if (current != null)
        {
            if (value.equals(current.value)){
                return true;
            }
            //TODO kommentar für &&... schrieben
            if (value > current.value && current.right != null){ //...data must be on the right node...
                containsHelper(value, current.right); //...go on the right node...
            }
            else if (value < current.value && current.left != null){ //... data < current.value, so data must be on the left node...
                containsHelper(value, current.left);//...go on the left node...
            }
        }
        return false;
    }


    public String toString() {
        return toStringHelper(root);
    }
    private String toStringHelper( Knoten current) {
        String s = "(";
        if(current != null) {
            if (current.left != null){
                s += toStringHelper(current.left);
            }

            s = s + current.value;

            if (current.right != null){
                s += toStringHelper(current.right);
            }
        }
        return s += ")";
    }


    public int hoehe(){
        return hoeheHelper(root);
    }
    private int hoeheHelper(Knoten current){
        int h = 0;
        if (current != null){
            h = Math.max(hoeheHelper(current.left) , hoeheHelper(current.right)) +1;
        }
        return h;
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
        /**
         * warum size size = 1
         * 1) Wir wissen, durch die überprufen oben in der size() methode, das root nicht null ist, somit gibt es ein element.
         * 2) size ist der rückgabe wert der methode, dh durch den rekursiven aufruf von sizeHelper() wird auch immer size zurückgegeben.
         *
         * was bringt das jetzt ...
         *
         * indem wir in rekursiven aufrufen size += sizeHelper() schreiben, können wir die anzahl der knoten bestimmen,denn
         * durch 2) wissen wir das size der rückgabewert ist, somit wird auf unseres derzeitiges size immer size drauf addiert.
         * dieses schema macht nichts anderes als <gesammt Anzahl der gefundenen Knoten> += <gefundener knoten (+=1)>
         * dies machen wir für den linken-und-rechten Teilbaum
         *
         * wäre size 0 würde immer null raus kommen, wäre size = 2 würde die doppelte anzahl an bestehenden knoten raus kommen ...
         *
         * für size = 0 könnte man auch hinter den rekursiven aufrufen + 1 hinzufügen,
         * alerdings wäre man dann bei anzahlAllerKnoten-1 und müsste in der obermethode return sizeHelper(root)+1 hinzufügen.
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

    public Folge preorder(){
        Folge<Integer> folge = new FolgeMitRing<>(size());
        preorderHelper(root, folge);
        return folge;
    }
    private void preorderHelper(Knoten current, Folge ring){
        
        if (current != null){
            ring.insert(current.value);

            if (current.left != null){
                //stellt alle elemente da, die unter einem Elternknoten das Linke Kindknoten sind
                preorderHelper(current.left , ring);
            }

            if (current.right != null){
                //stellt alle elemente da, die unter einem Elternknoten das Rechte Kindknoten sind
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

    public static void main(String[] args) {
        IntSuchBaum baum = new IntSuchBaum();
        baum.insert(3);
        baum.insert(2);
        baum.insert(5);
        baum.insert(4);
        baum.insert(1);
        baum.insert(7);
//        System.out.println(baum.toString());
//        System.out.println(baum.hoehe());
//        System.out.println(baum.hoehe2());
//        System.out.println(baum.size());
        System.out.println(baum.postorder().toString());

    }
}