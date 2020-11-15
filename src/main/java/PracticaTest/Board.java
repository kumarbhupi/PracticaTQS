package PracticaTest;

import java.util.ArrayList;
import java.util.Random;

public class Board {

	private Square[][] boardMatrix;
	int mineNum;
	int remaining = 14 * 18 - 40;
	
	Board() {
		boardMatrix = new Square[14][18];
		this.clearBoard();
		
	}
	////////////FOR TESTING PURPOSES////////////  
	Board(boolean[][] inputMat) {
		boardMatrix = new Square[inputMat.length][inputMat[0].length];
		this.generateFromBoolMatrix(inputMat);
	}
	////////////////////////////////////////////
	
	private void clearBoard() {
		
		for(int i=0; i < this.getLengthY();i++) {
			for(int j=0; j < this.getLengthX();j++) {
				boardMatrix[i][j] = new Square();
				
			}
		}
		
	}

	public void generateMineMap(int nMines) {

		int upperboundX = this.getLengthX()-1;
		int upperboundY = this.getLengthY()-1;
		int xAxis;
		int yAxis;

		Random rand = new Random();

		int placedMines = 0;

		while(placedMines != nMines) {
			xAxis = rand.nextInt(upperboundX);
			yAxis = rand.nextInt(upperboundY);

			if (!isMine(xAxis, yAxis)) {
				boardMatrix[yAxis][xAxis].setMine();
				placedMines++;
			}
		}

		for(int i=0; i < this.getLengthY();i++) {
			for(int j=0; j < this.getLengthX();j++) {
				boardMatrix[i][j].setAdjacentMines((getAdjacentMines(j, i)));
			}
		}

	}

	private int getAdjacentMines(int x, int y) {

		int mineCounting = 0;

		if (checkBounds(x, y, 0))
			if (boardMatrix[y-1][x].isMine())
				mineCounting++;

		if (checkBounds(x, y, 2))
			if (boardMatrix[y][x-1].isMine())
				mineCounting++;

		if (checkBounds(x, y, 3))
			if (boardMatrix[y][x+1].isMine())
				mineCounting++;

		if (checkBounds(x, y, 1))
			if (boardMatrix[y+1][x].isMine())
				mineCounting++;

		if (checkBounds(x, y, 0) && checkBounds(x, y, 2))
			if (boardMatrix[y-1][x-1].isMine())
				mineCounting++;

		if (checkBounds(x, y, 0) && checkBounds(x, y, 3))
			if (boardMatrix[y-1][x+1].isMine())
				mineCounting++;

		if (checkBounds(x, y, 1) && checkBounds(x, y, 2))
			if (boardMatrix[y+1][x-1].isMine())
				mineCounting++;

		if (checkBounds(x, y, 1) && checkBounds(x, y, 3))
			if (boardMatrix[y+1][x+1].isMine())
				mineCounting++;


		return mineCounting;
	}


	////////////FOR TESTING PURPOSES//////////// 
	public void generateFromBoolMatrix(boolean[][] inputMat) {
		
		for(int i=0; i < this.getLengthY();i++) {
			for(int j=0; j < this.getLengthX();j++) {
				boardMatrix[i][j] = new Square();
				
				if (inputMat[i][j])
					boardMatrix[i][j].setMine();
				
			}
		}
		
		for(int i=0; i < this.getLengthY();i++) {
			for(int j=0; j < this.getLengthX();j++) {
				boardMatrix[i][j].setAdjacentMines((getAdjacentMines(j, i)));
			}
		}														 
	}
	////////////////////////////////////////////

	//si peta -1
	//si no peta, el numero de casillas que descubre
	public int uncoverPosition(int x, int y) {

		//ArrayList<int[]> checkedPos = new ArrayList<>();

		if(boardMatrix[y][x].isMine()) {
			boardMatrix[y][x].setState(-3);
			return -1;
		} else {
			//boardMatrix[y][x].setState(-1);
			uncoverNeighbours(x, y);

			return 1;
			//checkedPos.add(new int[] {x,y});
			//uncoverNeighbours(x, y);
		}
	}

