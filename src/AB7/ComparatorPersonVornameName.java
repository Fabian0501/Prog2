package AB7;

import java.util.Comparator;

public class ComparatorPersonVornameName implements Comparator<person> {

    @Override
    public int compare(person firstPerson, person secondPerson) {
        //hier vergleichen wir name, also string Dh. wir können die compareTo methode für komplexe datentypen verwenden
        int vergleichVornamen = firstPerson.getVorname().compareTo(secondPerson.getVorname());
        return vergleichVornamen == 0 ?
                (firstPerson.getName().compareTo(secondPerson.getName()))
                : vergleichVornamen;

        // wenn der vornamen vergleich == 0 ist, gehen wir rüber zum Namen vergleich, falls nicht geben wir den Vornamen Vergleich aus
    }
}
