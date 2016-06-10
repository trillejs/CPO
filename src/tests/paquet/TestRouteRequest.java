package tests.paquet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import noeud.AdresseIP;
import noeud.Chemin;
import paquet.Paquet;
import paquet.RouteRequest;
import reseau.Reseau;

public class TestRouteRequest {

	Paquet pq;
	
	@Before
	public void setUp() throws Exception {
		Reseau reseau  = Reseau.createInstance(100);
		Chemin c = new Chemin();
		Chemin c2 = new Chemin();
		 pq = new RouteRequest(new AdresseIP(1,1,1,1), new AdresseIP(2,2,2,2),c,c2);
		
	}

	@Test
	public void test() {
		//getTaille
		assertEquals(pq.getTaille(), 6);
		
		//getDestination
		assertEquals(pq.getDestination(), new AdresseIP(2,2,2,2));
	}

}
