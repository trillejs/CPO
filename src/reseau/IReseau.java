package reseau;

import noeud.AdresseIP;
import noeud.INoeud;

public interface IReseau {

	/**atteignable
	 * Retourne si un noeud identifié par son adresse IP est atteignable
	 * @param ip - AdresseIP : adresse ip du noeud à atteindre
	 * @return atteignable - Boolean : vrai si le noeud est atteignable, faux sinon
	 */
	public boolean atteignable(AdresseIP ip);
	
	/**Appartient au réseau
	 * Vérifie qu'un noeud est présent sur le réseau
	 * @param ip - AdresseIP : adresse ip du noeud à chercher
	 * @return appartient - boolean : vrai si le noeud appartient au réseau, faux sinon
	 */
	public boolean appartientAuReseau(AdresseIP ip);
	
	/**ajouter noeud (avec un noeud)
	 * Ajoute un noeud au réseau en passant directement un Noeud en paramètre
	 * @param n - INoeud : Noeud à ajouter au réseau
	 */
	public void ajouterNoeud(INoeud n);
	
	/**ajouter noeud (avec une adresse ip)
	 * Ajoute un noeud au réseau en ne spécifiant que l'adresse ip, le reste des paramètres est demandé à l'utilisateur ultérieurement
	 * @param ip - AdresseIP : adresse ip identifieur unique d'un noeud
	 */
	public void ajouterNoeud(AdresseIP ip);
	
	/**enlever noeud
	 * Enlève un noeud du réseau à partir de son identifiant unique : l'adresse IP
	 * @param ip - AdresseIP : adresse du noeud à retirer du réseau
	 */
	public void enleverNoeud(AdresseIP ip);
	
	/**getNoeud
	 * Accesseur d'un noeud du réseau à partir de son adresse IP
	 * @param ip - AdresseIP : adresse du Noeud à retourner
	 * @return noeud - INoeud : noeud retourné si trouvé, null sinon
	 */
	public INoeud getNoeud(AdresseIP ip);
	
	/**getTTL
	 * Retourne le Time To Live général des paquets sur le réseau. 
	 * Le TTL est décidé à la création du réseau et n'est plus modifiable au cours de la simulation.
	 * @return ttl - Integer : Time to live des paquets du réseau
	 */
	public int getTTL();
}
