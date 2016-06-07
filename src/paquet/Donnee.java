package paquet;

import noeud.*;

public class Donnee extends Paquet {
	
	/** donnees a transmettre */
	private Object donnee; 

    /**
     * Constructeur du paquet de donnees
     * @param source AdresseIP du noeud source
     * @param destination AdresseIP du noeud destination
     * @param chemin chemin a parcourir depuis la source pour atteindre la destination
     * @param object donnees a transmettre
     * Précondition : source != null && destination != null && chemin != null && object != null
     */
	public Donnee(AdresseIP source, AdresseIP destination, Chemin chemin, Object object) {
		super(source, destination, chemin);
		this.donnee = object;
	}

	/**
	 * Retourne les données du paquet
	 * @return donnee
	 */
	public Object getDonne()
	{
		return this.donnee;
	}
}
