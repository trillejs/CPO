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
    
    /**Distance : fonction qui renvoie la distance entre deux positions
     * Param : 
     * a, b : Position
     * @return un Entier Distance
     * Pré : rien 
     * Post : rien
     */
    public double Distance(Position a, Position b){
    	return Math.sqrt(Math.pow(b.x - a.x, 2)+Math.pow(b.y - a.y, 2));
    }
    
    public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}

}