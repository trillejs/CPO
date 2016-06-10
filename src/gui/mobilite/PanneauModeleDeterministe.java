package gui.mobilite;


import gui.PanneauPosition;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mobilite.Deterministe;
import mobilite.ModeleDeMobilite;

public class PanneauModeleDeterministe extends PanneauModeleDeMobilite{

	/** Vitesse du modèle de mobilité */
	private JTextField vitesse;
	/** Destination du modèle de mobilité */
	private PanneauPosition destination;
	
	
	public PanneauModeleDeterministe()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints contraintes = new GridBagConstraints();
		
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		
		//vitesse
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;		
		JLabel vitesseLabel = new JLabel("Vitesse");
		this.add(vitesseLabel, contraintes);
		
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		vitesse = new JTextField("2");
		this.add(vitesse, contraintes);
		
		//point destination
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.destination = new PanneauPosition();
		this.add(this.destination, contraintes);
	}


	@Override
	public ModeleDeMobilite getModele() {
		
		int vitesseInt = Integer.parseInt(this.vitesse.getText());
		return new Deterministe(vitesseInt, this.destination.getPoint(), positionOrigin);
	}
	
	
}
