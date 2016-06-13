package tests.simulateur;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.ExceptionNoeudAbsent;
import junit.framework.TestCase;
import mobilite.Deterministe;
import mobilite.ModeleDeMobilite;
import noeud.AdresseIP;
import noeud.Chemin;
import noeud.INoeud;
import noeud.Noeud;
import operation.OpDeplacer;
import operation.OpEnvoyer;
import operation.OpFinEnvoi;
import operation.OpRecevoir;
import paquet.Donnee;
import paquet.Paquet;
import paquet.RouteError;
import paquet.RouteReply;
import paquet.RouteRequest;
import reseau.IReseau;
import reseau.Reseau;
import simulateur.*;

public class TestSimulateur extends TestCase{

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
	private Paquet []paquets;
	private Chemin chemin;
	private Chemin cheminRetour;


	@Before
	public void setUp() throws Exception {
		sim = new Simulateur(60);
		reseau = Reseau.createInstance(200);
		noeuds = new Noeud[20];
		source = new AdresseIP(1,1,1,1);
		chemin = new Chemin();
		chemin.ajouter(new AdresseIP(1,1,1,1), 1000);
		chemin.ajouter(new AdresseIP(2,2,2,2), 1000);
		cheminRetour = new Chemin();
		chemin.ajouter(new AdresseIP(2,2,2,2), 1000);		
		chemin.ajouter(new AdresseIP(1,1,1,1), 1000);
		paquets = new Paquet[5];		
		paquets[0] = new RouteError(source, chemin, new AdresseIP(1,1,1,1), new AdresseIP(2,2,2,2));
		paquets[1] = new RouteReply(source, chemin, cheminRetour);
		paquets[2] = new RouteRequest(source, new AdresseIP(2,2,2,2), chemin);
		paquets[3] = new RouteRequest(source, new AdresseIP(2,2,2,2), chemin);
		paquets[4] = new Donnee(source, chemin, "test");

		tabOp = new IOperation[20];
		tabEv = new IEvenement[20];
		tabOpRecevoir = new IOperation[5];
		tabOpFinEnvoi = new IOperation[5];
		tabOpEnvoyer = new IOperation[5];
		tabOpDeplacer = new IOperation[5];
		
		for(int i=0 ; i<noeuds.length ; i++ ){
			String nom = "Noeud "+i;
			ModeleDeMobilite modele = new Deterministe(i+1, new Point2D.Double(i+2,i+2), new Point2D.Double(i+1,i+1));
			noeuds[i] = new Noeud(i*1000 ,i*1000,nom,new AdresseIP(i,i,i,i),  modele);
			reseau.ajouterNoeud(noeuds[i]);
		}
		
		for(int i=0; i<5 ; i++ ){
			tabOpRecevoir[i] = new OpRecevoir(paquets[i], noeuds[i], reseau);
		}
		
		for(int i=0 ; i<tabOp.length ; i++){
			date = i;			
			if(i<5){
				tabOpFinEnvoi[i] = new OpFinEnvoi(paquets[0], reseau);
				tabOpEnvoyer[i] = new OpEnvoyer(reseau, source, paquets[1]);
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
	public void testInitialisation() {
		assertNotNull(sim);
		
	}
	
	@Test
	public void testEnregistrer(){
		sim.enregistrer(tabEv[0]);
		assertEquals(tabEv[0], sim.getFileAttente().poll());
	}
	
	@Test
	public void testAvancer(){
		for(int i=0; i<tabEv.length ; i++){
			sim.enregistrer(tabEv[i]);
			sim.avancer();
			assertEquals(i+1, sim.gettCourant());
		}
	}
	
	@Test
	public void testSimuler(){
		for(int i=0; i<tabEv.length ; i++){
			sim.enregistrer(tabEv[i]);
		}
		sim.simuler();
		System.out.println(sim.getFileFini().toString());
		for(int i=0; i<20; i++){
			assertEquals(tabEv[i], sim.getFileFini().poll());// N emarche pas en raison des opérations enregistrées en plus
		}		
	}
	
	@Test
	public void testSimulerPas(){
		for(int i=0; i<tabEv.length ; i++){
			sim.enregistrer(tabEv[i]);
		}
		sim.simulerPas(10);
		assertEquals(10, sim.gettCourant());
		sim.simulerPas(10);
		assertEquals(20, sim.gettCourant());
	}
	
	@Test
	public void testAccesseurs(){
		
		//getFin
		assertEquals(sim.gettFin(), 60);
		
		//gettCourant
		assertEquals(sim.gettCourant(), 0);
		
		//getFileAttente
		sim.enregistrer(tabEv[0]);
		assertEquals(tabEv[0], sim.getFileAttente().peek());
		
		//getFileFinie
		sim.avancer();
		assertEquals(tabEv[0], sim.getFileFini().peek());
	}

}
