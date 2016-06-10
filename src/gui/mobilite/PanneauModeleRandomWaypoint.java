package gui.mobilite;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.FenetrePrincipale;
import mobilite.ModeleDeMobilite;
import mobilite.RandomWayPoint;

public class PanneauModeleRandomWaypoint extends PanneauModeleRandomWalk {

	@Override
	public ModeleDeMobilite getModele() {
		ModeleDeMobilite modele = null;
		try{
			int dd = Integer.parseInt(this.distanceMin.getText());
			int df = Integer.parseInt(this.distanceMax.getText());
			int vd = Integer.parseInt(this.vitesseMin.getText());
			int vf = Integer.parseInt(this.vitesseMax.getText());
			modele = new RandomWayPoint(dd, df, vd, vf, positionOrigin);
		}
		catch(NumberFormatException n)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Une des valeurs n'est pas valide. Veuillez spécifier des valeurs valides");
		}
		return modele;
	}	
}
