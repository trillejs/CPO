package gui.mobilite;


import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanneauModeleRandomWalk extends PanneauModeleDeMobilite {

	public PanneauModeleRandomWalk()
	{
		this.setLayout(new GridLayout());
		
		//intervalle vitesse 
		GridBagConstraints contraintes = new GridBagConstraints();
		
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
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
		
		//intervalle distance
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;		
		JLabel distanceLabel = new JLabel("Distance");
		this.add(distanceLabel, contraintes);
		
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		JTextField distance = new JTextField("2");
		this.add(distance, contraintes);
	}
}
