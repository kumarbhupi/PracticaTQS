package PracticaTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SquareTest {
	@Test //Test the getters and setters of state square
	public void testSquareState() {
		Square squareTest = new Square();
		for(int i=1; i<=3; i++) {
			squareTest.setState(i);
			assertTrue(i==squareTest.getState());
		}
		squareTest.setState(-500);
		squareTest.setState(500);
		squareTest.setState(0);
		squareTest.setState(4);
		assertTrue(3==squareTest.getState());
	}

	@Test //Test setters and getters of mine
	public void testSquareMine() {
		Square squareTest = new Square();
		assertTrue(false==squareTest.isMine());
		squareTest.setMine();
		assertTrue(true==squareTest.isMine());
	}

	@Test //Test the calculation of adjacency mines
	public void testSquareAdjacent() {
		Square squareTest = new Square();
		//squareTest.getAdjacent();
		fail("Not yet implemented");
	}
}
