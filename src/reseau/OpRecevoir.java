package reseau;

import noeud.Chemin;
import noeud.INoeud;
import paquet.*;
import simulateur.Evenement;
import simulateur.IEvenement;
import simulateur.IOperation;
import simulateur.ISimulateur;

import java.util.Random;

/**OpRecevoir
 * @author Florian Postic
 */
public class OpRecevoir implements IOpVisiteur{

    /** Paquet en réception  */
    private Paquet paquet;

    /** Noeud en réception */
    private INoeud noeud;

    /** Réseau sur lequel envoyer les paquets de réponse */
    private IReseau reseau;

    /** Multiplicateur constant pour le délais de traitement des RouteRequest */
    private static final double H = 1.0;

    /** Simulateur dans lequel enregistrer les nouveaux évènements */
    private ISimulateur simulateur;

    /**OpRecevoir
     *
     * @param paquet - Paquet
     */
    public OpRecevoir(Paquet paquet) {
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
        this.simulateur = simulateur;
        paquet.accepter(this);
        //le paquet est pour moi
       /* if(paquet.getDestination().equals(noeud))
        {

            if(paquet instanceof RouteRequest)
            {
                Random rand = new Random();
                // C'est un RouteRequest

                // On enregistre le chemin pour créer le RouteReply
                Chemin routeSource = paquet.getChemin();
                // On calcule le délais de traitement du RouteRequest
                // H*((h-1)+r)
                double delaisTraitement = H * ((routeSource.getNombreSaut() - 1) + rand.nextDouble());

                // Vérifier la table de routage
                Chemin routeTable = noeud.getRoute(paquet.getSource());
                if(routeTable != null) {// Si on a un chemin vers la destination
                    // On envoie un RouteReply
                    RouteReply routeReply = new RouteReply(noeud.getAdresseIP(),
                            paquet.getSource(),
                            routeTable,
                            routeSource);
                    IEvenement reponseRouteReply = new Evenement(
                            simulateur.gettCourant()+(int)Math.round(delaisTraitement),
                            new OpEnvoyer(reseau, noeud.getAdresseIP(), routeReply));
                    simulateur.enregistrer(reponseRouteReply);
                }else { // Sinon
                    // On envoie un RouteRequest contenant le chemin de RouteReply
                }
            }
            else if(paquet instanceof RouteReply)
            {
                // C'est un RouteReply
                // On enregistre le nouveau chemin dans la table de routage
            }
            else if(paquet instanceof RouteError)
            {
                // C'est un RouteError
                // On recherche tous les chemins qui contiennent le lien dans la table de routage
                // On supprime tous ces liens
            }
            else
            {
                // Le paquet est de la donnée

            }
        }
        else
        {
            if(paquet instanceof RouteRequest)
            {
                // C'est un RouteRequest
                // Ajouter mon adresse au chemin
                // Envoie le paquet RouteRequest avec le nouveau chemin  (TTL--)
                // Penser au délais aléatoire du route request

            }
            else if(paquet instanceof RouteReply)
            {
                // C'est un RouteReply
                // Envoie le paquet RouteReply (TTL--)

            }
            else if(paquet instanceof RouteError)
            {
                // C'est un RouteError
                // On recherche tous les chemins qui contiennent le lien dans la table de routage
                // On supprime tous ces liens
                // On envoie le paquet RouteError (TTL--)
            }
            else
            {
                // Le paquet est de la donnée
                // On envoie le paquet donnée (TTL--)

            }*/
        }
    }

    public void traiter(RouteRequest routeRequest){
        if(routeRequest.getDestination().equals(noeud)){ // Le paquet est pour moi
            Random rand = new Random();

            // On enregistre le chemin pour créer le RouteReply
            Chemin routeSource = routeRequest.getChemin();
            // On calcule le délais de traitement du RouteRequest
            // H*((h-1)+r)
            double delaisTraitement = H * ((routeSource.getNombreSaut() - 1) + rand.nextDouble());

            // Vérifier la table de routage
            Chemin routeTable = noeud.getRoute(routeRequest.getSource());
            if(routeTable != null) {// Si on a un chemin vers la destination
                // On envoie un RouteReply
                RouteReply routeReply = new RouteReply(noeud.getAdresseIP(),
                        routeRequest.getSource(),
                        routeTable,
                        routeSource);
                IEvenement reponseRouteReply = new Evenement(
                        simulateur.gettCourant()+(int)Math.round(delaisTraitement),
                        new OpEnvoyer(reseau, noeud.getAdresseIP(), routeReply));
                simulateur.enregistrer(reponseRouteReply);
            }else { // Sinon
                // On envoie un RouteRequest contenant le chemin de RouteReply
                RouteRequest paquetRouteRequest = new RouteRequest(noeud.getAdresseIP(),
                        routeRequest.getSource(),
                        routeSource);
        }else{ // Le paquet n'est pas pour moi

        }
    }
    public void traiter(RouteReply routeReply){
        if(paquet.getDestination().equals(noeud)){ // Le paquet est pour moi

        }else{ // Le paquet n'est pas pour moi

        }
    }
    public void traiter(RouteError routeError){
        if(paquet.getDestination().equals(noeud)){ // Le paquet est pour moi

        }else{ // Le paquet n'est pas pour moi

        }
    }
    public void traiter(Donnee donnee){
        if(paquet.getDestination().equals(noeud)){ // Le paquet est pour moi

        }else{ // Le paquet n'est pas pour moi

        }
    }
}
