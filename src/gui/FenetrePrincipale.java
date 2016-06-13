package gui;

import noeud.INoeud;
import noeud.Noeud;

import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import exception.ExceptionNoeudAbsent;
import exception.ExceptionNoeudPresent;
import gui.evenements.PanneauEvenements;
import gui.simulation.PanneauSimulation;
import noeud.AdresseIP;
import reseau.*;
import simulateur.Evenement;
import simulateur.IOperation;
import simulateur.ISimulateur;
import simulateur.Simulateur;

public class FenetrePrincipale extends JFrame {
	
	private static IReseau reseau;
	private static Simulateur simulateur;
	private static FenetrePrincipale f;
	private static JTabbedPane onglets;

	public FenetrePrincipale() {
		setTitle("Simulateur de réseau ad'hoc");
		setSize(1000,600); 
		setLocation(200,0);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		f = new FenetrePrincipale();
		reseau = Reseau.getInstance();
		simulateur = new Simulateur(30);
		PanneauEvenements panneauEvenements = new PanneauEvenements();
		simulateur.addObserver(panneauEvenements);
		
		//Tabs de la frame
		onglets = new JTabbedPane(); 
		onglets.addTab("Simulation", new PanneauSimulation());
		onglets.addTab("Evenements", panneauEvenements);
		
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
	
	public static void addOperation(int temps, IOperation operation)
	{
		simulateur.enregistrer(new Evenement(temps, operation));
	}
	
	public static ISimulateur getSimulateur()
	{
		return simulateur;
	}

}
