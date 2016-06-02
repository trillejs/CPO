package simulateur;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Simulateur implements ISimulateur {

    private List<IEvenement> fileAttente;
    private Queue<IEvenement> fileFini;

    /**Simulateur
     * instancie la file d'attente et la file des finis d'évenement
     * Précondition : /
     * Postcondition : Les deux listes sont vides
     */
    public Simulateur() {
        Queue<IEvenement> fileAttente = new PriorityQueue<>();
        Queue<IEvenement> fileFini = new PriorityQueue<IEvenement>();
    }

    /**
     * enregistrer
     * positionne l'évenement dans la file d'attente des évenements du simulateur
     *
     * @param evenement - IEvenement : Evenement à ajouter à la liste
     * Précondition : /
     * Postcondition : L'évenement appartient à la liste
     *                  && La liste d'attente n'est pas vide
     */
    public void enregistrer(IEvenement evenement) {
        fileAttente
    }

    /**
     * avancer
     * execute l'évènement suivant dans la liste des évènements en attente
     */
    public void avancer() {

    }
}
