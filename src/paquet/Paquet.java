package paquet;

import reseau.Reseau;

import noeud.*;

/**
 * 
 */
public abstract class Paquet {

    /**
     * Default constructor
     */
    public Paquet(AdresseIP source, AdresseIP destination, Chemin chemin) {
    	this.TTL = Reseau.getInstance().getTTL();
    }

    private int TTL;
    private AdresseIP source;
    private AdresseIP destination;
    protected Chemin chemin;
    
    /**
     * 
     * @return
     */
    public int getTaille()
    {
    	int taille = 1; //La taille du paquet est de au moins 1, car le TTL est de taille 1
    	taille += this.source.getTaille();
    	taille += this.destination.getTaille();
    	taille += this.chemin.getTaille();
    	
    	return taille;
    }

    public AdresseIP getSource()
    {
    	return this.source;
    }

    public AdresseIP getDestination()
    {
    	return this.destination;
    }
    
    public void modifierTTL()
    {
    	this.TTL--;
    }
    
    public int getTTL()
    {
    	return this.TTL;
    }
    

}