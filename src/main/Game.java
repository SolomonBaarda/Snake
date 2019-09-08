package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import controller.Controller;
import display.Display;
import display.Renderer;
import gameObjects.Snake;
import utils.Point;

public class Game implements Runnable {

	public static final Point DEFAULT_BOARD_SIZE = new Point(24, 24);
	public static final int DEFAULT_CELL_SIZE = 32; // Pixels
	public static final Point DEFAULT_DISPLAY_SIZE = new Point(DEFAULT_BOARD_SIZE.x * DEFAULT_CELL_SIZE, DEFAULT_BOARD_SIZE.y * DEFAULT_CELL_SIZE);

	private Snake snake;
	private Board board;
	private Controller controller;
	private Display display;

	private Renderer renderer;
	private boolean gameOver;

	public Game() {
		board = new Board(DEFAULT_BOARD_SIZE);
		board.generateFood(board.getBoardSize());
		
		snake = new Snake(board.getCell(board.CENTRE_OF_CANVAS.x-1, board.CENTRE_OF_CANVAS.y));
		snake.moveAndGrow(board.getCell(board.CENTRE_OF_CANVAS.x, board.CENTRE_OF_CANVAS.y));
		snake.moveAndGrow(board.getCell(board.CENTRE_OF_CANVAS.x+1, board.CENTRE_OF_CANVAS.y));

		controller = new Controller(snake);
		display = new Display(DEFAULT_DISPLAY_SIZE);
		display.getCanvas().addKeyListener(controller);

		renderer = new Renderer(board, DEFAULT_CELL_SIZE, snake);

		//board.printBoard();
	}


	public void update() {
		if(!gameOver) {

			if(snake.getCurrentDirection() != Direction.None) {
				// Get reference to next cell
				Cell nextCell = board.getAdjacentCell(snake.getHead(), snake.getCurrentDirection());
				
				// Check for valid move
				if(snake.validMove(nextCell)) {
					// Eat food (move and grow)
					if(nextCell.getContent() == CellType.Food) {
						snake.moveAndGrow(nextCell);
						board.generateFood(board.getBoardSize());
					}
					// Move (move without grow)
					else {
						snake.moveWithoutGrow(nextCell);
						//snake.moveAndGrow(nextCell);
					}
				}
				// Not valid move
				else {
					snake.setCurrentDirection(Direction.None);
					gameOver = true;
					System.out.println();
					System.out.println("-------------------------");
					System.out.println("Game over. :(");
					System.out.println("You ate yourself!");
					int snakeLength = snake.getSnakeBody().size();
					System.out.println("Your length was " +snakeLength+ ".");
					int totalCells = board.getBoardSize().x * board.getBoardSize().y;
					float score = (snakeLength / totalCells) * 100f;
					System.out.println("You scored: " +score+ "%");
					System.out.println("-------------------------");
					System.out.println();
				}
			}
		}
		//System.out.println("Update complete");
	}



	public void render() {
		BufferStrategy bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			// Create 3 buffers for the game.
			display.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		renderer.render(g);

		g.dispose();
		bs.show();

		//System.out.println("Render complete");
	}




	@Override
	public void run() {
		long lastTime = System.nanoTime(); //long 2^63
		double nanoSecondConversion = 1000000000.0 / 8; // 8 ticks per second
		double changeInSeconds = 0;

		while(!gameOver) {
			long now = System.nanoTime();

			changeInSeconds += (now - lastTime) / nanoSecondConversion;
			while(changeInSeconds >= 1) {
				// Update both at the same time
				update();
				render();
				changeInSeconds--;
			}
			// Update graphics here for best rendering 
			//render();

			lastTime = now;
		}
	}



	public static void main(String[] args) {
		Game g = new Game();
		g.run();
	}
}
