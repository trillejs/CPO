package exception;

public class ExceptionNoeudAbsent extends Exception {

	public ExceptionNoeudAbsent() {
		super("Le noeud à enlever n'est pas présent sur le réseau.");
	}
}
