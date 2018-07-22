import java.util.Random;

public class Point {

	public float x;
	public float y;
	public int class_real;
	public int class_guessed;
	
	Point(float x0, float x1, float y0, float y1) {
		// Randomly generated coordinates
		Random rnd = new Random();
		x = rnd.nextFloat() * (x1 - x0) + x0;
		y = rnd.nextFloat() * (y1 - y0) + y0;
		
		class_guessed = 0;
		if(Math.abs(Math.sin(x)) > Math.abs(y)) {
			class_real = 1;
		} else {
			class_real = -1;
		}
	}
}
