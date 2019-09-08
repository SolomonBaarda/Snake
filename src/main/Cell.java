package main;

public class Cell {
	private CellType content;
	private int col, row;	


	public Cell(int col, int row) {
		content = CellType.Empty;
		this.col = col;
		this.row = row;
	}



	@Override
	public String toString() {
		return "Cell(" +col+ "," +row+ ") [content: " +content+ "]";
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

