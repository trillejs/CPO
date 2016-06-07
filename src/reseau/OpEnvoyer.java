package reseau;

import noeud.AdresseIP;
import noeud.INoeud;
import paquet.Paquet;
import simulateur.Evenement;
import simulateur.ISimulateur;

/**OpEnvoyer
 * Opération executée par l'évènement EvDéplacer
 * @author Florian Postic
 */
public class OpEnvoyer extends OpAbstraite{

    /** Source de l'envoi de paquet */
    private AdresseIP source;
    /** Contenu du paquet à transmettre */
    private Paquet paquet;

    /**OpEnvoyer
     *
     * @param reseau - IReseau : Réseau sur lequel appliquer l'opération
     */
    public OpEnvoyer(IReseau reseau, AdresseIP source, AdresseIP destination, Paquet paquet) {
        super(reseau);
        this.source = source;
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
        for (INoeud n:reseau.getListNoeuds())
        {
            if(reseau.atteignable(source, n.getAdresseIP())){
                simulateur.enregistrer(new Evenement(simulateur.gettCourant()+paquet.getTaille(),new OpFinEvoi()));
            }
        }
    }
}
