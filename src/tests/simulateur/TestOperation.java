package tests.simulateur;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import reseau.OpDeplacer;
import reseau.OpFinEvoi;
import simulateur.Evenement;
import simulateur.IEvenement;
import simulateur.IOperation;
import simulateur.ISimulateur;

public class TestOperation {

	private ISimulateur sim;
	private IEvenement []tabEv;
	private IOperation []tabOp;


	@Before
	public void setUp() throws Exception {
		tabOp = new IOperation[20];
		tabEv = new IEvenement[20];

		for(int i=0 ; i<tabOp.length ; i++){
			tabOp[i] = new OpFinEvoi();
			tabEv[i] = new Evenement(i, tabOp[i]);
		}
	}

	@Test
	public void testExecuter() {
		
	}

}
