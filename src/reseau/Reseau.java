package reseau;


import java.util.*;

import noeud.*;

/**
 * 
 */
public class Reseau implements IReseau{
	
    /**
     * 
     */
    private int TTL;

    /**
     * 
     */
    private double nbNoeuds;
    private List<Noeud> listNoeuds;
    
   
    public Reseau() {
    	this.listNoeuds = new ArrayList<>();
    }


    
    public void ajouterNoeud(INoeud n) {
        this.listNoeuds.add((Noeud) n);
    }

	@Override
	public boolean atteignable(AdresseIP ip) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean appartientAuReseau(AdresseIP ip) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public void ajouterNoeud(AdresseIP ip) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void enleverNoeud(AdresseIP ip) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getTTL() {
		// TODO Auto-generated method stub
		return TTL;
	}
	
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