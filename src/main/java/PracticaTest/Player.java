package PracticaTest;

public class Player {

	
	//PARAMETERS ADJUSTED FOR A 14*18 BOARD AND 40 MINES
	
	private static final int MINE_NUM = 40;
	
	private int score = 0;
	private int flagCount;
	
	
	Player() {
		this.flagCount = MINE_NUM;
	}
	
	Player(int mineNum) {
		this.flagCount = mineNum;
	}
	
	
	public int decreaseFlagNum(int numFlags) {
		
		int newFlagNum;
		
		if (numFlags - 1 <= 0)
			newFlagNum = 0;
		else 
			newFlagNum = --numFlags;
		
		return newFlagNum;
	}
	
	
	public int increaseFlagNum(int numFlags) {
		
		int newFlagNum;
		
		if (numFlags + 1 >= 40)
			newFlagNum = 40;
		else 
			newFlagNum = ++numFlags; 
			
		return newFlagNum;
		
	}
	
	public int increaseScore(int nSquares) {
		
		int scoreIncrement = this.score; 
		
		if (nSquares > 0) {
			scoreIncrement =nSquares * 10;
			this.score += scoreIncrement;
			return scoreIncrement;
		} else
			return 0;
	}
	
	public int finalScoreCalc() {
		
		return 0;
	}
	
	
	public int getFlagCount() { return this.flagCount; }
	public int getScore() { return this.score; }
	public void setScore(int points) { this.score = points; }
		
	
}
