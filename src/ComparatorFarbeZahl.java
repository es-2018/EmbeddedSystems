import java.util.Comparator;

public class ComparatorFarbeZahl implements Comparator<Karte> {
    public int compare(Karte k1, Karte k2) {
        // Karten sind Comparable und vergleichen sich nach Farbe, dann Zahl.
        // Greife daher einfach auf die compareTo-Methode zurück.
        return k1.compareTo(k2);
    }
}