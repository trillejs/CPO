package simulateur;

public interface IEvenement {

    /**seProduire
     * Lance l'opération associé à l'évenement et notifie le simulateur
     *
     * @param simulateur - ISimulateur : Simulateur exécutant l'évènement
     */
    void seProduire(ISimulateur simulateur);

    /**getTExec
     * retourne l'attribut TExec de l'objet de type Evenement
     *
     * Date à laquelle l'évènement devra se produire
     *
     * @return int
     */
    int getTExec();

    /**getOperation
     * retourne l'attribut operation de l'objet de type Evenement
     *
     * Opération à executer lorsque l'évènement survient
     *
     * @return IOperation
     */
    IOperation getOperation();
}
