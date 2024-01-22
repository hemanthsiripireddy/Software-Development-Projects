package api;

import boards.TicTacToeBoard;
import game.Board;

import game.GameState;
import game.Player;

public class RuleEngine {
	public GameState getState(Board board) {
		if (board instanceof TicTacToeBoard) {
			TicTacToeBoard t = (TicTacToeBoard) board;

			boolean gameOver = true;
			// row
			for (int i = 0; i < 3; i++) {
				gameOver = true;
				if (t.cells[i][0].getPalyer() == null) {
					gameOver = false;
					continue;
				}
				Player first = t.cells[i][0].getPalyer();

				for (int j = 1; j < 3; j++) {
					if (t.cells[i][j].getPalyer() == null || t.cells[i][j].getPalyer()!=(first)) {
						gameOver = false;
						break;
					}

				}
				if (gameOver) {
					return new GameState(gameOver, first);
				}
			}
			// col
			for (int i = 0; i < 3; i++) {
				gameOver = true;
				if (t.cells[0][i].getPalyer() == null) {
					gameOver = false;
					continue;
				}
				Player first = t.cells[0][i].getPalyer();

				for (int j = 1; j < 3; j++) {
					if (t.cells[j][i].getPalyer() == null ||  t.cells[j][i].getPalyer()!=(first)) {
						gameOver = false;
						break;
					}

				}
				if (gameOver) {
					return new GameState(gameOver, first);
				}
			}
			// diagonal
			gameOver = true;
			if (t.cells[0][0].getPalyer() == null) {
				gameOver = false;

			}
			if (gameOver) {
				Player first = t.cells[0][0].getPalyer();
				for (int i = 1; i < 3; i++) {
					if (t.cells[i][i] .getPalyer()== null ||  t.cells[i][i].getPalyer()!=(first)) {
						gameOver = false;
						break;
					}

				}
				if (gameOver) {
					return new GameState(gameOver, first);

				}
			}
			// opposite diagonal
			gameOver = true;
			if (t.cells[0][2].getPalyer() == null) {
				gameOver = false;

			}
			if (gameOver) {
				Player first = t.cells[0][2].getPalyer();
				for (int i = 1; i >= 0; i--) {
					if (t.cells[2 - i][i].getPalyer() == null || t.cells[2-i][i].getPalyer()!=(first)) {
						gameOver = false;
						break;
					}

				}
				if (gameOver) {
					return new GameState(gameOver, first);

				}
			}
			// is GameOver
			int count = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (t.cells[i][j].getPalyer() != null)
						count++;
				}
			}
			if (count == 9) {
				return new GameState(true, null);
			}
			return new GameState(false, null);

		} else
			return null;

	}

}
