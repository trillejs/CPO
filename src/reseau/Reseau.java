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

}