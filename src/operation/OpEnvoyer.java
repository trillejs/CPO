package operation;

import noeud.AdresseIP;
import noeud.INoeud;
import paquet.Paquet;
import reseau.IReseau;
import simulateur.Evenement;
import simulateur.ISimulateur;

import java.util.Map;

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
    public OpEnvoyer(IReseau reseau, AdresseIP source, Paquet paquet) {
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
        for (Map.Entry<AdresseIP, INoeud> entry:reseau.getListeNoeuds().entrySet())
        {
            if(reseau.atteignable(source, entry.getValue().getAdresseIP())){
                simulateur.enregistrer(new Evenement(simulateur.gettCourant()+(paquet.getTaille()*reseau.getListeNoeuds().get(source).getDebitEmission()),new OpFinEvoi(paquet)));
            }
        }
    }
}
