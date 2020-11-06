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
		String str = "UPPER";
		System.out.println(str);
		return str;
	
	}
	
	private String printCentralRow(int[] row, int nRow) {
		String str = "UPPER";
		System.out.println(str);
		return str;
	}
	
	private String printLowerRow(int[] row, int nRow) { 
		String str = "LOWER";
		System.out.println(str);
		return str;
	}
	
	
	//TEST PROXIES
	
	public String ProxyPrintUpperRow(int[] row) { return printUpperRow(row);}
	public String ProxyPrintCentralRow(int[] row, int nRow) { return printCentralRow(row, nRow);}
	public String ProxyPrintLowerRow(int[] row, int nRow) { return printLowerRow(row, nRow);}
	
	
}
