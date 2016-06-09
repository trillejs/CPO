package gui;



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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanneauAjoutNoeud extends JPanel {
	
	private static GridBagConstraints contraintes;
	
	private PanneauModeleDeterministe panneauDeter = new PanneauModeleDeterministe();
	private PanneauModeleRandomWalk panneauRandomW = new PanneauModeleRandomWalk();
	private PanneauModeleRandomWaypoint panneauRandowP = new PanneauModeleRandomWaypoint();
	private PanneauModelePursue panneauPursue = new PanneauModelePursue();
	
	public PanneauAjoutNoeud()
	{
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
		
		JTextField nom = new JTextField("Noeud 1");
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
		JPanel panneauIP = new JPanel();
		int nbChampsIp = 4;
		panneauIP.setLayout(new GridLayout(1,nbChampsIp));
		JTextField [] ipTab = new JTextField[nbChampsIp];
		for(int i = 0; i<nbChampsIp; i++)
		{
			ipTab[i] = new JTextField("1");
			ipTab[i].setPreferredSize(new Dimension(50, 10));
			panneauIP.add(ipTab[i]);
		}
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
		JTextField debitField = new JTextField("2");
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
		JTextField puissanceField = new JTextField("2");
		puissanceField.setPreferredSize(new Dimension(50, 10));
		this.add(puissanceField, contraintes);
		
		//Position
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 4;
		PanneauPosition p = new PanneauPosition();
//		p.setPreferredSize(new Dimension(this.getWidth(), 10));
		this.add(p, contraintes);
				
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
		JComboBox<ModeleMobilite> modele = new JComboBox<>(items);
		modele.addActionListener(new ActionModeleSelection());
		this.add(modele , contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 6;
		cacherBoutons();
		
		this.add(panneauDeter, contraintes);
		this.add(panneauPursue, contraintes);
		this.add(panneauRandomW, contraintes);
		this.add(panneauRandowP, contraintes);
	}

	public void cacherBoutons()
	{
		panneauDeter.setVisible(false);
		panneauPursue.setVisible(false);
		panneauRandomW.setVisible(false);
		panneauRandowP.setVisible(false);
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
}
