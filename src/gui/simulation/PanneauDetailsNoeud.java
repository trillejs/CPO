package gui.simulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import noeud.AdresseIP;
import noeud.Chemin;
import noeud.INoeud;
import noeud.Noeud;

public class PanneauDetailsNoeud extends JPanel implements Observer{
	
	private static GridBagConstraints contraintes;
	
	/** Nom du noeud à créer */
	private JLabel nom;
	/** Adresse IP du noeud à créer */
	private JLabel panneauIP;
	/** Débit d'émission du noeud à créer */
	private JLabel debitField;
	/** Puissance d'émission (correspondant à la distance maximum atteignable) du noeud à créer */
	private JLabel puissanceField;
	/** Position de départ du noeud à créer */
	private JLabel position;
	
	private Noeud noeud;
	
	private JList<AdresseIP> listeIP;
	private JScrollPane scrollPane;
	
	private JList<AdresseIP> listeIPChemin;
	private JScrollPane scrollPaneChemin;
	private Map<AdresseIP, Chemin> map;
	
	public PanneauDetailsNoeud(Noeud noeud)
	{
		
		this.noeud = noeud;
		this.setLayout(new GridBagLayout());
		contraintes = new GridBagConstraints();
		
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;

		//Nom
		JLabel nomLabel = new JLabel("Nom : ");
		this.add(nomLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		
		nom = new JLabel(this.noeud.getNom());
		nom.setPreferredSize(new Dimension(100, 10));
		this.add(nom, contraintes);
		
		//IP
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		JLabel ipLabel = new JLabel("Adresse IP : ");
		this.add(ipLabel, contraintes);
		
	
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 1;
		contraintes.gridy = 1;
		panneauIP = new JLabel(this.noeud.getAdresseIP().toString());
		this.add(panneauIP, contraintes);
		
		//Debit
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		JLabel debitLabel = new JLabel("Débit d'émission : ");
		this.add(debitLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 2;
		debitField = new JLabel(Integer.toString(this.noeud.getDebitEmission()));
		debitField.setPreferredSize(new Dimension(50, 10));
		this.add(debitField, contraintes);
		
		//Puissance
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 3;
		JLabel puissanceLabel = new JLabel("Puissance d'émission : ");
		this.add(puissanceLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 3;
		puissanceField = new JLabel(Double.toString(this.noeud.getPuissance()));
		puissanceField.setPreferredSize(new Dimension(50, 10));
		this.add(puissanceField, contraintes);
		
		//Position
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 4;
		JLabel positionLabel = new JLabel("Position : ");
		this.add(positionLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 4;
		position = new JLabel(this.noeud.getPoint().toString());
		this.add(position, contraintes);
				
		//Activation du noeud
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 5;
		
		JLabel activationNoeud; 
		if(this.noeud.estActif())
		{
			activationNoeud = new JLabel("Le noeud est activé");
		}
		else
		{
			activationNoeud = new JLabel("Le noeud est désactivé");	
		}
		this.add(activationNoeud, contraintes);
		
		//modele de mobilite
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 6;
		
		JLabel modeleLabel = new JLabel("Mod�le de mobilit� : ");
		this.add(modeleLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 6;
		
		JLabel modele = new JLabel(this.noeud.getModele().getClass().toString()); 
		this.add(modele, contraintes);
		
		//Table de routage
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 7;
		
		JLabel tableRouteLabel = new JLabel("Table de routage : ");
		this.add(tableRouteLabel, contraintes);
		
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 7;
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200,100));
		scrollPane.setVisible(true);
		
		this.scrollPane.setBackground(new Color(124));
		this.add(this.scrollPane, contraintes);
		
		//Table de routage
		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 0;
		contraintes.gridy = 8;

		JLabel donneesLabel = new JLabel("Donnees reçues : ");
		this.add(donneesLabel, contraintes);

		contraintes.weighty = 1;		
		contraintes.weightx = 1;		
		contraintes.gridx = 1;
		contraintes.gridy = 8;
	
		JList<String> listeDonnees = new JList<>(noeud.getMessagesRecus().toArray(new AdresseIP[1]));
		JScrollPane scrollPaneDonnees = new JScrollPane(listeDonnees);
		scrollPaneDonnees.setPreferredSize(new Dimension(200,100));
		scrollPaneDonnees.setVisible(true);
		scrollPaneDonnees.setBackground(new Color(124));
		this.add(scrollPaneDonnees, contraintes);
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		map = noeud.getRouteTable();
		List<AdresseIP> listeIps = new ArrayList<>(map.keySet());
		Collections.sort(listeIps);
		
		this.listeIP = new JList<>(listeIps.toArray(new AdresseIP[1]));

		this.listeIP.addListSelectionListener(new ActionListeSelect());
		this.remove(scrollPane);
		
		scrollPane = new JScrollPane(this.listeIP);
		scrollPane.setPreferredSize(new Dimension(200,100));
		scrollPane.setVisible(true);
		
		this.scrollPane.setBackground(new Color(124));
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 8;
		this.add(scrollPane, contraintes);
		

		revalidate();
		repaint();
	}
	
	public Noeud getNoeud()
	{
		return this.noeud;
	}
	
	public class ActionListeSelect implements ListSelectionListener
	{

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			
			JList<AdresseIP> list = (JList<AdresseIP>) arg0.getSource();

			AdresseIP noeudSelectionne = (AdresseIP)list.getSelectedValue();
			if(noeudSelectionne != null)
			{
				Chemin chemin = (Chemin)map.get(noeudSelectionne);

				//Cr�e le panneau de d�tails de noeud associ� au nouveau noeud s�lectionn�
				if(scrollPaneChemin !=  null)
				{
					remove(scrollPaneChemin);
				}
				
				List<AdresseIP> listeIps = new ArrayList<>(chemin.getListeNoeud().keySet());
				listeIPChemin = new JList<>(listeIps.toArray(new AdresseIP[1]));
				scrollPaneChemin = new JScrollPane(listeIPChemin);
				scrollPane.setPreferredSize(new Dimension(200,100));
				scrollPane.setVisible(true);
				
				contraintes.weighty = 1;
				contraintes.weightx = 1;
				contraintes.gridx = 1;
				contraintes.gridy = 9;
				add(scrollPaneChemin, contraintes);
				
				scrollPane.setPreferredSize(new Dimension(200,100));
				scrollPane.setVisible(true);
				
				revalidate();
				repaint();
			}
		}		
	}
}
