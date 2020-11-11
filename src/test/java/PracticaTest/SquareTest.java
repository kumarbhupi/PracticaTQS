package PracticaTest;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SquareTest {
	@Test
	public void testSquareState() {
		Square squareTest = new Square();
		for(int i=1; i<=3; i++) {
			squareTest.setState(i);
			assertTrue(i==squareTest.getState());
		}
	}

	@Test
	public void testSquareMine() {
		Square squareTest = new Square();
		assertTrue(false==squareTest.isMine());
		squareTest.setMine();
		assertTrue(true==squareTest.isMine());
	}

	@Test
	public void testSquareAdjacent() {
		Square squareTest = new Square();
		//squareTest.getAdjacent();
		fail("Not yet implemented");
	}
}
