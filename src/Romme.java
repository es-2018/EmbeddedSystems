import java.util.ArrayList;
import java.util.Collections;

public class Romme {

    private KartenStapel ziehstapel;
    private KartenStapel ablagestapel;

    public Romme() {
        ziehstapel = new KartenStapel(false);
        ablagestapel = new KartenStapel(true);

        // Ziehstapel initialisieren
        for (int i = 0; i < 2; i++) {
            for (Karte.Farbe farbe : Karte.Farbe.values()) {
                for (Karte.Zahl zahl : Karte.Zahl.values()) {
                    ziehstapel.ablegen(new Karte(farbe, zahl));
                }
            }
        }

        // Ziehstapel mischen
        ziehstapel.mischen();

        // ... und wieder sortieren.
        ArrayList<Karte> al = new ArrayList<Karte>();
        while (!ziehstapel.leer()) {
            al.add(ziehstapel.ziehen());
        }
        Collections.sort(al);

        // Ausgabe
        System.out.println(al);
    }
}