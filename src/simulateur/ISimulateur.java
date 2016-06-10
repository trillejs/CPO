package simulateur;

import java.util.Queue;

public interface ISimulateur {

    /**enregistrer
     * Positionne l'évènement dans la file d'attente des évènements du simulateur
     *
     * @param evenement - IEvenement : Evènement à ajouter à la liste
     * Précondition : /
     * Postcondition : L'évenement appartient à la file
     *                  && La file d'attente n'est pas vide
     */
    void enregistrer(IEvenement evenement);

    /**
     * avancer
     * execute l'évènement suivant dans la file des évènements en attente,
     * le transfert dans la file des "fini" si son temps d'execution vaut 1
     * sinon il ira dans la file des "en cours" et vera son temps d'execution décrémenté
     *
     * Précondition : La file d'attente n'est pas vide
     * Postcondition : /
     */
    void avancer();

    /**simuler
     * Lance la simulation jusqu'à ce que la simulation ai durée tFin interval
     * de temps
     */
    void simuler();

    /**simulerPas
     * Lance la simulation jusqu'à ce que le temps de simulation courant
     * atteigne temps courant + nbPas
     * @param nbPas - int : Nombre de pas
     */
    void simulerPas(int nbPas);

    /**getFileAttente
     * retourne l'attribut fileAttente de l'objet de type Simulateur
     *
     * File des évenements en attente d'être executés
     *
     * @return Queue<IEvenement>
     */
    public Queue<IEvenement> getFileAttente();


    /**getFileFini
     * retourne l'attribut fileFini de l'objet de type Simulateur
     *
     * File des évenements terminés
     *
     * @return Queue<IEvenement>
     */
    public Queue<IEvenement> getFileFini();

    /**gettCourant
     * retourne l'attribut tCourant de l'objet de type Simulateur
     *
     * Compteur de temps virtuel
     *
     * @return int
     */
    public int gettCourant();

    /**gettFin
     * retourne l'attribut tFin de l'objet de type Simulateur
     *
     * Instant auquel se termine la simulation
     *
     * @return int
     */
    public int gettFin();
}
