import java.util.ArrayList;

public abstract class SpielerVerhalten {

    KartenStapel ziehstapel;
    KartenStapel ablagestapel;
    ArrayList<KartenListe> spielfeld;
    KartenListe hand;

    public abstract void ziehen();
    public abstract void spielzugPruefen();
    public abstract void auslegen();
    public abstract void anlegen();
    public abstract void ablegen();

    public SpielerVerhalten(KartenStapel ziehstapel, KartenStapel ablagestapel,
        ArrayList<KartenListe> spielfeld, KartenListe hand)
    {
        this.ziehstapel = ziehstapel;
        this.ablagestapel = ablagestapel;
        this.spielfeld = spielfeld;
        this.hand = hand;
    }

    public void zug(){
        ziehen();
        spielzugPruefen();
        auslegen();
        anlegen();
        ablegen();  
    }
}