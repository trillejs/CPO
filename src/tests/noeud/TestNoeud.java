package tests.noeud;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;

import mobilite.Deterministe;
import mobilite.ModeleDeMobilite;
import noeud.*;

public class TestNoeud {

	private INoeud [] noeuds;

	@Before
	public void setUp() throws Exception {
		noeuds = new Noeud [10];

		for(int i = 0 ; i<noeuds.length ; i++){
			AdresseIP adresse = new AdresseIP(i,i,i,i);
			String nom = "Noeud "+i;
			ModeleDeMobilite modele = new Deterministe(i, new Point2D.Double(i,i));
			noeuds[i] = new Noeud(i ,i*1000,nom,adresse,  modele);
		}

	}

	@Test
	public void testSeDeplacer() {

	}

	@Test
	public void testSupprimerLienRompu() {
		Chemin c = new Chemin();
		c.ajouter(new AdresseIP(1,1,1,1), 1000);
		c.ajouter(new AdresseIP(2,2,2,2), 1000);
		noeuds[0].addRoute(c);
		assertNotNull(noeuds[0].getRoute(new AdresseIP(2,2,2,2)));
		noeuds[0].supprimerLienRompu(new AdresseIP(0,0,0,0), new AdresseIP(2,2,2,2));
		assertNull(noeuds[0].getRoute(new AdresseIP(2,2,2,2)));
	}

	@Test
	public void testAddRoute() {
		Chemin c = new Chemin();
		c.ajouter(new AdresseIP(1,1,1,1), 1000);
		c.ajouter(new AdresseIP(2,2,2,2), 1000);
		noeuds[0].addRoute(c);
		assertNotNull(noeuds[0].getRoute(new AdresseIP(2,2,2,2)));
	}

	@Test
	public void testActivation() {
		for(int i=0 ; i<noeuds.length ; i++){
			noeuds[i].activation(true);
			assertTrue(noeuds[i].estActif());
		}
		for(int i=0 ; i<noeuds.length ; i++){
			noeuds[i].activation(false);
			assertFalse(noeuds[i].estActif());
		}		
	}

	@Test
	public void testAccesseurs() {


		for(int i=0 ; i<noeuds.length ; i++){
			//getDebitEmission
			assertEquals(noeuds[i].getDebitEmission(), i*1000);

			//getAdresseIP
			AdresseIP adresse = new AdresseIP(i,i,i,i);
			assertTrue(noeuds[i].getAdresseIP().equals(adresse));

			//getPuissance
			assertEquals(noeuds[i].getPuissance(), i, 0.1);

			//getPoint
			//assertTrue(noeuds[i].getPoint().equals(new Point2D.Double(i,i)) );

			//getRoute
			Chemin c = new Chemin();
			c.ajouter(new AdresseIP(i,i,i,i), 1000);
			noeuds[i].addRoute(c);
			assertNotNull(noeuds[i].getRoute(new AdresseIP(i,i,i,i)));

		}	

	}



}
