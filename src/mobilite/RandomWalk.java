package mobilite;


import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.Random;
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
     * @param dd : int - début de l'intervalle de distance
     * @param df : iny - fin de l'intervalle de distance
     * @param vd : int - début de l'intervalle de vitesse
     * @param vf : int - fin de l'intervalle de vitesse
     */
    public RandomWalk(int dd, int df, int vd, int vf) {
    	
    	//crée l'intervalle de distance
    	this.distance_debut = dd;
    	this.distance_fin = df;
    	
    	//crée l'intervalle de vitesse
    	this.vitesse_debut = vd;
    	this.vitesse_fin = vf;
    }

	/** seDeplacer
	 * déplace aléatoirement un noeud d'un pas dans le plan
	 * @return Point2D.Double la nouvelle position du noeud
	 * pré : rien 
	 * post : rien
	 */
    
	public Point2D.Double seDeplacer() {
		
		// génération de l'Abcisse aléatoire
		Random rn1 = new Random();
		int n1 = this.distance_fin - this.distance_debut + 1;
		int x1 = this.distance_debut + rn1.nextInt() % n1;
		
		// Génération de la vitesse aléatoire
		Random rn2 = new Random();
		int n2 = (int) (this.vitesse_fin - this.vitesse_debut + 1);
		int vitesse = (int) (this.vitesse_debut + rn2.nextInt() % n2);
		
		// Génération de l'ordonnée aléatoire
		Random rn3 = new Random();
		int n3 = this.distance_fin - this.distance_debut + 1;
		int y1 = this.distance_debut + rn3.nextInt() % n3;
		
		//Génération du vecteur aléatoire
		Random rn4 = new Random();
		int n4 = 100 - 5 + 1;
		double vecteurAleatoire = 5 + rn4.nextInt() % n4;
		
		this.position.x = this.position.x + (x1/vitesse) + vecteurAleatoire;
		
		this.position.y = this.position.y + (y1/vitesse) + vecteurAleatoire;
			
		return this.position;
	}

	/** getPosition
	 * renvoie la position courante du noeud
	 * @return la position du noeud
	 */
	public Double getPosition() {
		return this.position;
	}
}