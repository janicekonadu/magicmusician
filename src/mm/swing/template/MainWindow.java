package mm.swing.template;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow {
	final int STARTING_WIDTH = 800;
	final int STARTING_HEIGHT = 600;
	
	public MainWindow() {
		JFrame jf = new JFrame("Magic Musician");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(STARTING_WIDTH, STARTING_HEIGHT);
		jf.setLocationRelativeTo(null);
		jf.setResizable(true);
		
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem imp = new JMenuItem("Import");
		JMenuItem exit = new JMenuItem("Exit");
		file.add(imp);
		file.addSeparator();
		file.add(exit);
		JMenu about = new JMenu("About");
		JMenuItem members = new JMenuItem("Developers");
		about.add(members);
		
		menu.add(file);
		menu.add(about);
		jf.setJMenuBar(menu);
		
		jf.add(new PostParsingScene(jf, 0));
		jf.pack();
		
		jf.setVisible(true);
	}
	public static void main(String[] sa) {
			EventQueue.invokeLater(MainWindow::new);
	}
}