package mobilite;

import java.awt.geom.Point2D;

public class RandomWayPoint extends RandomWalk {
	
	public double delai;
	public Point2D.Double position;
	
	/**RandomwayPoint
	 * 
	 * @param dd
	 * @param df
	 * @param vd
	 * @param vf
	 * @param delai
	 * @param position
	 */
	public RandomWayPoint(int dd, int df, int vd, int vf, double delai, Point2D.Double position) {
		super(dd, df, vd, vf);
		this.delai = delai;
		this.position = position;
	}
	/**seDeplacer
	 * 
	 */
	public Point2D.Double seDeplacer(){
		double i;
		i = 1 + (int)(Math.random() * (20 - 1)) + 1;
		if(i == this.delai){
			this.position.x = this.position.x + this.distance_debut + (int)(Math.random() * ((this.distance_fin - this.distance_debut) + 1))/this.vitesse_debut + (int)(Math.random() * ((this.vitesse_fin - this.vitesse_debut) + 1));
		
			this.position.y = this.position.y + this.distance_debut + (int)(Math.random() * ((this.distance_fin - this.distance_debut) + 1))/this.vitesse_debut + (int)(Math.random() * ((this.vitesse_fin - this.vitesse_debut) + 1));	
			
			delai++;
		}
		return new Point2D.Double(this.position.x, this.position.y);
	}

	}
	
