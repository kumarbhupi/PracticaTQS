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
				+ "  7 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
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
		
		
		
		//String outpt = BoardView.DrawBoard(testArray);
		//System.out.println(BoardView.DrawBoard(testArray));
		//System.out.println("");
		//System.out.println("");
		
		//System.out.println(testStr);
		
		
//		System.out.println("");
//		System.out.println("");
		

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

		//assertTrue(BoardView.DrawBoard(testArray1).equals(errorStr));
//		System.out.println("");
		
		
		//assertTrue(BoardView.DrawBoard(testArray2).equals(errorStr));
//		System.out.println("");
	}

	//////////////REDIMENSION TESTCASES//////////////

	@Test
	public void testResizingPrintUpper() {
		
//		System.out.println("testResizingPrintUpper()");
		
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
//		System.out.println("");
		
		assertTrue(BoardView.ProxyPrintUpperRow(null).equals(errorStr));
//		System.out.println("");

	}



	@Test
	public void testResizingPrintCentral() {
		
//		System.out.println("testResizingPrintCentral()");

		BoardVisuals BoardView = new BoardVisuals();

		int[] testRowArray = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};

		String centralStr =   " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
				+ " 10 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │";

		assertTrue(BoardView.ProxyPrintCentralRow(testRowArray, 10).equals(centralStr));
		
//		System.out.println("");

		int[] testRowArray2 = {-2,-2};

		centralStr =  " ───┼───┼───┤\r\n"
				+ " 10 │ █ │ █ │";

		assertTrue(BoardView.ProxyPrintCentralRow(testRowArray2, 10).equals(centralStr));

//		System.out.println("");
		
		int[] testRowArray0 = {};

		assertTrue(BoardView.ProxyPrintCentralRow(testRowArray0, 10).equals(errorStr));
		
//		System.out.println("");
		
		assertTrue(BoardView.ProxyPrintCentralRow(null, 0).equals(errorStr));
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
	}

	@Test
	public void testResizingPrintLower() {

		System.out.println("testResizingPrintLower()");
		
		BoardVisuals BoardView = new BoardVisuals();

		int[] testRowArray = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};

		String lowerStr = " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";

		assertTrue(BoardView.ProxyPrintLowerRow(testRowArray.length).equals(lowerStr));


		int[] testRowArray2 = {-2,-2};

		lowerStr = " ───┴───┴───┘";

		assertTrue(BoardView.ProxyPrintLowerRow(testRowArray2.length).equals(lowerStr));

		int[] testRowArray0 = {};

		assertTrue(BoardView.ProxyPrintLowerRow(testRowArray0.length).equals(errorStr));
		assertTrue(BoardView.ProxyPrintLowerRow(0).equals(errorStr));
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
	}



	//////////////ITEM VARIATION TESTCASES//////////////
	// " " = 0
	// "█" = -2
	// "#" = -1

	@Test
	public void testPrintUpperRow() {
		BoardVisuals BoardView = new BoardVisuals();
		String upperStr;
		int[] testRowArray = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};

		upperStr =    "    │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
				+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
				+ "  1 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │";

		assertTrue(BoardView.ProxyPrintUpperRow(testRowArray).equals(upperStr));

		for (int i = 0; i < testRowArray.length; i++)
			++testRowArray[i];


		upperStr =    "    │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
				+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
				+ "  1 │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │";

		assertTrue(BoardView.ProxyPrintUpperRow(testRowArray).equals(upperStr));

		for (int i = 0; i < testRowArray.length; i++)
			++testRowArray[i];


		upperStr =    "    │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10│ 11│ 12│ 13│ 14│ 15│ 16│ 17│ 18│\r\n"
				+ " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
				+ "  1 │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │";

		assertTrue(BoardView.ProxyPrintUpperRow(testRowArray).equals(upperStr));
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
	}


	@Test
	public void testPrintCentralRow() {

//		System.out.println("testPrintCentralRow()");
		
		BoardVisuals BoardView = new BoardVisuals();

		String centralStr;

		int[] testRowArray = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};

		centralStr =  
				" ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
				+ " 10 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │";

		assertTrue(BoardView.ProxyPrintCentralRow(testRowArray, 10).equals(centralStr));

		for (int i = 0; i < testRowArray.length; i++)
			++testRowArray[i];

		centralStr = " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"  
				+ " 10 │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │ # │";

		assertTrue(BoardView.ProxyPrintCentralRow(testRowArray, 10).equals(centralStr));

		for (int i = 0; i < testRowArray.length; i++)
			++testRowArray[i];

		centralStr =  " ───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤\r\n"
				+ " 10 │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │";

		assertTrue(BoardView.ProxyPrintCentralRow(testRowArray, 10).equals(centralStr));
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
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
		
//		System.out.println("testPrintLowerRow()");

		String lowerStr;

		BoardVisuals BoardView = new BoardVisuals();

		int[] testRowArray = {-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2,-2};

		lowerStr = " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";

		assertTrue(BoardView.ProxyPrintLowerRow(testRowArray.length).equals(lowerStr));


	}


}
