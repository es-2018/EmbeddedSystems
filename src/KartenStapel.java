import java.util.Collections;
import java.util.Stack;

public class KartenStapel {

    private Stack<Karte> stack;
    private boolean offen;

    public KartenStapel(boolean offen) {
        this.stack = new Stack<Karte>();
        this.offen = offen;
    }

    public int size() {
        return stack.size();
    }

    public void mischen() {
        Collections.shuffle(stack);
    }

    public void ablegen(Karte k) {
        stack.push(k);
    }

    // Eine Karte ziehen
    public Karte ziehen() {
        return stack.pop();
    }

    // Mehrere Karten ziehen
    public KartenListe ziehen(int n) {
        KartenListe kl = new KartenListe();
        for (int i = 0; i < n; i++) {
            kl.add(ziehen());
        }
        return kl;
    }

    public Karte anschauen() {
        if (offen)
            return stack.peek();
        else
            throw new RuntimeException("Die oberste Karte dieses Stapels darf nicht angesehen werden.");
    }

    public boolean leer() {
        return stack.isEmpty();
    }

    public boolean istOffen() {
        return offen;
    }
}
