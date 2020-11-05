package PracticaTest;

import static org.junit.Assert.*;

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
		
		assertTrue(plyrTest.decreaseFlagNum(40)==40);
		assertTrue(plyrTest.decreaseFlagNum(0)==1);
		
		assertFalse(plyrTest.decreaseFlagNum(40)==41);
		
	}

	@Test
	public void testIncreaseScore() {
		
		Player plyrTest = new Player();
		
		assertTrue(plyrTest.increaseScore(40)==400);
		assertTrue(plyrTest.increaseScore(10)==100);
		assertFalse(plyrTest.increaseScore(-50)==0);
		
		
	}

	@Test
	public void testFinalScoreCalc() {
		fail("Not yet implemented");
	}

}
