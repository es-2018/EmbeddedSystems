import java.util.ArrayList;
import java.util.Iterator;

public class Romme {

    private KartenStapel ziehstapel;
    private KartenStapel ablagestapel;
    private ArrayList<KartenListe> spielfeld;
    private ArrayList<Spieler> spielerListe;
    private Spieler aktuellerSpieler;

    public Romme() {
        neueRunde();
    }

    private void neueRunde() {
        // Stapel und Listen neu initialisieren
        ziehstapel = new KartenStapel(false);
        ablagestapel = new KartenStapel(true);
        spielfeld = new ArrayList<KartenListe>();
        spielerListe = new ArrayList<Spieler>();

        // DEBUG: Liste der Mitspieler
        // TODO: Kommandozeilen-Eingabe
        String[] namen = {"Alice", "Bob", "Carol"};

        // Wie viele "Kartenspiele" brauchen wir? Nimm mindestens 2.
        int anzahlKartenInEinemKartenspiel = Karte.Farbe.values().length * Karte.Zahl.values().length;
        int benoetigteKarten = (namen.length * 13) + 10; // 13 Handkarten pro Spieler und ein bisschen Puffer zum Ziehen
        int benoetigteKartenspiele = Math.max(2, (int) Math.ceil((double)benoetigteKarten / (double)anzahlKartenInEinemKartenspiel));

        // Ziehstapel initialisieren
        for (int i = 0; i < benoetigteKartenspiele; i++) {
            for (Karte.Farbe farbe : Karte.Farbe.values()) {
                for (Karte.Zahl zahl : Karte.Zahl.values()) {
                    ziehstapel.ablegen(new Karte(farbe, zahl));
                }
            }
        }
        // Ziehstapel mischen
        ziehstapel.mischen();

        // Spieler erzeugen und jeweils 13 Karten austeilen
        for (String name : namen) {
            spielerListe.add(new Spieler(true, name, ziehstapel.ziehen(13), ziehstapel, ablagestapel, spielfeld));
        }

        // Eine Karte umdrehen
        ablagestapel.ablegen(ziehstapel.ziehen());

        // So lange die Spieler nacheinander ziehen lassen,
        // bis nur noch einer übrig ist (der Ring-Iterator stoppt, wenn nur noch 1 übrig ist)
        Iterator<Spieler> it = new SpielRingIterator(spielerListe);
        while(it.hasNext()) {
            Spieler s = it.next();
            System.out.println(s.name() + " ist dran.");
            System.out.println("Hand vorher:  " + s);

            // Spieler einen Zug machen lassen
            s.zug();

            System.out.println("Hand nachher: " + s);

            // Falls der Ziehstapel leer ist, den Ablagestapel in den Ziehstapel
            // umschichten und mischen.
            if (ziehstapel.leer()) {
                System.out.println("Keine Karten mehr. Mische den Ablagestapel.");
                ziehstapelErneuern();
            }
        }
    }

    private void ziehstapelErneuern() {
        // Oberste Karte vom Ablagestapel beiseitelegen
        Karte obersteKarteAblagestapel = ablagestapel.ziehen();
        // Alle übrigen Karten vom Ablagestapel auf den Ziehstapel umschichten
        while (!ablagestapel.leer()) {
            ziehstapel.ablegen(ablagestapel.ziehen());
        }
        // oberste Karte vom Ablagestapel wieder zurücklegen
        ablagestapel.ablegen(obersteKarteAblagestapel);
        // Ziehstapel mischen
        ziehstapel.mischen();
        System.out.println("Auf dem Ziehstapel sind jetzt wieder " + ziehstapel.size() + " Karten.");
    }
}