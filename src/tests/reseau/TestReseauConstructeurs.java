package tests.reseau;

import static org.junit.Assert.*;

import org.junit.Test;

import reseau.IReseau;
import reseau.Reseau;

public class TestReseauConstructeurs {

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

}
