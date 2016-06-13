package gui.simulation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanneauPosition extends JPanel {

	private static GridBagConstraints contraintes;
	private JTextField positionField1;
	private JTextField positionField2;
	
	public PanneauPosition()
	{
		this.setLayout(new GridBagLayout());
		contraintes = new GridBagConstraints();
		
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.PAGE_START;
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		
		JLabel positionLabel = new JLabel("Position : ");
		this.add(positionLabel, contraintes);
		
		GridBagConstraints layout = new GridBagConstraints();
		JPanel panel = new JPanel(new GridBagLayout());
		
		layout.weighty = 1;
		layout.weightx = 1;
		layout.gridx = 0;
		layout.gridy = 0;
		positionField1 = new JTextField("2");
		panel.add(positionField1, layout);
		
		layout.weighty = 1;
		layout.weightx = 1;
		layout.gridx = 1;
		layout.gridy = 0;
		positionField2 = new JTextField("3");
		panel.add(positionField2, layout);
		
		contraintes.weighty = 1;
		contraintes.weightx = 1;
		contraintes.gridx = 0;
		contraintes.gridy = 1;
		this.add(panel);
	}
	
	/**
	 * Retourne un point si les coordonnées entrées sont valides, null sinon
	 * @return un point, ou null si coordonnées invalides
	 */
	public Point2D.Double getPoint()
	{
		Point2D.Double point = null;
		try
		{
			double x = Double.parseDouble(this.positionField1.getText());
			double y = Double.parseDouble(this.positionField2.getText());
			point = new Point2D.Double(x, y);
		}
		catch(NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(new JFrame(), "La position n'est pas valide. Veuillez spécifier une position valide");
		}
		return point;
	}
}