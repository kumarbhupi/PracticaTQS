package PracticaTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SquareTest {
	@Test //Test the getters and setters of state square
	public void testSquareState() {
		Square squareTest = new Square();
		for(int i=-3; i<=8; i++) {
			squareTest.setState(i);
			assertTrue(i==squareTest.getState()); 
		}
		squareTest.setState(-500);
		squareTest.setState(500);
		squareTest.setState(-4);
		squareTest.setState(8);
		assertTrue(8==squareTest.getState());
	}

	@Test //Test setters and getters of ismine
	public void testSquareMines() {
		Square squareTest = new Square();
		assertTrue(false==squareTest.isMine());
		squareTest.setMine();
		assertTrue(true==squareTest.isMine());
		squareTest.setMine();
		assertTrue(true==squareTest.isMine());
	}
	
	@Test //Test setters and getters of adjacentmines
	public void testAdjacentMines() {
		Square squareTest = new Square();
		for(int i=0; i<=8; i++) {
			squareTest.setAdjacentMines(i);
			assertTrue(i==squareTest.getAdjacentMines()); 
		}
		
		squareTest.setAdjacentMines(-500);
		squareTest.setAdjacentMines(500);
		squareTest.setAdjacentMines(-1);
		squareTest.setAdjacentMines(9);
		assertTrue(8==squareTest.getAdjacentMines());
	}
	
	@Test //Test setters and getters of explored
	public void testExploredMines() {
		Square squareTest = new Square();
		assertTrue(false==squareTest.getExplored());
		squareTest.setExplored();
		assertTrue(true==squareTest.getExplored());
		squareTest.setExplored();
		assertTrue(true==squareTest.getExplored());
	}
	
	
} 
