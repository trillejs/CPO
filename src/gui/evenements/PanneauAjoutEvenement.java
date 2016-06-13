package gui.evenements;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import exception.ExceptionNoeudPresent;
import gui.FenetrePrincipale;
import noeud.AdresseIP;
import noeud.Noeud;
import operation.IOpVisiteur;
import reseau.Reseau;

public class PanneauAjoutEvenement extends JPanel {
	
	private PanneauActivationNoeud panneauActiv;
	private PanneauEnvoiPaquet panneauEnvoi;
	private static GridBagConstraints contraintes;
	private JComboBox combo;
	private JTextField tempsField;
	
	public PanneauAjoutEvenement()
	{
		this.setLayout(new GridBagLayout());
		contraintes = new GridBagConstraints();
		contraintes.fill = GridBagConstraints.HORIZONTAL;
		
		//Initialisations
		Reseau reseau = (Reseau)FenetrePrincipale.getReseau();
		
		//Choix du temps
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		JLabel tempsLabel = new JLabel("Veuillez choisir le temps auquel l'op�ration sera effectu�e");
		this.add(tempsLabel, contraintes);
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		tempsField = new JTextField("1");
		this.add(tempsField, contraintes);
		
		//Choix op�ration
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		JLabel choixLabel = new JLabel("Veuillez choisir l'op�ration que vous voulez enregistrer");
		this.add(choixLabel, contraintes);
		
		Operation[] items = new Operation [Operation.values().length];
		for(int i = 0; i< Operation.values().length; i++)
		{
			items[i] = Operation.values()[i];
		}
		combo = new JComboBox<>(items);
		combo.addActionListener(new ActionModeleSelection());
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 3;
		this.add(combo , contraintes);
		
		
		
		//Ajout des diff�rents panneau de cr�ation d'�v�nement
		this.panneauActiv = new PanneauActivationNoeud();		
		reseau.addObserver(this.panneauActiv);
		
		this.panneauEnvoi = new PanneauEnvoiPaquet();		
		reseau.addObserver(this.panneauEnvoi);		
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 4;
		this.add(this.panneauActiv, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 4;
		this.add(this.panneauEnvoi, contraintes);
	}
	
public enum Operation { Envoi, Activ };
	
	class ActionModeleSelection implements ActionListener{
		public void actionPerformed(ActionEvent ev)
		{
			JComboBox<Operation> combo = (JComboBox<Operation>) ev.getSource();
			Operation operationSelectionne = (Operation)combo.getSelectedItem();
			switch(operationSelectionne)
			{
				case Envoi:
					cacherPanneaux();
					panneauEnvoi.setVisible(true);
					break;
				case Activ:
					cacherPanneaux();
					panneauActiv.setVisible(true);
					break;
			}
		}
	}
	
	/**
	 * Cache les panneaux des Modèles de mobilité non sélectionné dans le comboBox
	 */
	public void cacherPanneaux()
	{
		panneauActiv.setVisible(false);
		panneauEnvoi.setVisible(false);
	}
	

	/**
	 * V�rifie la valeur entr�e pour debit ; affiche un message d'erreur si la valeur est incorrecte
	 * @return la valeur de debit si elle est valide, 0 sinon
	 */
	public int getTemps()
	{
		int temps = 0;
		try{
			temps = Integer.parseInt(this.tempsField.getText());
			if(temps <= 0)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Le temps n'est pas valide. Veuillez entrer un nombre sup�rieur à 0");
				temps = 0;
			}
		}
		catch(NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Le temps n'est pas valide. Veuillez entrer un entier");
		}		
		return temps;
	}
	
	/**
	 * Cr�e un noeud � partir des champs remplis et l'ajoute au r�seau
	 * Affiche un message d'erreur si un des champs est invalide
	 */
	public void creerOperation()
	{
		int temps = getTemps();
		
		Operation operationSelectionne = (Operation)combo.getSelectedItem();
		IOpVisiteur operation = null;
		switch(operationSelectionne)
		{
			case Envoi:
				cacherPanneaux();
				operation = panneauEnvoi.getOperation();
				break;
			case Activ:
				cacherPanneaux();
				operation = panneauActiv.getOperation();
				break;
		}
		
		if(operation != null && temps > 0)
		{
			try{
				FenetrePrincipale.addOperation(temps, operation);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
				frame.dispose();
				JOptionPane.showMessageDialog(new JFrame(), "L'op�ration a bien �t� rajout� au simulateur");
			}
			catch(ExceptionNoeudPresent e)
			{		
				JOptionPane.showMessageDialog(new JFrame(), "Un noeud avec cette adresse IP existe déjà dans le réseau. Veuillez changer d'adresse ip");
			}
		}
	}

}