package simulateur;

public interface IEvenement {

    /**seProduire
     * Lance l'opération associé à l'évenement et notifie le simulateur
     *
     * @param simulateur - ISimulateur : Simulateur exécutant l'évènement
     */
    public void seProduire(ISimulateur simulateur);


    public int getTExec();
}
