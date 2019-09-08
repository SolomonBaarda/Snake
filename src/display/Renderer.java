package display;

import java.awt.Color;
import java.awt.Graphics;

import main.Board;
import main.Cell;
import main.CellType;

public class Renderer {

	private Board board;
	private int cellSize;

	public Renderer(Board board, int cellSize) {
		this.board = board;
		this.cellSize = cellSize;
	}
	

	public void render(Graphics g) {
		for(int row = 0; row < board.getBoardSize().y; row++)
			for(int col = 0; col < board.getBoardSize().x; col++) {
				
				Cell currentCell  = board.getCell(col, row);
				
				if(currentCell.getContent() == CellType.Empty) {
					g.setColor(Color.black);
				}
				else if(currentCell.getContent() == CellType.Snake) {
					g.setColor(Color.green);
				}
				else if(currentCell.getContent() == CellType.Food) {
					g.setColor(Color.red);
				}
				
				g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
			}
	}

}
