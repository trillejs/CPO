package tests.reseau;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import mobilite.*;
import noeud.*;
import reseau.*;
import exception.*;

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
	public void testAjouterNoeud() throws ExceptionNoeudPresent {
		IReseau reseau = Reseau.getInstance();
		
		AdresseIP ip = new AdresseIP(192,168,1,1);
		ModeleDeMobilite deter = new Deterministe(2, new Point2D.Double(1, 1));
		INoeud noeud = new Noeud(3, 3, "Noeud 1", ip, deter);
		reseau.ajouterNoeud(noeud);
		assertTrue(reseau.appartientAuReseau(ip));
	}
	
	@Test
	public void testEnleverNoeud() throws ExceptionNoeud {
		IReseau reseau = Reseau.getInstance();
		
		AdresseIP ip = new AdresseIP(192,168,1,1);
		ModeleDeMobilite deter = new Deterministe(2, new Point2D.Double(1, 1));
		INoeud noeud = new Noeud(3, 3, "Noeud 1", ip, deter);
		reseau.ajouterNoeud(noeud);
		assertTrue(reseau.appartientAuReseau(ip));
		reseau.enleverNoeud(ip);
		assertFalse(reseau.appartientAuReseau(ip));
	}
	
	@Test
	public void testAtteignable() throws ExceptionNoeud {
		IReseau reseau = Reseau.getInstance();
		
		//Noeud 1
		AdresseIP ip1 = new AdresseIP(192,168,1,1);
		ModeleDeMobilite deter1 = new Deterministe(2, new Point2D.Double(1, 1));
		INoeud noeud1 = new Noeud(3, 3, "Noeud 1", ip1, deter1);
		reseau.ajouterNoeud(noeud1);
		
		//Noeud 2
		AdresseIP ip2 = new AdresseIP(192,168,1,2);		
		ModeleDeMobilite deter2 = new Deterministe(2, new Point2D.Double(2, 2));		
		INoeud noeud2 = new Noeud(3, 3, "Noeud 2", ip2, deter2);		
		reseau.ajouterNoeud(noeud2);
		
		assertTrue(reseau.atteignable(ip1, ip2));
	}
	
	@Test
	public void testGetNoeud() throws ExceptionNoeud {
		IReseau reseau = Reseau.getInstance();
		
		AdresseIP ip = new AdresseIP(192,168,1,1);
		ModeleDeMobilite deter = new Deterministe(2, new Point2D.Double(1, 1));
		INoeud noeud = new Noeud(3, 3, "Noeud 1", ip, deter);
		reseau.ajouterNoeud(noeud);
		assertNotNull(reseau.getNoeud(ip));
	}
	
	@Test
	public void testDeplacerNoeuds() throws ExceptionNoeud {
		IReseau reseau = Reseau.getInstance();
		
		AdresseIP ip = new AdresseIP(192,168,1,1);
		Point2D.Double point = new Point2D.Double(1, 1);
		ModeleDeMobilite deter = new Deterministe(2, point);
		INoeud noeud = new Noeud(3, 3, "Noeud 1", ip, deter);
		reseau.ajouterNoeud(noeud);
		reseau.deplacerNoeuds();
		assertEquals(noeud.getPoint(), new Point2D.Double(1, 1));
	}
}
