package noeud;


import java.util.*;

public class Chemin {

	/**
	 * Stocke une liste d'adresses IP et de leur débit d'émission associé,
	 * afin de pouvoir calculer le temps total nécessaire pour envoyer un paquet par ce chemin
	 */
	public List<AbstractMap.SimpleEntry<AdresseIP,Integer>> listeNoeud;
	
    /**
     * Crée un chemin avec une liste de noeuds vide
     */
    public Chemin() {
    	this.listeNoeud = new ArrayList<>();
    }
    
    /**
     * 
     * @param adresse
     * @param debit
     * Precondition adresse != null, debit >=0
     * Postcondition listeNoeud.size() == old'listeNoeud.size()+1
     */
    public void ajouter(AdresseIP adresse, int debit)
    {
    	this.listeNoeud.add(new AbstractMap.SimpleEntry<>(adresse, new Integer(debit)));
    }
    
    /**
     * Cherche si une adresse IP est présente dans le chemin
     * @param adresse à rechercher
     * @return boolean
     * Précondition adresse != null
     */
    public boolean contains(AdresseIP adresse)
    {
    	boolean found = false; // booléen qui indique si l'adresse a été trouvée, initialisé à faux
    	int i = 0;
    	while(!found && i<this.listeNoeud.size())
    	{
    		if(this.listeNoeud.get(i).getKey().equals(adresse))
    		{
    			//le chemin contient bien l'adresse recherchée
    			found = true;
    		}
    		i++;
    	}
    	//l'adresse a été trouvée ou on a parcouru toute la liste
    	return found;
    }

    


}