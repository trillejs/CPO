package paquet;


import java.util.*;

import noeud.*;

/**
 * 
 */
public class RouteRequest extends Paquet {

	private Chemin routeReply;

	/**
	 * Constructeur dans le cas où le RouteRequest n'est pas en réponse à un RouteRequest
     * @param source AdresseIP du paquet source
     * @param destination AdresseIP du paquet destination
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
     * @param source AdresseIP du paquet source
     * @param destination AdresseIP du paquet destination
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

    private int identifiant;

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