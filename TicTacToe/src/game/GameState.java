package game;


public class GameState {
	private boolean isOver;
	private Player winner;
	public boolean isOver() {
		return isOver;
	}
	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	public GameState(boolean isOver, Player winner) {
		super();
		this.isOver = isOver;
		this.winner = winner;
	}

	
	
	
	

}

