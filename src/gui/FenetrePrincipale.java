package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetrePrincipale extends JFrame {
	
	private static GridBagConstraints contraintes;

	public FenetrePrincipale() {
		setTitle("Simulateur de réseau ad'hoc");
		setSize(300,200); 
		setLocation(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame f = new FenetrePrincipale();
		f.setVisible(true);
		contraintes = new GridBagConstraints();
		
		JPanel panneauSimulation = panneauSimulationGenerateur(); //Panneau affiché quand on est en mode simulation
		JPanel panneauPrincipalEvenements = new JPanel(new GridBagLayout()); //Panneau affiché en mode de création des évènements
		JPanel panneauListeNoeuds = new JPanel(new GridBagLayout());
		
		
		panneauSimulation.add(panneauListeNoeuds);
		
		f.add(panneauSimulation);
	}
	
	public static JPanel panneauSimulationGenerateur(){
		JPanel ps = new JPanel(new GridBagLayout());
		ps.setLayout(new GridBagLayout());
		
		
		return ps;
		
	}

}
