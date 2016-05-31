package reseau;


import java.util.*;

import noeud.*;

/**
 * 
 */
public class Reseau {

	
    /**
     * 
     */
    private double TTL;

    /**
     * 
     */
    private double nbNoeuds;
    private List<Noeud> listNoeuds;
    
    /**
     * Default constructor
     */
    public Reseau() {
    	this.listNoeuds = new ArrayList<>();
    }


    /**
     * @param n 
     * @return
     */
    public void ajouter(Noeud n) {
        this.listNoeuds.add(n);
    }

    /**
     * @param ip 
     * @return
     */
    public Noeud getNoeud(AdresseIP ip) {
        Noeud ret = null;
    	int i = 0;
        boolean trouve = false;
        while(i < this.listNoeuds.size() && !trouve)
        {
        	if(this.listNoeuds.get(i).getAdresseIP().equals(ip))
        	{
        		trouve = true;
        		ret = this.listNoeuds.get(i);
        	}
        }
        return ret;
    }


	/**
	 * @return the tTL
	 */
	public double getTTL() {
		return TTL;
	}


	/**
	 * @param tTL the tTL to set
	 */
	public void setTTL(double tTL) {
		TTL = tTL;
	}


	/**
	 * @return the nbNoeuds
	 */
	public double getNbNoeuds() {
		return nbNoeuds;
	}


	/**
	 * @param nbNoeuds the nbNoeuds to set
	 */
	public void setNbNoeuds(double nbNoeuds) {
		this.nbNoeuds = nbNoeuds;
	}

}