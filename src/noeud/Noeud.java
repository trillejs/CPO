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



	/**
	 * @return the adresse
	 */
	public AdresseIP getAdresse() {
		return adresse;
	}



	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(AdresseIP adresse) {
		this.adresse = adresse;
	}



	/**
	 * @return the puissance
	 */
	public int getPuissance() {
		return puissance;
	}



	/**
	 * @param puissance the puissance to set
	 */
	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}



	/**
	 * @return the debitEmission
	 */
	public int getDebitEmission() {
		return debitEmission;
	}



	/**
	 * @param debitEmission the debitEmission to set
	 */
	public void setDebitEmission(int debitEmission) {
		this.debitEmission = debitEmission;
	}



	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}



	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}



	/**
	 * @return the routeRequestTable
	 */
	public List<RouteRequest> getRouteRequestTable() {
		return routeRequestTable;
	}



	/**
	 * @param routeRequestTable the routeRequestTable to set
	 */
	public void setRouteRequestTable(List<RouteRequest> routeRequestTable) {
		this.routeRequestTable = routeRequestTable;
	}



	/**
	 * @return the listeAttente
	 */
	public List<Paquet> getListeAttente() {
		return listeAttente;
	}



	/**
	 * @param listeAttente the listeAttente to set
	 */
	public void setListeAttente(List<Paquet> listeAttente) {
		this.listeAttente = listeAttente;
	}



	/**
	 * @return the tableRoutage
	 */
	public List<Chemin> getTableRoutage() {
		return tableRoutage;
	}



	/**
	 * @param tableRoutage the tableRoutage to set
	 */
	public void setTableRoutage(List<Chemin> tableRoutage) {
		this.tableRoutage = tableRoutage;
	}



	@Override
	public Point getPoint() {
		// TODO Auto-generated method stub
		return this.position;
	}
	
	

}