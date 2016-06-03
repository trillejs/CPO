package mobilite;


import java.awt.geom.Point2D;

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
	public Point2D.Double seDeplacer() {
		// TODO Auto-generated method stub
		return null;
	}



}