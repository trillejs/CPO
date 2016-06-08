package simulateur;

import java.util.Observable;

/**Evenement
 * Evenement générique, la spécialisation se fait par l'attribut opération
 * @author Florian Postic
 */
public class Evenement extends Observable implements IEvenement{
	
	/** Date à laquelle l'évènement devra se produire */
	protected int tExec;
	/** Opération à executer lorsque l'évènement survient */
	protected IOperation operation;

	/**Evenement
	 *
	 * @param tExec - int : Date à laquelle l'évènement devra se produire
	 * @param operation - IOperation : Opération à executer lorsque l'évènement survient
	 */
	public Evenement(int tExec, IOperation operation) {
		this.tExec = tExec;
		this.operation = operation;
	}

	/**seProduire
     * Lance l'opération associé à l'évenement et notifie le simulateur
     *
     * @param simulateur - ISimulateur : Simulateur exécutant l'évènement
     */
	@Override
	public void seProduire(ISimulateur simulateur){
		operation.executer(simulateur, tExec);
	}


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

