package tests.simulateur;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exception.ExceptionNoeudAbsent;
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
			String nom = "Noeud "+i;
			ModeleDeMobilite modele = new Deterministe(i+1, new Point2D.Double(i+2,i+2), new Point2D.Double(i+1,i+1));
			noeuds[i] = new Noeud(i*1000 ,i*1000,nom,new AdresseIP(i,i,i,i),  modele);
			reseau.ajouterNoeud(noeuds[i]);

			if(i<5){
				tabOpFinEnvoi[i] = new OpFinEnvoi(paquet); 
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

	@After
	public void tearDown() throws ExceptionNoeudAbsent{
		for(int i=0 ; i < tabOp.length ; i++){
			reseau.enleverNoeud(new AdresseIP(i,i,i,i));
		}
	}

	
	@Test
	public void testOpDeplacer(){
			date = 0;
			for(int j=0 ; j<noeuds.length ; j++){
				assertEquals(new Point2D.Double(j+1, j+1), noeuds[j].getPoint());
			}			
			tabOpDeplacer[0].executer(sim, date);
			tabOpDeplacer[0].executer(sim, date); // En deux exécutions tous les points devraient avoir atteint leurs destinations
			assertTrue(sim.getFileAttente().isEmpty()); //L'opération déplacer ne s'enregistre pas dans le simulateur
			for(int j=0 ; j<noeuds.length ; j++){
				assertEquals(noeuds[j].getPoint(),new Point2D.Double(j+2, j+2) );
			}
	}

	@Test
	public void testOpFinEnvoi() {
		for(int i=0 ; i<tabOpFinEnvoi.length ; i++){
			date = i;
			tabOpFinEnvoi[i].executer(sim, date);
			assertEquals(sim.getFileAttente().peek().getTExec(),tabEv[i].getTExec());
			assertEquals(sim.getFileAttente().poll().getOperation().getClass(), OpRecevoir.class); //Enregistre un évènement avec une opération recevoir

		}
	}

	@Test
	public void testOpRecevoir() {
		for(int i=0 ; i<tabOpRecevoir.length ; i++){
			date = i;
			tabOpRecevoir[i].executer(sim, date);
			assertEquals(sim.getFileAttente().peek().getTExec(),tabEv[i].getTExec());
			assertEquals(sim.getFileAttente().poll().getOperation().getClass(), OpRecevoir.class);
		}
	}

	@Test
	public void testOpEnvoyer() {
		for(int i=0 ; i<tabOpEnvoyer.length ; i++){
			date = i;
			tabOpEnvoyer[i].executer(sim, date);
			assertEquals(sim.getFileAttente().peek().getTExec(), sim.gettCourant()+(paquet.getTaille()*reseau.getListeNoeuds().get(source).getDebitEmission()));
			assertEquals(sim.getFileAttente().poll().getOperation().getClass(), OpFinEnvoi.class);// Est enregistré sous la forme d'un événement avec opération de fin d'envoi

		}
	}



}