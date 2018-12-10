import java.util.Comparator;

public class ComparatorFarbeZahl implements Comparator<Karte> {
    public int compare(Karte k1, Karte k2) {
        return k1.compareTo(k2);
    }
}
