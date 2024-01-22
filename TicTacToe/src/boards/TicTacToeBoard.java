package boards;

import game.Board;
import game.Cell;
import game.Move;

public class TicTacToeBoard extends Board {
	public Cell[][] cells;

	public TicTacToeBoard() {
		
		this.cells = new Cell[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cells[i][j]=new Cell(null);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(cells[i][j].getPalyer()==null) {
					sb.append("- ");
				}else {
					sb.append(cells[i][j].getPalyer().getId()+" ");
					
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public void move(Move move) {
		// TODO Auto-generated method stub
		int col=move.getCol();
		int row=move.getRow();
		cells[row][col].setPalyer(move.getPlayer());
		
	}
	
	

}