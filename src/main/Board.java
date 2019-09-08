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

		// Create board size
		board = new Cell[boardSize.x][boardSize.y];
		
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
	public Cell getNextCell(Cell currentCell, Direction direction) {
		if(direction != Direction.None) {
			int newRow = currentCell.getRow();
			int newCol = currentCell.getCol();
			
			if(direction == Direction.North) {
				newRow--;
			}
			else if(direction == Direction.East) {
				newCol++;
			}
			else if(direction == Direction.South) {
				newRow++;
			}
			else if(direction == Direction.West) {
				newCol--;
			}
			
			// Allow wrap around the screen
			if(newRow >= boardSize.y) {
				newRow = 0;
			}
			else if(newRow < 0) {
				newRow = boardSize.y;
			}
			
			if(newCol >= boardSize.x) {
				newCol = 0;
			}
			else if(newCol < 0) {
				newCol = boardSize.x;
			}
				
			return board[newRow][newCol];
		}
		else {
			return null;
		}
	}
	
	public void printBoard() {
		System.out.println("Canvas size: "+ boardSize.x +" x "+ boardSize.y);
		
		for(int row = 0; row < boardSize.y; row++) {
			for(int column = 0; column < boardSize.x; column++) {
				System.out.print(board[column][row].getContent() +" ");
			}
			System.out.println();
		}
		
	}
	
	
	public void generateFood(Point boardBoundries) {
		
		int newRow = (int) (Math.random() * boardBoundries.y);
		int newCol = (int) (Math.random() * boardBoundries.x);
		
		board[newCol][newRow].setContent(CellType.Food);
		System.out.println("Cell "+ newCol +","+ newRow +" set as food.");
	}

	public Point getBoardSize() {
		return boardSize;
	}

	public Cell getCell(int col, int row) {
		return board[row][col];
	}

	public Cell[][] getBoard() {
		return board;
	}

	
	
	
}
