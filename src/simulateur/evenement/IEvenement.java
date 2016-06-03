package simulateur.evenement;

import simulateur.ISimulateur;

import java.util.Date;

public interface IEvenement {


    /**seProduire
     * Lance l'opération associé à lévenement et notifie le simulateur
     * @param simulateur - ISimulateur : Simulateur
     */
    public void seProduire(ISimulateur simulateur);

    /**getDate
     * @return date - Date : Date d'occurence de l'évenement
     */
    public Date getDate();
}
