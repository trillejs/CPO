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

}