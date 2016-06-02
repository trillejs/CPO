package reseau;


import java.util.*;

import exception.*;

import noeud.*;

public class Reseau implements IReseau{
	
    public final int TTL;
    private List<INoeud> listNoeuds;
    
   
    public Reseau(int TTL) {
    	this.listNoeuds = new ArrayList<>();
    	this.TTL = TTL;
    }


    
    public void ajouterNoeud(INoeud n) {
        this.listNoeuds.add(n);
    }

	@Override
	public boolean atteignable(AdresseIP ipSource, AdresseIP ipDestination) {
		boolean resultat = false;
		
		//vérifie source et dest appartientAuReseau		
		if(appartientAuReseau(ipSource) && appartientAuReseau(ipDestination))
		{
			//vérifie que dest est actif
			if(getNoeud(ipDestination).estActif())
			{
				//vérifie que source a une puissance suffisante pour atteindre destination
				//resultat = true;
			}
		}
		return resultat;
	}



	@Override
	public boolean appartientAuReseau(AdresseIP ip) {
		return getNoeud(ip) != null;
	}



	@Override
	public void enleverNoeud(AdresseIP ip) throws ExceptionNoeudAbsent {
		if(!appartientAuReseau(ip))
		{
			throw new ExceptionNoeudAbsent();//"Cette adresse IP n'est pas dans la liste"
		}
		else
		{
			this.listNoeuds.remove(getNoeud(ip));
		}
		
	}



	@Override
	public int getTTL() {
		return TTL;
	}
	
   
	@Override
	public INoeud getNoeud(AdresseIP ip) {
        INoeud ret = null;
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
        //On a parcouru toute la liste OU on a trouvé le noeud
        return ret;
    }

}