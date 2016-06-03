package simulateur;

import simulateur.evenement.IEvenement;

public interface ISimulateur {

    /**enregistrer
     * positionne l'évenement dans la file d'attente des évenements du simulateur
     * @param evenement - IEvenement : Evenement à ajouter à la liste
     */
    public void enregistrer(IEvenement evenement);

    /**avancer
     * passe le simulateur à l'intervalle de temps suivant
     */
    public void avancer();
}
