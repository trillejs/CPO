package paquet;

import noeud.*;

public class RouteRequest extends Paquet {

	/** chemin emprunté par le routeRequest */
	private Chemin routeReply;
	
	/** identifiant du Route Request */
    private int identifiant;

	/**
	 * Constructeur dans le cas où le RouteRequest n'est pas en réponse à un RouteRequest
     * @param source AdresseIP du noeud source
     * @param destination AdresseIP du noeud destination
     * @param chemin chemin parcouru par le RouteRequest pour le moment
	 * @param identifiant du Route Request
     * Précondition : 0 < identifiant < 255 && source != null && destination != null && chemin != null && routeReply != null
	 */
    public RouteRequest(AdresseIP source, AdresseIP destination, Chemin chemin, int identifiant) {
    	super(source, destination, chemin);
    	this.routeReply = null;
    	this.identifiant = identifiant;
    }

    /**
     * Constructeur dans le cas où le RouteRequest est en réponse à un RouteRequest
     * @param source AdresseIP du noeud source
     * @param destination AdresseIP du noeud destination
     * @param chemin chemin parcouru par le RouteRequest pour le moment
     * @param routeReply chemin emprunté par le routeRequest
     * @param identifiant du Route Request
     * Précondition : 0 < identifiant < 255 && source != null && destination != null && chemin != null && routeReply != null
     */
    public RouteRequest(AdresseIP source, AdresseIP destination, Chemin chemin, Chemin routeReply, int identifiant)
    {
    	super(source, destination, chemin);
    	this.routeReply = routeReply;
    	this.identifiant = identifiant;    	
    }

    /**
     * Retourne l'identifiant de la demande de route
     * @return
     */
    public int getIdentifiant()
    {
    	return this.identifiant;
    }
    
	@Override
	public int getTaille() {
		int taille = super.getTaille();
		taille+=this.routeReply.getTaille();
		taille += 1; //On ajoute la taille de l'identifiant
		return taille;
	}


}