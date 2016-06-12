package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.PanneauAjoutNoeud.ModeleMobilite;
import noeud.INoeud;
import noeud.Noeud;

public class PanneauDetailsNoeud extends JPanel {
	
	private static GridBagConstraints contraintes;
	
	/** Nom du noeud à créer */
	private JLabel nom;
	/** Adresse IP du noeud à créer */
	private JLabel panneauIP;
	/** Débit d'émission du noeud à créer */
	private JLabel debitField;
	/** Puissance d'émission (correspondant à la distance maximum atteignable) du noeud à créer */
	private JLabel puissanceField;
	/** Position de départ du noeud à créer */
	private JLabel position;
	
	private Noeud noeud;
	
	public PanneauDetailsNoeud(Noeud noeud)
	{
		
		this.noeud = noeud;
		this.setLayout(new GridBagLayout());
		contraintes = new GridBagConstraints();
		
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;

		//Nom
		JLabel nomLabel = new JLabel("Nom : ");
		this.add(nomLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		
		nom = new JLabel(this.noeud.getNom());
		nom.setPreferredSize(new Dimension(100, 10));
		this.add(nom, contraintes);
		
		//IP
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		JLabel ipLabel = new JLabel("Adresse IP : ");
		this.add(ipLabel, contraintes);
		
	
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		panneauIP = new JLabel(this.noeud.getAdresseIP().toString());
		this.add(panneauIP, contraintes);
		
		//Debit
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		JLabel debitLabel = new JLabel("Débit d'émission : ");
		this.add(debitLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 2;
		debitField = new JLabel(Integer.toString(this.noeud.getDebitEmission()));
		debitField.setPreferredSize(new Dimension(50, 10));
		this.add(debitField, contraintes);
		
		//Puissance
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 3;
		JLabel puissanceLabel = new JLabel("Puissance d'émission : ");
		this.add(puissanceLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 3;
		puissanceField = new JLabel(Double.toString(this.noeud.getPuissance()));
		puissanceField.setPreferredSize(new Dimension(50, 10));
		this.add(puissanceField, contraintes);
		
		//Position
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 4;
		JLabel positionLabel = new JLabel("Position : ");
		this.add(positionLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 4;
		position = new JLabel(this.noeud.getPoint().toString());
		this.add(position, contraintes);
				
		//modele de mobilite
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 5;
		
		JLabel modeleLabel = new JLabel("Mod�le de mobilit� : ");
		this.add(modeleLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 5;
		
		JLabel modele = new JLabel("valeur modele");
		this.add(modele, contraintes);
		
	}
	
	public Noeud getNoeud()
	{
		return this.noeud;
	}
}
