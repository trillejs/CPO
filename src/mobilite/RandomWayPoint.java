package mobilite;

import java.awt.geom.Point2D;

public class RandomWayPoint extends RandomWalk {
	
	/**RandomwayPoint
	 * 
	 * @param dd
	 * @param df
	 * @param vd
	 * @param vf
	 * @param delai
	 * @param position
	 */
	public RandomWayPoint(int dd, int df, int vd, int vf, Point2D.Double position) {
		super(dd, df, vd, vf, position);
	}
	
	/**seDeplacer
	 * 
	 */
	public Point2D.Double seDeplacer(){
		double i;
		i = 2 + (int)(Math.random() * (19));
		double ajout = this.distance_debut + (int)(Math.random() * ((this.distance_fin - this.distance_debut) + 1))/this.vitesse_debut + (int)(Math.random() * ((this.vitesse_fin - this.vitesse_debut) + 1));
		this.position.x = this.position.x + ajout;
		this.position.y = this.position.y + ajout;

		return new Point2D.Double(this.position.x, this.position.y);
	}

	}
	
