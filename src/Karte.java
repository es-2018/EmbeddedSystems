public class Karte implements Comparable<Karte> {

    public enum Farbe {
        KARO("♦"), HERZ("♥"), PIK("♠"), KREUZ("♧");

        private final String symbol;

        private Farbe (String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

        public String toString() {
            return symbol;
        }
    }

    public enum Zahl {
        ZWEI(2), DREI(3), VIER(4), FUENF(5), SECHS(6), SIEBEN(7), ACHT(8), NEUN(9), ZEHN(10),
        BUBE(10, "B"), DAME(10, "D"), KOENIG(10, "K"), ASS(11, "A");

        private final int wert;
        private final String symbol;

        private Zahl (int wert) {
            this.wert = wert;
            this.symbol = String.valueOf(wert);
        }

        private Zahl (int wert, String symbol) {
            this.wert = wert;
            this.symbol = symbol;
        }

        public int getWert() {
            return wert;
        }

        public String getSymbol() {
            return symbol;
        }

        public String toString() {
            return symbol;
        }
    }

    private Farbe farbe;
    private Zahl zahl;

    Karte(Farbe farbe, Zahl zahl) {
        this.farbe = farbe;
        this.zahl = zahl;
    }

    public Farbe getFarbe() {
        return farbe;
    }

    public Zahl getZahl() {
        return zahl;
    }

    public int getWert() {
        return zahl.getWert();
    }

    public String toString() {
        return farbe.toString() + zahl.toString();
    }

    // Implementiere Interface Comparable<Karte>
    @Override
    public int compareTo(Karte karte) {
        if (this.getFarbe().ordinal() == karte.getFarbe().ordinal()) {
            // Gleiche Farbe: Die Zahl entscheidet, welche Karte die höhere ist.
            return this.getZahl().ordinal() - karte.getZahl().ordinal();
        } else {
            // Unterschiedliche Farben: die höhere Farbe gewinnt.
            return this.getFarbe().ordinal() - karte.getFarbe().ordinal();
        }
    }
}