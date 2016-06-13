package tests.simulateur;

import static org.junit.Assert.*;

import noeud.AdresseIP;
import noeud.Chemin;
import org.junit.Before;
import org.junit.Test;

import operation.OpFinEnvoi;
import operation.OpRecevoir;
import paquet.Paquet;
import paquet.RouteRequest;
import reseau.IReseau;
import reseau.Reseau;
import simulateur.*;

public class TestEvenement {
	
	private int date;
	private ISimulateur sim;
	private IEvenement []tabEv;
	private IOperation []tabOp;
	private IOperation []tabOpRecevoir;
	private Paquet paquet;
	private IReseau reseau;
	private Chemin chemin;


	@Before
	public void setUp(){
		
		sim = new Simulateur(60);
		tabOp = new IOperation[20];
		tabEv = new IEvenement[20];
		chemin = new Chemin();
		chemin.ajouter(new AdresseIP(1,1,1,1), 100);
		chemin.ajouter(new AdresseIP(2,2,2,2), 100);
		paquet = new RouteRequest(new AdresseIP(1,1,1,1), new AdresseIP(2,2,2,2) ,chemin);
		reseau = new Reseau();

		for(int i=0 ; i<tabEv.length ; i++){
			date = i;
			tabOp[i] = new OpFinEnvoi(paquet, reseau);
			tabEv[i] = new Evenement(date, tabOp[i]);
		}
	}


	@Test
	public void testAccesseurs() {
		//Test getOperation
		for(int i=0 ; i<tabEv.length ; i++){
			assertEquals(tabEv[i].getOperation(), tabOp[i]);
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
			assertEquals(sim.getFileAttente().poll().getOperation().getClass(), OpRecevoir.class);
		}
	}

}
