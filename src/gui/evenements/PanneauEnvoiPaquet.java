package gui.evenements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import gui.FenetrePrincipale;
import noeud.AdresseIP;
import noeud.Chemin;
import noeud.INoeud;
import noeud.Noeud;
import operation.IOpVisiteur;
import operation.OpEnvoyer;
import paquet.Donnee;
import paquet.Paquet;
import simulateur.IOperation;

public class PanneauEnvoiPaquet extends JPanel implements Observer{

	private GridBagConstraints contraintes;
	
	private List<AdresseIP> listeIps;
	
	//liste 1
	private JList<AdresseIP> listeIP1;
	private JScrollPane scrollPane1;
	
	//liste 2
	private JList<AdresseIP> listeIP2;
	private JScrollPane scrollPane2;	
	
	private JTextField messagePaquet;
	
	public PanneauEnvoiPaquet()
	{
		setLayout(new GridBagLayout());
		contraintes = new GridBagConstraints();
		
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		
		JLabel labelPaquet = new JLabel("Entrez le message du paquet : ");
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		this.add(labelPaquet, contraintes);
		
		messagePaquet = new JTextField("Message");
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		this.add(messagePaquet, contraintes);
		
		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
		listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);
		
		//Ajout de la liste 1
		JLabel choixNoeudEmetteur = new JLabel("Veuillez cliquer sur le noeud �metteur dans la liste");
		
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(choixNoeudEmetteur, contraintes);
		
		scrollPane1 = new JScrollPane();
		scrollPane1.setPreferredSize(new Dimension(200,100));
		scrollPane1.setVisible(true);

		this.scrollPane1.setBackground(new Color(124));
		contraintes.weighty = 0.80;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		this.add(this.scrollPane1, contraintes);
		
		//Ajout de la liste 2
		JLabel choixNoeudRecepteur = new JLabel("Veuillez cliquer sur le noeud r�cepteur dans la liste");
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		this.add(choixNoeudRecepteur, contraintes);

		scrollPane2 = new JScrollPane();
		scrollPane2.setPreferredSize(new Dimension(200,100));
		scrollPane2.setVisible(true);

		this.scrollPane2.setBackground(new Color(124));
		contraintes.weighty = 0.80;
		contraintes.weightx = 1;
		contraintes.gridx = 1;
		contraintes.gridy = 2;
		this.add(this.scrollPane2, contraintes);
	}

	@Override
	public void update(Observable o, Object arg) {
		
		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
		List<AdresseIP> listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);
		
		//Liste 1
		this.listeIP1 = new JList<>(listeIps.toArray(new AdresseIP[1]));

		this.remove(scrollPane1);

		scrollPane1 = new JScrollPane(this.listeIP1);
		scrollPane1.setPreferredSize(new Dimension(200,100));
		scrollPane1.setVisible(true);

		this.scrollPane1.setBackground(new Color(124));
		contraintes.weighty = 0.80;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(scrollPane1, contraintes);

		//Liste 2
		this.listeIP2 = new JList<>(listeIps.toArray(new AdresseIP[1]));

		this.remove(scrollPane2);

		scrollPane2 = new JScrollPane(this.listeIP2);
		scrollPane2.setPreferredSize(new Dimension(200,100));
		scrollPane2.setVisible(true);

		this.scrollPane2.setBackground(new Color(124));
		contraintes.weighty = 0.80;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(scrollPane2, contraintes);
		
		
		revalidate();
		repaint();
		
	}
	

	public IOperation getOperation()
	{
		IOperation operation = null;
		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
		JFrame error = new JFrame("Erreur");

		if(listeIps.size() == 0)
		{
			JOptionPane.showMessageDialog(error, "Il n'y a pas de noeud dans le réseau. Vous ne pouvez pas envoyer de paquet. Ajoutez des noeuds dans le réseau et réessayez");
		}
		else if(this.listeIP1.isSelectionEmpty() || this.listeIP2.isSelectionEmpty())
		{
			JOptionPane.showMessageDialog(error, "Pas de noeud sélectionné. Veuillez sélectionner les noeuds entre lesquels vous souhaitez envoyer un paquet");
		}
		else
		{
			Noeud noeudEmetteur = (Noeud) map.get(this.listeIP1.getSelectedValue());
			Noeud noeudRecepteur = (Noeud) map.get(this.listeIP2.getSelectedValue());
			
			String message = messagePaquet.getText();
			
			Chemin chemin = noeudEmetteur.getRoute(noeudRecepteur.getAdresseIP());
			Paquet paquet = new Donnee(noeudEmetteur.getAdresseIP(), chemin, message);
			operation = new OpEnvoyer(FenetrePrincipale.getReseau(), noeudEmetteur.getAdresseIP(), paquet);
		}
		return operation;
	}
	
	
}
