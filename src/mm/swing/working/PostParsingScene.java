package mm.swing.working;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PostParsingScene extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JPanel cfgContainer6 = new JPanel();

	String numNotes = "<nn unknown>";
	
	JTextField keySig1 = new JTextField(8);
	JTextField timeSig1 = new JTextField(8);
	JTextField numMes1 = new JTextField(8);
	JTextField title1 = new JTextField(30);
		
	JLabel lbl1 = new JLabel("Chord Settings");
	Font customFont1 = new Font("Algerian", Font.BOLD, 22);
	
	int numTracks;
	
	Box trackBox = new Box(BoxLayout.Y_AXIS);

	
	public PostParsingScene(JFrame jf, WelcomeScene ws) {
		int WINDOW_WIDTH = jf.getWidth();
		int WINDOW_HEIGHT = jf.getHeight() - 60;
		
		int DATAVIEW_WIDTH = WINDOW_WIDTH * 3 / 5;
		int CFG_WIDTH = WINDOW_WIDTH * 2 / 5;
		int HEADER_HEIGHT = WINDOW_HEIGHT * 2 / 14;
		int TRACKBOX_HEIGHT = WINDOW_HEIGHT * 1 / 2;
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		
		
		Box dataViewBox = new Box(BoxLayout.Y_AXIS);
		dataViewBox.setPreferredSize(new Dimension(DATAVIEW_WIDTH, WINDOW_HEIGHT));
		JPanel dataViewContainer = new JPanel();
		dataViewContainer.setLayout(new BoxLayout(dataViewContainer, BoxLayout.Y_AXIS));
		dataViewContainer.setBackground(Color.WHITE);
		dataViewBox.add(dataViewContainer);
		this.add(dataViewBox);
		
		LabelCompBox cb = new LabelCompBox("Title", title1);
		LabelCompBox cb2 = new LabelCompBox("Key Signature", keySig1);
		LabelCompBox cb3 = new LabelCompBox("Time Signature", timeSig1);
			
		Box headerBox = new Box(BoxLayout.Y_AXIS);
		headerBox.setPreferredSize(new Dimension(DATAVIEW_WIDTH, HEADER_HEIGHT));
		JPanel headerContainer = new JPanel();
		headerContainer.setLayout(new FlowLayout (FlowLayout.LEFT));
		headerContainer.setBackground(Color.LIGHT_GRAY);
		headerContainer.add(cb);
		JPanel headerContainer2 = new JPanel();
		headerContainer2.setLayout(new FlowLayout (FlowLayout.LEFT));
		headerContainer2.setBackground(Color.LIGHT_GRAY);
		headerContainer2.add(cb2);
		JPanel headerContainer3 = new JPanel();
		headerContainer3.setLayout(new FlowLayout (FlowLayout.LEFT));
		headerContainer3.setBackground(Color.LIGHT_GRAY);
		headerContainer3.add(cb3);
		headerBox.add(headerContainer);
		headerBox.add(headerContainer2);
		headerBox.add(headerContainer3);
		dataViewContainer.add(headerBox);
		
		trackBox.setBackground(Color.DARK_GRAY);
		trackBox.setPreferredSize(new Dimension(DATAVIEW_WIDTH, TRACKBOX_HEIGHT));	
		dataViewContainer.add(trackBox);
		
		LabelCompBox lc = new LabelCompBox("Frequency", new JTextField(8));
		LabelCompBox lc1 = new LabelCompBox("Base Octave", new JTextField(8));
		LabelCompBox lc2 = new LabelCompBox("Max Number of Notes", new JTextField(8));
		LabelCompBox lc3 = new LabelCompBox("Parallel 5th's", new JCheckBox(""));
		
		
		Box cfgBox = new Box(BoxLayout.Y_AXIS);								//can just continue adding panels in same fashion 
		cfgBox.setPreferredSize(new Dimension(CFG_WIDTH, WINDOW_HEIGHT));	//to add additional chord settings
		JPanel cfgContainer = new JPanel();
		lbl1.setFont(customFont1);
		cfgContainer.add(lbl1);
		JPanel cfgContainer2 = new JPanel();								
		cfgContainer2.add(lc);												
		JPanel cfgContainer3 = new JPanel();
		cfgContainer3.add(lc1);
		JPanel cfgContainer4 = new JPanel();
		cfgContainer4.add(lc2);
		JPanel cfgContainer5 = new JPanel();
		cfgContainer5.add(lc3);
		jf.setVisible(true);
		cfgBox.add(cfgContainer);
		cfgBox.add(cfgContainer2);
		cfgBox.add(cfgContainer3);
		cfgBox.add(cfgContainer4);
		cfgBox.add(cfgContainer5);
		cfgBox.add(cfgContainer6);
		this.add(cfgBox);
	}
	public JPanel getTrack(int trackNum, String s){
		
		JPanel trackContainer = new JPanel();
		trackContainer.setLayout(new FlowLayout (FlowLayout.LEFT));
		trackContainer.setBackground(Color.DARK_GRAY);
		trackContainer.setPreferredSize(new Dimension (350, 100));
		trackContainer.setBackground(Color.DARK_GRAY);
		JLabel txt = new JLabel("TRACK" + trackNum);
		txt.setForeground(Color.WHITE);
		JTextArea txtArea = new JTextArea(1, 45);
		txtArea.setText(s);
		txtArea.setCaretPosition(0);
		JScrollPane sp = new JScrollPane(txtArea);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setMaximumSize(new Dimension (4, 40));
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, txt, sp);
		split.setBackground(Color.DARK_GRAY);
		split.setOneTouchExpandable(true);
		trackContainer.add(split);
		
		return trackContainer;
	} 
}
