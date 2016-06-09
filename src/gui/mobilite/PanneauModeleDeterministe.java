package gui.mobilite;


import gui.PanneauPosition;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanneauModeleDeterministe extends PanneauModeleDeMobilite{

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
		JTextField vitesse = new JTextField("2");
		this.add(vitesse, contraintes);
		
		//point destination
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(new PanneauPosition(), contraintes);
	}
}
