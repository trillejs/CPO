package gui.mobilite;


import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mobilite.ModeleDeMobilite;
import mobilite.RandomWalk;

public class PanneauModeleRandomWalk extends PanneauModeleDeMobilite {

	/** Borne min de l'intervalle de vitesse */
	protected JTextField vitesseMin;
	/** Borne max de l'intervalle de vitesse */
	protected JTextField vitesseMax;
	
	/** Borne min de l'intervalle de distance */
	protected JTextField distanceMin;	
	/** Borne min de l'intervalle de distance */
	protected JTextField distanceMax;
	
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
		vitesseMin = new JTextField("1");
		this.add(vitesseMin, contraintes);
		
		contraintes.weighty = 1;
		contraintes.weightx = 0.5;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		vitesseMax = new JTextField("2");
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
		distanceMin = new JTextField("1");
		this.add(distanceMin, contraintes);
		
		contraintes.weighty = 1;
		contraintes.weightx = 0.5;
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		distanceMax = new JTextField("2");
		this.add(distanceMax, contraintes);
	}

	@Override
	public ModeleDeMobilite getModele() {
		
		int dd = Integer.parseInt(this.distanceMin.getText());
		int df = Integer.parseInt(this.distanceMax.getText());
		int vd = Integer.parseInt(this.vitesseMin.getText());
		int vf = Integer.parseInt(this.vitesseMax.getText());
		return new RandomWalk(dd, df, vd, vf, positionOrigin);
	}
	
	
}
