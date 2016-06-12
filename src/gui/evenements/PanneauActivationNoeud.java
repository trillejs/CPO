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

import gui.FenetrePrincipale;
import mobilite.Pursue;
import noeud.AdresseIP;
import noeud.INoeud;
import noeud.Noeud;
import operation.IOpVisiteur;

public class PanneauActivationNoeud extends JPanel implements Observer{

	private GridBagConstraints contraintes;
	private JList<AdresseIP> listeIP;
	private JScrollPane scrollPane;
	private List<AdresseIP> listeIps;
	
	
	public PanneauActivationNoeud()
	{
		setLayout(new GridBagLayout());
		contraintes = new GridBagConstraints();

		JLabel choixNoeud = new JLabel("Veuillez cliquer sur le noeud à activer/désactiver dans la liste");

		//Ajout des composants

		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		this.add(choixNoeud, contraintes);

		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
		listeIps = new ArrayList<>(map.keySet());
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


	@Override
	public void update(Observable arg0, Object arg1) {

		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
		List<AdresseIP> listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);

		this.listeIP = new JList<>(listeIps.toArray(new AdresseIP[1]));

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
	
	public IOpVisiteur getOperation()
	{
		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
		JFrame error = new JFrame("Erreur");
		IOpVisiteur operation = null;
		if(listeIps.size() == 0)
		{
			JOptionPane.showMessageDialog(error, "Il n'y a pas de noeud dans le réseau. Vous ne pouvez pas activer/désactiver de noeuds");
		}
		else if(this.listeIP.isSelectionEmpty())
		{
			JOptionPane.showMessageDialog(error, "Pas de noeud sélectionné. Veuillez sélectionner un noeud à activer/désactiver");
		}
		else
		{
			Noeud noeud = (Noeud) map.get(this.listeIP.getSelectedValue());
			IOpVisiteur = new OpActiv(noeud);
		}
		
		return operation;
	}

}
