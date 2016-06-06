package simulateur;

public interface IEvenement {

    /**seProduire
     * Lance l'opération associé à lévenement et notifie le simulateur
     * @param simulateur - ISimulateur : Simulateur
     */
    public void seProduire(ISimulateur simulateur);


    public int getTExec();
}
