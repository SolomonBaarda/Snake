package display;

import java.awt.Canvas;

import javax.swing.JFrame;

import utils.Point;


public class Display extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Canvas canvas = new Canvas();

	public Display(Point p) {
		this(p.x, p.y);
	}

	public Display(int displayWidth, int displayHeight) {
		//Make our program shutdown when we exit out.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Snake");

		// Set the size of the canvas
		canvas.setBounds(0, 0, displayWidth, displayHeight);

		//Add our graphics component
		add(canvas);

		pack();

		//Put our frame in the centre of the screen.
		setLocationRelativeTo(null);

		//Make our frame visible.
		setVisible(true);

		//Create our object for buffer strategy.
		canvas.createBufferStrategy(3);

		canvas.requestFocus();
	}

	public Canvas getCanvas() {
		return canvas;
	}


	

}
