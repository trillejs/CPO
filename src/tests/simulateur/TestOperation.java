package tests.simulateur;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import reseau.OpDeplacer;
import reseau.OpFinEvoi;
import reseau.*;
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


	@Before
	public void setUp() throws Exception {
		sim = new Simulateur(60);
		tabOp = new IOperation[20];
		tabEv = new IEvenement[20];
		tabOpRecevoir = new IOperation[20];

		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			tabOp[i] = new OpFinEvoi();
			tabOpRecevoir[i] = new OpRecevoir();
			tabEv[i] = new Evenement(date, tabOpRecevoir[i]);
		}
	}

	@Test
	public void testExecuter() {
		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			tabOp[i].executer(sim, date);
			
			assertEquals(sim.getFileAttente().peek().getTExec(),tabEv[i].getTExec());
			assertEquals(sim.getFileAttente().peek().getOperation().getClass(), tabEv[i].getOperation().getClass());
		}
	}

}
