package ticTacToe;

import java.util.Scanner;

public class TicTacToeGame {
	
	Board board;
	private static TicTacToeGame game = null;
	
	private TicTacToeGame() {
		this.board = new TicTacToeBoard();
	}
	
	public static TicTacToeGame create() {
		if (TicTacToeGame.game == null) {
			TicTacToeGame.game = new TicTacToeGame();
		}
		return TicTacToeGame.game;
	}
	
	public void playMovePlayer(Scanner input) {
		System.out.println("Enter a Move (1-9)");
		int i = input.nextInt();
		while (!this.board.playMove(i - 1, TicTacToeGamePiece.X)) {
			System.out.println("Please try again");
			i = input.nextInt();
		}
	}
	
	public void playMoveVillain() {
		System.out.println("Villain Moves");
		int i = (int) (Math.random() * 9);
		while (!this.board.playMove(i, TicTacToeGamePiece.O)) {
			i = (int) (Math.random() * 9);
		}
	}
	
	public void startNewGame(Scanner input) {
		this.board.resetGame();
		this.board.drawBoard();
		while (!this.board.isGameOver()) {
			this.playMovePlayer(input);
			this.board.drawBoard();
			if (this.board.hasWon(TicTacToeGamePiece.X)) {
				System.out.println("You Won");
				return;
			}
			if (this.board.isGameOver()) {
				continue;
			}
			this.playMoveVillain();
			this.board.drawBoard();
			if (this.board.hasWon(TicTacToeGamePiece.O)) {
				System.out.println("You Lost");
				return;
			}
		}
		System.out.println("No More Moves Left");
	}
	
	public void start() {
		Scanner input = new Scanner(System.in);
		while (true) {
			this.startNewGame(input);
		}
	}
	

	public static void main(String[] args) {
		TicTacToeGame.create().start();
	}

}
