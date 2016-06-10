package mobilite;

import java.awt.geom.Point2D;

public class Deterministe implements ModeleDeMobilite {

	/** Vitesse de déplacement
	 */
	private double vitesse;
	
	/** Destination que le noeud veut atteindre
	 */
    private Point2D.Double destination;
    
    /** Position courante du noeud à déplacer
     */
    public Point2D.Double position;

    /**
     * Crée un modèle de mobilité déterministe à partie d'une vitesse et d'une destination
     * @param vitesse : double - vitesse de déplacement
     * @param destination : Point2D.Double - destination que le noeud veut atteindre
     * @param position_Courante : Point2D.Double - position courante du noeud à déplacer
     */
    public Deterministe(double vitesse, Point2D.Double destination, Point2D.Double position_Courante) {
    	
    	this.vitesse = vitesse;
    	this.destination = destination;
    	this.position = position_Courante;
    }
    
	/** seDeplacer
	 * Déplace un Noeud dans le plan selon les positions du modèle
	 * Pré : rien
	 * Post : rien
	 */

	public void seDeplacer() {
		if(this.position.x != this.destination.x){
			this.position.x = this.position.x + Math.cos(Math.atan(this.destination.y/this.destination.x))/this.vitesse;
		}
		if(this.position.y != this.destination.y){
			this.position.y = this.position.y + Math.sin(Math.atan(this.destination.y/this.destination.x))/this.vitesse;	
		}
	     }

	/** getPosition
	 * @return la position courante du noeud
	 */
	public Point2D.Double getPosition() {
		return this.position;
	}
}