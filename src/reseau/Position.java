package reseau;



/**
 * Coordonnées d'un Noeud
 */
public class Position {

    private int x;
    private int y;
    
    /**
     * Crée une position à partir de ses coordonnées x et y
     */
    public Position(int x, int y) {
    	this.x = x;
    	this.y = y;
    }


    /**
     * @return true si la position courante a les mêmes coordonnées que la position p
     */
    public boolean equals(Position p) {
        return this.x == p.x && this.y == p.y;
    }

}