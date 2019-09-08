package main;

public class Cell {
	private CellType content;
	private int row, col;	
	
	
	public Cell(int row, int col) {
		content = CellType.Empty;
		this.row = row;
		this.col = col;
	}

	
	
	
	
	

	@Override
	public String toString() {
		return "Cell(" +row+ "," +col+ ") [content: " +content+ "]";
	}







	public CellType getContent() {
		return content;
	}


	public void setContent(CellType content) {
		this.content = content;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}
	
	
	
	
}

