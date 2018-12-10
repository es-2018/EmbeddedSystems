import java.util.Comparator;

public class ComparatorZahlFarbe implements Comparator<Karte> {
    public int compare(Karte k1, Karte k2) {
        if (k1.getZahl().ordinal() == k2.getZahl().ordinal()) {
            // Gleiche Zahl: Die Farbe entscheidet, welche Karte die höhere ist.
            return k1.getFarbe().ordinal() - k2.getFarbe().ordinal();
        } else {
            // Unterschiedliche Zahlen: die höhere Zahl gewinnt.
            return k1.getZahl().ordinal() - k2.getZahl().ordinal();
        }
    }
}
