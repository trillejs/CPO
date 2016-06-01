package reseau;


/**
 * Coordonnées d'un Noeud
 */
public class Position {

    private int x; //Abscisse

	private int y; //Ordonnée
    
    /**
     * Crée une position à partir de ses coordonnées x et y
     */
    public Position(int x, int y) {
    	this.x = x;
    	this.y = y;
    }

    /**
     * @return true si la position courante a les mêmes coordonnées que la position p
     * Pré : p non null
     */
    public boolean equals(Position p) {
        return this.getX() == p.getX() && this.getY() == p.getY();
    }
    
    /**
     * distance : fonction qui renvoie la distance entre deux positions
     * @param : a : Position
     * @return un réél
     * Précondition : p non null 
     * Postcondition : retour >=0
     */
    public double distance(Position p){
    	return Math.sqrt(Math.pow(this.getX() - p.getX(), 2)+Math.pow(this.getY() - p.getY(), 2));
    }
    
    public int getX() {
		return this.x;
	}


    /**
     * Nécessité de modifier la position ?
     * @param x
     */
	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return this.y;
	}


	public void setY(int y) {
		this.y = y;
	}
	
	public String toString()
	{
		return "("+this.getX()+","+this.getY()+")";
	}

}