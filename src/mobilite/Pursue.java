package mobilite;


import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import noeud.*;

public class Pursue implements ModeleDeMobilite {
	
	private Point2D.Double cible;
	private Point2D.Double position;

    /**
     * Crée un modèle Pursue avec la cible qu'il va poursuivre
     * @param double1 le noeud cible
     */
    public Pursue(Point2D.Double double1, Point2D.Double position) {
    	this.cible = double1;
    	this.position = position;
    }

    
    /**seDeplacer
     * 
     * @return 
     */
   	@Override
	public Point2D.Double seDeplacer() {
		
		if(this.position.x != this.cible.x){
			this.position.x = this.position.x + Math.cos(Math.atan(this.cible.y/this.cible.x));
		}
		if(this.position.y != this.cible.y){
			this.position.y = this.position.y + Math.sin(Math.atan(this.cible.y/this.cible.x));	
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