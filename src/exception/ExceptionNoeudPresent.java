package exception;

public class ExceptionNoeudPresent extends Exception {
	public ExceptionNoeudPresent() {
		super("Le noeud est déjà sur le réseau ou tout du moins l'adresse IP de ce noeud est déjà utilisé sur ce réseau.");
	}
}
