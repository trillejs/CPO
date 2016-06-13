package gui.simulation;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.FenetrePrincipale;
import reseau.Reseau;
import simulateur.ISimulateur;

public class PanneauSimulation extends JPanel {

	private static GridBagConstraints contraintes;
	
	private PanneauListeNoeud panneauListeNoeuds;
	
	public PanneauSimulation()
	{
		this.setLayout(new GridBagLayout());
		//Initialisations
		panneauListeNoeuds = new PanneauListeNoeud();
		Reseau reseau = (Reseau)FenetrePrincipale.getReseau();
		reseau.addObserver(panneauListeNoeuds);
		
		
		contraintes = new GridBagConstraints();

		contraintes.fill = GridBagConstraints.HORIZONTAL;
		
		JButton simulation = new JButton("Lancer simulation");
		simulation.addActionListener(new ActionSimulation());
		
		contraintes.weighty = 1;		
		contraintes.weightx = 0.2;		
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		this.add(simulation, contraintes);
		
		JButton simulationPasAPas = new JButton("Lancer simulation pas à pas");
		simulationPasAPas.addActionListener(new ActionSimulationPasAPas());
		
		contraintes.weighty = 1;		
		contraintes.weightx = 0.2;		
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		this.add(simulationPasAPas, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 0.2;		
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(panneauListeNoeuds, contraintes);

	}	
	
	class ActionSimulation implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ISimulateur simulateur = FenetrePrincipale.getSimulateur();
			panneauListeNoeuds.activationBouton(false);
			simulateur.simuler();
			JOptionPane.showMessageDialog(new JFrame(), "La simulation est finie");
		}
		
	}
	
	class ActionSimulationPasAPas implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ISimulateur simulateur = FenetrePrincipale.getSimulateur();
			panneauListeNoeuds.activationBouton(false);
			simulateur.simulerPas(1);
			JOptionPane.showMessageDialog(new JFrame(), "La simulation est finie");
		}
		
	}
}
