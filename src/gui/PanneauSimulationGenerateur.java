package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class PanneauSimulationGenerateur extends JPanel {

	private static GridBagConstraints contraintes;

	public PanneauSimulationGenerateur()
	{
		//Initialisations
		JPanel panneauListeNoeuds = new JPanel(new GridBagLayout());
		JPanel panneauDetailNoeud = new JPanel(new GridBagLayout());
		JPanel ps = new JPanel(new GridBagLayout());
		JList listeNoeuds = new JList();
		JButton ajoutNoeud = new JButton("Ajouter noeud");
		contraintes = new GridBagConstraints();

		panneauListeNoeuds.setLayout(new GridBagLayout());
		ps.setLayout(new GridBagLayout());

		//Ajout des composants

		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 0.20;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		panneauListeNoeuds.add(ajoutNoeud);

		listeNoeuds.setBackground(new Color(124));
		contraintes.weighty = 0.80;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		panneauListeNoeuds.add(listeNoeuds, contraintes);

		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.weighty = 1;		
		contraintes.weightx = 0.2;		
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		ps.add(panneauListeNoeuds, contraintes);

		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.weightx = 0.3;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		ps.add(panneauDetailNoeud, contraintes);
	}

}
