package gui.mobilite;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanneauModeleDeterministe extends PanneauModeleDeMobilite{

	public PanneauModeleDeterministe()
	{
		this.setLayout(new GridLayout());
		
		this.add(new JButton("testDeter"));
		
		//
	}
}
