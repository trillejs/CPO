package gui;

import noeud.INoeud;
import noeud.Noeud;

import java.util.Map;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import exception.ExceptionNoeudPresent;

import noeud.AdresseIP;
import reseau.*;

public class FenetrePrincipale extends JFrame {
	
	private static GridBagConstraints contraintes;
	private static IReseau reseau;

	public FenetrePrincipale() {
		setTitle("Simulateur de réseau ad'hoc");
		setSize(800,600); 
		setLocation(200,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		FenetrePrincipale f = new FenetrePrincipale();
		contraintes = new GridBagConstraints();
		reseau = Reseau.getInstance();
		
		JPanel panneauSimulation = new PanneauSimulation(f); //Panneau affiché quand on est en mode simulation
		JPanel panneauPrincipalEvenements = new JPanel(new GridBagLayout()); //Panneau affiché en mode de création des évènements
		JMenuBar menu = new MenuBarre(); //MenuBar de la frame
		
		//Ajout des élèments
		f.setJMenuBar(menu);
		f.add(panneauSimulation);

		f.setVisible(true);
	}
	
	public static Map<AdresseIP, INoeud> getIPs()
	{
		return reseau.getListeNoeuds();
	}
	
	public static void addNoeud(Noeud noeud) throws ExceptionNoeudPresent
	{
		reseau.ajouterNoeud(noeud);
	}
}
