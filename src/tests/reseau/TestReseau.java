package tests.reseau;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import mobilite.*;
import noeud.*;
import reseau.*;
import exception.*;

import org.junit.Before;
import org.junit.Test;

public class TestReseau {

	IReseau reseau;
	AdresseIP ip1;
	INoeud noeud1;
	
	@Before
	public void setUp() throws ExceptionNoeud {
		reseau = Reseau.getInstance();

		ip1 = new AdresseIP(192,168,1,1);
		Point2D.Double point = new Point2D.Double(1, 1);
		ModeleDeMobilite deter = new Deterministe(2, point);
		noeud1 = new Noeud(3, 3, "Noeud 1", ip1, deter);
		reseau.ajouterNoeud(noeud1);
	}
	
	@Test
	public void testAjouterNoeud() throws ExceptionNoeudPresent {
		assertTrue(reseau.appartientAuReseau(ip1));
	}
	
	@Test
	public void testEnleverNoeud() throws ExceptionNoeud {
		assertTrue(reseau.appartientAuReseau(ip1));
		reseau.enleverNoeud(ip1);
		assertFalse(reseau.appartientAuReseau(ip1));
	}
	
	@Test
	public void testAtteignable() throws ExceptionNoeud {
		//Noeud 2
		AdresseIP ip2 = new AdresseIP(192,168,1,2);		
		ModeleDeMobilite deter2 = new Deterministe(2, new Point2D.Double(2, 2));		
		INoeud noeud2 = new Noeud(3, 3, "Noeud 2", ip2, deter2);		
		reseau.ajouterNoeud(noeud2);
		
		assertTrue(reseau.atteignable(ip1, ip2));
	}
	
	@Test
	public void testGetNoeud() throws ExceptionNoeud {
		assertNotNull(reseau.getNoeud(ip1));
	}
	
	@Test
	public void testDeplacerNoeuds() throws ExceptionNoeud {
		reseau.deplacerNoeuds();
		assertFalse(noeud1.getPoint().equals(new Point2D.Double(1, 1)));
	}
}
