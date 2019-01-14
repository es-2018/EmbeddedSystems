import java.util.ArrayList;
import java.util.Iterator;

public class SpielRingIterator implements Iterator<Spieler> {
    private ArrayList<Spieler> list;
    // Listenindex des Spielers, der dran ist.
    private int index = 0;

    public SpielRingIterator(ArrayList<Spieler> list) {
        this.list = list;
    }
    

    // hasNext() ist true, solange noch mindestens 2 Spieler > 0 Handkarten haben.
    public boolean hasNext() {
        int count = 0;
        for (Spieler s : list) {
            if (s.anzahlHandkarten() > 0) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    // next() gibt den nächsten Spieler in der durch die Liste gegebenen 
    // Spieler-Reihenfolge zurück, der noch > 0 Handkarten hat.
    // Am Ende der Liste beginne wieder von vorn ("Ring").
    public Spieler next() {
        // Gehe maximal size() Schritte, um Endlosschleife zu vermeiden.
        // count zählt die Schritte.
        int count = 0;
        do {
            index = (index + 1) % list.size();
            count++;
        } while (list.get(index).anzahlHandkarten() == 0
            && count < list.size());
        return list.get(index);
    }
}