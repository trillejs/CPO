package paquet;


import noeud.*;

public class RouteReply extends Paquet {

    /**
     * Default constructor
     */
    public RouteReply(AdresseIP source, AdresseIP destination, Chemin chemin) {
    	super(source, destination, chemin);
    }

}