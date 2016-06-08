package tests.simulateur;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;
import simulateur.*;

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
		assertEquals(sim.gettFin(), 100);
		assertEquals(sim.gettCourant(), 0);
		
	}

}
