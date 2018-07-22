import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import javax.swing.JComponent;

public class Screen extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Point[] points;
	public float[] classes;
	public int numOfPoints;
	public int width;
	public int height;

	public Screen(int _width, int _height, Point[] _points, int _numOfPoints) {
		this.points = _points;
		this.numOfPoints = _numOfPoints;
		
		classes = new float[numOfPoints];
		for(int i = 0; i < numOfPoints; i++) {
			this.classes[i] = 0;
		}
		
		this.width = _width;
		this.height = _height;
	}
	
	public void updateGuess(float[] guessed) {
		this.classes = guessed;
	}
	
	public void paintComponent(Graphics g1) {
		Graphics2D g = (Graphics2D)g1;
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(0, height / 2, width, height / 2);
		
		g.setColor(Color.black);
		double x = 0;
		do {
			g.drawLine((int)(x * 200), (int)(Math.sin(x) * 300) + (height / 2), (int)(x * 200) + 1, (int)(Math.sin(x + 0.01) * 300) + (height / 2));
			g.drawLine((int)(x * 200), (int)(Math.sin(-x) * 300) + (height / 2), (int)(x * 200) + 1, (int)(Math.sin(-x - 0.01) * 300) + (height / 2));
			x += 0.01;
		} while(x < 2 * Math.PI);
		
		for(int i = 0; i < this.numOfPoints; i++) {
			if(classes[i] > 0) {
				g.setColor(Color.green);
			} else if(classes[i] < 0) {
				g.setColor(Color.blue);
			} else {
				g.setColor(Color.red);
			}
			
			g.fillRect((int)(points[i].x * 200), (int)(points[i].y * 300) + height/ 2, 3, 3);
		}
	}
}