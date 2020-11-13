package PracticaTest;



public class Board {

	private Square[][] boardMatrix;
	int mineNum;
	
	Board() {
		//boardMatrix = new Square[14][18];
		
	}
	
	private void clearBoard() {
		
	}
	
	private boolean generateMineMap(int nMines) {
		return false;
	}
	
	
	public int uncoverPosition(int x, int y) {
		
		return 0;// tal vez el número de casillas para luego usarlo en la puntuación?
	}
	
	private void uncoverNeighbours() {
		
		
	}
	
	public void setFlag(int x, int y) {
		
		 
	}
	
	public int getState(int x, int y) {
		
		return 0; 
	}
	
	public boolean isMine(int x, int y) {
		
		return false; 
	}
	
	public int getLengthX() { return boardMatrix[0].length; }
	public int getLengthY() { return boardMatrix.length; }
	
	public void proxyClearBoard() { clearBoard();}
	public boolean proxyGenerateMineMap(int nMines) { return generateMineMap(nMines);}	
	//public boolean proxyChangeMineSate() { return changeMineSate();}
	public int proxyUncoverPosition(int x, int y) { return uncoverPosition(x, y);}
	public void proxyUncoverNeighbours() { uncoverNeighbours();}	
	public void proxyToggleBanderaByPosition(int x, int y) { setFlag(x, y);}
	
	
}
