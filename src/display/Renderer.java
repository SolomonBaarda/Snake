package display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import gameObjects.Snake;
import main.Board;
import main.Cell;
import main.CellType;
import main.Direction;
import utils.Point;

public class Renderer {

	private Board board;
	private int cellSize;
	private Snake snake;

	public Renderer(Board board, int cellSize, Snake snake) {
		this.board = board;
		this.cellSize = cellSize;
		this.snake = snake;
	}


	public void render(Graphics g) {
		for(int row = 0; row < board.getBoardSize().y; row++)
			for(int col = 0; col < board.getBoardSize().x; col++) {

				Cell currentCell  = board.getCell(col, row);

				// Draw all cell backgrounds as black
				g.setColor(Color.black);
				g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
				g.setColor(Color.darkGray);
				g.drawRect(col * cellSize, row * cellSize, cellSize-1, cellSize-1);

				if(currentCell.getContent() == CellType.Empty) {
					// Nothing special for here
				}
				else if(currentCell.getContent() == CellType.Snake) {
					g.setColor(Color.green);
					g.fillRoundRect(col * cellSize, row * cellSize, cellSize, cellSize, cellSize/2, cellSize/2);

					if(currentCell == snake.getHead()) {

						Point eyeOneOffset = new Point();
						Point eyeTwoOffset = new Point();
						int eyeThicknessWhite = cellSize / 4;
						int eyeThicknessBlack = cellSize / 8;

						if(snake.getCurrentDirection() == Direction.North) {
							eyeOneOffset.x = eyeThicknessBlack;
							eyeOneOffset.y = eyeThicknessBlack;
							eyeTwoOffset.x = cellSize - eyeThicknessWhite - eyeThicknessBlack;
							eyeTwoOffset.y = eyeThicknessBlack;
						}
						else if(snake.getCurrentDirection() == Direction.East || snake.getCurrentDirection() == Direction.None) {
							eyeOneOffset.x = cellSize - eyeThicknessWhite - eyeThicknessBlack;
							eyeOneOffset.y = eyeThicknessBlack;
							eyeTwoOffset.x = cellSize - eyeThicknessWhite - eyeThicknessBlack;
							eyeTwoOffset.y = cellSize - eyeThicknessWhite - eyeThicknessBlack;
						}
						else if(snake.getCurrentDirection() == Direction.South) {
							eyeOneOffset.x = eyeThicknessBlack;
							eyeOneOffset.y = cellSize - eyeThicknessWhite - eyeThicknessBlack;
							eyeTwoOffset.x = cellSize - eyeThicknessWhite - eyeThicknessBlack;
							eyeTwoOffset.y = cellSize - eyeThicknessWhite - eyeThicknessBlack;
						}
						else if(snake.getCurrentDirection() == Direction.West) {
							eyeOneOffset.x = eyeThicknessBlack;
							eyeOneOffset.y = eyeThicknessBlack;
							eyeTwoOffset.x = eyeThicknessBlack;
							eyeTwoOffset.y = cellSize - eyeThicknessWhite - eyeThicknessBlack;
						}

						g.setColor(Color.white);
						g.fillOval(col * cellSize + eyeOneOffset.x, row * cellSize + eyeOneOffset.y, eyeThicknessWhite, eyeThicknessWhite);
						g.fillOval(col * cellSize + eyeTwoOffset.x, row * cellSize + eyeTwoOffset.y, eyeThicknessWhite, eyeThicknessWhite);

						g.setColor(Color.black);
						g.fillOval(col * cellSize + eyeOneOffset.x + eyeThicknessBlack/2, row * cellSize + eyeOneOffset.y + eyeThicknessBlack/2, eyeThicknessBlack, eyeThicknessBlack);
						g.fillOval(col * cellSize + eyeTwoOffset.x + eyeThicknessBlack/2, row * cellSize + eyeTwoOffset.y + eyeThicknessBlack/2, eyeThicknessBlack, eyeThicknessBlack);

					}


				}
				else if(currentCell.getContent() == CellType.Food) {
					g.setColor(Color.red);
					g.fillOval(col * cellSize, row * cellSize, cellSize, cellSize);
				}

			}
	}

}
