package gui;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanneauAjoutNoeud extends JPanel {
	
	private static GridBagConstraints contraintes;
	
	public PanneauAjoutNoeud()
	{
		this.setLayout(new GridLayout());
		contraintes = new GridBagConstraints();
		
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 0.20;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		JButton test = new JButton("Test2");

		//Nom
		JTextField nom = new JTextField("Noeud 1");
		
		//IP
		JPanel panneauIP = new JPanel();
		int nbChampsIp = 4;
		panneauIP.setLayout(new GridLayout(1,nbChampsIp));
		for(int i = 0; i<nbChampsIp; i++)
		{
			JTextField ip = new JTextField("1");
			panneauIP.add(ip);
		}
		//Debit
		//Puissance
		//Position
		//modele de mobilite
	}

}
