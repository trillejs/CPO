package noeud;


import java.util.*;

public class Chemin {

	/**
	 * Stocke une liste d'adresses IP et de leur débit d'émission associé,
	 * afin de pouvoir calculer le temps total nécessaire pour envoyer un paquet par ce chemin
	 */
	private Map<AdresseIP, Integer> listeNoeud;
	
    /** Crée un chemin avec une liste de noeuds vide */
    public Chemin() {
    	this.listeNoeud = new LinkedHashMap<AdresseIP, Integer>(1, (float) 0.75);
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
		listeNoeud.put(adresse, debit);
    }
    
    /**
     * Cherche si une adresse IP est présente dans le chemin
     * @param adresse à rechercher
     * @return boolean
     * Précondition adresse != null
     */
    public boolean contains(AdresseIP adresse)
    {
		return listeNoeud.get(adresse) != null;
    }

	/**getNombreSaut
	 * retourne la taille de la Map listeNoeud
	 *
	 * @return int
	 */
	public int getNombreSaut(){
		return listeNoeud.size();
	}

    /**
     * Retourne la somme des tailles des adresses IP composant le chemin
     * @return taille totale du chemin
     */
    public int getTaille()
    {
    	int total = 0;
    	for(Map.Entry<AdresseIP,Integer> couple : listeNoeud.entrySet())
    	{
    		total += couple.getKey().getTaille();
    	}
    	//Tous les noeuds du chemin ont été comptés
    	return total;
    }

    /**getDestination
     * Retourne la destination du chemin
     * @return destination derniere adresse ip du chemin
     */
    public AdresseIP getDestination()
    {
		LinkedList<AdresseIP> temp = new LinkedList<AdresseIP>(listeNoeud.keySet());
    	return temp.getLast();
	}
    
    /**
     * Vérifie si un lien fait partie du chemin
     * @param source adresse IP du noeud source du lien
     * @param destination adresse IP du noeud destination du lien
     * @return vrai si le chemin contient le lien, faux sinon
     */
    public boolean containsLien(AdresseIP source, AdresseIP destination)
    {
		return listeNoeud.containsKey(source) && listeNoeud.entrySet().iterator().hasNext() && listeNoeud.entrySet().iterator().next().getKey().equals(source);
    }

    /**
     * Vérifie si le chemin courant est plus rapide que le chemin passé en paramètre
     * @param chemin à comparer avec le chemin courant
     * @return vrai si le chemin courant est plus rapide que celui passé en paramètre
     */
    public boolean estPlusRapide(Chemin chemin)
    {
    	double sommeThis = 0;
    	for(Map.Entry<AdresseIP, Integer> entry : listeNoeud.entrySet())
    	{
    		sommeThis += entry.getValue();
    	}
    	
    	double sommeAutre = 0;
    	for(Map.Entry<AdresseIP, Integer> entry : chemin.getListeNoeud().entrySet())
    	{
    		sommeAutre += entry.getValue();
    	}
    	
    	return (sommeAutre/sommeThis) < 1;
    }
    //tps du chemin =  somme(1/debit)
    // x1/x2 < 1 => x1 est plus rapide, sinon x2 est plus rapide


	/**getListeNoeud
	 * retourne l'attribut listeNoeud de l'objet de type Chemin
	 *
	 *  Stocke une liste d'adresses IP et de leur débit d'émission associé,
	 *
	 * @return Map<AdresseIP, Integer>
	 */
	public Map<AdresseIP, Integer> getListeNoeud() {
		return listeNoeud;
	}
}
