package mobilite;


import reseau.*;

public class Deterministe implements ModeleDeMobilite {

    private double vitesse;
    private Position destination;

    /**
     * Crée un modèle de mobilité déterministe à partie d'une vitesse et d'une destination
     * @param vitesse de déplacement
     * @param destination à atteindre
     */
    public Deterministe(double vitesse, Position destination) {
    	
    	this.vitesse = vitesse;
    	this.destination = destination;
    }

	@Override
	public Position seDeplacer() {
		// TODO Auto-generated method stub
		return null;
	}

	
    
}