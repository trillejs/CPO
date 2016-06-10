package paquet;


import noeud.*;
import operation.IOpVisiteur;

public class RouteReply extends Paquet {

	/** chemin parcouru par le RouteRequest pour atteindre la destination */
	private Chemin routeReply;
	
	/**
	 * Constructeur
     * @param source AdresseIP du noeud source
     * @param destination Chemin vers le noeud destination
     * @param cheminReponse chemin parcouru par le RouteRequest pour atteindre la destination
     * Précondition : source != null && destination != null && cheminReponse != null
	 */
    public RouteReply(AdresseIP source, Chemin destination, Chemin cheminReponse) {
    	super(source, destination);
    	this.routeReply = cheminReponse;
    }

    /**getRouteReply
     * Retourne le chemin utilisé par le RouteRequest pour arriver jusqu'au noeud cible
     * @return
     */
    public Chemin getRouteReply()
    {
    	return this.routeReply;
    }

	@Override
	public void accepter(IOpVisiteur iOpVisiteur) {
		iOpVisiteur.traiter(this);
	}
}
