package AB2;

public class Paar <E,Z> {

    public E erstes;
    public Z zweites;

    public Paar (E e , Z z){
        erstes = e;
        zweites = z;
    }

    public E getErstes(){
        return erstes;
    }

    public Z getZweites(){
        return zweites;
    }

    /**
     * @param e der neue wert für die variable erstes
     * @return den alten wert der variable erstes
     */
    public E setErstes(E e){
        E temp = this.erstes;
        this.erstes = e;
        return temp;
    }

    /**
     * @param z der neue wert der variable zweites
     * @return den alten wert der variable zweites
     */
    public Z setZweites(Z z){
        Z temp = this.zweites;
        this.zweites = z;
        return temp;
    }
    public void setBeide(E e , Z z){
        erstes = e;
        zweites = z;
    }
    public boolean equals(Paar<E,Z> paar){
        return paar.getErstes().equals(erstes) && paar.getZweites().equals(zweites);
    }
    public String toString(){
        return "( " + erstes + ", " + zweites + " )";
    }

}