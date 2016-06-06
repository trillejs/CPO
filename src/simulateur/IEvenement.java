package simulateur;

public interface IEvenement {

    /**seProduire
     * Lance l'opération associé à l'évenement et notifie le simulateur
     *
     * @param simulateur - ISimulateur : Simulateur exécutant l'évènement
     */
    void seProduire(ISimulateur simulateur);




    int getTExec();
}
