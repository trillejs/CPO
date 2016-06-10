package tests.simulateur;

import static org.junit.Assert.*;

import noeud.AdresseIP;
import noeud.Chemin;
import org.junit.Before;
import org.junit.Test;

import operation.OpFinEvoi;
import operation.OpRecevoir;
import paquet.Paquet;
import paquet.RouteRequest;
import simulateur.*;

public class TestEvenement {
	
	private int date;
	private ISimulateur sim;
	private IEvenement []tabEv;
	private IOperation []tabOp;
	private IOperation []tabOpRecevoir;
	private Paquet paquet;

	@Before
	public void setUp(){
		
		sim = new Simulateur(60);
		tabOp = new IOperation[20];
		tabOpRecevoir = new IOperation[20];
		tabEv = new IEvenement[20];
		paquet = new RouteRequest(new AdresseIP(1,1,1,1), new AdresseIP(2,2,2,2) ,new Chemin());

		for(int i=0 ; i<tabEv.length ; i++){
			date = i;
			tabOp[i] = new OpFinEvoi(paquet);
			tabOpRecevoir[i] = new OpRecevoir(null);
			tabEv[i] = new Evenement(date, tabOpRecevoir[i]);
		}
	}


	@Test
	public void testAccesseurs() {
		//Test getOperation
		for(int i=0 ; i<tabEv.length ; i++){
			assertEquals(tabEv[i].getOperation(), tabOpRecevoir[i]);
		}

		//Test getTExec()
		for(int i=0 ; i<tabEv.length ; i++){
			assertEquals(tabEv[i].getTExec(), i);
		}
	}
	
	@Test
	public void testSeProduire(){
		for(int i=0 ; i<tabEv.length ; i++){
			tabEv[i].seProduire(sim);
			
			assertEquals(sim.getFileAttente().peek().getTExec(),tabEv[i].getTExec());
			assertEquals(sim.getFileAttente().poll().getOperation().getClass(), tabEv[i].getOperation().getClass());
		}
	}

}
