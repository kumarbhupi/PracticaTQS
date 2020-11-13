package PracticaTest;

public class BoardVisuals {

	//PARAMETERS ADJUSTED FOR A 14*18 BOARD AND 40 MINES
	// PROTOTYPE ROW VALUES: 
	// " " = 0
	// "█" = -2
	// "#" = -1
	// POSITIVE NUMBERS REPRESENT THE ACTUAL NUMBER OF MINES AROUND THE SQUARE 
	String lastOutput;

	public String DrawBoard(Board b) {
		
		Square [][] matrix= b.getMatrix();
		String outputPrint = printUpperRow(matrix[0]) + "\r\n";
		
		for (int i=1;i<matrix.length;i++) {
				outputPrint += printCentralRow(matrix[i], i+1) + "\r\n";
		}
		
		outputPrint += printLowerRow(matrix[matrix.length-1].length);
		
		lastOutput = outputPrint;
		return outputPrint;
	}

	private String printUpperRow(Square[] row) {

		if(row != null && row.length>0) {

			String upperPart =	"    │";
			String centerPart =	" ───┼";
			String lowerPart= 	"  1 │";
			//String extraLowerPart = " ───┼";

			for (int i=0;i<row.length;i++) {

				if (i == row.length-1) {
					upperPart += " " + String.format("%-2d", i+1) + "│\r\n";
					centerPart += "───┤\r\n";
					//extraLowerPart  += "───┤";
				} else {
					upperPart += " " + String.format("%-2d", i+1) + "│";
					centerPart += "───┼";
					//extraLowerPart  += "───┼";
				} 

				lowerPart  += " " + itemPrinter(row[i].getState()) + " │";

			}

			String finalPrint = upperPart + centerPart + lowerPart;
			System.out.println(finalPrint);
			return finalPrint;
		} else {
			return "--PRINT ERROR. FILA DEMASIADO CORTA (MENOR QUE 1)--";
		}


	}

	private String printCentralRow(Square[] row, int nRow) {

		if(row != null && row.length>0) {
			String upperPart = " ───┼";
			String centerPart = " " + String.format("%2d", nRow) + " │"; 
			//String lowerPart= " ───┼";


			for (int i=0;i<row.length;i++) {

				if (i == row.length-1) {
					upperPart  += "───┤\r\n";
					centerPart += " " + itemPrinter(row[i].getState()) + " │";
					//lowerPart += "───┤";
				} else {
					upperPart  += "───┼";
					centerPart += " " + itemPrinter(row[i].getState()) + " │";
					//lowerPart  += "───┼";
				} 

			}

			String finalPrint = upperPart + centerPart ;//+ lowerPart;

			System.out.println(finalPrint);

			return finalPrint;
		} else {
			return "--PRINT ERROR. FILA DEMASIADO CORTA (MENOR QUE 1)--";
		}

	}

	private String printLowerRow(int rowLength) { 

		if(rowLength>0) {
			//String upperPart =	" " + String.format("%2d", nRow) + " │";
			String lowerPart= 	" ───┴";

			for (int i=0;i<rowLength;i++) {

				if (i == rowLength-1) {

					//upperPart += " " + itemPrinter(row[i]) + " │\r\n";
					lowerPart += "───┘";
				} else {
					//upperPart += " " + itemPrinter(row[i]) + " │";
					lowerPart += "───┴";
				} 

			}

			String finalPrint = /*upperPart +*/ lowerPart;

			System.out.println(finalPrint);

			return finalPrint;
		} else {
			return "--PRINT ERROR. FILA DEMASIADO CORTA (MENOR QUE 1)--";
		}
	}

	private String itemPrinter(int type) {

		// " " = 0
		// "█" = -2
		// "#" = -1

		String itemStr; 

		switch(type) {
		case 0:
			itemStr = " ";
			break;
		case -1:
			itemStr = "#";
			break;
		case -2:
			itemStr = "█";
			break;
		default:

			if (type>0 && type<9)
				itemStr = Integer.toString(type);
			else
				itemStr = "E";
		}

		return itemStr;
	}

	//TEST PROXIES

	public String ProxyitemPrinter(int type) { return itemPrinter(type);}
	public String ProxyPrintUpperRow(Square[] row) { return printUpperRow(row);}
	public String ProxyPrintCentralRow(Square[] row, int nRow) { return printCentralRow(row, nRow);}
	public String ProxyPrintLowerRow(int rowLength) { return printLowerRow(rowLength);}


}
