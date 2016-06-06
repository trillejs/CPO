package simulateur;

import java.util.Observable;

public abstract class Evenement extends Observable implements IEvenement{
	
	/** Date à laquelle l'évènement devra se produire */
	protected int tExec;
	/** Opération à executer lorsque l'évènement survient */
	protected IOperation operation;

	/**seProduire
     * Lance l'opération associé à l'évenement et notifie le simulateur
     *
     * @param simulateur - ISimulateur : Simulateur exécutant l'évènement
     */
	@Override
	public abstract void seProduire(ISimulateur simulateur);


	/**getTExec
	 * retourne l'attribut TExec de l'objet de type Evenement
	 *
	 * Date à laquelle l'évènement devra se produire
	 *
	 * @return int
	 */
	public int getTExec() {
		return tExec;
	}

	/**getOperation
     * retourne l'attribut operation de l'objet de type Evenement
     *
     * Opération à executer lorsque l'évènement survient
     *
     * @return IOperation
     */
	public IOperation getOperation() {
		return operation;
	}
}

