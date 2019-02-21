package mm.swing.working;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyChordT extends JPanel {
	private static final long serialVersionUID = 1L;
	int width;
	int height;
	int rows;
	int cols;
	
	String chordName;
	
	int[] chordY = new int[6];
	int[] y = new int[6];
	
	int x1 = 10;
	int x2 = 46;
	int x3 = 82;
	int x4 = 118;
	int x5 = 154;
	int x6 = 190;
	
	MyChordT(Integer[] chordArray, String s) {
		setPreferredSize(new Dimension (220, 280));
		setBackground(Color.WHITE);
		
		setChordName(s);
		
		rows = 5;
		cols = 5;
		int i = 0;
		
		for(i= 0; i < 6; i++){
			chordY[i] = -100;
		}
		for(i= 0; i < 6; i++){
			y[i] = -100;
		}
		
		for( i = 0; i < chordArray.length; i++) {
			if(chordArray[i] == null) {
				chordY[i] = chordY[i] + 128;
			}
			if(chordArray[i] != null) {
				y[i] = y[i] + 120 + ((chordArray[i] - 1) * 45);
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
			
			int i = 0;
		
		    width = getSize().width - 40;
		    height = getSize().height - 60;
		    
		    int rh = height / (rows);
		    int cw = (width / cols);
		   
		    for (i = 0; i <= rows; i++) {
		    	g.drawLine(20, i * rh + 35, width + 20, i * rh + 35);
		    }		    
		    for (i = 0; i <= cols; i++) {
		    	g.drawLine(i * cw + 20, 35, i * cw + 20, height + 35);
		    }	

		    
		    g.drawOval(x1, (rh/ 2) + y[0], 18, 18);
		    g.fillOval(x1, (rh/ 2) + y[0], 18, 18);
		    g.drawOval(x2, (rh/ 2) + y[1], 18, 18);
		    g.fillOval(x2, (rh/ 2) + y[1], 18, 18);
		    g.drawOval(x3, (rh/ 2) + y[2], 18, 18);
		    g.fillOval(x3, (rh/ 2) + y[2], 18, 18);
		    g.drawOval(x4, (rh/ 2) + y[3], 18, 18);
		    g.fillOval(x4, (rh/ 2) + y[3], 18, 18);
		    g.drawOval(x5, (rh/ 2) + y[4], 18, 18);
		    g.fillOval(x5, (rh/ 2) + y[4], 18, 18);
		    g.drawOval(x6, (rh/ 2) + y[5], 18, 18);
		    g.fillOval(x6, (rh/ 2) + y[5], 18, 18);
		    
		    g.drawString("X", 17, chordY[0]);
		    g.drawString("X", 53, chordY[1]);
		    g.drawString("X", 88, chordY[2]);
		    g.drawString("X", 123, chordY[3]);
		    g.drawString("X", 158, chordY[4]);
		    g.drawString("X", 193, chordY[5]);
		    
		    g.drawString(getChordName(), 105, 10);
		    
	}
	public void setChordName(String s) {
		this.chordName = s;
	}
	public String getChordName() {
		return this.chordName;
	}
}