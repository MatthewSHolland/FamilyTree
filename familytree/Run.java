package familytree;
import javax.swing.JFrame;


public class Run {

	private static void createMenu() {
		MainMenuGUI menu = new MainMenuGUI("Menu");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setBounds(100, 100, 600, 600);
		menu.pack();
		menu.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createMenu();
	}

}
