package tests.paquet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import noeud.AdresseIP;
import noeud.Chemin;
import paquet.Paquet;
import paquet.RouteReply;
import paquet.RouteRequest;
import reseau.Reseau;

public class TestRouteReply {
	
	Paquet pq;
	Chemin c,c2;

	@Before
	public void setUp() throws Exception {
		Reseau reseau  = Reseau.createInstance(100);
		c = new Chemin();
		c2 = new Chemin();
		pq = new RouteReply(new AdresseIP(1,1,1,1),c,c2);
	}

	@Test
	public void test() {
		assertEquals(((RouteReply) pq).getRouteReply(), c2);
	}

}
