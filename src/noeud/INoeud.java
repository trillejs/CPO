package noeud;

import paquet.Paquet;

public interface INoeud {

    /**
     * Déplace la position du noeud en fonction de son modèle de mobilité
     * Postcondition position != old'position
     */
    public void seDeplacer();
    
    /**
     * @param n 
     * @param p 
     * @return
     */
    public boolean envoyer(Noeud n, Paquet p);

    /**
     * @param p 
     * @return
     */
    public void recevoir(Paquet p);

    /**
     * @param d 
     * @param p 
     * @return
     */
    public void demandeEnvoi(Noeud d, Paquet p);

  
    public AdresseIP getAdresseIP();
}
