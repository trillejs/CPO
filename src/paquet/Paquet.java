package paquet;

import reseau.*;
import noeud.*;

public abstract class Paquet {

	/** TTL defini par le reseau */
    private int TTL;
    
    /** AdresseIP du noeud source */
    private AdresseIP source;
    
    /** AdresseIP du noeud destination */
    private AdresseIP destination;
    
    /** chemin a parcourir depuis la source pour atteindre la destination */
    protected Chemin chemin;

    /**
     * Constructeur du paquet generique
     * @param source AdresseIP du noeud source
     * @param destination AdresseIP du noeud destination
     * @param chemin chemin a parcourir depuis la source pour atteindre la destination
     * Précondition : source != null && destination != null && chemin != null
     */
    public Paquet(AdresseIP source, AdresseIP destination, Chemin chemin) {
    	this.TTL = Reseau.getInstance().getTTL();
    	this.source = source;
    	this.destination = destination;
    	this.chemin = chemin;
    }
    
    /**
     * Retourne la taille totale du paquet
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

    /**
     * Retourne l'adresse IP source du paquet
     * @return
     */
    public AdresseIP getSource()
    {
    	return this.source;
    }

    /**
     * Retourne l'adresse IP destination du paquet
     * @return
     */
    public AdresseIP getDestination()
    {
    	return this.destination;
    }
    
    /**
     * Decremente le TTL
     */
    public void decrementerTTL()
    {
    	this.TTL--;
    }
    
    /**
     * Retourne le TTL du paquet
     * @return TTL
     */
    public int getTTL()
    {
    	return this.TTL;
    }
    

}