package reseau;



import exception.*;

import noeud.*;

import java.util.HashMap;
import java.util.Map;

public class Reseau implements IReseau{
	
    public final int TTL;
    private Map<AdresseIP, INoeud> listNoeuds;
    
    private static Reseau instance;
    
    private Reseau(int TTL) {
		this.listNoeuds = new HashMap<AdresseIP, INoeud>(10,0.75);
    	this.TTL = TTL;
    }
    
    private Reseau() {
    	this(255);
    }

    public static Reseau createInstance(int TTL)
    {
    	if(instance == null)
    	{
    		instance = new Reseau(TTL);
    	}
    	return instance;
    }

	public static Reseau createInstance()
	{
		if(instance == null)
		{
			instance = new Reseau();
		}
		return instance;
	}
    
    public static Reseau getInstance()
    {
    	if(instance == null)
    	{
    		instance = createInstance();
    	}
    	return instance;
    }
    
    /**ajouterNoeud (avec un noeud)
     * Ajoute un noeud au réseau en passant directement un Noeud en paramètre
     * @param noeud - INoeud : Noeud à ajouter au réseau
     * @exception ExceptionNoeudPresent : Si le noeud identifié par son adresse IP est déjà sur le réseau.
     */
	public void ajouterNoeud(INoeud noeud) throws ExceptionNoeudPresent {
    	if(this.listNoeuds.containsValue(noeud))
    	{
    		throw new ExceptionNoeudPresent("Le noeud est déjà sur le réseau");
    	}
    	else
    	{
    		this.listNoeuds.put(noeud.getAdresseIP(), noeud);
    	}
    }

	/**enleverNoeud
	 * Enlève un noeud du réseau à partir de son identifiant unique : l'adresse IP
	 * @param ip - AdresseIP : adresse du noeud à retirer du réseau
	 * @exception ExceptionNoeudAbsent : Quand le noeud à enlever n'est pas présent dans le réseau
	 */
	@Override
	public void enleverNoeud(AdresseIP ip) throws ExceptionNoeudAbsent {
		if(!appartientAuReseau(ip))
		{
			throw new ExceptionNoeudAbsent("Cette adresse IP n'est pas dans le réseau");//"Cette adresse IP n'est pas dans la liste"
		}
		else
		{
			this.listNoeuds.remove(ip);
		}

	}

	/**appartientAuRéseau
	 * Vérifie qu'un noeud est présent sur le réseau
	 * @param ip - AdresseIP : adresse ip du noeud à chercher
	 * @return appartient - boolean : vrai si le noeud appartient au réseau, faux sinon
	 */
	@Override
	public boolean appartientAuReseau(AdresseIP ip) {
		return getNoeud(ip) != null;
	}

	/**atteignable
	 * Retourne si un noeud identifié par son adresse IP est atteignable : activé et à portée de l'envoyeur.
	 * @param ipSource - AdresseIP : adresse ip du noeud source
	 * @param ipDestination - AdresseIP : adresse ip du noeud à atteindre
	 * @return atteignable - Boolean : vrai si le noeud est atteignable, faux sinon
	 */
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

	/**deplacerNoeuds
	 * Déplace tous les noeuds présents dans le réseau
	 */
	@Override
	public void deplacerNoeuds() {
		for(Map.Entry<AdresseIP, INoeud> entry: listNoeuds.entrySet())
		{
			entry.getValue().seDeplacer();
		}
		//tous les noeuds se sont déplacés
	}

	/**getTTL
	 * Retourne le Time To Live général des paquets sur le réseau.
	 * Le TTL est décidé à la création du réseau et n'est plus modifiable au cours de la simulation.
	 * @return ttl - Integer : Time to live des paquets du réseau
	 */
	@Override
	public int getTTL() {
		return TTL;
	}

	/**getListeNoeud
	 * Retourne la liste des noeuds du réseau.
	 *
	 * @return liste - HashMap<AdresseIP, INoeud>: Liste des noeuds du réseau
	 */
	public Map<AdresseIP, INoeud> getListNoeuds() {
		return listNoeuds;
	}

	/**getNoeud
	 * Accesseur d'un noeud du réseau à partir de son adresse IP
	 * @param ip - AdresseIP : adresse du Noeud à retourner
	 * @return noeud - INoeud : noeud retourné si trouvé, null sinon
	 */
	@Override
	public INoeud getNoeud(AdresseIP ip) {
    	return listNoeuds.get(ip);
    }
}
