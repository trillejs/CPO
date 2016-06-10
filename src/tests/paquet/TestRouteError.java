package tests.paquet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import noeud.AdresseIP;
import noeud.Chemin;
import paquet.RouteError;
import paquet.RouteReply;
import reseau.Reseau;

public class TestRouteError {

	RouteError err;
	Chemin c;

	@Before
	public void setUp() throws Exception {
		Reseau reseau  = Reseau.createInstance(100);
		c = new Chemin();
		err = new RouteError(new AdresseIP(1,1,1,1),c, new AdresseIP(2,2,2,2), new AdresseIP(3,3,3,3));

	}

	@Test
	public void test() {
		//getTaille
		assertEquals(err.getTaille(), 13);

		//getNoeud1
		assertEquals(err.getNoeud1(), new AdresseIP(2,2,2,2));

		//getNoeud2
		assertEquals(err.getNoeud2(), new AdresseIP(3,3,3,3));
	}

}
