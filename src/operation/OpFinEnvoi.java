package operation;

import paquet.Paquet;
import simulateur.Evenement;
import simulateur.IOperation;
import simulateur.ISimulateur;

/**OpFinEnvoi
 * @author Florian Postic
 */
public class OpFinEnvoi implements IOperation{

    private Paquet paquet;

    public OpFinEnvoi(Paquet paquet) {
        this.paquet = paquet;
    }

    /**executer
     * Execute les intructions composant l'opération
     *
     * @param simulateur - Simulateur : Simulateur
     * @param date - int : Date d'execution de l'opération
     */
    @Override
    public void executer(ISimulateur simulateur, int date) {
        simulateur.enregistrer(new Evenement(date, new OpRecevoir(paquet)));
    }
}