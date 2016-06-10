package gui.mobilite;

import gui.FenetrePrincipale;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import noeud.INoeud;
import noeud.AdresseIP;
import noeud.Noeud;

import mobilite.ModeleDeMobilite;
import mobilite.Pursue;

public class PanneauModelePursue extends PanneauModeleDeMobilite {

	private JList<AdresseIP> listeIP;
	private Map<AdresseIP, INoeud> map;
	private JScrollPane scrollPane;
	private List<AdresseIP> listeIps;
	
	public PanneauModelePursue()
	{
		this.setPreferredSize(new Dimension(200, 100));
		this.setLayout(new GridLayout());
		
		map = FenetrePrincipale.getIPs();
		listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);
		this.listeIP = new JList<>(listeIps.toArray(new AdresseIP[1]));
		scrollPane = new JScrollPane(this.listeIP);
		scrollPane.setVisible(true);
		this.add(scrollPane);
		
	}

	/**
	 * Récupère la liste de noeuds présents dans le réseau et les affiches dans la JList
	 */
	public void refreshList()
	{
		map = FenetrePrincipale.getIPs();
		listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);
		this.listeIP = new JList<>(listeIps.toArray(new AdresseIP[1]));
		this.remove(scrollPane);
		scrollPane = new JScrollPane(this.listeIP);
		scrollPane.setVisible(true);
		this.add(scrollPane);
	}
	
	@Override
	public ModeleDeMobilite getModele() {
		ModeleDeMobilite modele = null;
		JFrame error = new JFrame("Erreur");
		if(listeIps.size() == 0)
		{
			JOptionPane.showMessageDialog(error, "Il n'y a pas de noeud dans le réseau. Vous ne pouvez pas créer de noeuds avec un modèle Pursue");
		}
		else if(this.listeIP.isSelectionEmpty())
		{
			JOptionPane.showMessageDialog(error, "Pas de noeud sélectionné. Veuillez sélectionner un noeud à poursuivre");
		}
		else
		{
			Noeud noeud = (Noeud) map.get(this.listeIP.getSelectedValue());
			modele = new Pursue(noeud, positionOrigin);
		}
		return modele;
	}
	
}
