package exception;

public class ExceptionNoeudAbsent extends Exception {

	public ExceptionNoeudAbsent(String message) {
		super(message);//"Le noeud à enlever n'est pas présent sur le réseau.");
	}
}
