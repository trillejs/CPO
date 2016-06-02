package noeud;


import java.util.*;

import mobilite.ModeleDeMobilite;

import paquet.*;

import reseau.Position;

/**
 * 
 */
public class Noeud implements INoeud {


	private AdresseIP adresse;
    private int puissance;
    private int debitEmission;
    private String nom;
    private Position position;
    private ModeleDeMobilite modele;
    
    private List<RouteRequest> routeRequestTable;
    private List<Paquet> listeAttente;
    private List<Chemin> tableRoutage;

    /**
     * Default constructor
     */
    public Noeud(Position p, int puissance, int debit, String nom, AdresseIP adresse, ModeleDeMobilite modele) {
    	
    	this.position = p;
    	this.puissance = puissance;
    	this.debitEmission = debit;
    	this.nom = nom;
    	this.adresse = adresse;
    	this.modele = modele;
    	
    	this.routeRequestTable = new ArrayList<>();
    	this.listeAttente = new ArrayList<>();
    	this.tableRoutage = new ArrayList<>();
    }



    /*
     * Déplace la position du noeud en fonction de son modèle de mobilité
     * Postcondition position != old'position
     * 
     */
    public void seDeplacer()
    {
    	this.position = this.modele.seDeplacer();
    }
    
    /**
     * @param n 
     * @param p 
     * @return
     */
    public boolean envoyer(Noeud n, Paquet p) {
        // TODO implement here
        return false;
    }

    /**
     * @param p 
     * @return
     */
    public void recevoir(Paquet p) {
        // TODO implement here
    }

    /**
     * @param d 
     * @param p 
     * @return
     */
    public void demandeEnvoi(Noeud d, Paquet p) {
        // TODO implement here
    }

  
    public AdresseIP getAdresseIP()
    {
    	return this.adresse;
    }

}