package familytree;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
public class Relationship extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel Name1Label, Name2Label, RelationLabel;
	private JComboBox Name1Drop, Name2Drop, RelationDrop;
	
	String[] relationTypes = { "Father", "Mother", "Brother", "Sister", "Aunt", "Uncle" };
	public Relationship() {
		JPanel ContentPane = new JPanel();
		ContentPane.setLayout(new GridBagLayout());
		setContentPane(ContentPane);
		
		Name1Label = new JLabel("");
		Name1Label.setHorizontalAlignment(JLabel.RIGHT);
		
		Name2Label = new JLabel("");
		Name2Label.setHorizontalAlignment(JLabel.RIGHT);
		
		RelationLabel = new JLabel("");
		RelationLabel.setHorizontalAlignment(JLabel.CENTER);
		
		Name1Drop = new JComboBox(relationTypes);
		Name1Drop.setSelectedIndex(0);
		//Name1Drop.addActionListener(this);
		
		//Name1Label.setText(Name1Drop.getSelectedItem());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10,5,10,5);
		
		c.gridx = 0;
		c.gridy = 0;
		ContentPane.add(Name1Drop, c);
	}
}
