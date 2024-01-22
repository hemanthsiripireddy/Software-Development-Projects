package myTest;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import api.AIEngine;
import api.GameEngine;
import api.RuleEngine;
import boards.TicTacToeBoard;
import game.Board;
import game.GameState;
import game.Move;
import game.Player;

public class GamePlayTest {
	GameEngine game;
	AIEngine aiEngine;
	RuleEngine ruleEngine;

	@Before
	public void setUp() {
		game = new GameEngine();
		aiEngine = new AIEngine();
		ruleEngine = new RuleEngine();

	}

	public GameState runTest(int[][] moves) {
		Board board = game.start("TicTacToe");
		Scanner sc = new Scanner(System.in);
		int turn = 0;
		Player hemanth = new Player("hemanth", "X");
		Player computer = new Player("Competer", "C");
		int next = 0;

		while (next < 3 && !ruleEngine.getState(board).isOver()) {
			board = (TicTacToeBoard) board;

			if (turn % 2 == 0) {
				System.out.println(board.toString());
				System.out.println("Enter your move");
				int row = moves[next][0];
				int col = moves[next][1];
				Move myMove = new Move(row, col, hemanth);
				next++;

				game.move(board, myMove);
			} else {
				System.out.println("Compter Move is");

				Move myMove = aiEngine.suggestMove(board, computer);
				System.out.println(board.toString());
				game.move(board, myMove);

			}
			turn++;

		}
		// board=(TicTacToeBoard)board;
		// System.out.println(board.toString());
		return ruleEngine.getState(board);
	}

	@Test
	public void checkForRowWin() {
		int[][] moves = { { 0, 0 }, { 0, 1 }, { 0, 2 } };
		GameState out = runTest(moves);

		Assert.assertTrue(out.isOver());
		Assert.assertTrue(out.getWinner().getId().equals("X"));

	}

	@Test
	public void checkForColWin() {
		int[][] moves = { { 0, 0 }, { 1, 0 }, { 2, 0 } };

		GameState out = runTest(moves);
		Assert.assertTrue(out.isOver());
		Assert.assertTrue(out.getWinner().getId().equals("X"));

	}

	@Test
	public void checkForDiaWin() {
		int[][] moves = { { 0, 0 }, { 1, 1 }, { 2, 2 } };

		GameState out = runTest(moves);
		Assert.assertTrue(out.isOver());
		Assert.assertTrue(out.getWinner().getId().equals("X"));

	}

	@Test
	public void checkForRevDiaWin() {
		int[][] moves = { { 0, 2 }, { 1, 1 }, { 2, 0 } };

		GameState out = runTest(moves);
		Assert.assertTrue(out.isOver());
		Assert.assertTrue(out.getWinner().getId().equals("X"));

	}

}
