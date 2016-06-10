package tests.paquet;

import static org.junit.Assert.*;

import org.junit.Test;

import noeud.AdresseIP;
import noeud.Chemin;
import paquet.Donnee;
import reseau.Reseau;

public class TestDonnee {

	@Test
	public void test() {
		Reseau reseau  = Reseau.createInstance(100);
		Chemin c = new Chemin();
		Donnee d = new Donnee(new AdresseIP(1,1,1,1), c, "test");
		
		//getDonnee
		assertEquals(d.getDonne(),"test");
		
		//getChemin
		assertEquals(d.getChemin(), c);
		
		//getSource
		assertEquals(d.getSource(), new AdresseIP(1,1,1,1));
		
		//getTaille
		assertEquals(d.getTaille(), 5);
		
		//getTTL
		assertEquals(d.getTTL(),100 );
	}

}
