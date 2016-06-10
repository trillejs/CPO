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
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import noeud.AdresseIP;
import noeud.INoeud;

public class PanneauListeNoeud extends JPanel implements Observer{
	
	private static GridBagConstraints contraintes;
	
	private JList<AdresseIP> listeIP;
	private Map<AdresseIP, INoeud> map;
	private JScrollPane scrollPane;
	private List<AdresseIP> listeIps;
	
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

		
		map = FenetrePrincipale.getIPs();
		listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);
		this.listeIP = new JList<>(listeIps.toArray(new AdresseIP[1]));
		scrollPane = new JScrollPane(this.listeIP);
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
		map = FenetrePrincipale.getIPs();
		listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);
		scrollPane.remove(this.listeIP);
		this.listeIP = new JList<>(listeIps.toArray(new AdresseIP[1]));
//		this.remove(scrollPane);
		scrollPane.add(this.listeIP);
//		scrollPane.setVisible(true);
//		this.add(scrollPane);
		
	}
}
