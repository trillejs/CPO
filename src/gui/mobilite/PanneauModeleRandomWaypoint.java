package gui.mobilite;

import gui.FenetrePrincipale;
import mobilite.ModeleDeMobilite;
import mobilite.RandomWayPoint;

public class PanneauModeleRandomWaypoint extends PanneauModeleRandomWalk {

	/** Fenetre principale de l'application, ayant accès au réseau*/
	private FenetrePrincipale fenetre;
	
	public PanneauModeleRandomWaypoint(FenetrePrincipale fenetre)
	{
		super(fenetre);
	}
	
	@Override
	public ModeleDeMobilite getModele() {

		int dd = Integer.parseInt(this.distanceMin.getText());
		int df = Integer.parseInt(this.distanceMax.getText());
		int vd = Integer.parseInt(this.vitesseMin.getText());
		int vf = Integer.parseInt(this.vitesseMax.getText());
		return new RandomWayPoint(dd, df, vd, vf, positionOrigin);
	}	
}
