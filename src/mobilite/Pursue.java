package mobilite;



import java.awt.geom.Point2D;

import noeud.*;

public class Pursue implements ModeleDeMobilite {
	
	private Noeud cible;
	public Point2D.Double position;

    /**
     * Crée un modèle Pursue avec la cible qu'il va poursuivre
     * @param cible le noeud cible
     */
    public Pursue(Noeud cible, Point2D.Double position) {
    	this.cible = cible;
    	this.position = position;
    }

    /**seDeplacer
     * deplace le noeud suivant un noeud cible
     * @return Point2D.Double la position courante du noeud post-déplacement
     * pré : rien
     * post : rien
     */
    
	public Point2D.Double seDeplacer() {
		int vecteurAleatoire = (int)(Math.random() * ((90 - 2) + 1));
		
		if(this.position.x != this.cible.getPoint().x){
			
			this.position.x = this.position.x + Math.cos(Math.atan(this.cible.getPoint().y/this.cible.getPoint().x)) + vecteurAleatoire;
		}
		if(this.position.y != this.cible.getPoint().y){
			this.position.y = this.position.y + Math.sin(Math.atan(this.cible.getPoint().y/this.cible.getPoint().x)) + vecteurAleatoire;	
		}
		return new Point2D.Double(this.position.x, this.position.y);
	     }

	/**
	 * getPosition
	 * @return la position courante du noeud
	 */
	public Point2D.Double getPosition() {
		return this.position;
	}
}