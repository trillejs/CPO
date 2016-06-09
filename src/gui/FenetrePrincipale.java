package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class FenetrePrincipale extends JFrame {
	
	private static GridBagConstraints contraintes;

	public FenetrePrincipale() {
		setTitle("Simulateur de réseau ad'hoc");
		setSize(800,600); 
		setLocation(200,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame f = new FenetrePrincipale();
		f.setVisible(true);
		contraintes = new GridBagConstraints();
		
		JPanel panneauSimulation = panneauSimulationGenerateur(); //Panneau affiché quand on est en mode simulation
		JPanel panneauPrincipalEvenements = new JPanel(new GridBagLayout()); //Panneau affiché en mode de création des évènements
		JMenuBar menu = menuBarreGenerateur(); //MenuBar de la frame
		
		//Ajout des élèments
		f.setJMenuBar(menu);
		f.add(panneauSimulation);
	}
	
	private static JMenuBar menuBarreGenerateur() {
		//Initialiations
		JMenu me = new JMenu("Changer de vue");
		JMenuBar mb = new JMenuBar();
		JMenuItem itemSimu = new JMenuItem("Simulation");
		JMenuItem itemEven = new JMenuItem("Evenements");

		me.add(itemSimu);
		me.add(itemEven);
		mb.add(me);
		
		return mb;
	}

	public static JPanel panneauSimulationGenerateur(){
		
		//Initialisations
		JPanel panneauListeNoeuds = new JPanel(new GridBagLayout());
		JPanel panneauDetailNoeud = new JPanel(new GridBagLayout());
		JPanel ps = new JPanel(new GridBagLayout());
		JList listeNoeuds = new JList();
		JButton ajoutNoeud = new JButton("Ajouter noeud");
		
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
		
		return ps;
		
	}

}