	private void uncoverNeighbours(int x, int y) {

		int mineCounting = 0;
		int posState;
		int contextualX, contextualY;
		boolean isUpperCenterPossible 	= false;

		boolean isCenterLeftPossible 	= false;
		boolean isCenterRightPossible 	= false;

		boolean isLowerCenterPossible 	= false;


		if (boardMatrix[y][x].getState()==0 && !boardMatrix[y][x].getExplored()) {

			boardMatrix[y][x].setExplored();

			if (boardMatrix[y][x].getAdjacentMines()==0) {

				boardMatrix[y][x].setState(-1);

				contextualX = x;
				contextualY = y-1;

				if (checkBounds(x, y, 0)) {

					posState = boardMatrix[contextualY][contextualX].getState();

					if (boardMatrix[contextualY][contextualX].isMine())
						mineCounting++;
					else {

						if ((posState==-2 || posState==0) && boardMatrix[contextualY][contextualX].getAdjacentMines()==0) {
							isUpperCenterPossible = true;
							uncoverNeighbours(contextualX, contextualY);
						} else if (!boardMatrix[contextualY][contextualX].getExplored()) {
							boardMatrix[contextualY][contextualX].setState(boardMatrix[contextualY][contextualX].getAdjacentMines());
							boardMatrix[contextualY][contextualX].setExplored();
						}

					}

				}


				contextualX = x-1;
				contextualY = y;

				if (checkBounds(x, y, 2)) {

					posState = boardMatrix[contextualY][contextualX].getState();

					if (boardMatrix[contextualY][contextualX].isMine())
						mineCounting++;
					else {

						if ((posState==-2 || posState==0) && boardMatrix[contextualY][contextualX].getAdjacentMines()==0) {
							isUpperCenterPossible = true;
							uncoverNeighbours(contextualX, contextualY);
						} else if (!boardMatrix[contextualY][contextualX].getExplored()) {
							boardMatrix[contextualY][contextualX].setState(boardMatrix[contextualY][contextualX].getAdjacentMines());
							boardMatrix[contextualY][contextualX].setExplored();
						}

					}

				}

				contextualX = x+1;
				contextualY = y;

				if (checkBounds(x, y, 3)) {

					posState = boardMatrix[contextualY][contextualX].getState();

					if (boardMatrix[contextualY][contextualX].isMine())
						mineCounting++;
					else {

						if ((posState==-2 || posState==0) && boardMatrix[contextualY][contextualX].getAdjacentMines()==0) {
							isUpperCenterPossible = true;
							uncoverNeighbours(contextualX, contextualY);
						} else if (!boardMatrix[contextualY][contextualX].getExplored()) {
							boardMatrix[contextualY][contextualX].setState(boardMatrix[contextualY][contextualX].getAdjacentMines());
							boardMatrix[contextualY][contextualX].setExplored();
						}

					}

				}


				contextualX = x;
				contextualY = y+1;

				if (checkBounds(x, y, 1)) {

					posState = boardMatrix[contextualY][contextualX].getState();

					if (boardMatrix[contextualY][contextualX].isMine())
						mineCounting++;
					else {

						if ((posState==-2 || posState==0) && boardMatrix[contextualY][contextualX].getAdjacentMines()==0) {
							isUpperCenterPossible = true;
							uncoverNeighbours(contextualX, contextualY);
						} else if (!boardMatrix[contextualY][contextualX].getExplored()) {
							boardMatrix[contextualY][contextualX].setState(boardMatrix[contextualY][contextualX].getAdjacentMines());
							boardMatrix[contextualY][contextualX].setExplored();
						}

					}

				}

				contextualX = x-1;
				contextualY = y-1;

				if (checkBounds(x, y, 0) && checkBounds(x, y, 2)) {

					posState = boardMatrix[contextualY][contextualX].getState();

					if (boardMatrix[contextualY][contextualX].isMine())
						mineCounting++;
					else {

						if ((posState==-2 || posState==0) && boardMatrix[contextualY][contextualX].getAdjacentMines()==0) {
							isUpperCenterPossible = true;
							uncoverNeighbours(contextualX, contextualY);
						} else if (!boardMatrix[contextualY][contextualX].getExplored()) {
							boardMatrix[contextualY][contextualX].setState(boardMatrix[contextualY][contextualX].getAdjacentMines());
							boardMatrix[contextualY][contextualX].setExplored();
						}


					}

				}

				contextualX = x+1;
				contextualY = y-1;

				if (checkBounds(x, y, 0) && checkBounds(x, y, 3)) {

					posState = boardMatrix[contextualY][contextualX].getState();

					if (boardMatrix[contextualY][contextualX].isMine())
						mineCounting++;
					else {

						if ((posState==-2 || posState==0) && boardMatrix[contextualY][contextualX].getAdjacentMines()==0) {
							isUpperCenterPossible = true;
							uncoverNeighbours(contextualX, contextualY);
						} else if (!boardMatrix[contextualY][contextualX].getExplored()) {
							boardMatrix[contextualY][contextualX].setState(boardMatrix[contextualY][contextualX].getAdjacentMines());
							boardMatrix[contextualY][contextualX].setExplored();
						}

					}

				}



				contextualX = x-1;
				contextualY = y+1;

				if (checkBounds(x, y, 1) && checkBounds(x, y, 2)) {

					posState = boardMatrix[contextualY][contextualX].getState();

					if (boardMatrix[contextualY][contextualX].isMine())
						mineCounting++;
					else {

						if ((posState==-2 || posState==0) && boardMatrix[contextualY][contextualX].getAdjacentMines()==0) {
							isUpperCenterPossible = true;
							uncoverNeighbours(contextualX, contextualY);
						} else if (!boardMatrix[contextualY][contextualX].getExplored()) {
							boardMatrix[contextualY][contextualX].setState(boardMatrix[contextualY][contextualX].getAdjacentMines());
							boardMatrix[contextualY][contextualX].setExplored();
						}

					}

				}

				contextualX = x+1;
				contextualY = y+1;

				if (checkBounds(x, y, 1) && checkBounds(x, y, 3)) {

					posState = boardMatrix[contextualY][contextualX].getState();

					if (boardMatrix[contextualY][contextualX].isMine())
						mineCounting++;
					else {

						if ((posState==-2 || posState==0) && boardMatrix[contextualY][contextualX].getAdjacentMines()==0) {
							isUpperCenterPossible = true;
							uncoverNeighbours(contextualX, contextualY);
						} else if (!boardMatrix[contextualY][contextualX].getExplored()) {
							boardMatrix[contextualY][contextualX].setState(boardMatrix[contextualY][contextualX].getAdjacentMines());
							boardMatrix[contextualY][contextualX].setExplored();
						}

					}

				}

			}
			else
				boardMatrix[y][x].setState(boardMatrix[y][x].getAdjacentMines());

		}

	}
	
	
	private boolean checkBounds(int x, int y, int dir) {
		
		boolean checkUpBound 	= y>0;
		boolean checkDownBound 	= y<getLengthY()-1;
		boolean checkLeftBound 	= x>0; 
		boolean checkRightBound = x<getLengthX()-1;
		
		
		switch(dir) {
		case 0:
			return checkUpBound;
		case 1:
			return checkDownBound;
		case 2:
			return checkLeftBound;
		case 3:
			return checkRightBound;
		}
		
		return checkLeftBound && checkRightBound && checkUpBound && checkDownBound;
		
	}
	
