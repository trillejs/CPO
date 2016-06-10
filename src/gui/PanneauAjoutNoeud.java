package gui;



import exception.ExceptionNoeudPresent;
import gui.mobilite.PanneauModeleDeMobilite;
import gui.mobilite.PanneauModeleDeterministe;
import gui.mobilite.PanneauModelePursue;
import gui.mobilite.PanneauModeleRandomWalk;
import gui.mobilite.PanneauModeleRandomWaypoint;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mobilite.ModeleDeMobilite;
import noeud.AdresseIP;
import noeud.Noeud;

public class PanneauAjoutNoeud extends JPanel {
	
	private static GridBagConstraints contraintes;
	
	/** Panneaux correspondant aux différents modèles de mobilité disponibles */
	private PanneauModeleDeterministe panneauDeter;
	private PanneauModeleRandomWalk panneauRandomW;
	private PanneauModeleRandomWaypoint panneauRandowP;
	private PanneauModelePursue panneauPursue;
	
	/** Nom du noeud à créer */
	private JTextField nom;
	/** Adresse IP du noeud à créer */
	private PanneauIP panneauIP;
	/** Débit d'émission du noeud à créer */
	private JTextField debitField;
	/** Puissance d'émission (correspondant à la distance maximum atteignable) du noeud à créer */
	private JTextField puissanceField;
	/** Position de départ du noeud à créer */
	private PanneauPosition position;
	/**	Menu déroulant permettant de choisir entre les différents modèles de mobilité */
	private JComboBox<ModeleMobilite> modele;
	
	private FenetrePrincipale fenetre;
	
	
	public PanneauAjoutNoeud(FenetrePrincipale fenetre)
	{
		this.setLayout(new GridBagLayout());
		contraintes = new GridBagConstraints();
		this.fenetre = fenetre;
		panneauDeter = new PanneauModeleDeterministe(this.fenetre);
		panneauRandomW = new PanneauModeleRandomWalk(this.fenetre);
		panneauRandowP = new PanneauModeleRandomWaypoint(this.fenetre);
		panneauPursue = new PanneauModelePursue(this.fenetre);

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
		
		nom = new JTextField("Noeud 1");
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
		panneauIP = new PanneauIP();
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
		debitField = new JTextField("2");
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
		puissanceField = new JTextField("2");
		puissanceField.setPreferredSize(new Dimension(50, 10));
		this.add(puissanceField, contraintes);
		
		//Position
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 4;
		position = new PanneauPosition();
		this.add(position, contraintes);
				
		//modele de mobilite
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 5;
		
		JLabel modeleLabel = new JLabel("Modèle de mobilité : ");
		this.add(modeleLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 5;
		ModeleMobilite[] items = new ModeleMobilite [ModeleMobilite.values().length];
		for(int i = 0; i< ModeleMobilite.values().length; i++)
		{
			items[i] = ModeleMobilite.values()[i];
		}
		modele = new JComboBox<>(items);
		modele.addActionListener(new ActionModeleSelection());
		this.add(modele , contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 6;
		cacherBoutons();
		panneauDeter.setVisible(true); //On met le modèle déterministe par défaut
		
		this.add(panneauDeter, contraintes);
		this.add(panneauPursue, contraintes);
		this.add(panneauRandomW, contraintes);
		this.add(panneauRandowP, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 7;
		JButton valider = new JButton("Ajouter");
		ActionValider actionV = new ActionValider();
		actionV.passerPanneau(this);
		valider.addActionListener(actionV);
		this.add(valider);
		
	}

	public void cacherBoutons()
	{
		panneauDeter.setVisible(false);
		panneauPursue.setVisible(false);
		panneauRandomW.setVisible(false);
		panneauRandowP.setVisible(false);
	}
	
	public void creerNoeud()
	{
		//double puissance, int debit, String nom, AdresseIP adresse, ModeleDeMobilite modele
		int puissance = Integer.parseInt(this.puissanceField.getText());
		int debit = Integer.parseInt(this.debitField.getText());
		AdresseIP adresse = this.panneauIP.getAdresseIP();
		
		Point2D.Double position = this.position.getPoint();
		ModeleMobilite mod = (ModeleMobilite) this.modele.getSelectedItem();
		ModeleDeMobilite modele = null;
		switch(mod)
		{
			case Deterministe:
				panneauDeter.setOriginPoint(position);
				modele = panneauDeter.getModele();
				break;
			case RandomWalk:
				panneauRandomW.setOriginPoint(position);
				modele = panneauRandomW.getModele();
				break;
			case RandomWaypoint:
				panneauRandowP.setOriginPoint(position);
				modele = panneauRandowP.getModele();
				break;
			case Pursue:
				panneauPursue.setOriginPoint(position);
				modele = panneauPursue.getModele();
				break;
		}
		System.out.println("On y arrive");
		Noeud noeud = new Noeud(puissance, debit, this.nom.getText(), adresse, modele);
		Noeud noeud2 = new Noeud(puissance, debit, this.nom.getText(), new AdresseIP(3, 4, 5, 5), modele);
		try{
			System.out.println("taille map : "+FenetrePrincipale.getIPs().size());
			FenetrePrincipale.addNoeud(noeud);
			System.out.println("ça passe");
			System.out.println("taille map : "+FenetrePrincipale.getIPs().size());
			FenetrePrincipale.addNoeud(noeud2);
			System.out.println("taille map : "+FenetrePrincipale.getIPs().size());
			System.out.println("");
		}
		catch(ExceptionNoeudPresent e)
		{		
			System.out.println("ça passe pas");
			JOptionPane.showMessageDialog(new JFrame(), "Un noeud avec cette adresse IP existe déjà dans le réseau. Veuillez changer d'adresse ip");
		}		
	}
	
	
	public enum ModeleMobilite { Deterministe, RandomWalk, RandomWaypoint, Pursue };
	
	class ActionModeleSelection implements ActionListener{
		public void actionPerformed(ActionEvent ev)
		{
			JComboBox<ModeleMobilite> combo = (JComboBox<ModeleMobilite>) ev.getSource();
			ModeleMobilite modeleSelectionne = (ModeleMobilite)combo.getSelectedItem();
			switch(modeleSelectionne)
			{
				case Deterministe:
					cacherBoutons();
					panneauDeter.setVisible(true);
					break;
				case RandomWalk:
					cacherBoutons();
					panneauRandomW.setVisible(true);
					break;
				case RandomWaypoint:
					cacherBoutons();
					panneauRandowP.setVisible(true);
					break;
				case Pursue:
					cacherBoutons();
					panneauPursue.setVisible(true);
					break;
			}
		}
	}
	
	class ActionValider implements ActionListener{
		PanneauAjoutNoeud panneau;
		
		public void passerPanneau(PanneauAjoutNoeud panneau)
		{
			this.panneau = panneau;
		}
		public void actionPerformed(ActionEvent ev)
		{
			this.panneau.creerNoeud();
		}
	}
}
