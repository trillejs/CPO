package mobilite;


import reseau.*;

/**
 * 
 */
public class Deterministe extends ModeleDeMobilite {


    /**
     * 
     */
    private double vitesse;
    private Position destination;

    /**
     * Crée un modèle de mobilité déterministe à partie d'une vitesse et d'une destination
     */
    public Deterministe(double vitesse, Position destination) {
    	
    	this.vitesse = vitesse;
    	this.destination = destination;
    }

	@Override
	public void seDeplacer() {
		// TODO Auto-generated method stub
		
	}
    
}