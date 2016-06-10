package tests.mobilite;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;

import mobilite.Deterministe;

public class TestRandomWaypoint {
	
	Deterministe []deterministes;

	@Before
	public void setUp() throws Exception {
		deterministes = new Deterministe[10];
		for(int i=0; i<deterministes.length ; i++){
			deterministes[i] = new Deterministe(i+1, new Point2D.Double(i+1,i+1), new Point2D.Double(i, i));
		}
	}

	@Test
	public void testGetPosition() {
		for(int i=0; i<deterministes.length ; i++){
			assertEquals(new Point2D.Double(i, i), deterministes[i].getPosition()); 
		}
	}
	
	@Test
	public void testSeDeplacer(){
		System.out.println(deterministes[0].seDeplacer());
		System.out.println(deterministes[0].seDeplacer());
		System.out.println(deterministes[0].seDeplacer());
		System.out.println(deterministes[0].seDeplacer());
	}

}
