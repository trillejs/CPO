package operation;

import noeud.INoeud;
import simulateur.IOperation;
import simulateur.ISimulateur;

public class OpActDes implements IOperation {

    private INoeud noeud;

    public OpActDes(INoeud noeud) {
        this.noeud = noeud;
    }

    /**
     * executer
     * Execute les intructions composant l'opération
     *
     * @param simulateur - Simulateur : Simulateur
     * @param date       - int : Date d'execution de l'opération
     */
    @Override
    public void executer(ISimulateur simulateur, int date) {
       if(noeud.estActif()){
           noeud.activation(false);
       }else{
           noeud.activation(true);
       }
    }
}
