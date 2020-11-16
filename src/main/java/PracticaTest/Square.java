package PracticaTest;

public class Square {
	
	/*THIS IS THE SQUARE CLASS. 
	 * Here we control the status of each box individually.
	 * mine->[true or false] tells us if there is a mine. Default: no mine.
	 * state->[0 or -1 or -2 or -3] tells us if the square is cover(0) uncover(-1) flag(-2) mine(-3). Default: cover.
	 * adjacent ->[int] tells us how many adjacent mines there are. Default: 0.*/
	
	private boolean mine;
	private int state;
	private int adjacent;
	private boolean explored;
	
	public Square() {
		this.mine=false;
		this.explored = false;
		this.state=0;
		this.adjacent=0;
	} 
	
	public void setMine() {
		this.mine=true;
	}
	
	public void setState(int s) {
	
	    if(s>=-3 && s<=8) {
	    	this.state=s;	    	
	    }
	}
	
	public boolean isMine() {
		return this.mine;
	}
	
	public int getState() {
		return this.state;	
	}
	
	public int getAdjacentMines() {
		
		return this.adjacent;
	}
	
	public void setAdjacentMines(int nAdjMines) {

	    if(nAdjMines>=0 && nAdjMines<=8) {
	   		this.adjacent=nAdjMines;	    	
	   	}
	}
	
	public void setExplored() {
		
		this.explored = true;
	}
	
	public boolean getExplored() {
		
		return this.explored;
	}
}
