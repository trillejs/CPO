package simulateur;

import java.util.Date;
import java.util.Observable;

public abstract class Evenement implements IEvenement extends Observable{
	
	private Date occurence;//Date à laquelle l'évènement se produit

	/**
	 * seProduire
	 * Lance l'opération associé à l'évenement et notifie le simulateur
	 *
	 * @param simulateur - ISimulateur : Simulateur executant l'évènement
	 */
	@Override
	public void seProduire(ISimulateur simulateur) {

	}
}

