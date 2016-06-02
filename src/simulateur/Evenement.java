package simulateur;

import java.util.Date;
import java.util.Observable;

public abstract class Evenement implements IEvenement extends Observable{
	
	private Date date;//Date à laquelle l'évènement se produit

	/**seProduire
	 * Lance l'opération associé à l'évenement et notifie le simulateur
	 *
	 * @param simulateur - ISimulateur : Simulateur exécutant l'évènement
	 */
	@Override
	public void seProduire(ISimulateur simulateur) {

	}

	/**getDate
	 * @return date - Date : Date d'occurence de l'évenement
	 */
	public Date getDate() {
		return date;
	}
}

