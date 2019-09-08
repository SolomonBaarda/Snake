package main;

import utils.Point;

public class Board {

	private Cell[][] board;
	private Point boardSize;

	public final Point CENTRE_OF_CANVAS;

	public Board(Point p) {
		this(p.x, p.y);
	}

	public Board(int columnCount, int rowCount) {
		boardSize = new Point(columnCount, rowCount);
		CENTRE_OF_CANVAS = new Point(boardSize.x / 2, boardSize.y / 2);

		// Create new board
		board = new Cell[boardSize.x][boardSize.y];

		// Initialise each cell in the board
		for(int row = 0; row < boardSize.y; row++) 
			for(int col = 0; col < boardSize.x; col++) {
				board[col][row] = new Cell(col, row);
			}

	}


	/**
	 * Method that takes a cell and direction and returns the next cell in that direction.
	 * @param currentCell
	 * @param direction
	 * @return
	 */
	public Cell getAdjacentCell(Cell currentCell, Direction currentDirection) {
		if(currentDirection != Direction.None) {
			int newCol = currentCell.getCol();
			int newRow = currentCell.getRow();

			if(currentDirection == Direction.North) {
				newRow--;
			}
			if(currentDirection == Direction.East) {
				newCol++;
			}
			if(currentDirection == Direction.South) {
				newRow++;
			}
			if(currentDirection == Direction.West) {
				newCol--;
			}

			// Allow wrap around the screen
			if(newRow >= boardSize.y) {
				newRow = 0;
			}
			else if(newRow < 0) {
				newRow = boardSize.y-1;
			}

			if(newCol >= boardSize.x) {
				newCol = 0;
			}
			else if(newCol < 0) {
				newCol = boardSize.x-1;
			}

			return getCell(newCol, newRow);
		}
		else {
			return null;
		}
	}




	public void printBoard() {
		System.out.println("Canvas size: "+ boardSize.x +" x "+ boardSize.y);

		for(int row = 0; row < boardSize.y; row++) {
			for(int column = 0; column < boardSize.x; column++) {
				System.out.print(getCell(column, row).getContent() +" ");
			}
			System.out.println();
		}

	}


	public void generateFood(Point boardBoundries) {
		int newRow;
		int newCol;
		
		do {
			newRow = (int) (Math.random() * boardBoundries.y);
			newCol = (int) (Math.random() * boardBoundries.x);
		}
		while(getCell(newCol, newRow).getContent() == CellType.Snake);

		getCell(newCol, newRow).setContent(CellType.Food);
	}


	public Point getBoardSize() {
		return boardSize;
	}

	public Cell getCell(int col, int row) {
		return board[col][row];
	}

	public Cell[][] getBoard() {
		return board;
	}




}
