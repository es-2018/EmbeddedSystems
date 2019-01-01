import java.util.ArrayList;

public class SpielerVerhaltenBenutzer extends SpielerVerhalten {

    public SpielerVerhaltenBenutzer(KartenStapel ziehstapel, KartenStapel ablagestapel,
        ArrayList<KartenListe> spielfeld, KartenListe hand)
    {
    	super(ziehstapel, ablagestapel, spielfeld, hand);
    }

	public void ziehen() {

	}
	
	public void spielzugPruefen() {

	}

	public void auslegen() {
		// DEBUG: In 50% der Fälle eine Karte ablegen
	    if (new java.util.Random().nextInt(2) == 0) {
            hand.remove(0);
        }
	}

	public void anlegen() {

	}

	public void ablegen() {

	}

}