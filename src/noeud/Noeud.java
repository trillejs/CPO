package noeud;


import java.util.*;

import paquet.*;

import reseau.Position;

/**
 * 
 */
public class Noeud {


	private AdresseIP adresse;
    private int puissance;
    private int debitEmission;
    private String nom;
    private Position position;
    
    private List<RouteRequest> routeRequestTable;
    private List<Paquet> listeAttente;
    private List<Chemin> tableRoutage;

    /**
     * Default constructor
     */
    public Noeud(Position p, int puissance, int debit, String nom, AdresseIP adresse) {
    	
    	this.position = p;
    	this.puissance = puissance;
    	this.debitEmission = debit;
    	this.nom = nom;
    	this.adresse = adresse;
    	
    	this.routeRequestTable = new ArrayList<>();
    	this.listeAttente = new ArrayList<>();
    	this.tableRoutage = new ArrayList<>();
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