package game;

public class Move {
	  private int row, col;
	  private Player player;

	public Move(int row, int col,Player player) {
		super();
		this.row = row;
		this.col = col;
		this.player=player;
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	

}