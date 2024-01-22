package main;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.border.Border;

import api.AIEngine;
import api.GameEngine;
import api.RuleEngine;
import boards.TicTacToeBoard;
import game.Board;
import game.GameState;
import game.Move;
import game.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameEngine game=new GameEngine();
		AIEngine aiEngine=new AIEngine();
		RuleEngine ruleEngine=new RuleEngine();
		Board board=game.start("TicTacToe");
		Scanner sc=new Scanner(System.in);
		int turn=0;
		Player hemanth =new Player("hemanth", "X");
		Player computer =new Player("Competer", "C");
		while(!ruleEngine.getState(board).isOver()) {
			board=(TicTacToeBoard)board;
			
			if(turn%2==0) {
				System.out.println(board.toString());
				System.out.println("Enter your move");
				int row=sc.nextInt();
				int col=sc.nextInt();
				Move myMove=new Move(row,col,hemanth);
				
				game.move(board, myMove);
			}else {
				System.out.println("Compter Move is");
				
				Move myMove=aiEngine.suggestMove(board, computer);
				System.out.println(board.toString());
				game.move(board, myMove);
				
			}
			turn++;
			
		}
		board=(TicTacToeBoard)board;
		System.out.println(board.toString());
		GameState out=ruleEngine.getState(board);
		System.out.println(out.isOver()+" "+out.getWinner().getName());

	}
	

}








