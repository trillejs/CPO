package noeud;


import java.util.*;

public class Chemin {

	/**
	 * Stocke une liste d'adresses IP et de leur débit d'émission associé,
	 * afin de pouvoir calculer le temps total nécessaire pour envoyer un paquet par ce chemin
	 */
	public List<AbstractMap.SimpleEntry<AdresseIP,Integer>> listeNoeud;
	
    /** Crée un chemin avec une liste de noeuds vide */
    public Chemin() {
    	this.listeNoeud = new ArrayList<>();
    }
    
    /**
     * Ajoute le couple Adresse IP, et son debit associe
     * @param adresse adresse IP du noeud a ajouter au chemin
     * @param debit debit d'emission du noeud
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
    	//L'adresse a été trouvée ou on a parcouru toute la liste
    	return found;
    }

    /**
     * Retourne la somme des tailles des adresses IP composant le chemin
     * @return taille totale du chemin
     */
    public int getTaille()
    {
    	int total = 0;
    	for(AbstractMap.SimpleEntry<AdresseIP,Integer> couple : this.listeNoeud)
    	{
    		total += couple.getKey().getTaille();
    	}
    	//Tous les noeuds du chemin ont été comptés
    	return total;
    }


}