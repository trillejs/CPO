package reseau;


import java.util.*;

import exception.*;

import noeud.*;

public class Reseau implements IReseau{
	
    public final int TTL;
    private List<INoeud> listNoeuds;
    
    private static Reseau instance;
    
    public Reseau(int TTL) {
    	this.listNoeuds = new ArrayList<>();
    	this.TTL = TTL;
    }
    
    public Reseau() {
    	this.listNoeuds = new ArrayList<>();
    	this.TTL = 255;
    }

    public static Reseau createInstance(int TTL)
    {
    	if(instance == null)
    	{
    		instance = new Reseau(TTL);
    	}
    	return instance;
    }
    
    public static Reseau getInstance()
    {
    	if(instance == null)
    	{
    		instance = new Reseau();
    	}
    	return instance;
    }
    
    public void ajouterNoeud(INoeud noeud) throws ExceptionNoeudPresent {
    	if(this.listNoeuds.contains(noeud))
    	{
    		throw new ExceptionNoeudPresent("Le noeud est déjà sur le réseau");
    	}
    	else
    	{
    		this.listNoeuds.add(noeud);
    	}
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
				INoeud dest = getNoeud(ipDestination);
				INoeud source = getNoeud(ipSource);
				//vérifie que source a une puissance suffisante pour atteindre destination
				if(dest.getPoint().distance(source.getPoint()) <= source.getPuissance())
				{
					resultat = true;
				}
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
			throw new ExceptionNoeudAbsent("Cette adresse IP n'est pas dans le réseau");//"Cette adresse IP n'est pas dans la liste"
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



	@Override
	public void deplacerNoeuds() {
		for(INoeud noeud: this.listNoeuds)
		{
			noeud.seDeplacer();
		}
		//tous les noeuds se sont déplacés
	}

}