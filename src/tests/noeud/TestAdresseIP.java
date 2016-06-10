package tests.noeud;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import noeud.AdresseIP;

public class TestAdresseIP {

	private AdresseIP [] adresses;
	
	@Before
	public void setUp() throws Exception {
		adresses  =new AdresseIP[10];
		
		for(int i=0 ;  i < adresses.length  ; i++){
			adresses[i] = new AdresseIP(i,i,i,i);
		}
	}

	@Test
	public void testAccesseurs() {
		//getAdresse
		for(int i=0 ; i<adresses.length; i++){
			int [] adresseTemp = {i,i,i,i};
			assertEquals(adresses[i].getAdresse()[0],adresseTemp[0]);
			assertEquals(adresses[i].getAdresse()[1],adresseTemp[1]);
			assertEquals(adresses[i].getAdresse()[2],adresseTemp[2]);
			assertEquals(adresses[i].getAdresse()[3],adresseTemp[3]);
		}
		//getTaille
		for(int i=0 ; i<adresses.length; i++){
			assertEquals(adresses[i].getTaille(),4);
		}
	}
	
	@Test
	public void testToString(){
		for(int i=0 ; i<adresses.length; i++){
			String adresseTemp = i+"."+i+"."+i+"."+i;
			assertEquals(adresses[i].toString(),adresseTemp);
		}
	}

	@Test
	public void testEquals(){
		for(int i=0 ; i<adresses.length; i++){
			AdresseIP adresseTemp = new AdresseIP(i,i,i,i);
			assertTrue(adresses[i].equals(adresseTemp));
		}
	}
}
