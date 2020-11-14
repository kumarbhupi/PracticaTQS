package PracticaTest;


public class Board {

	private Square[][] boardMatrix;
	int mineNum;
	
	Board() {
		//boardMatrix = new Square[14][18];
		
	}
	////////////FOR TESTING PURPOSES//////////// 
	Board(boolean[][] inputMat) {
	
	}
	////////////////////////////////////////////
	
	private void clearBoard() {

		
	}
	
	private void generateMineMap(int nMines) {
		

		
	}
	
	//si peta -1
	//si no peta, el numero de casillas que descubre
	public int uncoverPosition(int x, int y) {
		
		return 0;// tal vez el número de casillas para luego usarlo en la puntuación?
	}
	
	private void uncoverNeighbours(int x, int y) {

	}
	
	public boolean setFlag(int x, int y) {
		
		 return false;//cuando hay bandera y vuelven a llamar a set bandera
	}
	
	public int getState(int x, int y) {
		
		return 0; 
	}
	
	public boolean isMine(int x, int y) {
		
		return boardMatrix[y][x].isMine(); 
	}
	
	public int getLengthX() { return boardMatrix[0].length; }
	public int getLengthY() { return boardMatrix.length; }
	
	public Square[][] getMatrix() {return boardMatrix;} 
	
	public void proxyClearBoard() { clearBoard();}
	public void proxyGenerateMineMap(int nMines) { generateMineMap(nMines);}	
	//public boolean proxyChangeMineSate() { return changeMineSate();}
	public int proxyUncoverPosition(int x, int y) { return uncoverPosition(x, y);}
	public void proxyUncoverNeighbours(int x, int y) { uncoverNeighbours(x, y);}	
	public void proxyToggleBanderaByPosition(int x, int y) { setFlag(x, y);}
	
	
}
