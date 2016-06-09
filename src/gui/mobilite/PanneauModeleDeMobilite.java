package gui.mobilite;

import java.awt.geom.Point2D;

import javax.swing.JPanel;

import mobilite.ModeleDeMobilite;

public abstract class PanneauModeleDeMobilite extends JPanel {

	/**
	 * Point d'origine du modèle de mobilité
	 */
	protected Point2D.Double positionOrigin;
	
	/**
	 * Défini comme point d'origine du modèle de mobilité le point passé en paramètre
	 * @param position à définir comme point d'origine
	 */
	public void setOriginPoint(Point2D.Double position)
	{
		this.positionOrigin = position;
	}
	
	/**
	 * Crée et retourne un modèle de mobilité à partir des éléments lus dans les champs
	 * @return le modèle de mobilité créé
	 */
	public abstract ModeleDeMobilite getModele();
}
