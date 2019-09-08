package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameObjects.Snake;
import main.Direction;

public class Controller implements KeyListener {
	private Snake snake;

	public Controller(Snake snake) {
		this.snake = snake;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
			snake.setCurrentDirection(Direction.North);
		}
		if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
			snake.setCurrentDirection(Direction.East);
		}
		if(key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
			snake.setCurrentDirection(Direction.South);
		}
		if(key == KeyEvent.VK_A  || key == KeyEvent.VK_LEFT) {
			snake.setCurrentDirection(Direction.West);
		}

	}





	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}



}
