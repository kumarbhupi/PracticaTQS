package PracticaTest;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


public class PlayerTest {

	@Test
	public void testPlayer() {
		
		Player playerTest = new Player();
		
		assertTrue(playerTest.getFlagCount()==40);
		assertFalse(playerTest.getFlagCount()==0); 
		 
	}

	@Test
	public void testPlayerInt() {

		Player playerTest = new Player(40);
		
		assertTrue(playerTest.getFlagCount()==40);
		assertFalse(playerTest.getFlagCount()==0);
		
	}

	@Test
	public void testDecreaseFlagNum() {
		
		
		Player playerTest = new Player();
		
		playerTest.decreaseFlagNum();
		assertTrue(39==playerTest.getFlagCount());
		playerTest.decreaseFlagNum();
		assertTrue(38==playerTest.getFlagCount());
		playerTest.decreaseFlagNum();
		assertTrue(37==playerTest.getFlagCount());
		
		for(int i=0;i<37;i++) {
			playerTest.decreaseFlagNum();
		}
		
		assertTrue(0==playerTest.getFlagCount());
		
		
		
	}

	@Test
	public void testIncreaseFlagNum() {
		
		Player playerTest = new Player();
		
		playerTest.increaseFlagNum();
		assertTrue(40==playerTest.getFlagCount());
		
		playerTest.decreaseFlagNum();
		playerTest.decreaseFlagNum();
		playerTest.decreaseFlagNum();
		
		playerTest.increaseFlagNum();
		assertTrue(38==playerTest.getFlagCount());

		
	}

	@Test
	public void testIncreaseScore() {
		
		Player playerTest = new Player();
		
		playerTest.setScore(500);
		
		assertTrue(playerTest.increaseScore(40)==400);
		assertTrue(playerTest.getScore()==900);
		
		playerTest.setScore(500);
		
		assertTrue(playerTest.increaseScore(10)==100);
		assertTrue(playerTest.getScore()==600);
		
		playerTest.setScore(500);
		
		playerTest.increaseScore(-50);
		assertTrue(playerTest.getScore()==500);
		
	}
	
	@Test //Test the getters and setters of score
	public void testPlayerScore() {
		Player playerTest = new Player();
		
		playerTest.setScore(0);
		assertTrue(0==playerTest.getScore());
		playerTest.setScore(1000);
		assertTrue(1000==playerTest.getScore());
		playerTest.setScore(2120);
		assertTrue(2120==playerTest.getScore());

		playerTest.setScore(-500000);
		playerTest.setScore(1000000);
		playerTest.setScore(-1);
		playerTest.setScore(2121);
		assertTrue(2120==playerTest.getScore());
	}
}
