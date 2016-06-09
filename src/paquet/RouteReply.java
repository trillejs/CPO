package paquet;


import noeud.*;
import reseau.IOpVisiteur;

public class RouteReply extends Paquet {

	/** chemin parcouru par le RouteRequest pour atteindre la destination */
	private Chemin cheminReponse;
	
	/**
	 * Constructeur
     * @param source AdresseIP du noeud source
     * @param destination AdresseIP du noeud destination
     * @param chemin chemin à parcourir par le RouteReply pour atteindre la destination
     * @param cheminReponse chemin parcouru par le RouteRequest pour atteindre la destination
     * Précondition : source != null && destination != null && chemin != null && cheminReponse != null
	 */
    public RouteReply(AdresseIP source, AdresseIP destination, Chemin chemin, Chemin cheminReponse) {
    	super(source, destination, chemin);
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
