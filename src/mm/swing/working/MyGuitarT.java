package mm.swing.working;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyGuitarT extends JPanel{

	private static final long serialVersionUID = 1L;
	
	int width;
	int height;
	int rows;
	int cols;
	
	int[] fingerX = new int[6];
	int[] x = new int[6];
	 
	int y1 = 0;
	int y2 = 25;
	int y3 = 50;
	int y4 = 75;
	int y5 = 100;
	int y6 = 125;
	
	
	MyGuitarT() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension (800, 260));
	    rows = 7;
	    cols = 23;
	    int i = 0;
	      
	    for(i= 0; i < 6; i++){
			x[i] = -1000;
		}
		for(i= 0; i < 6; i++){
			fingerX[i] = -1000;
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int i = 0;
		
	    width = getSize().width;
	    height = getSize().height - 85;

	    int rh = height / (rows);
	    int cw = (width / cols);
	   
	    for (i = 0; i <= rows; i++) {
	    	g.drawLine(10, i * rh + 40, width - 8, i * rh + 40);
	    }		    
	    for (i = 0; i < 5; i++) {
	    	g.drawLine(i * 55 + 10 , 40, i * 55 + 10, height + 40);
	    }	    
	    for (i = 0; i < 5; i++) {
	    	g.drawLine((i * 45) + 230, 40, (i * 45) + 230, height + 40);
	    }
	    for (i = 0; i < 5; i++) {
	    	g.drawLine((i * 35) + 410, 40, (i * 35) + 410, height + 40);
	    }
	    for (i = 0; i < 5; i++) {
	    	g.drawLine((i * 27) + 550, 40, (i * 27) + 550, height + 40);
	    }
	    for (i = 0; i < 5; i++) {
	    	g.drawLine((i * 22) + 658, 40, (i * 22) + 658, height + 40);
	    }
	    for (i = 0; i < 3; i++) {
	    	g.drawLine((i * 17) + 746, 40, (i * 17) + 746, height + 40);
	    }

	    g.drawLine(cols * cw + 10, 40, cols * cw + 10, height + 40);
	    
	    g.setColor(Color.RED);
	    g.drawOval((cw / 2) + fingerX[0], 55 + y1, 18, 18);
	    g.fillOval((cw / 2) + fingerX[0], 55 + y1, 18, 18);
	    g.drawOval((cw / 2) + fingerX[1], 55 + y2, 18, 18);
	    g.fillOval((cw / 2) + fingerX[1], 55 + y2, 18, 18);
	    g.drawOval((cw / 2) + fingerX[2], 55 + y3, 18, 18);
	    g.fillOval((cw / 2) + fingerX[2], 55 + y3, 18, 18);
	    g.drawOval((cw / 2) + fingerX[3], 55 + y4, 18, 18);
	    g.fillOval((cw / 2) + fingerX[3], 55 + y4, 18, 18);
	    g.drawOval((cw / 2) + fingerX[4], 55 + y5, 18, 18);
	    g.fillOval((cw / 2) + fingerX[4], 55 + y5, 18, 18);
	    g.drawOval((cw / 2) + fingerX[5], 55 + y6, 18, 18);
	    g.fillOval((cw / 2) + fingerX[5], 55 + y6, 18, 18);
	    
	    g.setColor(Color.BLACK);
	    g.drawString("X", x[0], 70);
	    g.drawString("X", x[1], 95);
	    g.drawString("X", x[2], 120);
	    g.drawString("X", x[3], 145);
	    g.drawString("X", x[4], 170);
	    g.drawString("X", x[5], 195);
	    
	    g.setColor(Color.BLACK);
	    g.drawOval(525, 98, 8, 8);
	    g.fillOval(525, 98, 8, 8);
	    g.drawOval(140, 123, 8, 8);
	    g.fillOval(140, 123, 8, 8);
	    g.drawOval(250, 123, 8, 8);
	    g.fillOval(250, 123, 8, 8);
	    g.drawOval(340, 123, 8, 8);
	    g.fillOval(340, 123, 8, 8);
	    g.drawOval(422, 123, 8, 8);
	    g.fillOval(422, 123, 8, 8);
	    g.drawOval(525, 148, 8, 8);
	    g.fillOval(525, 148, 8, 8);
	    g.drawOval(615, 123, 8, 8);
	    g.fillOval(615, 123, 8, 8);
	    g.drawOval(665, 123, 8, 8);
	    g.fillOval(665, 123, 8, 8);
	    g.drawOval(710, 123, 8, 8);
	    g.fillOval(710, 123, 8, 8);
	    g.drawOval(751, 123, 8, 8);
	    g.fillOval(751, 123, 8, 8);
	   
		}
	
	public void doCoordinates(Integer[] chordArray) {
		int i;
		 
	    for(i= 0; i < 6; i++){
			x[i] = -1000;
		}
		for(i= 0; i < 6; i++){
			fingerX[i] = -1000;
		}
		
		for( i = 0; i < chordArray.length; i++) {
			if(chordArray[i] == null) {
				x[i] = x[i] + 1000;		
			}
			if(chordArray[i] != null && chordArray[i] < 4) {
				fingerX[i] = fingerX[i] + 1010 + ((chordArray[i] - 1) * 55);
			}
			if(chordArray[i] != null && chordArray[i] >= 4 && chordArray[i] < 8) {
				fingerX[i] = fingerX[i] + 1010 + 40 + ((chordArray[i] - 1) * 45);
			}
			if(chordArray[i] != null && chordArray[i] >= 8 && chordArray[i] < 12) {
				fingerX[i] = fingerX[i] + 1010 + 110 + ((chordArray[i] - 1) * 35);
			}
			if(chordArray[i] != null && chordArray[i] >= 12 && chordArray[i] < 16) {
				fingerX[i] = fingerX[i] + 1010 + 203 + ((chordArray[i] - 1) * 27);
			}
			if(chordArray[i] != null && chordArray[i] >= 16 && chordArray[i] < 20) {
				fingerX[i] = fingerX[i] + 1010 + 280 + ((chordArray[i] - 1) * 22);
			}
			if(chordArray[i] != null && chordArray[i] >=20) {
				fingerX[i] = fingerX[i] + 1010 + 395 + ((chordArray[i] - 1) * 17);
			}
		}
	}
}