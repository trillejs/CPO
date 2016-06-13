package operation;

import noeud.AdresseIP;
import noeud.Chemin;
import noeud.INoeud;
import paquet.Paquet;
import paquet.RouteRequest;
import reseau.IReseau;
import simulateur.Evenement;
import simulateur.ISimulateur;

import java.util.ArrayList;
import java.util.List;
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

        Chemin destination = paquet.getChemin();
        /* Si le paquet ne définit pas de destination */
        if(destination == null) {
            /* Stocker le paquet dans la liste des paquets en attente*/
            reseau.getListeNoeuds().get(source).ajouterPaquet(paquet);
            /* Créer un nouveau route request */
            RouteRequest routeRequest = new RouteRequest(paquet.getSource(), paquet.getDestination(),null);
            /* Ajouter ce route request à la liste des route request en attente*/
            reseau.getListeNoeuds().get(source).ajouterRouteRequest(routeRequest);
            for (Map.Entry<AdresseIP, INoeud> entry:reseau.getListeNoeuds().entrySet()) {
                /* Le noeud est atteignable */
                if (reseau.atteignable(source, entry.getValue().getAdresseIP())) {
                    simulateur.enregistrer(new Evenement(simulateur.gettCourant() + (routeRequest.getTaille() * reseau.getListeNoeuds().get(source).getDebitEmission()), new OpFinEnvoi(routeRequest)));
                    //} else { // Le noeud n'est pas atteignable
                 /* Envoyer un message d'erreur */
                    // Non implementé
                    //}
                }
            }
        }else{
            /* Si le paquet définit une destination */
            List<AdresseIP> chemin = new ArrayList<AdresseIP>(destination.getListeNoeud().keySet());
            /*Le noeud est atteignable*/
            if(reseau.atteignable(source, chemin.get(0))){
                simulateur.enregistrer(new Evenement(simulateur.gettCourant() + paquet.getTaille() * reseau.getListeNoeuds().get(source).getDebitEmission(), new OpFinEnvoi(paquet)));
            }//else{ // Le noeud n'est pas atteignable
            /* Envoyer message d'erreur */
            // Non implementé
            //}
        }
    }
}



/* Analyse du paquet
*
* */

