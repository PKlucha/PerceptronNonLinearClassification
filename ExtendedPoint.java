public class ExtendedPoint {
	
	float sigma = 1.5f; // BEST: 1.5f (for what i know)
	
	int numOfEDimensions;
	
	public int class_real;
	public int class_guessed;
	float[] extendedDimensions;
	
	public ExtendedPoint(Point _parent, int _numOfEDimensions, Point[] centers) {
		numOfEDimensions = _numOfEDimensions;
		class_real = _parent.class_real;
		
		extendedDimensions = new float[numOfEDimensions + 2];
		
		extendedDimensions[0] = _parent.x;
		extendedDimensions[1] = _parent.y;
		for(int i = 2; i < numOfEDimensions + 2; i++) {
			extendedDimensions[i] = (float)Math.exp(-1 * (((extendedDimensions[0] - centers[i - 2].x)*(extendedDimensions[0] - centers[i - 2].x) 
					+ (extendedDimensions[1] - centers[i - 2].y)*(extendedDimensions[1] - centers[i - 2].y)) / 2 * sigma*sigma));
			
		}
	}
}
