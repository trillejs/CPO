package noeud;


import java.awt.geom.Point2D;
import java.util.*;
import mobilite.*;
import paquet.*;

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
    	this.modele.seDeplacer();
    }
    
    /**
     * @param n 
     * @param p 
     * @return
     */
    public boolean envoyer(Noeud n, Paquet p) {
        // TODO implement here
    	//Creer evenement de reception
        return false;
    }

    /**
     * @param p 
     * @return
     */
    public void recevoir(Paquet paquet) {
        
    	//le paquet est pour moi
    	if(paquet.getDestination().equals(this.adresse))
    	{
    		if(paquet instanceof RouteRequest)
    		{
    			//C'est un RouteRequest
    			//On enregistre le chemin pour créer le RouteReply
    			//Vérifier la table de routage
    			//Si on a un chemin vers la destination
    				//On envoie un RouteReply
    			//Sinon 
    				//On envoie un RouteRequest contenant le chemin de RouteReply
    			
    		}
    		else if(paquet instanceof RouteReply)
    		{
    			//C'est un RouteReply
    			//On enregistre le nouveau chemin dans la table de routage
    			
    		}
    		else if(paquet instanceof RouteError)
    		{
    			//C'est un RouteError
    			//On recherche tous les chemins qui contiennent le lien dans la table de routage
    			//On supprime tous ces liens
    		}
    		else
    		{
    			//Le paquet est de la donnée
    			
    		}
    	}
    	else
    	{
    		if(paquet instanceof RouteRequest)
    		{
    			//C'est un RouteRequest
    			//Ajouter mon adresse au chemin
    			//Envoie le paquet RouteRequest avec le nouveau chemin  (TTL--)
    			
    		}
    		else if(paquet instanceof RouteReply)
    		{
    			//C'est un RouteReply
    			//Envoie le paquet RouteReply (TTL--)
    			
    		}
    		else if(paquet instanceof RouteError)
    		{
    			//C'est un RouteError
    			//On recherche tous les chemins qui contiennent le lien dans la table de routage
    			//On supprime tous ces liens
    			//On envoie le paquet RouteError (TTL--)
    		}
    		else
    		{
    			//Le paquet est de la donnée
    			//On envoie le paquet donnée (TTL--)
    			
    		}
    	}
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