package PracticaTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


public class PlayerTest {

	@Test
	public void testPlayer() {
		
		Player plyrTest = new Player();
		
		assertTrue(plyrTest.getFlagCount()==40);
		assertFalse(plyrTest.getFlagCount()==0);
		
	}

	@Test
	public void testPlayerInt() {
		
		int mines = 40;
		
		Player plyrTest = new Player(mines);
		
		assertTrue(plyrTest.getFlagCount()==mines);
		assertFalse(plyrTest.getFlagCount()==0);
		
	}

	@Test
	public void testDecreaseFlagNum() {
		
		
		Player plyrTest = new Player();
		
		assertTrue(plyrTest.decreaseFlagNum(20)==19);
		assertTrue(plyrTest.decreaseFlagNum(0)==0);
		
		assertFalse(plyrTest.decreaseFlagNum(0)==-1);
		
	}

	@Test
	public void testIncreaseFlagNum() {
		
		Player plyrTest = new Player();
		
		assertTrue(plyrTest.increaseFlagNum(40)==40);
		assertTrue(plyrTest.increaseFlagNum(0)==1);
		
		assertFalse(plyrTest.increaseFlagNum(0)==0);
		assertFalse(plyrTest.increaseFlagNum(40)==41);
		
	}

	@Test
	public void testIncreaseScore() {
		
		Player plyrTest = new Player();
		
		plyrTest.setScore(500);
		
		assertTrue(plyrTest.increaseScore(40)==400);
		
		
		assertTrue(plyrTest.getScore()==900);
		
		plyrTest.setScore(500);
		
		assertTrue(plyrTest.increaseScore(10)==100);
		assertTrue(plyrTest.getScore()==600);
		
		plyrTest.setScore(500);
		
		assertTrue(plyrTest.increaseScore(-50)==0);
		assertTrue(plyrTest.getScore()==500);
		
		assertFalse(plyrTest.increaseScore(-50)==-500);
		
		
	}

	@Test
	public void testFinalScoreCalc() {
		fail("Not yet implemented");
	}

}
