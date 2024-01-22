package api;

import boards.TicTacToeBoard;
import game.Board;

import game.GameState;
import game.Move;
import game.Player;

public class GameEngine {
	public Board start(String game) {
		if (game.equals("TicTacToe")) {
			return new TicTacToeBoard();

		} else {
			return null;
		}
	}

	public void move(Board board, Move move) {
		if (board instanceof TicTacToeBoard) {
			board.move(move);

		} else
			return;

	}

	
}