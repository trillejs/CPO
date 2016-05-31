package mobilite;

import java.util.*;

import reseau.Position;

/**
 * 
 */
public class RandomWalk implements ModeleDeMobilite {

    /**
     * Default constructor
     */
    public RandomWalk(double td, double tf, int dd, int df, double vd, double vf) {
    	this.temps_debut = td;
    	this.temps_fin = tf;
    	
    	this.distance_debut = dd;
    	this.distance_fin = df;
    	
    	this.vitesse_debut = vd;
    	this.vitesse_fin = vf;
    }

    /**
     * Intervalle de temps
     */
    private double temps_debut;
    private double temps_fin;

    /**
     * Intervalle de distance
     */
    private int distance_debut;
    private int distance_fin;

    /**
     * Intervalle de vitesse
     */
    private double vitesse_debut;
    private double vitesse_fin;

	@Override
	public Position seDeplacer() {
		return null;
		// TODO Auto-generated method stub
		
	}

}