package api;

import boards.TicTacToeBoard;
import game.Board;
import game.Move;
import game.Player;

public class AIEngine {
	public static Move suggestMove(Board board,Player player) {
		TicTacToeBoard t=(TicTacToeBoard)board;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(t.cells[i][j].getPalyer()==null)
					return new Move(i,j,player);
			}
		}
		return null;
		
	}

}
