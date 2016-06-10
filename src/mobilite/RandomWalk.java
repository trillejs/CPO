package mobilite;


import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
public class RandomWalk implements ModeleDeMobilite {

    /**
     * Intervalle de distance
     */
    protected int distance_debut;
    protected int distance_fin;

    /**
     * Intervalle de vitesse
     */
    protected double vitesse_debut;
    protected double vitesse_fin;
    
    /**
     * Position Courante
     */
    public Point2D.Double position;
    
    /**
     * Crée un RandomWalk à partir des intervalles donnés
     * @param dd début de l'intervalle de distance
     * @param df fin de l'intervalle de distance
     * @param vd début de l'intervalle de vitesse
     * @param vf fin de l'intervalle de vitesse
     */
    public RandomWalk(int dd, int df, int vd, int vf, Point2D.Double position) {
    	
    	//crée l'intervalle de distance
    	this.distance_debut = dd;
    	this.distance_fin = df;
    	
    	//crée l'intervalle de vitesse
    	this.vitesse_debut = vd;
    	this.vitesse_fin = vf;
    	
    	this.position = position;
    }

	/** seDeplacer
	 * déplace aléatoirement un noeud d'un pas dans le plan
	 * @return Point2D.Double le point 
	 * pré : rien 
	 * post : rien
	 */
    
	public Point2D.Double seDeplacer() {

		this.position.x = this.position.x + this.distance_debut + (int)(Math.random() * ((this.distance_fin - this.distance_debut) + 1))/this.vitesse_debut + (int)(Math.random() * ((this.vitesse_fin - this.vitesse_debut) + 1));
	
		this.position.y = this.position.y + this.distance_debut + (int)(Math.random() * ((this.distance_fin - this.distance_debut) + 1))/this.vitesse_debut + (int)(Math.random() * ((this.vitesse_fin - this.vitesse_debut) + 1));	
			
		return new Point2D.Double(this.position.x, this.position.y);
	}

	/** getPosition
	 * renvoie la position courante du noeud
	 * @return la position du noeud
	 */
	public Double getPosition() {
		return this.position;
	}
}