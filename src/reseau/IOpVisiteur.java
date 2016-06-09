package reseau;

import paquet.*;
import simulateur.IOperation;

/**
 * @author Florian Postic
 */
public interface IOpVisiteur extends IOperation {
    void traiter(RouteRequest routeRequest);
    void traiter(RouteReply routeReply);
    void traiter(RouteError routeError);
    void traiter(Donnee donnee);
}
