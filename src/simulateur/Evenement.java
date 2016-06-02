package simulateur;

import java.util.Date;
import java.util.Observable;

public abstract class Evenement extends Observable{
	
	private Date occurence;//Date à laquelle l'évènement se produit
	
	/**seProduire
	 * Notifie le simulateur que l'évènement s'est produit
	 * @param s - Simulateur : le simulateur à notifier
	 */
	public void seProduire(Simulateur s){
		notifyObservers();
	}
}
