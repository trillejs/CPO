package reseau;

import simulateur.IOperation;
import simulateur.ISimulateur;

/**
 * Classe abstraite permettant l'implémentation du paramètre réseau spécifique
 * au réseau adhoc ainsi que le constructeur associé.
 * @author Florian Postic
 */
    /*PackageLocal*/ abstract class OpAbstraite implements IOperation{

    /** Réseau sur lequel appliquer l'opération */
    protected IReseau reseau;

    /**OpAbstraite
     *
     * @param reseau - IReseau : Réseau sur lequel appliquer l'opération
     */
    public OpAbstraite(IReseau reseau) {
        this.reseau = reseau;
    }

    /**executer
     * Execute les intructions composant l'opération
     *
     * @param simulateur - Simulateur : Simulateur
     * @param date - int : Date d'execution de l'opération
     */
    @Override
    public abstract void executer(ISimulateur simulateur, int date);
}
