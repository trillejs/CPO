package mobilite;


import java.awt.geom.Point2D;

public class Deterministe implements ModeleDeMobilite {

    private double vitesse;
    private Point2D.Double destination;

    /**
     * Crée un modèle de mobilité déterministe à partie d'une vitesse et d'une destination
     * @param vitesse de déplacement
     * @param destination à atteindre
     */
    public Deterministe(double vitesse, Point2D.Double destination) {
    	
    	this.vitesse = vitesse;
    	this.destination = destination;
    }

	@Override
	public Point2D.Double seDeplacer() {
		// TODO Auto-generated method stub
		return null;
	}

	
    
}