package paquet;


import noeud.*;
import reseau.IOpVisiteur;

public class RouteReply extends Paquet {

	/** chemin parcouru par le RouteRequest pour atteindre la destination */
	private Chemin cheminReponse;
	
	/**
	 * Constructeur
     * @param source AdresseIP du noeud source
     * @param destination Chemin vers le noeud destination
     * @param cheminReponse chemin parcouru par le RouteRequest pour atteindre la destination
     * Précondition : source != null && destination != null && cheminReponse != null
	 */
    public RouteReply(AdresseIP source, Chemin destination, Chemin cheminReponse) {
    	super(source, destination);
    	this.cheminReponse = cheminReponse;
    }

    /**
     * Retourne le chemin utilisé par le RouteRequest pour arriver jusqu'au noeud cible
     * @return
     */
    public Chemin getCheminReponse()
    {
    	return this.cheminReponse;
    }

	@Override
	public void accepter(IOpVisiteur iOpVisiteur) {
		iOpVisiteur.traiter(this);
	}
}
