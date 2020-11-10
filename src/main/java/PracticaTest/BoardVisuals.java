package PracticaTest;

public class BoardVisuals {

	//PARAMETERS ADJUSTED FOR A 14*18 BOARD AND 40 MINES
	// PROTOTYPE ROW VALUES: 
	// " " = 0
	// "█" = -2
	// "#" = -1
	// POSITIVE NUMBERS REPRESENT THE ACTUAL NUMBER OF MINES AROUND THE SQUARE 
	

	BoardVisuals() {
		
	}
	
	public void DrawBoard() {}
	
	private String printUpperRow(int[] row) {
		
		String upperPart =	"   │";
		String centerPart =	"───┼";
		String lowerPart= 	" 1 │";
		
		for (int i=0;i<row.length;i++) {
			
			if (i == row.length-1) {
				upperPart += " " + String.format("%-2d", i+1) + "│\r\n";
				centerPart += "───┤\r\n";
			} else {
				upperPart += " " + String.format("%-2d", i+1) + "│";
				centerPart += "───┼";
			} 
			
            lowerPart  += " █ │";
			
		}
		
		String finalPrint = upperPart + centerPart + lowerPart;
		
		System.out.println(finalPrint);
		return finalPrint;
	
	}
	
	private String printCentralRow(int[] row, int nRow) {

		String upperPart = "───┼";
		String centerPart = "" + String.format("%2d", nRow) + " │"; 
		String lowerPart= "───┼";

		
		for (int i=0;i<row.length;i++) {
			
			if (i == row.length-1) {
				upperPart  += "───┤\r\n";
				centerPart += " █ │\r\n";
				lowerPart += "───┤";
			} else {
				upperPart  += "───┼";
				centerPart += " █ │";
				lowerPart  += "───┼";
			} 
			
		}
		
		System.out.println("center");
		
		String finalPrint = upperPart + centerPart + lowerPart;
		
		System.out.println(finalPrint);
		return finalPrint;
		
		
	}
	
	private String printLowerRow(int[] row, int nRow) { 
		String str = "LOWER";
		
		String lowerStr = " 14 │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │ █ │\r\n"
						+ " ───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘";
		
		String upperPart =	"" + String.format("%2d", nRow) + " │";
		String lowerPart= 	"───┴";
		
		for (int i=0;i<row.length;i++) {
			
			if (i == row.length-1) {
				 
				upperPart += " █ │\r\n";
				lowerPart += "───┘";
			} else {
				upperPart += " █ │";
				lowerPart += "───┴";
			} 
			
		}
		
		String finalPrint = upperPart + lowerPart;
		
		System.out.println("LOWER");
		
		System.out.println(finalPrint);
		return finalPrint;
	}
	
	private String itemPrinter(int type) {
		
		// " " = 0
		// "█" = -2
		// "#" = -1
		
		String itemStr = ""; 
	
		return itemStr;
	}
	
	//TEST PROXIES
	
	public String ProxyitemPrinter(int type) { return itemPrinter(type);}
	public String ProxyPrintUpperRow(int[] row) { return printUpperRow(row);}
	public String ProxyPrintCentralRow(int[] row, int nRow) { return printCentralRow(row, nRow);}
	public String ProxyPrintLowerRow(int[] row, int nRow) { return printLowerRow(row, nRow);}
	
	
}
