package mm.swing.template;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PostParsingScene extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public PostParsingScene(JFrame jf, int NUM_TRACKS) {
		int WINDOW_WIDTH = jf.getWidth();
		int WINDOW_HEIGHT = jf.getHeight();
		
		int DATAVIEW_WIDTH = WINDOW_WIDTH * 3 / 5;
		int CFG_WIDTH = WINDOW_WIDTH * 2 / 5;
		int HEADER_HEIGHT = WINDOW_HEIGHT * 1 / 2;
		int TRACKBOX_HEIGHT = WINDOW_HEIGHT * 1 / 2;
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		Box dataViewBox = new Box(BoxLayout.X_AXIS);
		dataViewBox.setPreferredSize(new Dimension(DATAVIEW_WIDTH, WINDOW_HEIGHT));
		JPanel dataViewContainer = new JPanel();
		dataViewContainer.setLayout(new BoxLayout(dataViewContainer, BoxLayout.Y_AXIS));
		dataViewContainer.setBackground(Color.RED);
		dataViewBox.add(dataViewContainer);
		this.add(dataViewBox);
		
		Box headerBox = new Box(BoxLayout.Y_AXIS);
		headerBox.setPreferredSize(new Dimension(DATAVIEW_WIDTH, HEADER_HEIGHT));
		JPanel headerContainer = new JPanel();
		headerContainer.setBackground(Color.ORANGE);
		headerBox.add(headerContainer);
		dataViewContainer.add(headerBox);
		
		Box trackBox = new Box(BoxLayout.Y_AXIS);
		trackBox.setPreferredSize(new Dimension(DATAVIEW_WIDTH, TRACKBOX_HEIGHT));
		JPanel trackContainer = new JPanel();
		trackContainer.setBackground(Color.GREEN);
		trackBox.add(trackContainer);
		dataViewContainer.add(trackBox);
		
		Box cfgBox = new Box(BoxLayout.X_AXIS);
		cfgBox.setPreferredSize(new Dimension(CFG_WIDTH, WINDOW_HEIGHT));
		JPanel cfgContainer = new JPanel();
		cfgContainer.setBackground(Color.BLUE);
		cfgBox.add(cfgContainer);
		this.add(cfgBox);
	}
}
