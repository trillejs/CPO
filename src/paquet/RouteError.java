package paquet;

import noeud.*;

public class RouteError extends Paquet {
	
	/** adresse du noeud qui n'arrive pas à atteindre le suivant */
    private final AdresseIP noeudIndisponible1;
    
    /** adresse du noeud qui n'est pas atteint par le précédent*/
    private final AdresseIP noeudIndisponible2;

    
	/**
	 * Constructeur
     * @param source AdresseIP du paquet source
     * @param destination AdresseIP du paquet destination
     * @param chemin chemin parcouru par le RouteError pour le moment
	 * @param noeud1 le noeud qui n'arrive pas à atteindre le suivant
	 * @param noeud2 le noeud qui n'est pas atteint par le précédent
     * Précondition : source != null && destination != null && chemin != null && noeud1 != null && noeud2 != null
	 */
    public RouteError(AdresseIP source, AdresseIP destination, Chemin chemin, AdresseIP noeud1, AdresseIP noeud2) {
    	super(source, destination, chemin);
    	this.noeudIndisponible1 = noeud1;
    	this.noeudIndisponible2 = noeud2;
    }


	@Override
	public int getTaille() {
		int taille = super.getTaille();
		taille += this.noeudIndisponible1.getTaille();
		taille += this.noeudIndisponible2.getTaille();
		return taille;
	}
	
	/**
	 * adresse du noeud qui n'arrive pas à atteindre le suivant
	 * @return adresse du noeud source
	 */
	public AdresseIP getNoeud1()
	{
		return this.noeudIndisponible1;
	}
	
	/**
	 * adresse du noeud qui n'est pas atteint par le précédent
	 * @return adresse du noeud destination
	 */
	public AdresseIP getNoeud2()
	{
		return this.noeudIndisponible2;
	}

}