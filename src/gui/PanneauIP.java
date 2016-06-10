package gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import noeud.AdresseIP;

public class PanneauIP extends JPanel {

	private JTextField [] ipTab;
	private int nbChampsIp = 4;;
	
	public PanneauIP()
	{
		this.setLayout(new GridLayout(1,nbChampsIp));
		ipTab = new JTextField[nbChampsIp];
		for(int i = 0; i<nbChampsIp; i++)
		{
			ipTab[i] = new JTextField("1");
			ipTab[i].setPreferredSize(new Dimension(50, 10));
			this.add(ipTab[i]);
		}
	}
	
	public AdresseIP getAdresseIP()
	{
		int [] tabInt = new int [nbChampsIp];
		for(int i = 0; i< nbChampsIp; i++)
		{
			tabInt[i] = Integer.parseInt(ipTab[i].getText());
		}
		return new AdresseIP(tabInt[0], tabInt[1], tabInt[2], tabInt[3]);
	}
}
