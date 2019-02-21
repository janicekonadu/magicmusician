package mm.swing.template;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChordViewScene extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ChordViewScene(JFrame jf, int NUM_CHORDS) {
		int WINDOW_WIDTH = jf.getWidth();
		int WINDOW_HEIGHT = jf.getHeight();
		
		int PLAYERCONTROL_HEIGHT = WINDOW_HEIGHT * 1 / 14;
		int CHORDVIEW_HEIGHT =  WINDOW_HEIGHT * 8 / 14;
		int FRETBOARD_HEIGHT = WINDOW_HEIGHT * 5 / 14;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		Box playerControlBox = new Box(BoxLayout.Y_AXIS);
		playerControlBox.setPreferredSize(new Dimension(WINDOW_WIDTH, PLAYERCONTROL_HEIGHT));
		JPanel playerControlContainer = new JPanel();
		playerControlContainer.setBackground(Color.BLUE);
		playerControlBox.add(playerControlContainer);
		this.add(playerControlBox);
		
		Box chordViewBox = new Box(BoxLayout.Y_AXIS);
		chordViewBox.setPreferredSize(new Dimension(WINDOW_WIDTH, CHORDVIEW_HEIGHT));
		JPanel chordViewContainer = new JPanel();
		chordViewContainer.setBackground(Color.RED);
		chordViewBox.add(chordViewContainer);
		this.add(chordViewBox);
		
		Box fretboardBox = new Box(BoxLayout.Y_AXIS);
		fretboardBox.setPreferredSize(new Dimension(WINDOW_WIDTH, FRETBOARD_HEIGHT));
		JPanel fretboardContainer = new JPanel();
		fretboardContainer.setBackground(Color.GREEN);
		fretboardBox.add(fretboardContainer);
		this.add(fretboardBox);
	}
}
