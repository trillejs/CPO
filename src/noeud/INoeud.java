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
}
