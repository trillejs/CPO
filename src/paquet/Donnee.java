package paquet;

import noeud.*;
import operation.IOpVisiteur;

public class Donnee extends Paquet {
	
	/** donnees a transmettre */
	private Object donnee; 

    /**
     * Constructeur du paquet de donnees
     * @param source AdresseIP du noeud source
     * @param destination chemin a parcourir depuis la source pour atteindre la destination
     * @param object donnees a transmettre
     * Précondition : source != null && destination != null && chemin != null && object != null
     */
	public Donnee(AdresseIP source, Chemin destination, Object object) {
		super(source, destination);
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

	@Override
	public void accepter(IOpVisiteur iOpVisiteur) {
		iOpVisiteur.traiter(this);
	}
}
