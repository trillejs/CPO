package mobilite;

import java.awt.geom.Point2D;
import java.util.Random;

import noeud.*;

public class Pursue implements ModeleDeMobilite {
	
	/** 
	 * Le Noeud que le noeud doit suivre
	 */
	
	private Noeud cible;
	
    /** Position courante du noeud à déplacer
     */
	
    public Point2D.Double position;;

    /**
     * Crée un modèle Pursue avec la cible qu'il va poursuivre
     * @param cible : noeud - le noeud cible
     */
    
    public Pursue(Noeud cible, Point2D.Double position) {
    	this.cible = cible;
    	this.position = position;
    }

    /**
     * seDeplacer
     * deplace le noeud suivant un noeud cible
     * @return Point2D.Double la position courante du noeud post-déplacement
     * pré : rien
     * post : rien
     */
    
	public void seDeplacer() {
		
		Random Rand = new Random();
		int n = 10 - 2 + 1;
		int i = Rand.nextInt() % n;
		int vecteurAleatoire = 2 + i;
		
		if(this.position.x != this.cible.getPoint().x){
			
			this.position.x = this.position.x + Math.cos(Math.atan(this.cible.getPoint().y/this.cible.getPoint().x)) + vecteurAleatoire;
		}
		if(this.position.y != this.cible.getPoint().y){
			this.position.y = this.position.y + Math.sin(Math.atan(this.cible.getPoint().y/this.cible.getPoint().x)) + vecteurAleatoire;	
		}
		//Cas de dépassements
		if(this.position.x > this.cible.getPoint().x){
			this.position.x =  this.cible.getPoint().x;
		}

		if(this.position.y > this.cible.getPoint().y){
			this.position.y =  this.cible.getPoint().y;
		}
	     }

	/**
	 * getPosition
	 * @return la position courante du noeud
	 */
	public Point2D.Double getPosition() {
		return this.position;
	}
	
	/** getCible
	 * @return la cible que suit le noeud
	 */
	public Noeud getCible(){
		return this.cible;
	}
}