import java.util.ArrayList;

public class Spieler {

    private SpielerVerhalten spielerVerhalten;
    private String name;
    private KartenListe hand;

    public Spieler(boolean benutzer, String name, KartenListe hand, KartenStapel ziehstapel,
        KartenStapel ablagestapel, ArrayList<KartenListe> spielfeld)
    {
        this.name = name;
        this.hand = hand;
        if (benutzer) {
            spielerVerhalten = new SpielerVerhaltenBenutzer(ziehstapel, ablagestapel, spielfeld, hand);
        } else {
            spielerVerhalten = new SpielerVerhaltenPC(ziehstapel, ablagestapel, spielfeld, hand);
        }
    }

    public String toString() {
        return name() + ": " + hand + " (" + hand.size() + ")";
    }

    public String name() {
        return name;
    }

    public void zug() {
        spielerVerhalten.zug();
    }

    public int anzahlHandkarten() {
        return hand.size();
    }

}