package gui;

import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame {

	public FenetrePrincipale() {
		setTitle("Simulateur de réseau ad'hoc");
		setSize(300,200); 
		setLocation(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		JFrame f = new FenetrePrincipale();
		f.setVisible(true);
	}

}
