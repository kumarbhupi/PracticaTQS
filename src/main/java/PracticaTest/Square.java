package PracticaTest;

public class Square {
	
	/*THIS IS THE SQUARE CLASS. 
	 * Here we control the status of each box individually.
	 * mine->[true or false] tells us if there is a bomb. Default: no mine.
	 * state->[1 or 2 or 3] tells us if the square is cover(1) uncover(2) or with a flag(3). Default: cover.
	 * adjacent ->[int] tells us how many adjacent mines there are. Default: 0.*/
	
	private boolean mine;
	private int state;
	private int adjacent;
	
	public Square() {
		this.mine=false;
		this.state=1;
		this.adjacent=0;
	}
	
	public void setMine() {
		this.mine=true;
	}
	
	public void setState(int s) {
		this.state=s;
	}
	
	public boolean isMine() {
		return this.mine;
	}
	
	public int getState() {
		return this.state;	
	}
	
	public int getAdjacent() {
		return 0;
	}

}
