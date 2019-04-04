package ticTacToe;

public interface Board {
	
	public void drawBoard();
	public boolean isGameOver();
	public void resetGame();
	public boolean playMove(int m, GamePiece p);
	public boolean hasWon(GamePiece p);
	
}
