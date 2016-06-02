package mobilite;


import java.awt.Point;

public class Deterministe implements ModeleDeMobilite {

    private double vitesse;
    private Point destination;

    /**
     * Crée un modèle de mobilité déterministe à partie d'une vitesse et d'une destination
     * @param vitesse de déplacement
     * @param destination à atteindre
     */
    public Deterministe(double vitesse, Point destination) {
    	
    	this.vitesse = vitesse;
    	this.destination = destination;
    }

	@Override
	public Point seDeplacer() {
		// TODO Auto-generated method stub
		return null;
	}

	
    
}