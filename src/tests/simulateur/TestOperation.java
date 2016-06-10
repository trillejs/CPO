package tests.simulateur;

import static org.junit.Assert.*;

import noeud.AdresseIP;
import noeud.Chemin;
import operation.OpRecevoir;
import org.junit.Before;
import org.junit.Test;

import operation.OpFinEvoi;
import paquet.Paquet;
import paquet.RouteRequest;
import simulateur.Evenement;
import simulateur.IEvenement;
import simulateur.IOperation;
import simulateur.ISimulateur;
import simulateur.Simulateur;

public class TestOperation {

	private int date;
	private ISimulateur sim;
	private IEvenement []tabEv;
	private IOperation []tabOp;
	private IOperation []tabOpRecevoir;
	private Paquet paquet;


	@Before
	public void setUp() throws Exception {
		sim = new Simulateur(60);
		tabOp = new IOperation[20];
		tabEv = new IEvenement[20];
		tabOpRecevoir = new IOperation[20];
		paquet = new RouteRequest(new AdresseIP(1,1,1,1), new AdresseIP(2,2,2,2), new Chemin());

		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			tabOp[i] = new OpFinEvoi(paquet);
			tabOpRecevoir[i] = new OpRecevoir(null);
			tabEv[i] = new Evenement(date, tabOpRecevoir[i]);
		}
	}

	@Test
	public void testExecuter() {
		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			tabOp[i].executer(sim, date);
			
			assertEquals(sim.getFileAttente().peek().getTExec(),tabEv[i].getTExec());
			assertEquals(sim.getFileAttente().poll().getOperation().getClass(), tabEv[i].getOperation().getClass());
		}
	}

}
