package gui.mobilite;


import gui.PanneauPosition;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.text.Position;

public class PanneauModelePursue extends PanneauModeleDeMobilite {

	public PanneauModelePursue()
	{
		this.setLayout(new GridLayout());
		this.add(new PanneauPosition());
	}
	
}
