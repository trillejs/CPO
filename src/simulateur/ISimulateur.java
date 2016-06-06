package simulateur;

public interface ISimulateur {

    /**enregistrer
     * Positionne l'évènement dans la file d'attente des évènements du simulateur
     *
     * @param evenement - IEvenement : Evènement à ajouter à la liste
     * Précondition : /
     * Postcondition : L'évenement appartient à la file
     *                  && La file d'attente n'est pas vide
     */
    public void enregistrer(IEvenement evenement);

    /**
     * avancer
     * execute l'évènement suivant dans la file des évènements en attente,
     * le transfert dans la file des "fini" si son temps d'execution vaut 1
     * sinon il ira dans la file des "en cours" et vera son temps d'execution décrémenté
     *
     * Précondition : La file d'attente n'est pas vide
     * Postcondition : /
     */
    public void avancer();
}
