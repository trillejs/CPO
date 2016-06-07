package paquet;


import noeud.*;

public class RouteReply extends Paquet {

	private Chemin cheminReponse;
	
	/**
	 * Constructeur
     * @param source AdresseIP du paquet source
     * @param destination AdresseIP du paquet destination
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
}