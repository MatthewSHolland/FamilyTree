package familytree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

public class TimeLine extends JFrame{
	private static final long serialVersionUID = 1L;
	static ArrayList<Family> Familytree = new ArrayList<Family>();
	//static ArrayList<Relationships> Relation = new ArrayList<Relationships>();
//	int familyindex;
//	int relationindex;
	private JLabel FamilyLabel, NameLabel, PlaceLabel, YearLabel, DeathLabel;
	private JTextField FamilyText, NameText, PlaceText, YearText, DeathText;
	private JButton New, Close, SaveNew, Update, Relations;
	private JSlider Slider;
	static String FamilyName;
	
	public TimeLine(String Family) {
		super(Family);
		FamilyName = Family;
		JPanel ContentPane = new JPanel();
		ContentPane.setLayout(new GridBagLayout());
		setContentPane(ContentPane);

		FamilyLabel = new JLabel("Family Name");
		FamilyLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		NameLabel = new JLabel("First Name");
		NameLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		PlaceLabel = new JLabel("Birth Place");
		PlaceLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		YearLabel = new JLabel("Birth Year");
		YearLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		DeathLabel = new JLabel("Year of Death");
		DeathLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		FamilyText = new JTextField(20);
		
		NameText = new JTextField(20);
		
		PlaceText = new JTextField(20);
		
		YearText = new JTextField(20);
		
		DeathText = new JTextField(20);
		
		New = new JButton("New");
		New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FamilyText.setText("");
				NameText.setText("");
				PlaceText.setText("");
				YearText.setText("");
				SaveNew.setVisible(true);
				pack();
			}
		});
		Close = new JButton("Close");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		Close.addActionListener(e -> this.dispose());
		
		
		
		SaveNew = new JButton("Save New");
		SaveNew.setVisible(false);
		SaveNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Family Member = new Family(FamilyText.getText(), NameText.getText(), PlaceText.getText(), Integer.parseInt(YearText.getText()), Integer.parseInt(DeathText.getText()));
				Familytree.add(Member);
			}
		});
		
		
		
		Update = new JButton("Update");
		Relations = new JButton("Create Relation");
		Relations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relationship relation = new Relationship();
				relation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				relation.setBounds(100, 100, 600, 600);
				relation.pack();
				relation.setVisible(true);
			}
		});
		
		Slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
		Slider.setMajorTickSpacing(1);
		Slider.setPaintTicks(true);
		Slider.setPaintLabels(true);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(10, 5, 10, 5);
		
		c.gridx = 0;
		c.gridy = 0;
		ContentPane.add(FamilyLabel, c);
		
		c.gridx = 1;
		ContentPane.add(FamilyText, c);
		
		c.gridx = 0;
		c.gridy = 1;
		ContentPane.add(NameLabel, c);
		
		c.gridx = 1;
		ContentPane.add(NameText, c);
		
		c.gridx = 0;
		c.gridy = 2;
		ContentPane.add(PlaceLabel, c);
		
		c.gridx = 1;
		ContentPane.add(PlaceText, c);
		
		c.gridx = 0;
		c.gridy = 3;
		ContentPane.add(YearLabel, c);
		
		c.gridx = 1;
		ContentPane.add(YearText, c);
		
		c.gridx = 0;
		c.gridy = 4;
		ContentPane.add(DeathLabel, c);
		
		c.gridx = 1;
		c.gridy = 4;
		ContentPane.add(DeathText, c);
		c.gridx = 2;
		c.gridy = 0;
		ContentPane.add(New, c);
		c.gridx = 3;
		ContentPane.add(SaveNew, c);
		
		c.gridx = 2;
		c.gridy = 1;
		ContentPane.add(Relations, c);
		
		c.gridx = 3;
		ContentPane.add(Update, c);
		
		c.gridx = 2;
		c.gridy = 2;
		ContentPane.add(Close, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		ContentPane.add(Slider, c);
	}
	
	public static void save() {
		try(PrintWriter out = new PrintWriter(FamilyName + ".txt")) {
			for (int i = 0; i<Familytree.size(); i++) {
				out.println(Familytree.get(i).getFamilyName() + "," + Familytree.get(i).getFirstName() + "," + Familytree.get(i).getBirthPlace() + "," + Familytree.get(i).getBirthYear() + "," + Familytree.get(i).getDeathYear());
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}//end function save
	
	public static void load() throws IOException{
		try {
			//@SupressWarnings("resource")
			BufferedReader ReadFamily = new BufferedReader(new FileReader(FamilyName + ".txt"));
			String line = "";
			while((line = ReadFamily.readLine()) != null) {
				String [] split = line.split(",");
				int Birthint = Integer.parseInt(split[3]);
				int Deathint = Integer.parseInt(split[4]);
				Family rebuild = new Family(split[0], split[1], split[2], Birthint, Deathint);
				Familytree.add(rebuild);
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
