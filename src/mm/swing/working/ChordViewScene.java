package mm.swing.working;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

public class ChordViewScene extends JPanel {
	private static final long serialVersionUID = 1L;
	int index = 0;	
	
	Integer[] array1 = {1, 2, 1, 3, 2, null};			//EXAMPLE ARRAYS TO BE PASSED IN
	Integer[] array2 = {4, 3, 1, null, null};
	Integer[] array3 = {null, 4, 3, 1, 2, 2};
	String[] array4 = {"C", "D", "B"};
	Integer[][] arrays = { array1, array2, array3};
	
	
	JPanel jpChord = new JPanel();				
	MyGuitarT gc = new MyGuitarT();	
	
	Box fretboardBox = new Box(BoxLayout.Y_AXIS); 
	JPanel fretboardContainer = new JPanel();
	
	public ChordViewScene(JFrame jf, WelcomeScene ws, PostParsingScene pp, int NUM_CHORDS) {
		
		MyChordT chordArray[] = new MyChordT[NUM_CHORDS];  
		
		for(int i = 0; i < NUM_CHORDS; i++) {
			chordArray[i] = new MyChordT(arrays[i], array4[i]);
		}
		
		int WINDOW_WIDTH = jf.getWidth();
		int WINDOW_HEIGHT = jf.getHeight();
		
		int PLAYERCONTROL_HEIGHT = WINDOW_HEIGHT * 1 / 14;
		int CHORDVIEW_HEIGHT =  WINDOW_HEIGHT * 7 / 14;
		int FRETBOARD_HEIGHT = WINDOW_HEIGHT * 6 / 14;
		
		int timerDelay = 500; //This could be another parameter passed in that will be based on time signature???
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		Box chordViewBox = new Box(BoxLayout.X_AXIS);
		chordViewBox.setPreferredSize(new Dimension(((index + 1) * 300), CHORDVIEW_HEIGHT));
		jpChord.setBackground(Color.WHITE);
		jpChord.setPreferredSize(new Dimension(850,355));
		jpChord.setLayout(new FlowLayout(FlowLayout.RIGHT));
		chordViewBox.add(jpChord);

		JScrollPane scrollPane = new JScrollPane(chordViewBox);
	    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    JScrollBar sb = scrollPane.getHorizontalScrollBar();
	   	AdjustmentListener al = new AdjustmentListener() {
	   		public void adjustmentValueChanged(AdjustmentEvent e) {
	   			e.getAdjustable().setValue(e.getAdjustable().getMaximum());
	    		}	
	    	};
	  
	    this.add(scrollPane);	
		
		Box playerControlBox = new Box(BoxLayout.Y_AXIS);
		playerControlBox.setPreferredSize(new Dimension(WINDOW_WIDTH, PLAYERCONTROL_HEIGHT));
		JPanel playerControlContainer = new JPanel();
		playerControlContainer.setBackground(Color.WHITE);
		playerControlContainer.setLayout(new FlowLayout());
		JSlider js = new JSlider();
		js.setPreferredSize(new Dimension(100, 30));
		playerControlContainer.add(js);
		JButton playButton = new JButton("PLAY >>");
		playButton.setPreferredSize(new Dimension(100, 30));
		playerControlContainer.add(playButton);
		javax.swing.Timer timer = new javax.swing.Timer(timerDelay, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(index < NUM_CHORDS) {							
				chordViewBox.setPreferredSize(new Dimension(((index + 1) * 300), CHORDVIEW_HEIGHT));
				jpChord.add(chordArray[index], BorderLayout.WEST);
				gc.doCoordinates(arrays[index]);					//HERE is where the guitar and chord arrays are uploaded
				gc.repaint();										//EXAMPLE of how this could play
				jf.pack();
				index++;
				try {
				    Thread.sleep(500);                 
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
					}
				}
			}
	    });     
		playButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    		  timer.start();						
		    		  sb.addAdjustmentListener(al);				//Should also play the song
		    		  if(index == NUM_CHORDS){
		    			  timer.stop();
		    			  sb.removeAdjustmentListener(al);
		    		  }
		 
		  }  
		});
		JButton pauseButton = new JButton("PAUSE ||");
		pauseButton.setPreferredSize(new Dimension(100, 30));
		playerControlContainer.add(pauseButton);
		pauseButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    		  timer.stop();
		    		  sb.removeAdjustmentListener(al);
		  }  
		});
		JButton stopButton = new JButton("STOP []");
		stopButton.setPreferredSize(new Dimension(100, 30));
		playerControlContainer.add(stopButton);
		stopButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    		  timer.restart();
		    		  sb.removeAdjustmentListener(al);
		  }  
		});
		playerControlBox.add(playerControlContainer);
		this.add(playerControlBox);
		
		fretboardBox.setPreferredSize(new Dimension(WINDOW_WIDTH, FRETBOARD_HEIGHT));
		fretboardContainer.setBackground(Color.WHITE);
		fretboardContainer.add(gc);						
		fretboardBox.add(fretboardContainer);
		this.add(fretboardBox);
	}
}
