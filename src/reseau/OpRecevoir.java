package reseau;

import paquet.Paquet;
import paquet.RouteError;
import paquet.RouteReply;
import paquet.RouteRequest;
import simulateur.IOperation;
import simulateur.ISimulateur;

/**OpRecevoir
 * @author Florian Postic
 */
public class OpRecevoir implements IOperation{

    /** Paquet en réception  */
    private Paquet paquet;

    /**OpRecevoir
     *
     * @param paquet - Paquet
     */
    public OpRecevoir(Paquet paquet) {
        this.paquet = paquet;
    }

    /**
     * executer
     * Execute les intructions composant l'opération
     *
     * @param simulateur - Simulateur : Simulateur
     * @param date       - int : Date d'execution de l'opération
     */
    @Override
    public void executer(ISimulateur simulateur, int date) {
        //le paquet est pour moi
        if(paquet.getDestination().equals(this.adresse))
        {
            if(paquet instanceof RouteRequest)
            {
                //C'est un RouteRequest
                //On enregistre le chemin pour créer le RouteReply
                //Vérifier la table de routage
                //Si on a un chemin vers la destination
                //On envoie un RouteReply
                //Sinon
                //On envoie un RouteRequest contenant le chemin de RouteReply

            }
            else if(paquet instanceof RouteReply)
            {
                //C'est un RouteReply
                //On enregistre le nouveau chemin dans la table de routage

            }
            else if(paquet instanceof RouteError)
            {
                //C'est un RouteError
                //On recherche tous les chemins qui contiennent le lien dans la table de routage
                //On supprime tous ces liens
            }
            else
            {
                //Le paquet est de la donnée

            }
        }
        else
        {
            if(paquet instanceof RouteRequest)
            {
                //C'est un RouteRequest
                //Ajouter mon adresse au chemin
                //Envoie le paquet RouteRequest avec le nouveau chemin  (TTL--)
                // Penser au délais aléatoire du route request

            }
            else if(paquet instanceof RouteReply)
            {
                //C'est un RouteReply
                //Envoie le paquet RouteReply (TTL--)

            }
            else if(paquet instanceof RouteError)
            {
                //C'est un RouteError
                //On recherche tous les chemins qui contiennent le lien dans la table de routage
                //On supprime tous ces liens
                //On envoie le paquet RouteError (TTL--)
            }
            else
            {
                //Le paquet est de la donnée
                //On envoie le paquet donnée (TTL--)

            }
        }
    }
}