	public boolean isAllUncovered() {
		
		return remaining == 0;
	}
	
	public boolean setFlag(int x, int y) {
		
		if(this.getState(x, y) == -2) {
			setState(x, y, 0);
			return false;
		} else {
			setState(x, y, -2);
			return true;
		}
		
		
	}
	
	public int getState(int x, int y) {
		
		return boardMatrix[y][x].getState();
	}
	
	public void setState(int x, int y, int state) {
		
		boardMatrix[y][x].setState(state);
	}
	
	public boolean isMine(int x, int y) {
		
		return boardMatrix[y][x].isMine(); 
	}
	
	public int getLengthX() { return boardMatrix[0].length; }
	public int getLengthY() { return boardMatrix.length; }
	
	public Square[][] getMatrix() {return boardMatrix;} 
	
	public void proxyClearBoard() { clearBoard();}
	public void proxyGenerateMineMap(int nMines) { generateMineMap(nMines);}	
	public int proxyUncoverPosition(int x, int y) { return uncoverPosition(x, y);}
	public boolean proxyCheckBounds (int x, int y, int dir) {return checkBounds(x, y, dir);}
	public void proxyToggleBanderaByPosition(int x, int y) { setFlag(x, y);}
	
	public int proxyGetAdjacentMines(int x, int y) { return getAdjacentMines(x, y);}
	
	
	
}