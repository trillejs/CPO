package tests.simulateur;

import static org.junit.Assert.*;

import org.junit.Test;

import simulateur.*;

public class TestEvenement {

	private IOperation []tabOp;
	private IEvenement []tabEv;
	private ISimulateur sim;

	public void setup(){
		tabOp = new IOperation[20];
		tabEv = new IEvenement[20];

		for(int i=0 ; i<tabEv.length ; i++){
			//tabOp[i] = new Operation();
			tabEv[i] = new Evenement(i, tabOp[i]);
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
		
	}

}
