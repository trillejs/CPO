package operation;

import noeud.Chemin;
import noeud.INoeud;
import paquet.*;
import reseau.IReseau;
import simulateur.Evenement;
import simulateur.IEvenement;
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
    public OpRecevoir(Paquet paquet, INoeud noeud, IReseau reseau) {
        this.paquet = paquet;
        this.noeud = noeud;
        this.reseau = reseau;
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


    @Override
    public void traiter(RouteRequest routeRequest){

        // On enregistre le chemin pour créer le RouteReply
        Chemin routeSource = routeRequest.getChemin();
        // On calcule le délais de traitement du RouteRequest
        // H*((h-1)+r)
        Random rand = new Random();
        double delaisTraitement = H * ((routeSource.getNombreSaut() - 1) + rand.nextDouble());

        if(routeRequest.getDestination().equals(noeud)){ // Le paquet est pour moi
            /* Si le routeRequest contient un routeReply dans la donnée*/
            if(routeRequest.getRouteReply() != null){
                /* Ajouter le route replay à la table de routage */
                noeud.ajouterRoute(routeRequest.getRouteReply());
            }
            // Vérifier la table de routage
            Chemin routeTable = noeud.getRoute(routeRequest.getSource());
            if(routeTable != null) {// Si on a un chemin vers la destination
                // On envoie un RouteReply
                RouteReply routeReply = new RouteReply(noeud.getAdresseIP(), //Source
                        routeTable, // CheminDestination
                        routeSource); // Résultat du routeRequest
                IEvenement reponseRouteReply = new Evenement(
                        simulateur.gettCourant()+(int)Math.round(delaisTraitement),
                        new OpEnvoyer(reseau, noeud.getAdresseIP(), routeReply));
                simulateur.enregistrer(reponseRouteReply);
            }else { // Sinon
                // On envoie un RouteRequest contenant le chemin de RouteReply
                RouteRequest paquetRouteRequest = new RouteRequest(noeud.getAdresseIP(),
                        routeRequest.getSource(),
                        routeSource);
                simulateur.enregistrer(new Evenement(
                        simulateur.gettCourant()+(int)Math.round(delaisTraitement),
                        new OpEnvoyer(reseau, noeud.getAdresseIP(), paquetRouteRequest)));
            }

        }else{ // Le paquet n'est pas pour moi
            /* Ajouter le noeud courant au chemin par la source */
            routeRequest.ajouterEtape(noeud);
            /* Décrémenter le TTL */
            routeRequest.decrementerTTL();
            /* Si le TTL n'est pas égal à 0 */
            if(routeRequest.getTTL()!=0) {
                simulateur.enregistrer(new Evenement(
                        simulateur.gettCourant() + (int) Math.round(delaisTraitement),
                        new OpEnvoyer(reseau, noeud.getAdresseIP(), routeRequest)));
            }
        }
    }

    public void traiter(RouteReply routeReply){
        if(routeReply.getDestination().equals(noeud)){ // Le paquet est pour moi
            noeud.ajouterRoute(routeReply.getRouteReply());
        }else{ // Le paquet n'est pas pour moi
            routeReply.incCurseur();
            simulateur.enregistrer(new Evenement(simulateur.gettCourant(),
                       new OpEnvoyer(reseau, noeud.getAdresseIP(), routeReply)));
        }
    }
    public void traiter(RouteError routeError){
        if(routeError.getDestination().equals(noeud)){ // Le paquet est pour moi
            /* On supprimme tous les liens dans la table de routage qui contienent
            le lien en erreur*/
            noeud.supprimerLienRompu(routeError.getNoeud1(), routeError.getNoeud2());
        }
    }
    public void traiter(Donnee donnee){
        if(donnee.getDestination().equals(noeud)){ // Le paquet est pour moi
            noeud.ajouterMessage((String)donnee.getDonne());
        }else{ // Le paquet n'est pas pour moi
            donnee.incCurseur();
            simulateur.enregistrer(new Evenement(simulateur.gettCourant(),
                    new OpEnvoyer(reseau, noeud.getAdresseIP(), donnee)));
        }
    }
}
