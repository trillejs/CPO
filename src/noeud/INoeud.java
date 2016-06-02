package noeud;

import paquet.Paquet;

public interface INoeud {

    /**seDeplacer
     * Déplace la position du noeud en fonction de son modèle de mobilité
     * Postcondition position != old'position
     */
    public void seDeplacer();

    /**recevoir
     * Reçoit un paquet envoyé au travers du réseau.
     * @param p - Paquet : Paquet à recevoir
     */
    public void recevoir(Paquet p);
  
    /**getAdresseIP
     * @return ip - AdresseIP : Adresse IP du noeud.
     */
    public AdresseIP getAdresseIP();
    /**
     * Vérifie si le noeud courant est actif
     * @return vrai si le noeud est actif, faux si le noeud est inactif
     */
    public boolean estActif();
    
    /**
     * Active ou désactive le noeud en fonction du paramètre actif
     * Si actif = true, on active
     * Si actif = false, on désactive
     * @param actif 
     */
    public void activation(boolean actif);
}
