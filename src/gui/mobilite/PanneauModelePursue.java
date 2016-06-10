package gui.mobilite;


import gui.FenetrePrincipale;
import gui.PanneauPosition;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JList;
import javax.swing.JScrollPane;

import noeud.INoeud;
import noeud.AdresseIP;
import noeud.Noeud;

import mobilite.ModeleDeMobilite;
import mobilite.Pursue;

public class PanneauModelePursue extends PanneauModeleDeMobilite {

//	private PanneauPosition panneauCible = new PanneauPosition();
	private FenetrePrincipale fenetre;
	private JList<AdresseIP> listeIP;
	private Map<AdresseIP, INoeud> map;
	
	public PanneauModelePursue(FenetrePrincipale fenetre)
	{
		this.fenetre = fenetre;
		this.setLayout(new GridLayout());
		map = FenetrePrincipale.getIPs();
		List<AdresseIP> listeIps = new ArrayList<>(map.keySet());
		this.listeIP = new JList<>(listeIps.toArray(new AdresseIP[1]));
//		System.out.println("nombre d'IP : "+listeIps.size());
//		this.add(this.panneauCible);
		JScrollPane scrollPane = new JScrollPane(this.listeIP);
		this.add(scrollPane);
	}

	@Override
	public ModeleDeMobilite getModele() {
		Noeud noeud = (Noeud) map.get(this.listeIP.getSelectedValue());
		return new Pursue(noeud, positionOrigin);
	}
	
}
