package simulateur;

public abstract class Evenement implements IEvenement extends Observable{
	
	private int tExec; // Date à laquelle l'évènement devra se produire

	/**seProduire
	 * Lance l'opération associé à l'évenement et notifie le simulateur
	 *
	 * @param simulateur - ISimulateur : Simulateur exécutant l'évènement
	 */
	@Override
	public abstract void seProduire(ISimulateur simulateur);

	/**getDate
	 * @return date - Date : Date d'occurence de l'évenement
	 */
	public int getTExec() {
		return tExec;
	}
}

