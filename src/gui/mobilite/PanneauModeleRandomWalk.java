package gui.mobilite;


import java.awt.GridLayout;

import javax.swing.JButton;

public class PanneauModeleRandomWalk extends PanneauModeleDeMobilite {

	public PanneauModeleRandomWalk()
	{
		this.setLayout(new GridLayout());
		this.add(new JButton("testWalk"));
	}
}
