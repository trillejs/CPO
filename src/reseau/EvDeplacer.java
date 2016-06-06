package reseau;

import simulateur.Evenement;
import simulateur.IOperation;
import simulateur.ISimulateur;

/**EvDeplacer
 *
 * Evènement qui provoque le déplacement de tous les noeuds du réseau
 * @author Florian Postic
 */
public class EvDeplacer extends Evenement{

    public EvDeplacer(int tExec, IOperation operation) {
        this.tExec = tExec;
        this.operation = operation;
    }

    /**seProduire
     * Lance l'opération associé à l'évenement et notifie le simulateur
     *
     * @param simulateur - ISimulateur : Simulateur exécutant l'évènement
     */
    @Override
    public void seProduire(ISimulateur simulateur) {
        operation.executer(simulateur, tExec);
    }
}
