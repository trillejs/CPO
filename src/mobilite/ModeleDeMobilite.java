package mobilite;

import reseau.*;


public interface ModeleDeMobilite {


    /**
     * Déplace le Noeud à une nouvelle position
     * @return la nouvelle position du noeud après le déplacement
     */
    public abstract Position seDeplacer();

}