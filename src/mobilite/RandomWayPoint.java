package mobilite;

import java.awt.geom.Point2D;
import java.util.Random;

public class RandomWayPoint extends RandomWalk {
	
	/**
	 * Délai d'attente pour le noeud
	 */
	public double delai;
	/**
	 * Position courante du noeud
	 */
	public Point2D.Double position;
	
	/**
	 * Etat de mouvement du noeud
	 */
	public boolean enMouvement;
	
	/**RandomwayPoint
	 * @param dd : int - début de l'intervalle de distance
     * @param df : iny - fin de l'intervalle de distance
     * @param vd : int - début de l'intervalle de vitesse
     * @param vf : int - fin de l'intervalle de vitesse
	 * @param delai : double - délai d'arrêt du déplacement 
	 * @param position : Point2D.Double - position courante du noeud
	 */
	public RandomWayPoint(int dd, int df, int vd, int vf, double delai, Point2D.Double position) {
		super(dd, df, vd, vf);
		this.delai = delai;
		this.position = position;
	}
	/** seDeplacer
	 * déplace aléatoirement un noeud d'un pas dans le plan
	 * pré : rien 
	 * post : rien
	 */
	public void seDeplacer(){
		
		if(enMouvement){
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
			int vecteurAleatoire = 5 + rn4.nextInt() % n4;
		
			// Modification de la position
			this.position.x = this.position.x + (x1/vitesse)+ vecteurAleatoire;
		
			this.position.y = this.position.y + (y1/vitesse) + vecteurAleatoire;
			}
		else{
			
			for(int i = 0;i<this.delai;i++){
				System.out.println("wait");
			}
		}
		
	}

	}
	
