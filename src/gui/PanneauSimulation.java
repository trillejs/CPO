package gui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import reseau.Reseau;

public class PanneauSimulation extends JPanel {

	private static GridBagConstraints contraintes;
	
	public PanneauSimulation()
	{
		this.setLayout(new GridBagLayout());
		//Initialisations
		PanneauListeNoeud panneauListeNoeuds = new PanneauListeNoeud();
		Reseau reseau = (Reseau)FenetrePrincipale.getReseau();
		reseau.addObserver(panneauListeNoeuds);
		JPanel panneauDetailNoeud = new JPanel(new GridBagLayout());
		

		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.weighty = 1;		
		contraintes.weightx = 0.2;		
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		this.add(panneauListeNoeuds, contraintes);

		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.weightx = 0.3;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		this.add(panneauDetailNoeud, contraintes);

	}	
}
