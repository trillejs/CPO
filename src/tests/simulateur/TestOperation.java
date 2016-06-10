package tests.simulateur;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;

import mobilite.*;
import noeud.*;
import paquet.*;
import reseau.*;
import operation.*;
import simulateur.*;

public class TestOperation {

	private int date;
	private ISimulateur sim;
	private INoeud []noeuds;
	private IEvenement []tabEv;
	private IOperation []tabOp;
	private IOperation []tabOpRecevoir;
	private IOperation []tabOpFinEnvoi;
	private IOperation []tabOpEnvoyer;
	private IOperation []tabOpDeplacer;
	private IReseau reseau;
	private AdresseIP source;
	private Paquet paquet;
	private Chemin chemin;


	@Before
	public void setUp() throws Exception {
		sim = new Simulateur(60);
		reseau = Reseau.createInstance(200);
		noeuds = new Noeud[20];
		source = new AdresseIP(1,1,1,1);
		chemin = new Chemin();
		chemin.ajouter(new AdresseIP(1,1,1,1), 1000);
		chemin.ajouter(new AdresseIP(2,2,2,2), 1000);
		paquet = new Paquet(source, chemin) {			
			@Override
			public void accepter(IOpVisiteur iOpVisiteur) {				
			}
		};		
		tabOp = new IOperation[20];
		tabEv = new IEvenement[20];
		tabOpRecevoir = new IOperation[5];
		tabOpFinEnvoi = new IOperation[5];
		tabOpEnvoyer = new IOperation[5];
		tabOpDeplacer = new IOperation[5];

		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			AdresseIP adresse = new AdresseIP(i,i,i,i);
			String nom = "Noeud "+i;
			ModeleDeMobilite modele = new Deterministe(i, new Point2D.Double(i,i), new Point2D.Double(i,i));
			noeuds[i] = new Noeud(i*1000 ,i*1000,nom,new AdresseIP(i,i,i,i),  modele);
			reseau.ajouterNoeud(noeuds[i]);
			
			if(i<5){
				tabOpFinEnvoi[i] = new OpFinEvoi(paquet); 
				tabOpRecevoir[i] = new OpRecevoir(paquet);
				tabOpEnvoyer[i] = new OpEnvoyer(reseau, source, paquet);
				tabOpDeplacer[i] = new OpDeplacer(reseau);
				tabOp[i] = tabOpFinEnvoi[i];
				tabOp[i+5] = tabOpRecevoir[i];
				tabOp[i+10] = tabOpEnvoyer[i];
				tabOp[i+15] = tabOpDeplacer[i];
			}			
			tabEv[i] = new Evenement(date, tabOp[i]);
		}
	}

	@Test
	public void testOpGeneral() {
		for(int i=0 ; i<tabOp.length ; i++){
			date = i;
			tabOp[i].executer(sim, date);
			
			// OpRecevoir pas d'évènements
			//assertEquals(sim.getFileAttente().poll().getTExec(),tabEv[i].getTExec());			
		}
	}
	
	@Test
	public void testOpFinEnvoi() {
		for(int i=0 ; i<tabOpFinEnvoi.length ; i++){
			date = i;
			tabOpFinEnvoi[i].executer(sim, date);
			assertEquals(sim.getFileAttente().poll().getOperation().getClass(), OpRecevoir.class);
			
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
		for(int i=0 ; i<tabOpEnvoyer.length ; i++){
			date = i;
			tabOp[i].executer(sim, date);
			
			
		}
	}
	
	
	@Test
	public void testOpDeplacer() {
		for(int i=0 ; i<tabOpDeplacer.length ; i++){
			date = i;
			tabOp[i].executer(sim, date);
			
			
		}
	}
	


}