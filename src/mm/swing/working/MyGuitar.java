package mm.swing.working;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import javax.swing.JPanel;

public class MyGuitar extends JPanel{
	private AffineTransform gat = new AffineTransform();
	private AffineTransform at = new AffineTransform();
	private static final Stroke STROKE_1 = new BasicStroke(1.0f);
	private static final Stroke STROKE_2 = new BasicStroke(2.0f);
	private static final Stroke STROKE_4 = new BasicStroke(4.0f);
	private static final Stroke STROKE_10 = new BasicStroke(10.0f);
	private Shape s = null;
	private static final long serialVersionUID = 1L;
	int x1 = -1000;
	int y1 = 110;
	int x2 = -1000;
	int y2 = 55;
	int x3 = -1000;
	int y3 = 0;
	int x4 = -1000;
	int y4 = -55;
	
	
	MyGuitar() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(850, 330));
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
		
		Path2D outline = new Path2D.Double();
		outline.moveTo(-420.0, 120.0);
		outline.lineTo(420, 120);
		outline.lineTo(420, -120);
		outline.lineTo(-420, -120);
		outline.lineTo(-420, 120);
		outline.closePath();
		at.setToIdentity();
		s = at.createTransformedShape(outline);
		g2d.setPaint(new Color(102, 51, 0));
		g2d.fill(s);
		g2d.setStroke(STROKE_4);
		g2d.setPaint(Color.BLACK);
		g2d.draw(s);
		
		Path2D strings = new Path2D.Double();
		strings.moveTo(-420.0, 100.0);
		strings.lineTo(420, 100);	
		strings.moveTo(-420.0, 60.0);
		strings.lineTo(420.0, 60.0);
		strings.moveTo(-420.0, 20.0);
		strings.lineTo(420.0, 20);
		strings.moveTo(-420.0, -20.0);
		strings.lineTo(420.0, -20.0);
		strings.moveTo(-420.0, -60.0);
		strings.lineTo(420, -60);
		strings.moveTo(-420.0, -100.0);
		strings.lineTo(420.0, -100);
		at.setToIdentity();
		s = at.createTransformedShape(strings);
		g2d.setStroke(STROKE_2);
		g2d.setPaint(Color.LIGHT_GRAY);
		g2d.draw(s);
		
		Line2D outline2 = new Line2D.Double(
				-416.0,
				118.0,
				-416.0,
				-118.0
			);
			at.setToIdentity();
			s = at.createTransformedShape(outline2); 
			g2d.setStroke(STROKE_10);
			g2d.setPaint(Color.BLACK);
			g2d.draw(s);
			
			Path2D grid = new Path2D.Double();
			grid.moveTo(-356.0, 120.0);
			grid.lineTo(-356.0, -120.0);	
			grid.moveTo(-296.0, 120.0);
			grid.lineTo(-296.0, -120.0);
			grid.moveTo(-236.0, 120.0);
			grid.lineTo(-236.0, -120.0);
			grid.moveTo(-186.0, 120.0);
			grid.lineTo(-186.0, -120.0);
			grid.moveTo(-126.0, 120.0);
			grid.lineTo(-126.0, -120.0);
			grid.moveTo(-76.0, 120.0);
			grid.lineTo(-76.0, -120.0);
			grid.moveTo(-26.0, 120.0);
			grid.lineTo(-26.0, -120.0);
			grid.moveTo(24.0, 120.0);
			grid.lineTo(24.0, -120.0);
			grid.moveTo(64.0, 120.0);
			grid.lineTo(64, -120.0);
			grid.moveTo(104.0, 120.0);
			grid.lineTo(104, -120.0);
			grid.moveTo(144.0, 120.0);
			grid.lineTo(144, -120.0);
			grid.moveTo(174.0, 120.0);
			grid.lineTo(174, -120.0);
			grid.moveTo(214, 120.0);
		    grid.lineTo(214, -120.0);
			grid.moveTo(244, 120.0);
			grid.lineTo(244, -120.0);
			grid.moveTo(274, 120.0);
			grid.lineTo(274, -120.0);
			grid.moveTo(304, 120.0);
			grid.lineTo(304, -120.0);
			grid.moveTo(324, 120.0);
			grid.lineTo(324, -120.0);
			grid.moveTo(344, 120.0);
			grid.lineTo(344, -120.0);
			grid.moveTo(364, 120.0);
			grid.lineTo(364, -120.0);
			grid.moveTo(384, 120.0);
			grid.lineTo(384, -120.0);
			grid.moveTo(404.0, 120.0);
			grid.lineTo(404, -120.0);
			grid.moveTo(414.0, 120.0);
			grid.lineTo(414, -120.0);
			at.setToIdentity();
			s = at.createTransformedShape(grid);
			g2d.setStroke(STROKE_1);
			g2d.setPaint(Color.BLACK);
			g2d.draw(s);
			
			Ellipse2D dot1 = new Ellipse2D.Double(
					-269.0,
					-4.0,
					8.0,
					8.0
					);
					g2d.fill(dot1);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot1);
			Ellipse2D dot2 = new Ellipse2D.Double(
					-159.0,
					-4.0,
					8.0,
					8.0
					);
					g2d.fill(dot2);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot2);
			Ellipse2D dot3 = new Ellipse2D.Double(
					-54.0,
					-4.0,
					8.0,
					8.0
					);
					g2d.fill(dot3);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot3);
			Ellipse2D dot4 = new Ellipse2D.Double(
					40.0,
					-4.0,
					8.0,
					8.0
					);
					g2d.fill(dot4);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot4);
			Ellipse2D dot5 = new Ellipse2D.Double(
					154.0,
					76.0,
					8.0,
					8.0
					);
					g2d.fill(dot5);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot5);
			Ellipse2D dot6 = new Ellipse2D.Double(
					154.0,
					-44.0,
					8.0,
					8.0
					);
					g2d.fill(dot6);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot6);
			Ellipse2D dot7 = new Ellipse2D.Double(
					154.0,
					36.0,
					8.0,
					8.0
					);
					g2d.fill(dot7);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot7);
			Ellipse2D dot8 = new Ellipse2D.Double(
					154.0,
					-84.0,
					8.0,
					8.0
					);
					g2d.fill(dot8);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot8);
			Ellipse2D dot9 = new Ellipse2D.Double(
					254.0,
					-4.0,
					8.0,
					8.0
					);
					g2d.fill(dot9);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot9);
			Ellipse2D dot10 = new Ellipse2D.Double(
					310.0,
					-4.0,
					8.0,
					8.0
					);
					g2d.fill(dot10);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot10);
			Ellipse2D dot11 = new Ellipse2D.Double(
					350.0,
					-4.0,
					8.0,
					8.0
					);
					g2d.fill(dot11);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot11);
			Ellipse2D dot12 = new Ellipse2D.Double(
					390.0,
					-4.0,
					8.0,
					8.0
					);
					g2d.fill(dot12);
					g2d.setStroke(new BasicStroke(1.0f));
					g2d.setPaint(Color.BLACK);
					g2d.draw(dot12);
					Ellipse2D finger1= new Ellipse2D.Double(
							x1,
							y1,
							24.0,
							24.0
							);
							g2d.setStroke(new BasicStroke(1.0f));
							g2d.setPaint(Color.RED);
							g2d.fill(finger1);
							g2d.setPaint(Color.BLACK);
							g2d.draw(finger1);
					Ellipse2D finger2= new Ellipse2D.Double(
							x2,
							y2,
							24.0,
							24.0
							);
							g2d.setStroke(new BasicStroke(1.0f));
							g2d.setPaint(Color.RED);
							g2d.fill(finger2);
							g2d.setPaint(Color.BLACK);
							g2d.draw(finger2);
					Ellipse2D finger3= new Ellipse2D.Double(
							x3,
							y3,
							24.0,
							24.0
							);
							g2d.setStroke(new BasicStroke(1.0f));
							g2d.setPaint(Color.RED);
							g2d.fill(finger3);
							g2d.setPaint(Color.BLACK);
							g2d.draw(finger3);
					Ellipse2D finger4= new Ellipse2D.Double(
							x4,
							y4,
							24.0,
							24.0
							);
							g2d.setStroke(new BasicStroke(1.0f));
							g2d.setPaint(Color.RED);
							g2d.fill(finger4);
							g2d.setPaint(Color.BLACK);
							g2d.draw(finger4);
							
							
				g2d.dispose();
			}
			public void getFingerings(int n) {
				if(n == 1) { 	//A
					x1 = -340;
					y1 = 90;
					x2 = -340;
					y2 = 50;
					x3 = -340;
					y3 = 10;
					x4 = -1000;
					y4 = -30;
					repaint();
				}
				if(n == 2) {	//C
					x1 = -398;
					y1 = 50;
					x2 = -398;
					y2 = 50;
					x3 = -340;
					y3 = -30;
					x4 = -280;
					y4 = -70;
					repaint();
				}
				if(n == 3) {  //D
					repaint();
				}
			}
		}
