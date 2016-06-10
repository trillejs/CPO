package gui.mobilite;


import gui.FenetrePrincipale;
import gui.PanneauPosition;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import mobilite.Deterministe;
import mobilite.ModeleDeMobilite;

public class PanneauModeleDeterministe extends PanneauModeleDeMobilite{

	/** Vitesse du modèle de mobilité */
	private JTextField vitesse;
	/** Destination du modèle de mobilité */
	private PanneauPosition destination;
	
	/** Fenetre principale de l'application, ayant accès au réseau*/
	private FenetrePrincipale fenetre;
	
	
	public PanneauModeleDeterministe(FenetrePrincipale fenetre)
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
		vitesse = new JTextField("2");
		this.add(vitesse, contraintes);
		
		//point destination
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.destination = new PanneauPosition();
		this.add(this.destination, contraintes);
	}


	@Override
	public ModeleDeMobilite getModele() {
		ModeleDeMobilite modele = null;
		int vitesseInt = -1;
		boolean vitesseValide = false;
		try{
			vitesseInt = Integer.parseInt(this.vitesse.getText());
			vitesseValide = true;
		}
		catch(NumberFormatException n)
		{
			vitesseValide = false;
			JOptionPane.showMessageDialog(new JFrame(), "La vitesse n'est pas valide. Veuillez spécifier une vitesse valide");
		}
		if(vitesseValide && this.destination.getPoint() != null && positionOrigin != null)
		{
			modele = new Deterministe(vitesseInt, this.destination.getPoint(), positionOrigin);
		}
		return modele;
	}
	
	
}
