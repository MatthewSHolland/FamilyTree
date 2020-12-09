package familytree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
public class MainMenuGUI extends JFrame{

private JButton New, Open, OK;
private JTextField Name;
private JLabel Welcome, FamilyName;

public MainMenuGUI(String title) {
	
	JPanel ContentPane = new JPanel();
	ContentPane.setLayout(new GridBagLayout());
	setContentPane(ContentPane);
	
	Welcome = new JLabel ("Welcome to the Family Tree Maker");
	Welcome.setHorizontalAlignment(JLabel.CENTER);
	
	FamilyName = new JLabel ("Family Name:");
	FamilyName.setHorizontalAlignment(JLabel.RIGHT);
	FamilyName.setVisible(false);
	Name = new JTextField(30);
	Name.setVisible(false);
	OK = new JButton("OK");
	OK.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CreateTimeLine(Name.getText());
		}
	});
	OK.setVisible(false);
	
	
	New = new JButton("New Family Tree");
	New.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Name.setVisible(true);
			OK.setVisible(true);
			FamilyName.setVisible(true);
			pack();
		}
	});
	Open = new JButton("Open Family Tree");
	
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	c.insets = new Insets(10, 5, 10, 5);
	
	c.anchor = GridBagConstraints.CENTER;
	c.weighty = 2;
	c.gridx = 0;
	c.gridy = 1;
	ContentPane.add(New, c);
	c.gridx = 2;
	c.gridy = 1;
	ContentPane.add(Open, c);
	
	c.anchor = GridBagConstraints.SOUTH;
	c.weighty = 1;
	c.gridx = 1;
	c.gridy = 2;
	ContentPane.add(Name, c);
	c.gridx = 0;
	ContentPane.add(FamilyName, c);
	c.gridx = 2;
	ContentPane.add(OK, c);
	
	c.gridx = 1;
	c.gridy = 0;
	c.anchor = GridBagConstraints.NORTH;
	c.weighty = 1;
	ContentPane.add(Welcome, c);
	
	
	}

	private static void CreateTimeLine(String Family) {
		TimeLine TL = new TimeLine(Family);
		TL.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		TL.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				TimeLine.save();
			}
		});
		TL.setBounds(100, 100, 600, 600);
		TL.pack();
		TL.setVisible(true);
	}
}
