package paquet;

import noeud.*;
import reseau.IOpVisiteur;

import java.util.Random;

public class RouteRequest extends Paquet {

	/** noeud que l'on cerche à atteindre */
    private AdresseIP destination;

	/** chemin emprunté par le routeRequest précédent */
	private Chemin routeReply;
	
	/** identifiant du Route Request */
    private int identifiant;

	/**
	 * Constructeur dans le cas où le RouteRequest n'est pas en réponse à un RouteRequest
     * @param source AdresseIP du noeud source
     * @param destination AdresseIP du noeud destination
     * @param cheminDestination chemin parcouru par le RouteRequest pour le moment
     * Précondition : source != null && destination != null && chemin != null && routeReply != null
	 */
    public RouteRequest(AdresseIP source, AdresseIP destination, Chemin cheminDestination) {
    	super(source, cheminDestination);
    	this.routeReply = null;
		Random rand = new Random();
		identifiant = rand.nextInt();
    }

    /**
     * Constructeur dans le cas où le RouteRequest est en réponse à un RouteRequest
     * @param source AdresseIP du noeud source
     * @param destination AdresseIP du noeud destination
     * @param cheminDestination chemin parcouru par le RouteRequest pour le moment
     * @param routeReply chemin emprunté par le routeRequest
     * Précondition : source != null && destination != null && chemin != null && routeReply != null
     */
    public RouteRequest(AdresseIP source, AdresseIP destination, Chemin cheminDestination, Chemin routeReply)
    {
    	super(source, cheminDestination);

    	this.routeReply = routeReply;
		Random rand = new Random();
		identifiant = rand.nextInt();
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

	/**
	 * Retourne l'adresse IP destination du paquet
	 *
	 * @return
	 */
	@Override
	public AdresseIP getDestination() {
		return this.destination;
	}

	@Override
	public void accepter(IOpVisiteur iOpVisiteur) {
		iOpVisiteur.traiter(this);
	}
}