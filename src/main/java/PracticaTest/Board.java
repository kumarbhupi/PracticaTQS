package PracticaTest;

import java.util.ArrayList;
import java.util.Random;

public class Board {

	private Square[][] boardMatrix;
	int mineNum;
	int remaining;
	
	Board() {
		boardMatrix = new Square[14][18];
		this.clearBoard();
		
		this.mineNum = 40;
		
		this.remaining = this.getLengthX() * this.getLengthY() - mineNum;
		
	}
	////////////FOR TESTING PURPOSES////////////  
	Board(boolean[][] inputMat) {
		
		try {
			boardMatrix = new Square[inputMat.length][inputMat[0].length];
			this.generateFromBoolMatrix(inputMat);
		} catch(Exception e) {
			System.out.println("ERROR: Null input at Board(boolean[][] inputMat)");
			System.out.println(e);
	    }
		
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
				
				if (inputMat[i][j]) {
					boardMatrix[i][j].setMine();
					mineNum++;
				}
			}
		}
		
		this.remaining = this.getLengthX() * this.getLengthY() - mineNum;
		
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
			int aux = this.remaining;
			uncoverNeighbours(x, y);
			
			return aux - this.remaining;

		}
	}

	private void uncoverNeighboursCore(int contextualX, int contextualY) {
		
		int posState = boardMatrix[contextualY][contextualX].getState();

		if (!boardMatrix[contextualY][contextualX].isMine() && (posState==-2 || posState==0) && boardMatrix[contextualY][contextualX].getAdjacentMines()==0) {
			uncoverNeighbours(contextualX, contextualY);
		} else if (!boardMatrix[contextualY][contextualX].getExplored()) {
			this.remaining--;
			boardMatrix[contextualY][contextualX].setState(boardMatrix[contextualY][contextualX].getAdjacentMines());
			boardMatrix[contextualY][contextualX].setExplored();
		}
	}
	
	private void uncoverNeighbours(int x, int y) {
		
		int contextualX, contextualY;

		if (boardMatrix[y][x].getState()==0 && !boardMatrix[y][x].getExplored()) {

			boardMatrix[y][x].setExplored();
			this.remaining--;
			
			if (boardMatrix[y][x].getAdjacentMines()==0) {

				boardMatrix[y][x].setState(-1);

				contextualX = x;
				contextualY = y-1;

				if (checkBounds(x, y, 0))
					uncoverNeighboursCore(contextualX, contextualY);

				contextualX = x-1;
				contextualY = y;

				if (checkBounds(x, y, 2))
					uncoverNeighboursCore(contextualX, contextualY);

				contextualX = x+1;
				contextualY = y;

				if (checkBounds(x, y, 3))
					uncoverNeighboursCore(contextualX, contextualY);

				contextualX = x;
				contextualY = y+1;

				if (checkBounds(x, y, 1))
					uncoverNeighboursCore(contextualX, contextualY);

				contextualX = x-1;
				contextualY = y-1;

				if (checkBounds(x, y, 0) && checkBounds(x, y, 2))
					uncoverNeighboursCore(contextualX, contextualY);

				contextualX = x+1;
				contextualY = y-1;

				if (checkBounds(x, y, 0) && checkBounds(x, y, 3))
					uncoverNeighboursCore(contextualX, contextualY);

				contextualX = x-1;
				contextualY = y+1;

				if (checkBounds(x, y, 1) && checkBounds(x, y, 2))
					uncoverNeighboursCore(contextualX, contextualY);

				contextualX = x+1;
				contextualY = y+1;

				if (checkBounds(x, y, 1) && checkBounds(x, y, 3))
					uncoverNeighboursCore(contextualX, contextualY);


			}
			else
				boardMatrix[y][x].setState(boardMatrix[y][x].getAdjacentMines());

		}

	}
	
	
	private boolean checkBounds(int x, int y, int dir) {
		
		
		if (x>=0 && x<getLengthX() && y>=0 && y<getLengthY()) {
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
				default:
					throw new IndexOutOfBoundsException("ERROR: dir variable must be between 0 & 3");
				}
				
		    } else {
		    	throw new IndexOutOfBoundsException("ERROR: coordinates out of bounds: " + x + ", " + y);
		    }
		
	}
	
	public void printMal() {
		
		for(int i=0; i < this.getLengthY();i++) {
			for(int j=0; j < this.getLengthX();j++) {
				System.out.print(" " + boardMatrix[i][j].isMine() + " |");
			}
			System.out.println();
		} 
		
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
		
			if (x>=0 && x<getLengthX() && y>=0 && y<getLengthY())
				return boardMatrix[y][x].getState();
			else
				throw new IndexOutOfBoundsException("ERROR: coordinates out of bounds: " + x + ", " + y);
	}
	
	public void setState(int x, int y, int state) {
		
		

			if (x>=0 && x<getLengthX() && y>=0 && y<getLengthY())
				boardMatrix[y][x].setState(state);
			else
				throw new IndexOutOfBoundsException("ERROR: coordinates out of bounds: " + x + ", " + y);
		
	}
	
	public boolean isMine(int x, int y) {
		
			if (x>=0 && x<getLengthX() && y>=0 && y<getLengthY()) {
				return boardMatrix[y][x].isMine();
			}else
				throw new IndexOutOfBoundsException("ERROR: coordinates out of bounds: " + x + ", " + y);
		
	}
	
	public int getLengthX() { 
		
		try {	
			return boardMatrix[0].length;
		}catch(Exception e) {
			//System.out.println("ERROR: Null input at the constructor");
			throw new IllegalArgumentException(e);
	    }
		 	
	}
	public int getLengthY() { 
		
		try {
			return boardMatrix.length;
		}catch(Exception e) {
	    	throw new IllegalArgumentException("ERROR: Null Matrix");
	    }
		
	}
	
	public Square[][] getMatrix() {
		
		try {	
			return boardMatrix;
		}catch(Exception e) {
	    	throw new IllegalArgumentException("ERROR: Null Matrix");
	    }
		
	}
	
	
	public void proxyClearBoard() { clearBoard();}
	public void proxyGenerateMineMap(int nMines) { generateMineMap(nMines);}	
	public boolean proxyCheckBounds (int x, int y, int dir) {return checkBounds(x, y, dir);}
	
	public int proxyGetAdjacentMines(int x, int y) { return getAdjacentMines(x, y);}
	
	
	
}