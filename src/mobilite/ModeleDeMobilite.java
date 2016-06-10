package mobilite;

import java.awt.geom.Point2D;

public interface ModeleDeMobilite {
	
    /**
     * Déplace le Noeud à une nouvelle position
     * @return la nouvelle position du noeud après le déplacement
     */

    public Point2D.Double seDeplacer();
    
    /** 
     * getPosition
     * @return la position courante du noeud
     */
    
    public Point2D.Double getPosition();

}