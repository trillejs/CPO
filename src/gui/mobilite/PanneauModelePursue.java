package gui.mobilite;


import java.awt.GridLayout;

import javax.swing.JButton;

public class PanneauModelePursue extends PanneauModeleDeMobilite {

	public PanneauModelePursue()
	{
		this.setLayout(new GridLayout());
		this.add(new JButton("testPursue"));
	}
	
}
