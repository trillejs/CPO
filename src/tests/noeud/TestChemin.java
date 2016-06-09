package tests.noeud;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import mobilite.Deterministe;
import mobilite.ModeleDeMobilite;
import noeud.AdresseIP;
import noeud.Chemin;
import noeud.INoeud;
import noeud.Noeud;

public class TestChemin {

	//Attention au getDestination probablement faux
	private INoeud [] noeuds;
	private Chemin [] chemins;
	private AdresseIP [] adresses;


	@Before
	public void setUp() throws Exception {
		noeuds = new Noeud [10];
		chemins = new Chemin[10];
		adresses = new AdresseIP[10];

		for(int i = 0 ; i<noeuds.length ; i++){
			chemins[i] = new Chemin();
			adresses[i] = new AdresseIP(i,i,i,i);
			String nom = "Noeud "+i;
			ModeleDeMobilite modele = new Deterministe(i, new Point2D.Double(i,i), new Point2D.Double(i,i));
			noeuds[i] = new Noeud(i ,i*1000,nom,adresses[i],  modele);
		}
	}

	@Test
	public void testAjouter() {
		assertFalse(chemins[1].contains(adresses[1]));
		chemins[1].ajouter(noeuds[1].getAdresseIP(), noeuds[1].getDebitEmission());
		assertTrue(chemins[1].contains(adresses[1]));
	}
	
	@Test
	public void testContains() {
		assertFalse(chemins[0].contains(adresses[0]));
		chemins[0].ajouter(noeuds[0].getAdresseIP(), noeuds[0].getDebitEmission());
		assertTrue(chemins[0].contains(adresses[0]));
	}
	
	@Test
	public void testEstPlusRapide() {
		chemins[0].ajouter(noeuds[0].getAdresseIP(), noeuds[0].getDebitEmission());
		chemins[0].ajouter(noeuds[1].getAdresseIP(), noeuds[1].getDebitEmission());
		
		chemins[1].ajouter(noeuds[0].getAdresseIP(), noeuds[0].getDebitEmission());
		chemins[1].ajouter(noeuds[1].getAdresseIP(), noeuds[1].getDebitEmission());
		
		chemins[2].ajouter(noeuds[1].getAdresseIP(), noeuds[1].getDebitEmission());
		chemins[2].ajouter(noeuds[2].getAdresseIP(), noeuds[2].getDebitEmission());
		
		assertFalse(chemins[0].estPlusRapide(chemins[1]));
		assertFalse(chemins[0].estPlusRapide(chemins[2]));
		assertTrue(chemins[2].estPlusRapide(chemins[0]));
	}
	
	@Test
	public void testContainsLien() {
		assertFalse(chemins[0].containsLien(adresses[0], adresses[1]));
		chemins[0].ajouter(noeuds[0].getAdresseIP(), noeuds[0].getDebitEmission());
		chemins[0].ajouter(noeuds[1].getAdresseIP(), noeuds[1].getDebitEmission());
		assertTrue(chemins[0].containsLien(adresses[0], adresses[1]));
		assertFalse(chemins[0].containsLien(adresses[1], adresses[0]));
	}
	
	@Test
	public void testAccesseurs() {
		
		//getNombreSaut
		assertEquals(0, chemins[0].getNombreSaut());
		chemins[0].ajouter(noeuds[0].getAdresseIP(), noeuds[0].getDebitEmission());
		assertEquals(1, chemins[0].getNombreSaut());		
		chemins[0].ajouter(noeuds[1].getAdresseIP(), noeuds[1].getDebitEmission());
		assertEquals(2, chemins[0].getNombreSaut());		
		
		//getTaille
		assertEquals(0, chemins[1].getTaille());
		chemins[1].ajouter(noeuds[1].getAdresseIP(), noeuds[1].getDebitEmission());
		assertEquals(4, chemins[1].getTaille());
		chemins[1].ajouter(noeuds[2].getAdresseIP(), noeuds[2].getDebitEmission());
		assertEquals(8, chemins[1].getTaille());
		
		//getDestination
		boolean excPassed= false;
		try{
			chemins[2].getDestination();
		}catch(Exception e){
			excPassed = true;
		}
		assertTrue(excPassed);
		chemins[2].ajouter(noeuds[2].getAdresseIP(), noeuds[2].getDebitEmission());
		assertEquals(noeuds[2].getAdresseIP(),chemins[2].getDestination());
		
		//getListeNoeuds
		chemins[3].ajouter(noeuds[1].getAdresseIP(), noeuds[1].getDebitEmission());
		chemins[3].ajouter(noeuds[2].getAdresseIP(), noeuds[2].getDebitEmission());
		
		chemins[4].ajouter(noeuds[1].getAdresseIP(), noeuds[1].getDebitEmission());
		chemins[4].ajouter(noeuds[2].getAdresseIP(), noeuds[2].getDebitEmission());
		
		assertEquals(chemins[3].getListeNoeud(), chemins[4].getListeNoeud());
		assertNotEquals(chemins[3].getListeNoeud(), chemins[0].getListeNoeud());
	}

}
