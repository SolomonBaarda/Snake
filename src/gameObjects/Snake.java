package gameObjects;

import java.util.LinkedList;

import main.Cell;
import main.CellType;
import main.Direction;

public class Snake {

	private LinkedList<Cell> snakeBody;
	private Cell head;

	private Direction currentDirection;

	public Snake(Cell startingPosition) {
		snakeBody = new LinkedList<Cell>();

		// Set snake to be this position
		moveAndGrow(startingPosition);

		// Set direction to none by default
		currentDirection = Direction.None;
	}



	/**
	 * Method that checks if a move is valid. Fails if the 
	 * Snake eats its' self.
	 * @param 	destination
	 * @return	true if valid move
	 */
	public boolean validMove(Cell destination) {
		// Check through all cells in the snake body
		for(Cell cell: snakeBody) {
			if(cell == destination) {
				// Snake has eaten it's self
				return false;
			}
		}
		return true;
	}

	
	/**
	 * @param destination
	 */
	public void moveAndGrow(Cell destination) {
		if(validMove(destination)) {
			head = destination;
			head.setContent(CellType.Snake);
			snakeBody.addFirst(head);
		}
	}

	
	/**
	 * @param destination
	 */
	public void moveWithoutGrow(Cell destination) {
		moveAndGrow(destination);

		Cell tail = snakeBody.removeLast();
		tail.setContent(CellType.Empty);
	}



	public Cell getHead() {
		return head;
	}


	public LinkedList<Cell> getSnakeBody() {
		return snakeBody;
	}


	public Direction getCurrentDirection() {
		return currentDirection;
	}


	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}







}
