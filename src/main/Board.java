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


//	/**
//	 * Adds GameObject to centre of canvas.
//	 * @param o
//	 */
//	public void addToCanvas(GameObject o) {
//		addToCanvas(o, CENTRE_OF_CANVAS);
//	}
//
//	/**
//	 * Adds GameObject to canvas at point p. 
//	 * @param o
//	 * @param p
//	 */
//	public void addToCanvas(GameObject object, Point p) {
//
//		// if snake
//		if(object instanceof Snake) {
//			int snakeSize = ((Snake)object).getLength();
//			
//			// Set head of snake
//			canvas[CENTRE_OF_CANVAS.x][CENTRE_OF_CANVAS.y].content = CellContent.SnakeHead;
//			// Set body of snake
//			for(int remainingLength = snakeSize - 2; remainingLength > 0; remainingLength--) {
//				canvas[CENTRE_OF_CANVAS.x - remainingLength][CENTRE_OF_CANVAS.y].content = CellContent.SnakeBody;
//			}
//			// Set tail of snake
//			canvas[CENTRE_OF_CANVAS.x - snakeSize + 1][CENTRE_OF_CANVAS.y].content = CellContent.SnakeTail;
//		}
//	}
//
//
//	public void render() {
//		for(int i = 0; i < canvasSize.x; i++)
//			for(int k = 0; k < canvasSize.y; k++) {
//
//			}
//	}
	
//	public void update() {
//		
//	}
	

	/**
	 * Method that takes a cell and direction and returns the next cell in that direction.
	 * @param currentCell
	 * @param direction
	 * @return
	 */
	public Cell getNextCell(Cell currentCell, Direction direction) {
		if(direction != Direction.None) {
			int row = currentCell.getRow();
			int col = currentCell.getCol();
			
			if(direction == Direction.North) {
				row--;
			}
			else if(direction == Direction.East) {
				col++;
			}
			else if(direction == Direction.South) {
				row++;
			}
			else if(direction == Direction.West) {
				col--;
			}
			
			// Allow wrap around the screen
			if(row >= boardSize.y) {
				row = 0;
			}
			else if(row < 0) {
				row = boardSize.y;
			}
			
			if(col >= boardSize.x) {
				col = 0;
			}
			else if(col < 0) {
				col = boardSize.x;
			}
				
			return board[col][row];
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
