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
	public void testResizingPrintUpper() {
		BoardVisuals BoardView = new BoardVisuals();
		
		int[] aja = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
		
		String upperStr =      "   │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
							 + "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
							 + " 1 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │";
				
		assertTrue(BoardView.ProxyPrintUpperRow(aja).equals(upperStr));
		
		
		int[] aja2 = {-2,-2};
		
		 upperStr = "   │ 1 │ 2 │\r\n"
				 +  "───┼───┼───┤\r\n"
				 +  " 1 │ █ │ █ │";
		 
		 assertTrue(BoardView.ProxyPrintUpperRow(aja2).equals(upperStr));
		
	}
	
	

	@Test
	public void testResizingPrintCentral() {
		
		BoardVisuals BoardView = new BoardVisuals();
		
		int[] aja = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
		
		String centralStr =   "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
							+ "10 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
							+ "───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤";
		
		assertTrue(BoardView.ProxyPrintCentralRow(aja, 10).equals(centralStr));
		
		int[] aja2 = {-2,-2};
		
		centralStr =  "───┼───┼───┤\r\n"
					+ "10 │ █ │ █ │\r\n"
					+ "───┼───┼───┤";
		 
		 assertTrue(BoardView.ProxyPrintCentralRow(aja2, 10).equals(centralStr));
		
	}

	@Test
	public void testResizingPrintLower() {
		
		
		BoardVisuals BoardView = new BoardVisuals();
		
		int[] aja = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
		
		String lowerStr = "14 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ "───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
		
		assertTrue(BoardView.ProxyPrintLowerRow(aja, 14).equals(lowerStr));
		
				
		int[] aja2 = {-2,-2};
				
		lowerStr = "14 │ █ │ █ │\r\n"
				 + "───┴───┴───┘";
		 
		 assertTrue(BoardView.ProxyPrintLowerRow(aja2, 14).equals(lowerStr));
		
		
	}
	
	
	
	//////////////ITEM VARIATION TESTCASES//////////////
	// " " = 0
	// "█" = -2
	// "#" = -1
	
	@Test
	public void testPrintUpperRow() {
	BoardVisuals BoardView = new BoardVisuals();
	
	int[] aja = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	String upperStr =   "		│ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
						 + " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						 + "  1 │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │";
	
	assertTrue(BoardView.ProxyPrintUpperRow(aja).equals(upperStr));
	
	}
	
	
	@Test
	public void testPrintCentralRow() {
	
	BoardVisuals BoardView = new BoardVisuals();
	
	String centralStr;
	
	int[] aja = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	
	centralStr =   " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
				 + " 10 │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │\r\n"
				 + " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤";
	
	assertTrue(BoardView.ProxyPrintCentralRow(aja, 10).equals(centralStr));
	
	}
	
	@Test
	public void testItemPrinter() {
		BoardVisuals BoardView = new BoardVisuals();
		
		assertTrue(BoardView.ProxyitemPrinter(0).equals(" "));
		assertTrue(BoardView.ProxyitemPrinter(-1).equals("█"));
		assertTrue(BoardView.ProxyitemPrinter(-2).equals("#"));
		assertTrue(BoardView.ProxyitemPrinter(-3).equals("E"));
		
		
		assertTrue(BoardView.ProxyitemPrinter(9).equals("E"));
		assertTrue(BoardView.ProxyitemPrinter(8).equals("8"));
		assertTrue(BoardView.ProxyitemPrinter(1).equals("1"));
		
	}
	
	@Test
	public void testPrintLowerRow() {
	
	String lowerStr;
		
	BoardVisuals BoardView = new BoardVisuals();
	
	int[] aja = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
	
	lowerStr = " 14 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
			 + " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
	
	assertTrue(BoardView.ProxyPrintLowerRow(aja, 14).equals(lowerStr));
	
	for (int i = 0; i < aja.length; i++)
		++aja[i];
	
	lowerStr = " 14 │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │\r\n"
			 + " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
	
	assertTrue(BoardView.ProxyPrintLowerRow(aja, 14).equals(lowerStr));
	
	for (int i = 0; i < aja.length; i++)
		++aja[i];
	
	lowerStr = " 14 │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │\r\n"
			 + " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
	
	assertTrue(BoardView.ProxyPrintLowerRow(aja, 14).equals(lowerStr));
	
	}
	

}
