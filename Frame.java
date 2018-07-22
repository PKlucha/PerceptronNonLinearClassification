import java.awt.GridLayout;
import javax.swing.JFrame;

public class Frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Frame(int width, int height) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width + 15, height + 39);
		setResizable(false);
		setTitle("Perceptron prosty");
		setLocationRelativeTo(null);
	}
	public void init() {
		setLayout(new GridLayout(1, 1, 0, 0));
		
		setVisible(true);
	}
}
