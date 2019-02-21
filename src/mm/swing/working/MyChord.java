package mm.swing.working;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class MyChord extends JPanel{
	private AffineTransform gat = new AffineTransform();
	private AffineTransform at = new AffineTransform();
	private static final Stroke STROKE_2 = new BasicStroke(2.0f);
	private static final Stroke STROKE_3 = new BasicStroke(3.0f);
	private static final Stroke STROKE_10 = new BasicStroke(10.0f);
	private Shape s = null;
	private static final long serialVersionUID = 1L;
	int x1 = -50;
	int xc1 = 25;
	int xc2 = 55;
	int xc3 = 85;
	int xc4 = 115;
	int yc1 = 20;
	int yc2 = 20;
	int yc3 = 20;
	int yc4 = -1000;
	MyChord() {		
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		gat = AffineTransform.getTranslateInstance(
			getWidth() / 2.0,
			getHeight() / 2.0
		);
		gat.scale(1.0, -1.0);
		g2d.transform(gat);

		Rectangle2D r2d = new Rectangle2D.Double(
				x1,
				-120.0,
				200.0,
				250.0
			);
			at.setToIdentity();
			s = at.createTransformedShape(r2d);
			g2d.setStroke(STROKE_3);
			g2d.setPaint(Color.WHITE);
			g2d.fill(s);
			g2d.setPaint(Color.BLACK);
			g2d.draw(s);
		Rectangle2D chord = new Rectangle2D.Double(
				x1 + 25,
				-95.0,
				150.0,
				200.0
			);
			at.setToIdentity();
			s = at.createTransformedShape(chord);
			g2d.setStroke(STROKE_3);
			g2d.setPaint(Color.WHITE);
			g2d.fill(s);
			g2d.setPaint(Color.BLACK);
			g2d.draw(s);
		Path2D outline = new Path2D.Double();
			outline.moveTo(x1 + 29, 105.0);
			outline.lineTo(x1 + 172, 105.0);
			at.setToIdentity();
			s = at.createTransformedShape(outline); 
			g2d.setStroke(STROKE_10);
			g2d.setPaint(Color.BLACK);
			g2d.draw(s);
		Path2D grid = new Path2D.Double();
			grid.moveTo(x1 + 55, 105.0);
			grid.lineTo(x1 + 55, -95.0);
			grid.moveTo(x1 + 85, 105.0);
			grid.lineTo(x1 + 85, -95);
			grid.moveTo(x1 + 115, 105.0);
			grid.lineTo(x1 + 115, -95);
			grid.moveTo(x1 + 145, 105.0);
			grid.lineTo(x1 + 145, -95);
			grid.moveTo(x1 + 25, 50.0);
			grid.lineTo(x1 + 175, 50);
			grid.moveTo(x1 + 25, 0);
			grid.lineTo(x1 + 175, 0);
			grid.moveTo(x1 + 25, -50);
			grid.lineTo(x1 + 175, -50);
			at.setToIdentity();
			s = at.createTransformedShape(grid);
			g2d.setStroke(STROKE_2);
			g2d.setPaint(Color.BLACK);
			g2d.draw(s);
			
		Ellipse2D chord1= new Ellipse2D.Double(
				xc1,
				yc1,
				18.0,
				18.0
				);
			g2d.setStroke(new BasicStroke(1.0f));
			g2d.setPaint(Color.BLACK);
			g2d.fill(chord1);
			g2d.draw(chord1);
		Ellipse2D chord2= new Ellipse2D.Double(
				xc2,
				yc2,
				18.0,
				18.0
				);
			g2d.setStroke(new BasicStroke(1.0f));
			g2d.setPaint(Color.BLACK);
			g2d.fill(chord2);
			g2d.draw(chord2);
		Ellipse2D chord3= new Ellipse2D.Double(
				xc3,
				yc3,
				18.0,
				18.0
				);
			g2d.setStroke(new BasicStroke(1.0f));
			g2d.setPaint(Color.BLACK);
			g2d.fill(chord3);
			g2d.draw(chord3);	
			
		Ellipse2D chord4= new Ellipse2D.Double(
				xc4,
				yc4,
				18.0,
				18.0
				);
			g2d.setStroke(new BasicStroke(1.0f));
			g2d.setPaint(Color.BLACK);
			g2d.fill(chord4);
			g2d.draw(chord4);
		
		g2d.dispose();
		}

	public void getChords(int n) {
		if(n == 1) { 	//A
			xc1 = 25;
			xc2 = 55;
			xc3 = 85;
			xc4 = 115;
			yc1 = 20;
			yc2 = 20;
			yc3 = 20;
			yc4 = -1000;
			
			repaint();
		}
		if(n == 2) {	//C
			xc1 = -5;
			xc2 = 25;
			xc3 = 85;
			xc4 = 115;
			yc1 = -30;
			yc2 = 20;
			yc3 = 70;
			yc4 = 1000;
			
			repaint();
		}

	}
}
