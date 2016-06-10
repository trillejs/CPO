package gui.mobilite;


import gui.PanneauPosition;

import java.awt.GridLayout;

import mobilite.ModeleDeMobilite;
import mobilite.Pursue;

public class PanneauModelePursue extends PanneauModeleDeMobilite {

	private PanneauPosition panneauCible = new PanneauPosition();
	
	public PanneauModelePursue()
	{
		this.setLayout(new GridLayout());
		this.add(this.panneauCible);
	}

	@Override
	public ModeleDeMobilite getModele() {
		return new Pursue(this.panneauCible.getPoint(), positionOrigin);
	}
	
}
