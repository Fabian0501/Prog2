package AB6;

import AB3.SchlangeMitEVL;
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
        /*
        In der gegebenen Methode containsHelper wird die Ausführung nicht abgebrochen,
        wenn return true erreicht wird, weil der Rückgabewert nicht sofort an den Aufrufer zurückgegeben wird.
        Stattdessen wird der Rückgabewert nur an den Aufruf der rekursiven containsHelper-Methode weitergegeben.
        In den Zeilen, in denen containsHelper erneut aufgerufen wird, wird jedoch der Rückgabewert nicht verwendet.
        Die rekursive Methode wird aufgerufen, aber der Rückgabewert wird nicht beachtet.
        Dies bedeutet, dass der Wert von return true nicht an den ursprünglichen Aufrufer zurückgegeben wird,
        sondern die Methode stattdessen weiterhin durchläuft und return false am Ende erreicht.
         */
        if (current != null){
            if (value == current.value){
                return true;
            }
            if (value > current.value) {
                return containsHelper(current.right, value);
            }
            if (value < current.value){
                return containsHelper(current.left, value);
            }
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
        SchlangeMitEVL<Knoten> fifo = new SchlangeMitEVL<>();
        if (! isEmpty()){
            fifo.insert(root);
        }
        breitensucheHelper(root,folge,fifo);
        return folge;
    }
    private void breitensucheHelper(Knoten current, Folge folge , SchlangeMitEVL fifo){
        if (current != null) {
            if (current.left != null) {
                fifo.insert(current.left);
            }
            if (current.right != null) {
                fifo.insert(current.right);
            }
        }
        Knoten firstOutFifo = (Knoten) fifo.remove();
        folge.insert( firstOutFifo.value );
        if (fifo.size() > 0){
            breitensucheHelper((Knoten) fifo.front(), folge, fifo);
        }
    }


    public Knoten remove(Integer removeValue){
        Knoten knoten = searchNode(removeValue, root); //hilfsfunktion, um den knoten des entfernenden elements zu suchen
        if (knoten == null){ //dh der gesuchte wert ist nicht im baum enthalten
            return null;
        }

        Knoten parent = searchParent(root, knoten); //hilfsfunktion, um parent des gesuchten element zu finden

        //Fall 1: der knoten hat keine teil bäume
        if (knoten.left == null && knoten.right == null){

            if (knoten == root){ // Sonderfall wurzel wird entfernt
                Knoten tmp = root;
                root = null;
                return tmp;
            }

            //referenz zum elternknoten entfernen
            if (parent.left == knoten) parent.left = null; //kein equals verwenden, da wenn parent.left null ist wird eine exception
            if (parent.right == knoten) parent.right = null;
            return knoten;
        }

        //Fall 2: ein teilbaum
        if (hasOnlyOneSubtree(knoten)){

            if (knoten == root){ // Sonderfall wurzel wird entfernt
                Knoten tmp = root;
                Knoten nachfolger = searchInorderReplacer(knoten);
                remove(nachfolger.value); //entfernt nachfolger und strukturiert je nachdem den baum um
                root.value = nachfolger.value; //wert in root durch nachfolger überschreiben
                return tmp;
            }

            if (parent.left == knoten){ //gesuchter knoten liegt links vom parent
                if (knoten.left != null){ //Teilbaum liegt links
                    parent.left = knoten.left; //referenz im elternknoten auf teilbaum vom gesuchten knoten setzt
                }
                else { //Teilbaum liegt rechts
                    parent.left = knoten.right; //referenz im elternknoten auf teilbaum vom gesuchten knoten setzt
                }
            }
            if (parent.right == knoten){ // gesuchter knoten liegt rechts vom parent
                if (knoten.left != null){ //Teilbaum liegt links
                    parent.right = knoten.left; //referenz im elternknoten auf teilbaum vom gesuchten knoten setzt
                }
                else { //Teilbaum liegt rechts
                    parent.right = knoten.right; //referenz im elternknoten auf teilbaum vom gesuchten knoten setzt
                }
            }
            return knoten;
        }

        //Fall 3: zwei teilbäume
        if (knoten.left != null && knoten.right != null){

            if (knoten == root){ // Sonderfall wurzel wird entfernt
                Knoten tmp = root;
                Knoten nachfolger = searchInorderReplacer(knoten);
                remove(nachfolger.value); //entfernt nachfolger und strukturiert je nachdem den baum um
                root.value = nachfolger.value; //wert in root durch nachfolger überschreiben
                return tmp;
            }


            parent = searchParent(root, knoten); //parent vom gesuchten element
            Knoten inorderReplacer = searchInorderReplacer(knoten); //Sucht den Nachfolger
            Knoten parentOfReplacer = searchParent(root,inorderReplacer); //sucht den elternknoten vom Nachfolger

            //Der wert im gesuchten Knoten wird durch seinen nachfolger überschrieben
            if (parent.left == knoten){  //knoten liegt links vom parent
                parent.left.value = inorderReplacer.value; //überschrieben
            }
            if (parent.right == knoten){ //Knoten liegt rechts vom parent
                parent.right.value = inorderReplacer.value; //überschreiben
            }

            //löschen des Nachfolger elements
            if (parentOfReplacer.left == inorderReplacer){
                parentOfReplacer.left = null;
            }
            if (parentOfReplacer.right == inorderReplacer){
                parentOfReplacer.right = null;
            }
        }
        return knoten;
    }


    //Hilfsmethoden
    /**
     * sucht den kleinsten wert im rechten teilbaum und den größten wert im linken teilbaum
     * @param current der zu Entfernende knoten
     * @return der Knoten der am tiefsten in dem baum liegt. sprich der knoten bei dem die while die meisten durchläufe hat
     */
    private Knoten searchInorderReplacer(Knoten current){
        int stepsInRightTree = 0,  stepsInLeftTree = 0;
        Knoten smallestRight = null;
        Knoten highestLeft = null;

        //Die beiden if abfragen, um zu sehen, ob es überhaupt elemente an root gibt, denn wenn nicht, sind die schleifen unten überflüssig
        if (current.right != null){
            smallestRight = current.right;
            stepsInRightTree++;
        }
        if (current.left != null){
            highestLeft = current.left;
            stepsInLeftTree++;
        }

        //schleifen die durch den baum iterieren, um den Nachfolger vom gesuchten element zu finden, der es ersetzten soll
        if (smallestRight != null && smallestRight.left != null){
            while (smallestRight.left != null) {
                smallestRight = smallestRight.left;
                stepsInRightTree++;
            }
        }
        if (highestLeft != null && highestLeft.right != null){
            while (highestLeft.right != null){
                highestLeft = highestLeft.right;
                stepsInLeftTree++;
            }
        }

        return stepsInRightTree > stepsInLeftTree ? smallestRight : highestLeft;
    }
    private boolean hasOnlyOneSubtree(Knoten knoten){
        if (knoten.left != null && knoten.right == null){
            return true;
        }
        if (knoten.left == null && knoten.right != null){
            return true;
        }
        return false;
    }
    private Knoten searchParent(Knoten current, Knoten knoten){
        if (current.left != null){
            if (current.left.equals(knoten)){
                return current;
            }
        }
        if (current.right != null){
            if (current.right.equals(knoten)){
                return current;
            }
        }
        if (knoten.value > current.value && current.right != null){
            return searchParent(current.right, knoten);
        }
        if (knoten.value < current.value && current.left != null){
            return searchParent(current.left, knoten);
        }
        else {
            return null;
        }
    }
    private Knoten searchNode(Integer removeValue, Knoten current){
        if (removeValue == current.value){
            return current;
        }
        else if (removeValue > current.value && current.right != null){
            return searchNode(removeValue, current.right);
        }
        else if (removeValue < current.value && current.left != null){
            return searchNode(removeValue, current.left);
        }
        else {
            return null;
        }
    }





    public static void main(String[] args) {
        IntSuchBaum baum = new IntSuchBaum();
        baum.insert(6);
        baum.insert(4);
        baum.insert(1);
        baum.insert(9);
        baum.insert(7);
        baum.insert(10);
        baum.insert(8);
        System.out.println(baum.toString());
//        baum.remove3(9);
//        baum.remove3(8);
        baum.remove(6);
        System.gc();
        System.out.println(baum.toString());

    }
}