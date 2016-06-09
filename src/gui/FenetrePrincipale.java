package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import reseau.*;

public class FenetrePrincipale extends JFrame {
	
	private static GridBagConstraints contraintes;
	private static IReseau reseau;

	public FenetrePrincipale() {
		setTitle("Simulateur de réseau ad'hoc");
		setSize(800,600); 
		setLocation(200,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame f = new FenetrePrincipale();
		contraintes = new GridBagConstraints();
		reseau = Reseau.getInstance();
		
		JPanel panneauSimulation = new PanneauSimulationGenerateur(); //Panneau affiché quand on est en mode simulation
		JPanel panneauPrincipalEvenements = new JPanel(new GridBagLayout()); //Panneau affiché en mode de création des évènements
		JMenuBar menu = menuBarreGenerateur(); //MenuBar de la frame
		
		//Ajout des élèments
		f.setJMenuBar(menu);
		f.add(panneauSimulation);
		
		f.pack();
		f.setVisible(true);
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
	
	class ActionAjouterNoeud implements ActionListener{
		public void actionPerformed(ActionEvent ev)
		{
			//ouvre une pop up
			System.out.println("nouvelle partie");
		}
	}

}
