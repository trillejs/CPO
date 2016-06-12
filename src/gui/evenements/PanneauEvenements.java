package gui.evenements;

import simulateur.Evenement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui.FenetrePrincipale;


public class PanneauEvenements extends JPanel implements Observer{

	private static GridBagConstraints contraintes;
	
	private JList<Evenement> listeIP;
	private JScrollPane scrollPane;
	
	private PanneauDetailsEvenement panneauDetailEvenement;
	
	public PanneauEvenements()
	{
		this.setLayout(new GridBagLayout());
		contraintes = new GridBagConstraints();
		
		JButton ajoutEvenement = new JButton("Ajouter evenement");
		ajoutEvenement.addActionListener(new ActionAjouterEvenement());
		
		//Ajout des composants

		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		this.add(ajoutEvenement, contraintes);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.addActionListener(new ActionSupprimer());
		
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		this.add(supprimer, contraintes);

		
//		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
//		List<AdresseIP> listeIps = new ArrayList<>(map.keySet());
//		Collections.sort(listeIps);
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200,100));
		scrollPane.setVisible(true);
		
		this.scrollPane.setBackground(new Color(124));
		contraintes.weighty = 0.80;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(this.scrollPane, contraintes);
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		
//		Map<AdresseIP, INoeud> map = FenetrePrincipale.getIPs();
//		List<AdresseIP> listeIps = new ArrayList<>(map.keySet());
//		Collections.sort(listeIps);
//		
//		this.listeIP = new JList<>(listeIps.toArray(new AdresseIP[1]));
//
//		this.listeIP.addListSelectionListener(new ActionListeSelect());
		this.remove(scrollPane);
		
		scrollPane = new JScrollPane(this.listeIP);
		scrollPane.setPreferredSize(new Dimension(200,100));
		scrollPane.setVisible(true);
		
		this.scrollPane.setBackground(new Color(124));
		contraintes.weighty = 0.80;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(scrollPane, contraintes);
		

		revalidate();
		repaint();
		
	}
	
	class ActionAjouterEvenement implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//ouvre une pop up
			JFrame frame = new JFrame();
			frame.setSize(800,500);
			frame.setTitle("Ajout d'un noeud");
			frame.setLayout(new GridLayout());
			frame.add(new PanneauAjoutEvenement());
			frame.setVisible(true);			
		}
	}

	
	class ActionSupprimer implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(panneauDetailEvenement == null)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Aucun evenement sélectionné. Veuillez sélectionner un noeud à supprimer");
			}
			else
			{
//					FenetrePrincipale.delEvent(panneauDetailEvenement.getEvenement());
					JOptionPane.showMessageDialog(new JFrame(), "L'evenement a bien été supprimé.");				
			}
			
		}
		
	}
	
//	public class ActionListeSelect implements ListSelectionListener
//	{
//
//		@Override
//		public void valueChanged(ListSelectionEvent arg0) {
//			
////			JList<AdresseIP> list = (JList<AdresseIP>) arg0.getSource();
////			AdresseIP noeudSelectionne = (AdresseIP)list.getSelectedValue();
////			Noeud noeud = (Noeud)FenetrePrincipale.getReseau().getNoeud(noeudSelectionne);
//			
//			//Crée le panneau de détails de noeud associé au nouveau noeud sélectionné
//			if(panneauDetailEvenement !=  null)
//			{
//				remove(panneauDetailEvenement);
//			}
////			panneauDetailEvenement = new PanneauDetailsNoeud(noeud);
//			contraintes.weighty = 1;
//			contraintes.weightx = 1;
//			contraintes.gridx = 1;
//			contraintes.gridy = 1;
//			add(panneauDetailEvenement, contraintes);
//
//			revalidate();
//			repaint();
//
//
//		}
//		
//	}

}


