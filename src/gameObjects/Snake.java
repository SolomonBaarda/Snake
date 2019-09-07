package gameObjects;

import java.util.LinkedList;

import main.Cell;
import main.CellType;
import main.Direction;

public class Snake extends GameObject {

	private LinkedList<Cell> snakeBody;
	private Cell head;
	
	private Direction currentDirection;

	public Snake(Cell pos) {
		snakeBody = new LinkedList<>();
		// Keep reference to the head cell
		head = pos;
		head.setContent(CellType.Snake);
		snakeBody.add(head);
		
		currentDirection = Direction.East;
	}


	public void incrementLength() {
		snakeBody.add(head);
	}


	public boolean validMove(Cell destination) {
		for(Cell cell: snakeBody) {
			if(cell == destination) {
				// Snake has eaten it's self
				return false;
			}
		}
		return true;
	}


	public void move(Cell destination) {
		head = destination;
		head.setContent(CellType.Snake);
		snakeBody.addFirst(head);

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
