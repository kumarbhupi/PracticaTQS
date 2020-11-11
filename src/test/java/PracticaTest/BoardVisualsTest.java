package PracticaTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardVisualsTest {

	String errorStr = "--PRINT ERROR. FILA DEMASIADO CORTA (MENOR QUE 1)--";
	
	@Test
	public void testDrawBoard() {

		int[][] testArray ={{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2},
							{-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2}};
		
		String testStr =  "    │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ "  1 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ "  2 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ "  3 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ "  4 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ "  5 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ "  6 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ "  8 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ "  9 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ " 10 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ " 11 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ " 12 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ " 13 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						+ " 14 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
		
		
		BoardVisuals BoardView = new BoardVisuals();
		
		assertTrue(BoardView.DrawBoard(testArray).equals(testStr));
		
		int[][] testArray1 ={{},
							 {},
							 {},
							 {},
							 {},
							 {},
							 {},
							 {},
							 {},
							 {},
							 {},
							 {},
							 {},
							 {}};
		
		int[][] testArray2 ={};
		
		assertTrue(BoardView.DrawBoard(testArray1).equals(errorStr));

		assertTrue(BoardView.DrawBoard(testArray2).equals(errorStr));
		
	}
	
	//////////////REDIMENSION TESTCASES//////////////
	
	@Test
	public void testResizingPrintUpper() {
		BoardVisuals BoardView = new BoardVisuals();
		
		int[] testRowArray = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
		
		String upperStr =      "    │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
							 + " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
							 + "  1 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │";
	
		
		assertTrue(BoardView.ProxyPrintUpperRow(testRowArray).equals(upperStr));
		
		
		int[] testRowArray2 = {-2,-2};
		
		 upperStr = "    │ 1 │ 2 │\r\n"
				 +  " ───┼───┼───┤\r\n"
				 +  "  1 │ █ │ █ │";
		 
		 assertTrue(BoardView.ProxyPrintUpperRow(testRowArray2).equals(upperStr));
		
		 int[] testRowArray0 = {};
		 
		 assertTrue(BoardView.ProxyPrintUpperRow(testRowArray0).equals(errorStr));
		 assertTrue(BoardView.ProxyPrintUpperRow(null).equals(errorStr));
		 
	}
	
	

	@Test
	public void testResizingPrintCentral() {
		
		BoardVisuals BoardView = new BoardVisuals();
		
		int[] testRowArray = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
		
		String centralStr =   " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
							+ " 10 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
							+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤";
		
		assertTrue(BoardView.ProxyPrintCentralRow(testRowArray, 10).equals(centralStr));
		
		int[] testRowArray2 = {-2,-2};
		
		centralStr =  " ───┼───┼───┤\r\n"
					+ " 10 │ █ │ █ │\r\n"
					+ " ───┼───┼───┤";
		 
		 assertTrue(BoardView.ProxyPrintCentralRow(testRowArray2, 10).equals(centralStr));
		
		 int[] testRowArray0 = {};
		 
		 assertTrue(BoardView.ProxyPrintCentralRow(testRowArray0, 10).equals(errorStr));
		 assertTrue(BoardView.ProxyPrintCentralRow(null, 0).equals(errorStr));
		 
	}

	@Test
	public void testResizingPrintLower() {
		
		
		BoardVisuals BoardView = new BoardVisuals();
		
		int[] testRowArray = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
		
		String lowerStr = " 14 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
		
		assertTrue(BoardView.ProxyPrintLowerRow(testRowArray, 14).equals(lowerStr));
		
				
		int[] testRowArray2 = {-2,-2};
				
		lowerStr = " 14 │ █ │ █ │\r\n"
				 + " ───┴───┴───┘";
		 
		 assertTrue(BoardView.ProxyPrintLowerRow(testRowArray2, 14).equals(lowerStr));
		 
		 int[] testRowArray0 = {};
		 
		 assertTrue(BoardView.ProxyPrintLowerRow(testRowArray0, 10).equals(errorStr));
		 assertTrue(BoardView.ProxyPrintLowerRow(null, 0).equals(errorStr));
		
	}
	
	
	
	//////////////ITEM VARIATION TESTCASES//////////////
	// " " = 0
	// "█" = -2
	// "#" = -1
	
	@Test
	public void testPrintUpperRow() {
	BoardVisuals BoardView = new BoardVisuals();
	
	int[] testRowArray = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	String upperStr =      "    │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
						 + " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
						 + "  1 │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │";
	
	assertTrue(BoardView.ProxyPrintUpperRow(testRowArray).equals(upperStr));
	
	}
	
	
	@Test
	public void testPrintCentralRow() {
	
	BoardVisuals BoardView = new BoardVisuals();
	
	String centralStr;
	
	int[] testRowArray = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	
	centralStr =   " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
				 + " 10 │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │\r\n"
				 + " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤";
	
	assertTrue(BoardView.ProxyPrintCentralRow(testRowArray, 10).equals(centralStr));
	
	}
	
	@Test
	public void testItemPrinter() {
		BoardVisuals BoardView = new BoardVisuals();
		
		assertTrue(BoardView.ProxyitemPrinter(0).equals(" "));
		assertTrue(BoardView.ProxyitemPrinter(-1).equals("#"));
		assertTrue(BoardView.ProxyitemPrinter(-2).equals("█"));
		assertTrue(BoardView.ProxyitemPrinter(-3).equals("E"));
		
		
		assertTrue(BoardView.ProxyitemPrinter(9).equals("E"));
		assertTrue(BoardView.ProxyitemPrinter(8).equals("8"));
		assertTrue(BoardView.ProxyitemPrinter(1).equals("1"));
		
		//assertTrue(BoardView.ProxyitemPrinter(null).equals(errorStr));
		
	}
	
	@Test
	public void testPrintLowerRow() {
	
	String lowerStr;
		
	BoardVisuals BoardView = new BoardVisuals();
	
	int[] testRowArray = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};
	
	lowerStr = " 14 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
			 + " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
	
	assertTrue(BoardView.ProxyPrintLowerRow(testRowArray, 14).equals(lowerStr));
	
	for (int i = 0; i < testRowArray.length; i++)
		++testRowArray[i];
	
	lowerStr = " 14 │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │\r\n"
			 + " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
	
	assertTrue(BoardView.ProxyPrintLowerRow(testRowArray, 14).equals(lowerStr));
	
	for (int i = 0; i < testRowArray.length; i++)
		++testRowArray[i];
	
	lowerStr = " 14 │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │\r\n"
			 + " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
	
	assertTrue(BoardView.ProxyPrintLowerRow(testRowArray, 14).equals(lowerStr));
	
	}
	

}
