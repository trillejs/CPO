package gui.simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import exception.ExceptionNoeudAbsent;
import gui.FenetrePrincipale;
import noeud.AdresseIP;
import noeud.INoeud;
import noeud.Noeud;

public class PanneauListeNoeud extends JPanel implements Observer{
	
	private static GridBagConstraints contraintes;
	
	private JList<AdresseIP> listeIP;
	private JScrollPane scrollPane;
	
	private PanneauDetailsNoeud panneauDetailNoeud;
	private JButton ajoutNoeud;
	private JButton supprimer;
	
	public PanneauListeNoeud()
	{
		this.setLayout(new GridBagLayout());
		contraintes = new GridBagConstraints();
		
		ajoutNoeud = new JButton("Ajouter noeud");
		ajoutNoeud.addActionListener(new ActionAjouterNoeud());
		
		//Ajout des composants

		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		this.add(ajoutNoeud, contraintes);
		
		supprimer = new JButton("Supprimer");
		supprimer.addActionListener(new ActionSupprimer());
		
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		this.add(supprimer, contraintes);

		
		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
		List<AdresseIP> listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200,100));
		scrollPane.setVisible(true);
		
		this.scrollPane.setBackground(new Color(124));
		contraintes.weighty = 0.80;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(this.scrollPane, contraintes);
	}
	
	public void activationBouton(boolean actif)
	{
		if(actif)
		{
			this.supprimer.setEnabled(true);
			this.ajoutNoeud.setEnabled(true);
		}
		else
		{
			this.supprimer.setEnabled(false);
			this.ajoutNoeud.setEnabled(false);
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
		List<AdresseIP> listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);
		
		this.listeIP = new JList<>(listeIps.toArray(new AdresseIP[1]));

		this.listeIP.addListSelectionListener(new ActionListeSelect());
		this.remove(scrollPane);
		
		scrollPane = new JScrollPane(this.listeIP);
		scrollPane.setPreferredSize(new Dimension(200,100));
		scrollPane.setVisible(true);
		
		this.scrollPane.setBackground(new Color(124));
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(scrollPane, contraintes);
		

		revalidate();
		repaint();
		
	}
	
	class ActionAjouterNoeud implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ev)
		{
			//ouvre une pop up
			JFrame frame = new JFrame();
			frame.setSize(800,500);
			frame.setTitle("Ajout d'un noeud");
			frame.setLayout(new GridLayout());
			frame.add(new PanneauAjoutNoeud());
			frame.setVisible(true);
		}
	}

	
	class ActionSupprimer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(panneauDetailNoeud == null)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Aucun noeud sélectionné. Veuillez sélectionner un noeud à supprimer");
			}
			else
			{
				try{
					FenetrePrincipale.delNoeud(panneauDetailNoeud.getNoeud());
					
					JOptionPane.showMessageDialog(new JFrame(), "Le noeud a bien été supprimé.");
				}
				catch(ExceptionNoeudAbsent e)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Erreur. Le noeud que vous essayez de supprimer ne fait pas partie du réseau. Veuillez sélectionner un autre noeud.");
				}
			}			
		}		
	}
	
	public class ActionListeSelect implements ListSelectionListener
	{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			
			JList<AdresseIP> list = (JList<AdresseIP>) arg0.getSource();

			AdresseIP noeudSelectionne = (AdresseIP)list.getSelectedValue();
			if(noeudSelectionne != null)
			{
				Noeud noeud = (Noeud)FenetrePrincipale.getReseau().getNoeud(noeudSelectionne);

				//Cr�e le panneau de d�tails de noeud associ� au nouveau noeud s�lectionn�
				if(panneauDetailNoeud !=  null)
				{
					remove(panneauDetailNoeud);
				}
				panneauDetailNoeud = new PanneauDetailsNoeud(noeud);
				contraintes.weighty = 1;
				contraintes.weightx = 1;
				contraintes.gridx = 1;
				contraintes.gridy = 1;
				add(panneauDetailNoeud, contraintes);

				revalidate();
				repaint();
			}
		}		
	}	
}


