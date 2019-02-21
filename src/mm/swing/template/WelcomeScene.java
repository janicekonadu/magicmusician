package mm.swing.template;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomeScene extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public WelcomeScene(JFrame jf) {
		int WINDOW_WIDTH = jf.getWidth();
		int WINDOW_HEIGHT = jf.getHeight();
		
		int SPLASH_HEIGHT = WINDOW_HEIGHT * 8 / 14;
		int BROWSE_HEIGHT = WINDOW_HEIGHT * 1 / 14;
		int RECENT_HEIGHT = WINDOW_HEIGHT * 5 / 14;
		
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		Box splashBox = new Box(BoxLayout.Y_AXIS);
		splashBox.setPreferredSize(new Dimension(WINDOW_WIDTH, SPLASH_HEIGHT));
		JPanel splashContainer = new JPanel();
		splashContainer.setBackground(Color.RED);
		splashBox.add(splashContainer);
		this.add(splashBox);
		
		Box browseBox = new Box(BoxLayout.Y_AXIS);
		browseBox.setPreferredSize(new Dimension(WINDOW_WIDTH, BROWSE_HEIGHT));
		JPanel browseContainer = new JPanel();
		browseContainer.setBackground(Color.BLUE);
		browseContainer.setLayout(new FlowLayout());
		JButton playButton = new JButton("▶");
		playButton.setPreferredSize(new Dimension(30, 30));
		browseContainer.add(playButton);
		JButton stopButton = new JButton("◼");
		stopButton.setPreferredSize(new Dimension(30, 30));
		browseContainer.add(stopButton);
		JTextField browseField = new JTextField();
		browseField.setPreferredSize(new Dimension(400, 30));
		browseContainer.add(browseField);
		JButton browseButton = new JButton("Browse...");
		browseButton.setPreferredSize(new Dimension(100, 30));
		browseContainer.add(browseButton);
		browseBox.add(browseContainer);
		this.add(browseBox);
		
		Box recentBox = new Box(BoxLayout.Y_AXIS);
		recentBox.setPreferredSize(new Dimension(WINDOW_WIDTH, RECENT_HEIGHT));
		JPanel recentContainer = new JPanel();
		recentContainer.setBackground(Color.GREEN);
		recentBox.add(recentContainer);
		this.add(recentBox);
	}
}
