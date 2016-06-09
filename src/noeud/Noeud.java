package noeud;


import java.awt.geom.Point2D;
import java.util.*;
import mobilite.*;
import paquet.*;

public class Noeud implements INoeud {


	/** Adresse IP du noeud */
	private AdresseIP adresse;
	/** La distance maximale à laquelle le noeud peut atteindre un autre noeud */
    private double puissance;
    /** La vitesse d'envoi des paquets en octet/s */
    private int debitEmission;
    /** Nom du noeud */
    private String nom;
    /** Modèle de mobilité qui gère les déplacements du noeud */
    private ModeleDeMobilite modele;
    /** Booleen qui dit si le noeud est actif ou non */
    private boolean actif;
    
    /** Table qui stocke toutes les RouteRequest qui ont été envoyés ou renvoyer par le noeud */
    private List<RouteRequest> routeRequestTable;
    /** Liste des paquets pour lesquels on attend un RouteReply avant de pouvoir les envoyer */
    private List<Paquet> listeAttente;
    /** Liste des chemins connus du noeud */
    private Map<AdresseIP, Chemin> tableRoutage;
    
    

    /**
     * Crée un noeud
     * @param puissance La distance maximale à laquelle le noeud peut atteindre un autre noeud
     * @param debit La vitesse d'envoi des paquets en octet/s
     * @param nom Nom du noeud
     * @param adresse Adresse IP du noeud
     * @param modele Modèle de mobilité qui gère les déplacements du noeud
     */
    public Noeud(double puissance, int debit, String nom, AdresseIP adresse, ModeleDeMobilite modele) {
    	this.puissance = puissance;
    	this.debitEmission = debit;
    	this.nom = nom;
    	this.adresse = adresse;
    	this.modele = modele;
    	
    	this.routeRequestTable = new ArrayList<>();
    	this.listeAttente = new ArrayList<>();
    	this.tableRoutage = new HashMap<>();
    	
    	this.actif = true;
    }

    /**seDeplacer
     * Déplace la position du noeud en fonction de son modèle de mobilité
     * Postcondition position != old'position
     */
    public void seDeplacer()
    {
    	this.modele.seDeplacer();
    }
    
    /**
     * Supprime tous les chemins de la table de routage qui contiennent le lien passé en paramètre
     * @param source adresse IP du noeud source du lien
     * @param destination adresse IP du noeud destination du lien
     */
    public void supprimerLienRompu(AdresseIP source, AdresseIP destination)
    {    	
    	for(AdresseIP adresse : this.tableRoutage.keySet())
    	{
        	Chemin chemin = this.tableRoutage.get(adresse);
        	if(chemin != null && chemin.containsLien(source, destination))
        	{
        		this.tableRoutage.remove(adresse);
        	}
    	}
    	//Tous les chemins de la table de routage ont été vérifiés
    }
    
    /**
     * Ajoute le chemin à la table de routage
     * @param chemin à ajouter à la table de routage
     */
    public void addRoute(Chemin chemin)
    {
 	   this.tableRoutage.put(chemin.getDestination(), chemin);
    }
    
    /**
    * Verifie qu'un chemin de la table de routage mène à l'adresse IP de destination et renvoie le chemin
    * @param adresse de destination
    * @return le chemin s'il existe, null sinon
    */
   public Chemin getRoute(AdresseIP adresse)
   {
   	return this.tableRoutage.get(adresse);
   }

   /**
    * Active ou désactive le noeud en fonction du paramètre actif
    * Si actif = true, on active
    * Si actif = false, on désactive
    * @param actif
    */
   @Override
   public void activation(boolean actif) {
	   this.actif = actif;
   }

   /**
    * Vérifie si le noeud courant est actif
    * @return vrai si le noeud est actif, faux si le noeud est inactif
    */
   @Override
   public boolean estActif() {
	   return actif;
   }

	/**
     * Donne le point où est situé le noeud
     * @return
     */
    @Override
	public Point2D.Double getPoint() {
//		return this.modele.getPosition();
		return null;
	}
	
	/**
     * Donne la puissance d'émission du noeud
     * @return
     */
    @Override
	public double getPuissance()
	{
		return this.puissance;
	}
	
    /**getAdresseIP
     * @return ip - AdresseIP : Adresse IP du noeud.
     */
    @Override
    public AdresseIP getAdresseIP()
    {
    	return this.adresse;
    }

    /**getDebitEmission
     * retourne l'attribut debitEmission de l'objet de type Noeud
     *
     * La vitesse d'envoi des paquets en octet/s
     *
     * @return int
     */
    @Override
    public int getDebitEmission() {
        return debitEmission;
    }
}