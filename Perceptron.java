import java.util.Random;

public class Perceptron {
	public float[] weights;	// Adding more weights as more inputs come -> if so better to also make an input array
	public int numOfWeights;
	
	public float step = 0.0001f;
	public float accError = 0.1f; // Acceptable error for guess
	
	public int errorRate;
	
	public Perceptron(int _numOfWeights) {
		errorRate = 0;
		
		numOfWeights = _numOfWeights;
		weights = new float[numOfWeights];
		
		Random rnd = new Random();
		for(int i = 0; i < numOfWeights; i++) {
			weights[i] = (rnd.nextFloat() * 2) - 1; // Random floats between -1 and 1
		}
	}
	
	public static float activationFunction(float sum) {
		return (float)Math.tanh(sum);
	}
	
	public float guess(ExtendedPoint point) {
		float sum = 0;
		for(int i = 0; i < numOfWeights; i++) {
			sum += weights[i] * point.extendedDimensions[i];
		}
		
		return activationFunction(sum);
	}
	
	public float[] train(ExtendedPoint[] points, int numOfPoints) {
		float[] guessed = new float[numOfPoints];
		this.errorRate = 0;
		
		for(int i = 0; i < numOfPoints; i++) {
			float guess = guess(points[i]);
			float error = points[i].class_real - guess;
			
			if(Math.signum(guess) != Math.signum(points[i].class_real)) {
				for(int j = 0; j < numOfWeights; j++) {
					this.weights[j] += error * this.step * points[i].extendedDimensions[j];
				}
				this.errorRate++;
			}
			guessed[i] = guess;
		}
		if(errorRate != 0) System.out.printf("Error = " + this.errorRate + " Succes Rate: %2.1f\n", ((float)(1 - (float)errorRate / (float)numOfPoints) * 100));
		else System.out.print("ErrorRate = " + this.errorRate + " Succes Rate: 100%!!!" + "\n");
		return guessed;
	}
}
