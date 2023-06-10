package AB7;

import AB3.SchlangeMitEVL;
import AB5.Folge;
import AB5.FolgeMitRing;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class SuchBaum<T> implements Comparable<SuchBaum <T> >{

    Knoten root;

    private Comparator<T> comparator;

    //Konstruktor zur erstmaligen Initialisierung
    public SuchBaum(){
        root = null;
        comparator = null;
    }
    public SuchBaum(Comparator<T> comp){
        comparator = comp;
    }

    @Override
    public int compareTo(@NotNull SuchBaum<T> other) {
        return this.compareTo(other);
    }


    public class Knoten {
        public Knoten left = null;
        public Knoten right = null;
        public T value;

        public Knoten(T value) {
            this.value = value;
        }
    }

    private int compareHelper(T object1, T object2){
        return comparator == null ? ((Comparable<T>)object1).compareTo(object2) : comparator.compare(object1, object2);
    }


    public boolean isEmpty(){
        return root == null;
    }

    public void insert(T value){
        if (isEmpty()){
            root = new Knoten(value);
        }
        else {
            insertHelper(root, value);
        }
    }
    private void insertHelper(Knoten current, T value){
        if (compareHelper(current.value, value) == 0){
            return;
        }
        if (compareHelper(value, current.value) > 0){
            if (current.right == null){
                current.right = new Knoten(value);
            }else{
                insertHelper(current.right, value);
            }
        }
        else { //compareHelper < 0
            if (current.left == null){
                current.left = new Knoten(value);
            }else {
                insertHelper(current.left, value);
            }
        }
    }


    public boolean contains(T value){
        if (isEmpty()){
            return false;
        }
        return containsHelper(root, value);
    }
    private boolean containsHelper(Knoten current, T value){
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
            if (compareHelper(value, current.value) == 0){
                return true;
            }
            if (compareHelper(value, current.value) > 0){
                return containsHelper(current.right, value);
            }
            if (compareHelper(value, current.value) < 0){
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


    public Knoten remove(T removeValue){
        Knoten Knoten = searchNode(removeValue, root); //hilfsfunktion, um den Knoten des entfernenden elements zu suchen
        if (Knoten == null){ //dh der gesuchte wert ist nicht im baum enthalten
            return null;
        }

        Knoten parent = searchParent(root, Knoten); //hilfsfunktion, um parent des gesuchten element zu finden

        //Fall 1: der Knoten hat keine teil bäume
        if (Knoten.left == null && Knoten.right == null){

            if (Knoten == root){ // Sonderfall wurzel wird entfernt
                Knoten tmp = root;
                root = null;
                return tmp;
            }

            //referenz zum elternknoten entfernen //TODO compareHelper
            if (parent.left == Knoten) parent.left = null; //kein equals verwenden, da wenn parent.left null ist wird eine exception
            if (parent.right == Knoten) parent.right = null;
            return Knoten;
        }

        //Fall 2: ein teilbaum
        if (hasOnlyOneSubtree(Knoten)){

            //TODO laskdjfhslkdjfhsalkdjfhsalkdjfhsalkdjfhskladjfhskladhfslkadhfslakdhflkashdflkasdhfslkajdfhklashdflkashdfkshfdskh compareHElper
            if (Knoten == root){ // Sonderfall wurzel wird entfernt
                Knoten tmp = root;
                Knoten nachfolger = searchInorderReplacer(Knoten);
                remove(nachfolger.value); //entfernt nachfolger und strukturiert je nachdem den baum um
                root.value = nachfolger.value; //wert in root durch nachfolger überschreiben
                return tmp;
            }

            if (parent.left == Knoten){ //gesuchter Knoten liegt links vom parent
                if (Knoten.left != null){ //Teilbaum liegt links
                    parent.left = Knoten.left; //referenz im elternknoten auf teilbaum vom gesuchten Knoten setzt
                }
                else { //Teilbaum liegt rechts
                    parent.left = Knoten.right; //referenz im elternknoten auf teilbaum vom gesuchten Knoten setzt
                }
            }
            if (parent.right == Knoten){ // gesuchter Knoten liegt rechts vom parent
                if (Knoten.left != null){ //Teilbaum liegt links
                    parent.right = Knoten.left; //referenz im elternknoten auf teilbaum vom gesuchten Knoten setzt
                }
                else { //Teilbaum liegt rechts
                    parent.right = Knoten.right; //referenz im elternknoten auf teilbaum vom gesuchten Knoten setzt
                }
            }
            return Knoten;
        }

        //Fall 3: zwei teilbäume
        if (Knoten.left != null && Knoten.right != null){

            if (Knoten == root){ // Sonderfall wurzel wird entfernt
                Knoten tmp = root;
                Knoten nachfolger = searchInorderReplacer(Knoten);
                remove(nachfolger.value); //entfernt nachfolger und strukturiert je nachdem den baum um
                root.value = nachfolger.value; //wert in root durch nachfolger überschreiben
                return tmp;
            }


            parent = searchParent(root, Knoten); //parent vom gesuchten element
            Knoten inorderReplacer = searchInorderReplacer(Knoten); //Sucht den Nachfolger
            Knoten parentOfReplacer = searchParent(root,inorderReplacer); //sucht den elternknoten vom Nachfolger

            //Der wert im gesuchten Knoten wird durch seinen nachfolger überschrieben
            if (parent.left == Knoten){  //Knoten liegt links vom parent
                parent.left.value = inorderReplacer.value; //überschrieben
            }
            if (parent.right == Knoten){ //Knoten liegt rechts vom parent
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
        return Knoten;
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
    private boolean hasOnlyOneSubtree(Knoten Knoten){
        if (Knoten.left != null && Knoten.right == null){
            return true;
        }
        if (Knoten.left == null && Knoten.right != null){
            return true;
        }
        return false;
    }
    private Knoten searchParent(Knoten current, Knoten Knoten){
        //in jedem if eine return anweisung, deswegen macht es wenig sinn else if zu verwenden, da jer block eh nur 1-mal ausgeführt wird
        if (current.left != null){
            if (compareHelper(current.left.value, Knoten.value) == 0){
                return current;
            }
        }
        if (current.right != null){
            if (compareHelper(current.right.value, Knoten.value) == 0){
                return current;
            }
        }
        if (compareHelper(Knoten.value, current.value) > 0  &&  current.right != null){
            return searchParent(current.right, Knoten);
        }
        if (compareHelper(Knoten.value, current.value) < 0  &&  current.left != null){
            return searchParent(current.left, Knoten);
        }
        else {
            return null;
        }
    }
    private Knoten searchNode(T removeValue, Knoten current){
        if (compareHelper(removeValue, current.value) == 0){
            return current;
        } else if (compareHelper(removeValue, current.value) > 0  && current.right != null) {
            return searchNode(removeValue, current.right);
        } else if (compareHelper(removeValue, current.value) < 0  && current.left != null) {
            return searchNode(removeValue, current.left);
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        SuchBaum baum = new SuchBaum<Integer>();
        baum.insert("kg"); //laufzeit fehler, da der suchbaum baum den typparameter Integer hat und "Kg" kein Integer ist
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