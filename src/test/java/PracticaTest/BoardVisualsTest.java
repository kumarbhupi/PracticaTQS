package PracticaTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardVisualsTest {

	@Test
	public void testDrawBoard() {
		fail("Not yet implemented");
	}
	
	
	//////////////REDIMENSION TESTCASES//////////////
	
	@Test
	public void testProxyPrintUpperResizing() {
		BoardVisuals BoardView = new BoardVisuals();
		
		int[] aja = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
		
		String upperStr =   "		│ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
							 + " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
							 + "  1 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │";
		
		assertTrue(BoardView.ProxyPrintUpperRow(aja)==upperStr);
		
		
		int[] aja2 = {-2,-2};
		
		 upperStr =  "	│ 1 │ 2 │\r\n"
				 + " ───┼───┼───┤\r\n"
				 + "  1 │ █ │ █ │";
		 
		 assertTrue(BoardView.ProxyPrintUpperRow(aja2)==upperStr);
		
	}
	
	

	@Test
	public void testProxyPrintCentralResizing() {
		
		BoardVisuals BoardView = new BoardVisuals();
		
		int[] aja = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
		
		String centralStr =   " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
							+ " 10 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
							+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤";
		
		assertTrue(BoardView.ProxyPrintCentralRow(aja, 10)==centralStr);
		
		int[] aja2 = {-2,-2};
		
		centralStr =  " ───┼───┼───┤\r\n"
					+ " 10 │ █ │ █ │\r\n"
					+ " ───┼───┼───┤";
		 
		 assertTrue(BoardView.ProxyPrintCentralRow(aja2, 10)==centralStr);
		
	}

	@Test
	public void testProxyPrintLowerResizing() {
		
		
		BoardVisuals BoardView = new BoardVisuals();
		
		int[] aja = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
		
		String lowerStr = " 14 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
		
		assertTrue(BoardView.ProxyPrintLowerRow(aja, 14)==lowerStr);
		
				
		int[] aja2 = {-2,-2};
				
		lowerStr = " 14 │ █ │ █ │\r\n"
				 + " ───┴───┴───┘";
		 
		 assertTrue(BoardView.ProxyPrintLowerRow(aja2, 14)==lowerStr);
		
		
	}
	
	//////////////ITEM VARIATION TESTCASES//////////////
	// " " = 0
	// "█" = -2
	// "#" = -1
	
	@Test
	public void testProxyPrintUpperRow() {
	BoardVisuals BoardView = new BoardVisuals();
	
	int[] aja = {0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	String upperStr =   "		│ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
						 + " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						 + "  1 │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │";
	
	assertTrue(BoardView.ProxyPrintUpperRow(aja)==upperStr);
	
	
	}
	
	
	
	@Test
	public void testProxyPrintCentralRow() {
	
	BoardVisuals BoardView = new BoardVisuals();
	
	String centralStr;
	
	int[] aja = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	
	centralStr =   " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
				 + " 10 │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │\r\n"
				 + " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤";
	
	assertTrue(BoardView.ProxyPrintCentralRow(aja, 10)==centralStr);
	
	}
	
	@Test
	public void testProxyPrintLowerRow() {
	
	String lowerStr;
		
	BoardVisuals BoardView = new BoardVisuals();
	
	int[] aja = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
	
	lowerStr = " 14 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
			 + " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
	
	assertTrue(BoardView.ProxyPrintLowerRow(aja, 14)==lowerStr);
	
	for (int i = 0; i < aja.length; i++)
		++aja[i];
	
	lowerStr = " 14 │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │\r\n"
			 + " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
	
	assertTrue(BoardView.ProxyPrintLowerRow(aja, 14)==lowerStr);
	
	for (int i = 0; i < aja.length; i++)
		++aja[i];
	
	lowerStr = " 14 │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │\r\n"
			 + " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
	
	assertTrue(BoardView.ProxyPrintLowerRow(aja, 14)==lowerStr);
	
	}
	

}
