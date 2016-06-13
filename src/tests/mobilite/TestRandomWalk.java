package tests.mobilite;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;

import mobilite.RandomWalk;

public class TestRandomWalk {
	
	RandomWalk []rw;

	@Before
	public void setUp() throws Exception {
		rw = new RandomWalk[10];
		for(int i=0 ; i < rw.length ; i++){
			rw[i] = new RandomWalk(i+1, +10, i+1, i+10, new Point2D.Double(i,i));
		}
	}

	@Test
	public void test() {
		for(int i=0 ; i < rw.length ; i++){
			Point2D.Double temp = new Point2D.Double(rw[i].getPosition().getX(), rw[i].getPosition().getY());
			rw[i].seDeplacer();
			assertNotEquals(rw[i].getPosition(), temp);
		}
	}

}
