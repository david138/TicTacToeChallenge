package ticTacToe;

public class TicTacToeBoard implements Board {

	private GamePiece[] board;
	
	public TicTacToeBoard() {
		this.board = new TicTacToeGamePiece[9];
		this.resetGame();
	}
	@Override
	public void drawBoard() {
		System.out.printf(
		    "%s | %s | %s \n" +
	        "---------    \n" +
			"%s | %s | %s \n" +
	        "---------    \n" +
			"%s | %s | %s \n", 
			board[0].getSymbol(), board[1].getSymbol(), board[2].getSymbol(),
			board[3].getSymbol(), board[4].getSymbol(), board[5].getSymbol(),
			board[6].getSymbol(), board[7].getSymbol(), board[8].getSymbol());	
	}

	@Override
	public boolean isGameOver() {
		for (int i = 0; i < 9; i++) {
			if (board[i] == TicTacToeGamePiece.EMPTY) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void resetGame() {
		for (int i = 0; i < 9; i++) {
			board[i] = TicTacToeGamePiece.EMPTY;
		}
	}

	@Override
	public boolean playMove(int m, GamePiece p) {
		if (board[m] != TicTacToeGamePiece.EMPTY) {
			return false;
		}
		board[m] = p;
		return true;
	}
	@Override
	public boolean hasWon(GamePiece p) {
		//horizontal
		for (int i = 0; i < 9; i += 3) {
			if (board[i] == p && board[i + 1] == p && board[i + 2] == p) {
				return true;
			}
		}
		//vertical
		for (int i = 0; i < 3; i += 1) {
			if (board[i] == p && board[i + 3] == p && board[i + 6] == p) {
				return true;
			}
		}
		
		//diagonal
		if ((board[0] == p && board[4] == p && board[8] == p) &&
	        (board[0] == p && board[4] == p && board[8] == p)) {
			return true;
		}
		return false;
	}

}
