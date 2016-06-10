package paquet;

import operation.IOpVisiteur;
import reseau.*;
import noeud.*;

public abstract class Paquet {

	/** TTL defini par le reseau */
    private int ttl;
    
    /** AdresseIP du noeud source */
    private AdresseIP source;
    
    /** chemin a parcourir depuis la source pour atteindre la destination */
    protected Chemin destination;

    /** curseur pointant sur l'étape courante du chemin par la source */
    private int curseur;

    /**
     * Constructeur du paquet generique
     * @param source AdresseIP du noeud source
     * @param destination chemin a parcourir depuis la source pour atteindre la destination
     * Précondition : source != null && chemin != null
     */
    public Paquet(AdresseIP source, Chemin destination) {
    	this.ttl = Reseau.getInstance().getTTL();
    	this.source = source;
    	this.destination = destination;
        this.curseur = 1;
    }
    
    /**getTaille
     * Retourne la taille totale du paquet
     * @return
     */
    public int getTaille()
    {
    	int taille = 1; //La taille du paquet est de au moins 1, car le TTL est de taille 1
    	taille += this.source.getTaille();
    	taille += this.destination.getTaille();

    	return taille;
    }

    /**getSource
     * Retourne l'adresse IP source du paquet
     * @return
     */
    public AdresseIP getSource()
    {
    	return this.source;
    }

    /**getDestination
     * Retourne l'adresse IP destination du paquet
     * @return
     */
    public AdresseIP getDestination()
    {
    	return this.destination.getDestination();
    }
    
    /**decrementerTTL
     * Decremente le TTL
     */
    public void decrementerTTL()
    {
    	this.ttl--;
    }
    
    /**getTTL
     * Retourne le TTL du paquet
     * @return TTL
     */
    public int getTTL()
    {
    	return this.ttl;
    }

    /**getChemin
     * retourne l'attribut chemin de l'objet de type Paquet
     *
     * chemin a parcourir depuis la source pour atteindre la destination
     *
     * @return Chemin
     */
    public Chemin getChemin() {
        return destination;
    }

    /**incCurseur
     * incrémente le curseur, appellé à chaque étape dans le chemin vers la destination
     */
    public void incCurseur(){
        curseur++;
    }

    /**accepter
     * méthode abstraite à redéfinir dans chaque implémentation de Paquet
     * permet d'implanter le patron de conception visiteur
     * @param iOpVisiteur - IOpVisiteur : Opération Visiteur comportant les méthodes
     *                    de traitement du paquet
     */
    public abstract void accepter(IOpVisiteur iOpVisiteur);
}