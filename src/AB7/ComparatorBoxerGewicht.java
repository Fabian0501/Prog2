package AB7;

import java.util.Comparator;

public class ComparatorBoxerGewicht implements Comparator <Boxer> {
    @Override
    public int compare(Boxer first_boxer, Boxer second_boxer) {
        //hier wird gewicht vergleichen, da wir davon ausgehen, dass das gewicht realistisch ist wird es nicht zu einem overflow kommen

        return first_boxer.getGewicht() - second_boxer.getGewicht();
    }
}
