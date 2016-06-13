package tests.mobilite;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;

import mobilite.*;
import noeud.AdresseIP;
import noeud.Noeud;

public class TestPursue {

	Noeud []noeuds;
	Deterministe []deterministes;
	Pursue []pursues;

	@Before
	public void setUp() throws Exception {
		deterministes = new Deterministe[10];
		noeuds = new Noeud[10];
		pursues = new Pursue[10];
		for(int i=0; i<deterministes.length ; i++){
			deterministes[i] = new Deterministe(i+1, new Point2D.Double(i+1,i+1), new Point2D.Double(i, i));
			noeuds[i] = new Noeud(i, i, "test"+i, new AdresseIP(i,i,i,i), deterministes[i]);
			pursues[i] = new Pursue(noeuds[i], new Point2D.Double(i,i));
		}
	}

	@Test
	public void testGetPosition() {
		for(int i=0; i<deterministes.length ; i++){
			assertEquals(new Point2D.Double(i, i), pursues[i].getPosition()); 
		}
	}
	
	@Test
	public void testSeDeplacer(){
		for(int i=0; i<deterministes.length ; i++){
			for(int j=0 ; j<100 ; j++){
				deterministes[i].seDeplacer();
				pursues[i].seDeplacer();
			}
			assertEquals(deterministes[i].getDestination(), deterministes[i].getPosition());
			assertEquals(deterministes[i].getDestination(), pursues[i].getPosition());
		}
	}

}
