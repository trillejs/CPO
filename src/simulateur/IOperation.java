package simulateur;

import java.util.Date;

public interface IOperation {

	
	/**executer
	 * Execute les intructions composant l'opération
	 * @param simulateur - Simulateur : Simulateur
	 * @param date - Date : Date d'occurence de l'évenement appelant
	 */
	public void executer(Simulateur simulateur, Date date);
}
