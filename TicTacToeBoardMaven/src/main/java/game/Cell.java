package game;

public class Cell {

	private Player palyer;

	public Cell() {
		super();
	}

	public Cell(Player palyer) {
		super();
		this.palyer = palyer;
	}

	public Player getPalyer() {
		return palyer;
	}

	public void setPalyer(Player palyer) {
		this.palyer = palyer;
	}

}
