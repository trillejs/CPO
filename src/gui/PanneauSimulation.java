package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class PanneauSimulation extends JPanel {

	private static GridBagConstraints contraintes;

	public PanneauSimulation()
	{
		this.setLayout(new GridBagLayout());
		//Initialisations
		JPanel panneauListeNoeuds = new JPanel(new GridBagLayout());
		JPanel panneauDetailNoeud = new JPanel(new GridBagLayout());
		JList listeNoeuds = new JList();
		JButton ajoutNoeud = new JButton("Ajouter noeud");
		ajoutNoeud.addActionListener(new ActionAjouterNoeud());
		contraintes = new GridBagConstraints();

		panneauListeNoeuds.setLayout(new GridBagLayout());

		//Ajout des composants

		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 0.20;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		panneauListeNoeuds.add(ajoutNoeud, contraintes);

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
		this.add(panneauListeNoeuds, contraintes);

		contraintes.fill = GridBagConstraints.HORIZONTAL;
		contraintes.weightx = 0.3;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		this.add(panneauDetailNoeud, contraintes);

	}

	
	class ActionAjouterNoeud implements ActionListener{
		public void actionPerformed(ActionEvent ev)
		{
			//ouvre une pop up
			JFrame frame = new JFrame();
			frame.setSize(500,400);
			frame.setTitle("Ajout d'un noeud");
			frame.setLayout(new GridLayout());
			frame.add(new PanneauAjoutNoeud());
			frame.setVisible(true);
		}
	}
	
}
