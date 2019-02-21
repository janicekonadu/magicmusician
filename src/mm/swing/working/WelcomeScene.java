package mm.swing.working;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mm.util.MidiReader;


public class WelcomeScene extends JPanel {
	private static final long serialVersionUID = 1L;	//ALL Components that need to collaborate with other components should be listed here
	
	JPanel browseContainer = new JPanel();
	
	JTextField browseField = new JTextField();
	JTextArea txtArea = new JTextArea(9, 50);
	
	JFileChooser fc = new JFileChooser();
	
	JButton playButton = new JButton("PLAY >>");
	JButton stopButton = new JButton("STOP []");
	
	public boolean isMidi = false;
	public boolean isXML = false;
	
	MidiReader mr = new MidiReader();					//MIDIREADER
	
	public WelcomeScene(JFrame jf) {
		int WINDOW_WIDTH = jf.getWidth();
		int WINDOW_HEIGHT = jf.getHeight();
		
		int SPLASH_HEIGHT = WINDOW_HEIGHT * 8 / 14;
		int BROWSE_HEIGHT = WINDOW_HEIGHT * 1 / 14;
		int RECENT_HEIGHT = WINDOW_HEIGHT * 5 / 14;
		
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		JScrollPane pane = new JScrollPane(txtArea);
		txtArea.setLineWrap(true);					
		txtArea.setWrapStyleWord(true);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		Box splashBox = new Box(BoxLayout.Y_AXIS);
		splashBox.setPreferredSize(new Dimension(WINDOW_WIDTH, SPLASH_HEIGHT));
		JPanel splashContainer = new JPanel();
		splashContainer.setBackground(Color.WHITE);
		Font customFont = new Font("Algerian", Font.BOLD, 44);
		JLabel lbl = new JLabel("                    The Magic Musician                    ");
		lbl.setFont(customFont);
		JLabel imgLabel = new JLabel(new ImageIcon("data/logo.png"));
		splashContainer.add(lbl);
		splashContainer.add(imgLabel);
		splashBox.add(splashContainer);
		this.add(splashBox);
		
		Box browseBox = new Box(BoxLayout.Y_AXIS);
		browseBox.setPreferredSize(new Dimension(WINDOW_WIDTH, BROWSE_HEIGHT));
		browseContainer.setBackground(Color.WHITE);
		browseContainer.setLayout(new FlowLayout());
		JSlider js = new JSlider();
		js.setPreferredSize(new Dimension(100, 30));
		browseContainer.add(js);
		playButton.setPreferredSize(new Dimension(85, 30));
		browseContainer.add(playButton);
		stopButton.setPreferredSize(new Dimension(85, 30));
		browseContainer.add(stopButton);
		browseField.setPreferredSize(new Dimension(350, 30));
		browseContainer.add(browseField);
		JButton browseButton = new JButton("Browse...");
		browseButton.setPreferredSize(new Dimension(90, 30));
		browseContainer.add(browseButton);
		browseButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {				//BROWSING
		    	  fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setAcceptAllFileFilterUsed(false);
					int num = fc.showOpenDialog(null);
					if (num == JFileChooser.APPROVE_OPTION) {									
						browseField.setText(fc.getSelectedFile().toString());
						txtArea.setText(fc.getSelectedFile().toString());
						if(isMidi(fc.getSelectedFile().toString())) {
							isMidi = true;
							mr.setFile(fc.getSelectedFile());						
						}															//setting filename for MIDIREADER
						File file = new File(fc.getSelectedFile().toString());
						playMidi(file);
					}
		      }
		});
		browseBox.add(browseContainer);
		this.add(browseBox);
		
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem imp = new JMenuItem("Import");
		JMenuItem exit = new JMenuItem("Exit");
		file.add(imp);
		imp.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {	
		    	  fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fc.setAcceptAllFileFilterUsed(false);
					int num = fc.showOpenDialog(null);
					if (num == JFileChooser.APPROVE_OPTION) {
						browseField.setText(fc.getSelectedFile().toString());
						txtArea.setText(fc.getSelectedFile().toString());
						if(isMidi(fc.getSelectedFile().toString())) {
							isMidi = true;
							mr.setFile(fc.getSelectedFile());						//setting filename for MIDIREADER
						}
						File file = new File(fc.getSelectedFile().toString());
						playMidi(file);
					}
		      	}
			});
		file.addSeparator();
		file.add(exit);
		exit.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  System.exit(0);
	          }
			});
		JMenu about = new JMenu("About");
		JMenuItem members = new JMenuItem("Developers");
		about.add(members);
		members.addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	        	  JOptionPane.showMessageDialog (null, "Monica \nMurphy \nJanice \nJoe \nSanjit");
	          }
			});
		menu.add(file);
		menu.add(about);
		jf.setJMenuBar(menu);
		
		Box recentBox = new Box(BoxLayout.X_AXIS);
		recentBox.setPreferredSize(new Dimension(WINDOW_WIDTH, RECENT_HEIGHT));
		JPanel recentContainer = new JPanel();
		recentContainer.setBackground(Color.WHITE);
		Font customFont2 = new Font("Times New Roman", Font.PLAIN, 20);
		JLabel lbl2 = new JLabel("Recent Files:    ");
		lbl2.setFont(customFont2);
		recentContainer.add(lbl2);
		recentContainer.add(pane);
		recentBox.add(recentContainer);
		this.add(recentBox);
		}
		public void browseFiles(){
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setAcceptAllFileFilterUsed(false);
			int num = fc.showOpenDialog(null);
			if (num == JFileChooser.APPROVE_OPTION) {
				browseField.setText(fc.getSelectedFile().toString());
				txtArea.setText(fc.getSelectedFile().toString());
				File file = new File(fc.getSelectedFile().toString());
				playMidi(file);
			}
		}
		public void playMidi(File file) {
			playButton.addActionListener(new ActionListener() {  
				public void actionPerformed(ActionEvent e) {
					try {
						Sequencer sq = MidiSystem.getSequencer();	
						sq.setSequence(MidiSystem.getSequence(file));
						sq.open();
						sq.start();
						if(sq.isRunning()) {
							stopButton.addActionListener(new ActionListener() {  
								public void actionPerformed(ActionEvent e) {
									sq.stop();
									sq.close();
								}
							});
						}
	          
					} catch (IOException  |InvalidMidiDataException |MidiUnavailableException exep  ) {
						JOptionPane.showMessageDialog (null, "File Invalid!");
					}
				} 
			});
		}
			//Method to check if it is a MIDI File
			public boolean isMidi(String s) {	
				if(s.endsWith(".mid")) {
					return true;
				} else {
					return false;
				}
		}
			//Method to check if it is a MIDI File
			public boolean isXML(String s) {	
				if(s.endsWith(".xml")) {
					return true;
				} else {
					return false;
				}
		}
}
