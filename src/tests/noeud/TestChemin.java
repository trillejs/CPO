package tests.noeud;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

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


	@Before
	public void setUp() throws Exception {
		noeuds = new Noeud [10];

		for(int i = 0 ; i<noeuds.length ; i++){
			AdresseIP adresse = new AdresseIP(i,i,i,i);
			String nom = "Noeud "+i;
			ModeleDeMobilite modele = new Deterministe(i, new Point2D.Double(i,i), new Point2D.Double(i,i));
			noeuds[i] = new Noeud(i ,i*1000,nom,adresse,  modele);
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
