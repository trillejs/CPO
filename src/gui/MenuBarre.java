package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBarre extends JMenuBar {

	public MenuBarre()
	{
		JMenu me = new JMenu("Changer de vue");
		JMenuItem itemSimu = new JMenuItem("Simulation");
		JMenuItem itemEven = new JMenuItem("Evenements");

		me.add(itemSimu);
		me.add(itemEven);
		this.add(me);
		
	}
}