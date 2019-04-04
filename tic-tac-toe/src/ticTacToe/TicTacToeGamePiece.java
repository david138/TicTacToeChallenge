package ticTacToe;

public enum TicTacToeGamePiece implements GamePiece {
	X("X"),
	O("O"),
	EMPTY(" ");
	
	private String symbol;
	TicTacToeGamePiece(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
}
