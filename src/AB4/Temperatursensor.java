package AB4;

public class Temperatursensor {

    Ringpuffer<Float> speicher = new Ringpuffer<>(24);

    public void neueMessung(Float wert){
        try {
            speicher.addLast(wert);
        }catch (IndexOutOfBoundsException boundsException){
            speicher.removeFirst();
            speicher.addLast(wert);
        }
    }

    public Float aktuelleMessung(){
        try {
            return speicher.get(speicher.size()-1);
            //man geht size-1 felder vom first weiter, um an den zuletzt eingefügten wert zu gelangen
        }catch (IndexOutOfBoundsException boundsException){
            return Float.NaN;
        }
    }

    public Float durchschnittsTemperatur(){
        if (speicher.isEmpty())
            return Float.NaN;

        Float summe = 0.0F;
        for (int i = 0; i < speicher.size(); i++){
            summe += speicher.get(i);
        }
        return summe;
    }

    public void reset(){
        for (int i = speicher.size(); i > 0; i--){
            speicher.removeLast();
        }
    }

    public Ringpuffer<Float> getSpeicher() {
        return speicher;
    }

}