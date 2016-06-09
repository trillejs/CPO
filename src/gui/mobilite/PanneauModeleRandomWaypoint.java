package gui.mobilite;




import java.awt.GridLayout;

import javax.swing.JButton;

public class PanneauModeleRandomWaypoint extends PanneauModeleDeMobilite {

	public PanneauModeleRandomWaypoint()
	{
		this.setLayout(new GridLayout());
		this.add(new JButton("testWaypoint"));
	}
	
}
