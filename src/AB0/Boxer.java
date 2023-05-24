package AB0;

public class Boxer extends person{
    private int gewicht;

    public Boxer(String name, String vorname, int gewicht) {
        super(name,vorname);
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString() {
        return super.toString() + " " + gewicht;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Boxer)) {
            return false;
        }
        Boxer boxer = (Boxer) other;
        return super.equals(boxer) && boxer.gewicht == this.gewicht;
    }
}