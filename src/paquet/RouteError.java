package paquet;

import noeud.*;

public class RouteError extends Paquet {

    /**
     * Default constructor
     */
    public RouteError(AdresseIP source, AdresseIP destination, Chemin chemin) {
    	super(source, destination, chemin);
    }

    /**
     * 
     */
    public Noeud noeudIndisponible1;

    /**
     * 
     */
    public Noeud noeudIndisponible2;

}