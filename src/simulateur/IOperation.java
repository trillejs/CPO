package simulateur;

public interface IOperation {

	
	/**executer
	 * Execute les intructions composant l'opération
	 * @param simulateur - Simulateur : Simulateur
	 * @param date - int : Date d'execution de l'opération
	 */
	public void executer(Simulateur simulateur, int date);
}
