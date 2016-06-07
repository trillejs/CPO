package tests.simulateur;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import simulateur.ISimulateur;
import simulateur.Simulateur;

public class TestSimulateur extends TestCase{

	private ISimulateur sim;
	
	public void setUp(){
		sim = new Simulateur(100);
	}
	
	@Test
	public void testInitialisation() {
		assertNotNull(sim);
		
	}
	
	@Test
	public void testAccesseurs(){
		assertEquals(sim.getTFin(), 100);
		assertEquals(sim.getTCourant(), 0);
	}

}
