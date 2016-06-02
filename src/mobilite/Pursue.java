package mobilite;


import java.awt.Point;

import noeud.*;

public class Pursue implements ModeleDeMobilite {
	
	private Noeud cible;

    /**
     * Crée un modèle Pursue avec la cible qu'il va poursuivre
     * @param cible le noeud cible
     */
    public Pursue(Noeud cible) {
    	this.cible = cible;
    }

	@Override
	public Point seDeplacer() {
		// TODO Auto-generated method stub
		return null;
	}



}