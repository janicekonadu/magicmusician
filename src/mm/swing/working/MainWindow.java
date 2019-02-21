package mm.swing.working;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainWindow {
	final int STARTING_WIDTH = 900;
	final int STARTING_HEIGHT = 675;
	
	public MainWindow() {
		JFrame jf = new JFrame("Magic Musician");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(STARTING_WIDTH, STARTING_HEIGHT);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		
		WelcomeScene ws = new WelcomeScene(jf);
		PostParsingScene pp = new PostParsingScene(jf, ws);
		
		ChordViewScene cv = new ChordViewScene(jf, ws, pp, 3);
		jf.add(ws);
		
		JButton nextButton = new JButton("Next");				//This button takes you to the post parsing screen by removing welcome screen and adding pp
		nextButton.setPreferredSize(new Dimension(100, 30));
		ws.browseContainer.add(nextButton);
		nextButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) { 		//midiReader
		    	if(ws.isMidi == true) {									
		    		ws.mr.doIt();
		    		pp.title1.setText(ws.mr.getFile());
		    		pp.keySig1.setText(ws.mr.newSong.getKeySig().toString());
		    		pp.timeSig1.setText(ws.mr.newSong.getTimeSig().toString());
		    		for(int i = 0; i < ws.mr.newSong.getNumTracks(); i++) {
		    		pp.trackBox.add(pp.getTrack(i + 1, ws.mr.newSong.getTracks().get(i).toString()));
		    		}
		    		ws.remove(nextButton);
		    		jf.remove(ws);
			    	jf.add(pp);
			    	jf.pack();
			    	jf.setVisible(true);
			    	
			    	
			    	System.out.println(ws.mr.fileName.toString());
			    	System.out.println(ws.mr.newSong.getTracks().toString());
//		    	} else {
//		    		if(ws.isXML == true) {									//Would be XMLReader
//			    		//fill in XMLReader
//			    		ws.remove(nextButton);
//			    		jf.remove(ws);
//				    	jf.add(pp);
//				    	jf.pack();
//				    	jf.setVisible(true);
			    	} else {
		    			JOptionPane.showMessageDialog (null, "You did not select a valid file.");
			    	}      
		      }  
		});
		
		JButton nextButton2 = new JButton("Next");				//This button takes you to the chordview screen by removing pp screen and adding cv
		nextButton2.setPreferredSize(new Dimension(100, 30));	//This button could also xml -> harmony?
		pp.cfgContainer6.add(nextButton2);
		nextButton2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	pp.remove(nextButton2);  
		    	jf.remove(pp);
		    	jf.add(cv);
		    	jf.pack();
		    	jf.setVisible(true);
		      }  
		});
	}
	public static void main(String[] sa) {
			EventQueue.invokeLater(MainWindow::new);
	}
}