package PracticaTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	
	@Test
	public void testClearBoard() {
		Board tabla = new Board();
		tabla.proxyClearBoard();
		
		assertTrue(!tabla.isMine(0, 0));
		assertTrue(!tabla.isMine(0, tabla.getLengthY()));
		assertTrue(!tabla.isMine(tabla.getLengthX(), 0));
		assertTrue(!tabla.isMine(tabla.getLengthX(), tabla.getLengthY()));
		
	}
	
	@Test
	public void testGenerateMineMap() {
		Board tabla = new Board();
		
		int mineNum   = 40;
		int mineCount = 0;
		
		tabla.proxyGenerateMineMap(mineNum);
		
		for(int i=0; i < tabla.getLengthY();i++) {
			for(int j=0; j < tabla.getLengthX();j++) {
				if (tabla.isMine(i, j))
					mineCount++;
				
			}
		}

		assertTrue(mineCount==mineNum);		
		
	}
	
	
}
