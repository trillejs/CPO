package noeud;


import java.awt.geom.Point2D;
import java.util.*;

import mobilite.ModeleDeMobilite;

import paquet.*;

/**
 * 
 */
public class Noeud implements INoeud {


	private AdresseIP adresse;
    private double puissance; //rayon d'émission du noeud
    private int debitEmission;
    private String nom;
    private Point2D.Double position;
    private ModeleDeMobilite modele;
    
    private List<RouteRequest> routeRequestTable;
    private List<Paquet> listeAttente;
    private List<Chemin> tableRoutage;
    
    private boolean actif;

    /**
     * Default constructor
     */
    public Noeud(Point2D.Double p, double puissance, int debit, String nom, AdresseIP adresse, ModeleDeMobilite modele) {
    	
    	this.position = p;
    	this.puissance = puissance;
    	this.debitEmission = debit;
    	this.nom = nom;
    	this.adresse = adresse;
    	this.modele = modele;
    	
    	this.routeRequestTable = new ArrayList<>();
    	this.listeAttente = new ArrayList<>();
    	this.tableRoutage = new ArrayList<>();
    	
    	this.actif = true;
    }



    /**
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



	@Override
	public boolean estActif() {
		// TODO Auto-generated method stub
		return actif;
	}



	@Override
	public void activation(boolean actif) {
		this.actif = actif;
		
	}



	@Override
	public Point2D.Double getPoint() {
		return this.position;
	}
	
	@Override
	public double getPuissance()
	{
		return this.puissance;
	}

}