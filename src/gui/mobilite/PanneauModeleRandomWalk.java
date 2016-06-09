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
		contraintes.weightx = 0.5;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		JTextField vitesseMin = new JTextField("1");
		this.add(vitesseMin, contraintes);
		
		contraintes.weighty = 1;
		contraintes.weightx = 0.5;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		JTextField vitesseMax = new JTextField("2");
		this.add(vitesseMax, contraintes);
		
		//intervalle distance
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;		
		JLabel distanceLabel = new JLabel("Distance");
		this.add(distanceLabel, contraintes);
		
		contraintes.weighty = 1;
		contraintes.weightx = 0.5;
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		JTextField distanceMin = new JTextField("1");
		this.add(distanceMin, contraintes);
		
		contraintes.weighty = 1;
		contraintes.weightx = 0.5;
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		JTextField distanceMax = new JTextField("2");
		this.add(distanceMax, contraintes);
	}
}
