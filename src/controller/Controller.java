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

		if(key == KeyEvent.VK_W) {
			snake.setCurrentDirection(Direction.North);
		}
		if(key == KeyEvent.VK_D) {
			snake.setCurrentDirection(Direction.East);
		}
		if(key == KeyEvent.VK_S) {
			snake.setCurrentDirection(Direction.South);
		}
		if(key == KeyEvent.VK_A) {
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
