package reseau;

import exception.ExceptionNoeudAbsent;
import exception.ExceptionNoeudPresent;
import noeud.AdresseIP;
import noeud.INoeud;

import java.util.Map;

/**Interface Reseau
 * @author G5
 *Emule certaines parties des couches réseaux et accès. 
 *Permet de contrôller les états des différents noeuds du réseau.
 */
public interface IReseau {

	/**
	 * Retourne si un noeud identifié par son adresse IP est atteignable : activé et à portée de l'envoyeur.
	 * @param ipSource - AdresseIP : adresse ip du noeud source
	 * @param ipDestination - AdresseIP : adresse ip du noeud à atteindre
	 * @return atteignable - Boolean : vrai si le noeud est atteignable, faux sinon
	 */
	public boolean atteignable(AdresseIP ipSource, AdresseIP ipDestination);
	
	/**�seau
	 * Vérifie qu'un noeud est présent sur le réseau
	 * @param ip - AdresseIP : adresse ip du noeud à chercher
	 * @return appartient - boolean : vrai si le noeud appartient au réseau, faux sinon
	 */
	public boolean appartientAuReseau(AdresseIP ip);

	/**ajouterNoeud (avec un noeud)
	 * Ajoute un noeud au réseau en passant directement un Noeud en paramètre
	 * @param n - INoeud : Noeud à ajouter au réseau
	 * @exception ExceptionNoeudPresent : Si le noeud identifié par son adresse IP est déjà sur le réseau.
	 */
	public void ajouterNoeud(INoeud n)throws ExceptionNoeudPresent;
	
	/**
	 * Enlève un noeud du réseau à partir de son identifiant unique : l'adresse IP
	 * @param ip - AdresseIP : adresse du noeud à retirer du réseau
	 * @exception ExceptionNoeudAbsent : Quand le noeud à enlever n'est pas présent dans le réseau
	 */
	public void enleverNoeud(AdresseIP ip) throws ExceptionNoeudAbsent;
	
	/**
	 * Accesseur d'un noeud du réseau à partir de son adresse IP
	 * @param ip - AdresseIP : adresse du Noeud à retourner
	 * @return noeud - INoeud : noeud retourné si trouvé, null sinon
	 */
	public INoeud getNoeud(AdresseIP ip);
	
	/**
	 * Retourne le Time To Live général des paquets sur le réseau. 
	 * Le TTL est décidé à la création du réseau et n'est plus modifiable au cours de la simulation.
	 * @return ttl - Integer : Time to live des paquets du réseau
	 */
	public int getTTL();

	/**
	 * Retourne la liste des noeuds du réseau.
	 *
	 * @return liste - Map<AdresseIP, INoeud>: Liste des noeuds du réseau
	 */
	public Map<AdresseIP, INoeud> getListeNoeuds();

	/**
	 * Déplace tous les noeuds présents dans le réseau
	 */
	public void deplacerNoeuds();
}
