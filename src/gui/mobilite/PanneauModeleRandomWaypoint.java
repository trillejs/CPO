package gui.mobilite;

import mobilite.ModeleDeMobilite;
import mobilite.RandomWalk;
import mobilite.RandomWayPoint;

public class PanneauModeleRandomWaypoint extends PanneauModeleRandomWalk {

	@Override
	public ModeleDeMobilite getModele() {
		
		int dd = Integer.parseInt(this.distanceMin.getText());
		int df = Integer.parseInt(this.distanceMax.getText());
		int vd = Integer.parseInt(this.vitesseMin.getText());
		int vf = Integer.parseInt(this.vitesseMax.getText());
		return new RandomWayPoint(dd, df, vd, vf, positionOrigin);
	}	
}
