package gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mobilite.ModeleDeMobilite;
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
		AdresseIP adresse = null;
		int [] tabInt = new int [nbChampsIp];
		try{
			for(int i = 0; i< nbChampsIp; i++)
			{
				tabInt[i] = Integer.parseInt(ipTab[i].getText());
			}			
		}
		catch(NumberFormatException n)
		{
			JOptionPane.showMessageDialog(new JFrame(), "Une des valeurs n'est pas valide. Veuillez spécifier des valeurs valides entières");
		}
		
		//On vérifie que les valeurs sont bien comprises entre 0 et 255
		if(tabInt[0] > 0 && tabInt[0] < 256 && tabInt[1] > 0 && tabInt[1] < 256 && tabInt[2] > 0 && tabInt[2] < 256 && tabInt[3] > 0 && tabInt[3] < 256)
		{
			adresse = new AdresseIP(tabInt[0], tabInt[1], tabInt[2], tabInt[3]);
		}
		else
		{
			JOptionPane.showMessageDialog(new JFrame(), "Une des valeurs n'est pas valide. Veuillez spécifier des valeurs comprises entre 1 et 255");
		}
		return adresse;
	}
}
