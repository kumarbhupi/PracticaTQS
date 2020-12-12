package PracticaTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {
	@Test //Tests the function that checks the input
	public void testcheckInput() {
		Game game= new Game(false);
		boolean r;
		r=game.checkInput("1,   1", 1);
		assertTrue(r==true);
		r=game.checkInput("1,   14", 1);
		assertTrue(r==true);
		r=game.checkInput("18,1 ", 1);
		assertTrue(r==true);
		r=game.checkInput("18,   14", 1);
		assertTrue(r==true);
		r=game.checkInput("5,,5", 1);
		assertTrue(r==false);
		r=game.checkInput("5+1,5", 1);
		assertTrue(r==false);
		r=game.checkInput("5,a", 1);
		assertTrue(r==false);
		r=game.checkInput("0,5", 1);
		assertTrue(r==false);
		r=game.checkInput(" ", 1);
		assertTrue(r==false); 
		
		r=game.checkInput("F",2);
		assertTrue(r==true);
		r=game.checkInput("d    ", 2);
		assertTrue(r==true);
		r=game.checkInput("FD", 2);
		assertTrue(r==false);
		r=game.checkInput("+", 2);
		assertTrue(r==false);
		r=game.checkInput("500", 2);
		assertTrue(r==false);
		r=game.checkInput(" ", 2);
		assertTrue(r==false);

	}

}
