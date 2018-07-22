public class Main {

	public static void main(String[] args) {
		// Config

		int numOfPoints = 200000;
		int numOfEDimensions = 60;
		int iterations = 100000;
		
		int width = 628 * 2;
		int height = 300 * 2;
		
		// ------------------------------------------------------------- //
		
		Point[] points = new Point[numOfPoints];
		for(int i = 0; i < numOfPoints; i++) {
			points[i] = new Point(0, (float)(2 * Math.PI), -1, 1);
		}

		Frame frame = new Frame(width, height);
		Screen screen = new Screen(width, height, points, numOfPoints);
		frame.add(screen);
		frame.init();
		
		System.out.print("Centra:\n");
		
		Point[] centers = new Point[numOfEDimensions];
		for(int i = 0; i < numOfEDimensions; i++) {
			centers[i] = new Point(0, (float)(2 * Math.PI), -1, 1);
			System.out.print("(" + centers[i].x + "," + centers[i].y + ")\n");
		}
		
		ExtendedPoint[] extendedPoints = new ExtendedPoint[numOfPoints];
		for(int i = 0; i < numOfPoints; i++) {
			extendedPoints[i] = new ExtendedPoint(points[i], numOfEDimensions, centers);
		}
		
		Perceptron brain = new Perceptron(numOfEDimensions + 2);
		
		// Main training loop
		for(int i = 0; i < iterations; i++) {
			float[] guessed = new float[numOfPoints];
			
			System.out.print("Iteration " + (i + 1) + " ");
			guessed = brain.train(extendedPoints, numOfPoints);
			
			screen.updateGuess(guessed);
			screen.repaint();
		}
	}
}
