package noeud;

import java.awt.geom.Point2D;

public interface INoeud {

    /**seDeplacer
     * Déplace la position du noeud en fonction de son modèle de mobilité
     * Postcondition position != old'position
     */
    public void seDeplacer();

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
    
    /**
     * Donne le point où est situé le noeud
     * @return
     */
    public Point2D.Double getPoint();
    
    /**
     * Donne la puissance d'émission du noeud
     * @return
     */
    public double getPuissance();
}
