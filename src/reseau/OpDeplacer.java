package reseau;

import simulateur.ISimulateur;

/**OpDeplacer
 * Operation executée par un évènement de déplacement
 * @author Florian Postic
 */
public class OpDeplacer extends OpAbstraite{

    /**OpDeplacer
     *
     * @param reseau - IReseau : Réseau sur lequel appliquer l'opération
     */
    public OpDeplacer(IReseau reseau) {
        super(reseau);
    }

    /**executer
     * Execute les intructions composant l'opération
     *
     * @param simulateur - Simulateur : Simulateur
     * @param date - int : Date d'execution de l'opération
     */
    @Override
    public void executer(ISimulateur simulateur, int date) {
        reseau.deplacerNoeuds();
    }
}
