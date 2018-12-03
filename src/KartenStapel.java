import java.util.Collections;
import java.util.Stack;

public class KartenStapel {

    private Stack<Karte> stack;
    private boolean offen;

    public KartenStapel(boolean offen) {
        this.stack = new Stack<Karte>();
        this.offen = offen;
    }

    public void mischen() {
        Collections.shuffle(stack);
    }

    public void ablegen(Karte k) {
        stack.push(k);
    }

    public Karte ziehen() {
        return stack.pop();
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
