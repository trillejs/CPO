package gui;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import gui.PanneauAjoutNoeud.ModeleMobilite;
import noeud.AdresseIP;
import noeud.INoeud;
import noeud.Noeud;

public class PanneauListeNoeud extends JPanel implements Observer{
	
	private static GridBagConstraints contraintes;
	
	private JList<AdresseIP> listeIP;
	private JScrollPane scrollPane;
	
	private PanneauDetailsNoeud panneauDetailNoeud;
	
	public PanneauListeNoeud()
	{
		this.setLayout(new GridBagLayout());
	
		JButton ajoutNoeud = new JButton("Ajouter noeud");
		ajoutNoeud.addActionListener(new ActionAjouterNoeud());
		contraintes = new GridBagConstraints();

		//Ajout des composants

		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 0.20;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		this.add(ajoutNoeud, contraintes);

		
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
	
	class ActionAjouterNoeud implements ActionListener{
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
		contraintes.weighty = 0.80;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(scrollPane, contraintes);
		

		revalidate();
		repaint();
		
	}
	
	public class ActionListeSelect implements ListSelectionListener
	{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			
			System.out.println("on passe");
			JList<AdresseIP> list = (JList<AdresseIP>) arg0.getSource();
			AdresseIP noeudSelectionne = (AdresseIP)list.getSelectedValue();
			Noeud noeud = (Noeud)FenetrePrincipale.getReseau().getNoeud(noeudSelectionne);
			System.out.println("Début de l'adresse IP "+noeudSelectionne.getAdresse()[0]);
			
			//Crée le panneau de détails de noeud associé au nouveau noeud sélectionné
			if(panneauDetailNoeud !=  null)
			{
				remove(panneauDetailNoeud);
			}
			panneauDetailNoeud = new PanneauDetailsNoeud(noeud);
			contraintes.weighty = 1;
			contraintes.weightx = 1;
			contraintes.gridx = 1;
			contraintes.gridy = 0;
			add(panneauDetailNoeud, contraintes);

			revalidate();
			repaint();


		}
		
	}
	
}


