package reseau;

import simulateur.IOperation;
import simulateur.Simulateur;

/**OpDeplacer
 * Operation executée par l'evenement EvDeplacer
 * @author Florian Postic
 */
public class OpDeplacer implements IOperation{

    /** Réseau sur lequel appliquer le déplacement  */
    private IReseau reseau;

    /**
     * Constructor OpDeplacer creates a new OpDeplacer instance.
     *
     * @param reseau - Reseau : Réseau sur lequel appliquer le déplacement
     */
    public OpDeplacer(IReseau reseau) {
        this.reseau = reseau;
    }

    /**executer
     * Execute les intructions composant l'opération
     * @param simulateur - Simulateur : Simulateur
     * @param date - int : Date d'execution de l'opération
     */
    @Override
    public void executer(Simulateur simulateur, int date) {
        reseau.deplacerNoeuds();
    }
}
