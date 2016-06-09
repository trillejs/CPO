package mobilite;


import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Deterministe implements ModeleDeMobilite {

    
	private double vitesse;
    private Point2D.Double destination;
    public Point2D.Double position;

    /**
     * Crée un modèle de mobilité déterministe à partie d'une vitesse et d'une destination
     * @param vitesse de déplacement
     * @param destination à atteindre
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
	 * @return Point2D.Double la nouvelle position du noeud
	 */
    @Override
	public Point2D.Double seDeplacer() {
		if(this.position.x != this.destination.x){
			this.position.x = this.position.x + Math.cos(Math.atan(this.destination.y/this.destination.x));
		}
		if(this.position.y != this.destination.y){
			this.position.y = this.position.y + Math.sin(Math.atan(this.destination.y/this.destination.x));	
		}
		return new Point2D.Double(this.position.x, this.position.y);
	     }

	/** getPosition
	 * 
	 */
	public Point2D.Double getPosition() {
		return this.position;
	}
}