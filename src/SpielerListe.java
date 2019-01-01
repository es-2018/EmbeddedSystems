import java.util.ArrayList;
import java.util.Iterator;

public class SpielerListe implements Iterable<Spieler> {

    private class SpielerListeRingIterator implements Iterator<Spieler> {
        // Listenindex des Spielers, der dran ist.
        private int index = 0;

        // hasNext() ist true, solange noch mindestens 2 Spieler > 0 Handkarten haben.
        public boolean hasNext() {
            int count = 0;
            for (Spieler s : SpielerListe.this) {
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
                index = (index + 1) % SpielerListe.this.size();
                count++;
            } while (SpielerListe.this.get(index).anzahlHandkarten() == 0
                && count < SpielerListe.this.size());
            return SpielerListe.this.get(index);
        }
    }
    
    private ArrayList<Spieler> al;

    public SpielerListe() {
        al = new ArrayList<Spieler>();
    }

    /* Methoden "an ArrayList durchreichen" */

    public void add(Spieler s) {
        al.add(s);
    }

    public Spieler get(int i) {
        return al.get(i);
    }

    public String toString() {
        return al.toString();
    }

    public int size() {
        return al.size();
    }

    public boolean remove(Spieler s) {
        return al.remove(s);
    }

    public Spieler remove(int i) {
        return al.remove(i);
    }

    public Iterator<Spieler> iterator() {
        return al.iterator();
    }

    /* Spezifische Methoden */

    public Iterator<Spieler> ringIterator() {
        return new SpielerListeRingIterator();
    }
}