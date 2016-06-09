package mobilite;


import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

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
     * 
     * @return 
     */
   	@Override
	public Point2D.Double seDeplacer() {
		
		if(this.position.x != this.cible.getPoint().x){
			this.position.x = this.position.x + Math.cos(Math.atan(this.cible.getPoint().y/this.cible.getPoint().x));
		}
		if(this.position.y != this.cible.getPoint().y){
			this.position.y = this.position.y + Math.sin(Math.atan(this.cible.getPoint().y/this.cible.getPoint().x));	
		}
		return new Point2D.Double(this.position.x, this.position.y);
	     }

	/**
	 * getPosition
	 * 
	 */
	public Point2D.Double getPosition() {
		return this.position;
	}
}