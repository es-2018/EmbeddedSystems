import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

public class KartenListe implements Iterable<Karte> {
    private ArrayList<Karte> al;

    public KartenListe() {
        al = new ArrayList<Karte>();
    }

    /* Methoden "an ArrayList durchreichen" */

    public void add(Karte k) {
        al.add(k);
    }

    public Karte get(int i) {
        return al.get(i);
    }

    public String toString() {
        return al.toString();
    }

    public int size() {
        return al.size();
    }
    
    public boolean remove(Karte s) {
        return al.remove(s);
    }

    public Karte remove(int i) {
        return al.remove(i);
    }

    public Iterator<Karte> iterator() {
        return al.iterator();
    }

    /* Spezifische Methoden */

    public void tausche(int i, int j) {
        if (i < size() && j < size()) {
            Karte tmp = get(i);
            al.set(i, get(j));
            al.set(j, tmp);
        }
    }    

    public void sortierenNachFarbe() {
        Collections.sort(al, new ComparatorFarbeZahl());
    }

    public void sortierenNachZahl() {
        Collections.sort(al, new ComparatorZahlFarbe());
    }
}
