package tests.simulateur;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import noeud.AdresseIP;
import paquet.Paquet;
import reseau.*;
import simulateur.Evenement;
import simulateur.IEvenement;
import simulateur.IOperation;
import simulateur.ISimulateur;
import simulateur.Simulateur;

public class TestOperation {

	private int date;
	private ISimulateur sim;
	private IEvenement []tabEv;
	private IOperation []tabOp;
	private IOperation []tabOpRecevoir;
	private IOperation []tabOpFinEnvoi;
	private IOperation []tabOpEnvoyer;
	private IOperation []tabOpDeplacer;
	private IReseau reseau;
	private AdresseIP source;
	private Paquet paquet;


	@Before
	public void setUp() throws Exception {
		sim = new Simulateur(60);
		tabOp = new IOperation[20];
		tabEv = new IEvenement[20];
		tabOpRecevoir = new IOperation[5];
		tabOpFinEnvoi = new IOperation[5];
		tabOpEnvoyer = new IOperation[5];
		tabOpDeplacer = new IOperation[5];

		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			
			if(i<5){
				tabOpFinEnvoi[i] = new OpFinEvoi(); //Problème de nom
				tabOpRecevoir[i] = new OpRecevoir(null);
				tabOpEnvoyer[i] = new OpEnvoyer(reseau, source, paquet);
				tabOpDeplacer[i] = new OpDeplacer(reseau);
				tabOp[i] = tabOpFinEnvoi[i];
				tabOp[i] = tabOpRecevoir[i+5];
				tabOp[i] = tabOpEnvoyer[i+10];
				tabOp[i] = tabOpDeplacer[i+15];
			}			
			tabEv[i] = new Evenement(date, tabOp[i]);
		}
	}

	@Test
	public void testOpGeneral() {
		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			tabOp[i].executer(sim, date);
			
			assertEquals(sim.getFileAttente().peek().getTExec(),tabEv[i].getTExec());
			assertEquals(sim.getFileAttente().poll().getOperation().getClass(), tabEv[i].getOperation().getClass());
		}
	}
	
	@Test
	public void testOpFinEnvoi() {
		for(int i=0 ; i<tabOpFinEnvoi.length ; i++){
			date = i;
			tabOpFinEnvoi[i].executer(sim, date);
			
			
		}
	}
	
	@Test
	public void testOpRecevoir() {
		for(int i=0 ; i<tabOpRecevoir.length ; i++){
			date = i;
			tabOpRecevoir[i].executer(sim, date);
			
			
		}
	}
	
	@Test
	public void testOpEnvoyer() {
		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			tabOp[i].executer(sim, date);
			
			
		}
	}
	
	
	@Test
	public void testOpDeplacer() {
		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			tabOp[i].executer(sim, date);
			
			
		}
	}
	


}