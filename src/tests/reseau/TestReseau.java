package tests.reseau;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import mobilite.*;
import noeud.*;
import reseau.*;

import org.junit.Test;

public class TestReseau {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCreateInstanceSansTTL() {
		IReseau reseau = Reseau.createInstance();
		assertNotNull(reseau);
	}
	
	@Test
	public void testCreateInstanceAvecTTL() {
		IReseau reseau = Reseau.createInstance(200);
		assertEquals(reseau.getTTL(), 200);
	}

	@Test
	public void testGetInstance() {
		IReseau reseau = Reseau.getInstance();
		assertNotNull(reseau);
	}
	
	@Test
	public void testAjouterNoeud() {
//		ajouterNoeud(INoeud noeud)
		IReseau reseau = Reseau.getInstance();
		ModeleDeMobilite deter = new Deterministe(2, new Point2D.Double(1, 1));
		INoeud noeud = new Noeud(3, 3, "Noeud 1", new AdresseIP(192,168,1,1), deter);
		assertNotNull(reseau);
	}
}
