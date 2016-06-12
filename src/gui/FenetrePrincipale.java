package gui;

import noeud.INoeud;
import noeud.Noeud;

import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

//import javax.swing.*;

import exception.ExceptionNoeudAbsent;
import exception.ExceptionNoeudPresent;
import gui.evenements.PanneauEvenements;
import gui.simulation.PanneauSimulation;
import noeud.AdresseIP;
import reseau.*;

public class FenetrePrincipale extends JFrame {
	
	private static IReseau reseau;
	private static FenetrePrincipale f;
	private static JTabbedPane onglets;

	public FenetrePrincipale() {
		setTitle("Simulateur de réseau ad'hoc");
		setSize(800,600); 
		setLocation(200,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		f = new FenetrePrincipale();
		reseau = Reseau.getInstance();
		
		//Tabs de la frame
		onglets = new JTabbedPane(); 
		onglets.addTab("Simulation", new PanneauSimulation());
		onglets.addTab("Evenements", new PanneauEvenements());
		
		//Ajout des élèments
		f.add(onglets);		
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
	
	public static IReseau getReseau()
	{
		return reseau;
	}

	public static void delNoeud(Noeud noeud) throws ExceptionNoeudAbsent {
		reseau.enleverNoeud(noeud.getAdresseIP());		
	}

}
