package simulateur;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class Simulateur
 * Un simulateur est un moteur de traitement des évenements sur les individus
 * d'un système.
 * Pour utiliser le simulateur avec un système il faut faire heriter les objets
 * du système des classes Systeme, Evenement et Individu.
 * @author Florian Postic
 */
public class Simulateur implements ISimulateur {

    /** File des évenements en attente d'être executés  */
    private Queue<IEvenement> fileAttente;
    /** File des évenements terminés  */
    private Queue<IEvenement> fileFini;
    /** Compteur de temps virtuel */
    private int tCourant;
    /** Instant auquel se termine la simulation */
    private int tFin;

    /**Simulateur
     * instancie la file d'attente, la file d'évenements terminés
     * et initialise le temsp t0
     * @param tFin - int : Instant auquel se termine la simulation
     * Précondition : /
     * Postcondition : Les deux files sont vides
     */
    public Simulateur(int tFin) {
        ComparateurTExec cT = new ComparateurTExec();
        Queue<IEvenement> fileAttente = new PriorityQueue<IEvenement>(1, cT);
        Queue<IEvenement> fileFini = new LinkedList<IEvenement>();
        tCourant = 0;
        this.tFin = tFin;
    }

    /**enregistrer
     * Positionne l'évènement dans la file d'attente des évènements du simulateur
     *
     * @param evenement - IEvenement : Evènement à ajouter à la liste
     * Précondition : /
     * Postcondition : L'évenement appartient à la file
     *                  && La file d'attente n'est pas vide
     */
    public void enregistrer(IEvenement evenement) {
        fileAttente.add(evenement);
    }

    /**
     * avancer
     * execute l'évènement suivant dans la file des évènements en attente,
     * le transfert dans la file des "fini" si son temps d'execution vaut 1
     * sinon il ira dans la file des "en cours" et vera son temps d'execution décrémenté
     *
     * Précondition : La file d'attente n'est pas vide
     * Postcondition : /
     */
    public boolean avancer() {
        IEvenement evenementCourant;
        while (fileAttente.peek().getTExec() == tCourant) {
            evenementCourant = fileAttente.poll();
            evenementCourant.seProduire(this);
            fileFini.add(evenementCourant);
        }
        tCourant++;
    }

    public void simuler(){
        while(tCourant != tFin){
            avancer();
        }
    }

    /**ComparateurTExec
     * Classe interne pour implementer le comparateur de la PriorityQueue
     *
     * @author Florian Postic
     */
    private class ComparateurTExec implements Comparator<IEvenement> {

        /**compare
         * Redéfinition de la méthode compare pour trier les évenement par date d'execution
         * @param e1 - IEvenement
         * @param e2 - IEvenement
         * @return int
         */
        @Override
        public int compare(IEvenement e1, IEvenement e2) {
            return ((Integer) e1.getTExec()).compareTo(e2.getTExec());
        }
    }

    /**getFileAttente
     * retourne l'attribut fileAttente de l'objet de type Simulateur
     *
     * File des évenements en attente d'être executés
     *
     * @return Queue<IEvenement>
     */
    public Queue<IEvenement> getFileAttente() {
        return fileAttente;
    }


    /**getFileFini
     * retourne l'attribut fileFini de l'objet de type Simulateur
     *
     * File des évenements terminés
     *
     * @return Queue<IEvenement>
     */
    public Queue<IEvenement> getFileFini()
    {
        return fileFini;
    }

    /**gettCourant
     * retourne l'attribut tCourant de l'objet de type Simulateur
     *
     * Compteur de temps virtuel
     *
     * @return int
     */
    public int gettCourant() {
        return tCourant;
    }

    /**gettFin
     * retourne l'attribut tFin de l'objet de type Simulateur
     *
     * Instant auquel se termine la simulation
     *
     * @return int
     */
    public int gettFin() {
        return tFin;
    }
}
