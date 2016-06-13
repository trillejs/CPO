package mobilite;

import java.awt.geom.Point2D;

public interface ModeleDeMobilite {
	
    /**
     * Déplace le Noeud à une nouvelle position
     */

    public void seDeplacer();
    
    /** 
     * getPosition
     * @return la position courante du noeud
     */
    
    public Point2D.Double getPosition();

}