package simulateur;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Simulateur implements ISimulateur {

    private Queue<IEvenement> fileAttente;
    private Queue<IEvenement> fileFini;

    /**Simulateur
     * instancie la file d'attente et la file des évènements finit
     * Précondition : /
     * Postcondition : Les deux files sont vides
     */
    public Simulateur() {
        ComparateurDate cD = new ComparateurDate();
        Queue<IEvenement> fileAttente = new PriorityQueue<IEvenement>(1, cD);
        Queue<IEvenement> fileFini = new LinkedList<IEvenement>();
    }

    /**
     * enregistrer
     * positionne l'évènement dans la file d'attente des évènements du simulateur
     *
     * @param evenement - IEvenement : Evenement à ajouter à la liste
     * Précondition : /
     * Postcondition : L'évenement appartient à la file
     *                  && La file d'attente n'est pas vide
     */
    public void enregistrer(IEvenement evenement) {
        fileAttente.add(evenement);
    }

    /**
     * avancer
     * execute l'évènement suivant dans la file des évènements en attente et le transfert dans la file des finit
     * Précondition : La file n'est pas vide
     * Postcondition : L'évènement en tête de file d'attente se retrouve maintenant en queue de file de finit
     *                  && La file de finit n'est pas vide
     */
    public void avancer() {
        fileAttente.peek().seProduire();
        fileFini.add(fileAttente.poll());
    }

    // Classe interne pour implementer le comparateur de la PriorityQueue
    private class ComparateurDate implements Comparator<IEvenement> {

        @Override
        public int compare(IEvenement e1, IEvenement e2) {
            return e1.getDate().compareTo(e2.getDate());
        }
    };


    public Queue<IEvenement> getFileAttente() {
        return fileAttente;
    }

    public Queue<IEvenement> getFileFini() {
        return fileFini;
    }
}
