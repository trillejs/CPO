package noeud;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;

import mobilite.ModeleDeMobilite;

public interface INoeud {

    /**seDeplacer
     * Déplace la position du noeud en fonction de son modèle de mobilité
     * Postcondition position != old'position
     */
    public void seDeplacer();

    /**supprimmerLienRompu
     * Supprime tous les chemins de la table de routage qui contiennent le lien passé en paramètre
     * @param source adresse IP du noeud source du lien
     * @param destination adresse IP du noeud destination du lien
     */
    public void supprimerLienRompu(AdresseIP source, AdresseIP destination);
    
    /**ajouterRoute
     * Ajoute le chemin à la table de routage
     * @param chemin à ajouter à la table de routage
     */
    public void ajouterRoute(Chemin chemin);
    
    /**
    * Verifie qu'un chemin de la table de routage mène à l'adresse IP de destination et renvoie le chemin
    * @param adresse de destination
    * @return le chemin s'il existe, null sinon
    */
    public Chemin getRoute(AdresseIP adresse);

    public Map<AdresseIP, Chemin> getRouteTable();

    /**
     * Active ou désactive le noeud en fonction du paramètre actif
     * Si actif = true, on active
     * Si actif = false, on désactive
     * @param actif 
     */
    public void activation(boolean actif);
    
    /**
     * Vérifie si le noeud courant est actif
     * @return vrai si le noeud est actif, faux si le noeud est inactif
     */
    public boolean estActif();
    
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
    
    /**getAdresseIP
     * @return ip - AdresseIP : Adresse IP du noeud.
     */
    public AdresseIP getAdresseIP();

    /**getDebitEmission
     * retourne l'attribut debitEmission de l'objet de type Noeud
     *
     * La vitesse d'envoi des paquets en octet/s
     *
     * @return int
     */
    public int getDebitEmission();

    public List<String> getMessagesRecus();

    public void ajouterMessage(String message);

    public ModeleDeMobilite getModele();

    public String getNom();

}
