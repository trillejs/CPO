package mobilite;


import reseau.*;

public class RandomWalk implements ModeleDeMobilite {

    /**
     * Crée un RandomWalk à partir des intervalles donnés
     * @param td début de l'intervalle de temps
     * @param tf fin de l'intervalle de temps
     * @param dd début de l'intervalle de distance
     * @param df fin de l'intervalle de distance
     * @param vd début de l'intervalle de vitesse
     * @param vf fin de l'intervalle de vitesse
     */
    public RandomWalk(double td, double tf, int dd, int df, double vd, double vf) {
    	//crée l'intervalle de temps
    	this.temps_debut = td;
    	this.temps_fin = tf;
    	
    	//crée l'intervalle de distance
    	this.distance_debut = dd;
    	this.distance_fin = df;
    	
    	//crée l'intervalle de vitesse
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