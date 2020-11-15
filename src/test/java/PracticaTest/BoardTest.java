package PracticaTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	
	@Test
	public void testClearBoard() {
		Board tabla = new Board();
		tabla.proxyClearBoard();
		
		assertTrue(!tabla.isMine(0, 0));
		assertTrue(!tabla.isMine(0, tabla.getLengthY()-1));
		assertTrue(!tabla.isMine(tabla.getLengthX()-1, 0));
		assertTrue(!tabla.isMine(tabla.getLengthX()-1, tabla.getLengthY()-1));
	
	}
	
	@Test
	public void testGenerateMineMap() {
		Board tabla = new Board();
		
		int mineNum   = 40;
		int mineCount = 0;
		
		tabla.proxyGenerateMineMap(mineNum);
		
		for(int i=0; i < tabla.getLengthY();i++) {
			for(int j=0; j < tabla.getLengthX();j++) {
				if (tabla.isMine(j, i))
					mineCount++;
				
			}
		}

		assertTrue(mineCount==mineNum);		
		
	}
	
	@Test
	public void testSetFlag() {
		Board tabla = new Board();
		
		assertTrue(tabla.setFlag(0, 0));
		assertTrue(tabla.getState(0, 0)==-2);//falta definir los valores de state correctamente
		assertFalse(tabla.setFlag(0, 0));
		assertTrue(tabla.getState(0, 0)==0);//falta definir los valores de state correctamente
		
	}
	
	@Test
	public void testFullUncover() {
		
		
		BoardVisuals visuals = new BoardVisuals();
		boolean[][] testArray ={{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true},
								{true,true,true,true,true,true,true,false,false,false,false,true,true,true,true,true,true,true}};
		
		
		Board tabla = new Board(testArray);
		visuals.DrawBoard(tabla);
		System.out.println();
		System.out.println();
		
		tabla.uncoverPosition(9, 4);
		visuals.DrawBoard(tabla);
		
		
		assertTrue(tabla.getState(7, 0)==3);
		assertTrue(tabla.getState(10, 0)==3);
		
		assertTrue(tabla.getState(7, tabla.getLengthY()-1)==3);
		assertTrue(tabla.getState(10, tabla.getLengthY()-1)==3);
		
		for (int i=1; i<tabla.getLengthY()-1;i++) {
			assertTrue(tabla.getState(7, tabla.getLengthY()-1)==2);
			assertTrue(tabla.getState(10, tabla.getLengthY()-1)==2);
		}
		
		//EXCEPCIONES
		
//		boolean[][] testArrayExcep ={{true,false,false,false,false},
//									 {false,false,true,false,false},
//									 {false,false,false,false,true}};
//		
//		tabla = new Board(testArrayExcep);
//		tabla.uncoverPosition(-1, -1);
//		tabla.uncoverPosition(5, 3);
	}
	
	@Test
	public void testMineUncovering() {
		
		boolean[][] testArray ={{true,false,false,false,true},
								{false,false,true,false,false},
								{true,false,false,false,true}};

		Board tabla = new Board(testArray);
		
		assertTrue(tabla.uncoverPosition(0,0)==-1);
		assertTrue(tabla.uncoverPosition(4,0)==-1);
		
		assertTrue(tabla.uncoverPosition(2,1)==-1);
		
		assertTrue(tabla.uncoverPosition(0,2)==-1);
		assertTrue(tabla.uncoverPosition(4,2)==-1);

		
		//EXCEPCIONES
		//assertTrue(tabla.uncoverPosition(-1,-1)==-1);
		//assertTrue(tabla.uncoverPosition(5, 3)==-1);
		
	}
	
	@Test
	public void testIsMine() {
		
		boolean[][] testArray ={{true,false,false,false,false},
								{false,false,true,false,false},
								{false,false,false,false,true}};
		
		Board tabla = new Board(testArray);
		
		assertTrue(tabla.isMine(0, 0));
		assertFalse(tabla.isMine(4, 0));
		assertFalse(tabla.isMine(0, 1));
		assertTrue(tabla.isMine(2, 1));
		assertTrue(tabla.isMine(4, 2));
		
		
		//EXCEPCIONES
		
		//assertFalse(tabla.isMine(-1, -1));
		//assertFalse(tabla.isMine(5, 3));
		//assertFalse(tabla.isMine(null, null));
	}
	
	
		
	@Test
	public void testGetState() {
		
		boolean[][] testArray ={{true,false,false,false,false},
								{false,false,true,false,false},
								{false,false,false,false,true}};

		Board tabla = new Board(testArray); 
		
		for(int i=0; i < tabla.getLengthY();i++)
			for(int j=0; j < tabla.getLengthX();j++) {
				assertTrue(tabla.getState(j, i)==0);
				tabla.setState(j, i, 8);	
			}
		
		for(int i=0; i < tabla.getLengthY();i++)
			for(int j=0; j < tabla.getLengthX();j++) {
				assertTrue(tabla.getState(j, i)==8);
					
			}
		
		
		
		//EXCEPTIONS
		
		//setter test 
		tabla.setState(-1, -1, 8);
		tabla.setState(-1, 2, 8);
		
		tabla.setState(5, 3, 8);
		tabla.setState(5, 0, 8);
		
		
		//getter test
		assertTrue(tabla.getState(-1, -1)==8);
		assertTrue(tabla.getState(-1, 2)==8);
		
		assertTrue(tabla.getState(5, 3)==8);
		assertTrue(tabla.getState(5, 0)==8);
		
		
	}
	
	@Test
	public void testGetLengthFunctions() { // getLengthX() y getLengthY()
		
		boolean[][] testArray ={{true,false,false,false,false},
								{false,false,true,false,false},
								{false,false,false,false,true}};
		
		boolean[][] testArray2 ={{},
								{},
								{}};
		
		
		Board tabla = new Board(testArray);
		
		assertTrue(tabla.getLengthX()==5);
		assertTrue(tabla.getLengthY()==3);
		
		
		//EXCEPTIONS
		
		tabla = new Board(testArray2);
		
//		assertTrue(tabla.getLengthX()==0);
//		assertTrue(tabla.getLengthY()==0);
		
	}
	
	
	@Test
	public void testGetMatrix() {
		
		boolean[][] testArray ={{true,false,false,false,false},
								{false,false,true,false,false},
								{false,false,false,false,true}};
		
		Board tabla = new Board(testArray);
		
		Square[][] mat = tabla.getMatrix();
		
		for(int i=0; i < tabla.getLengthY();i++) {
			for(int j=0; j < tabla.getLengthX();j++) {
				assertTrue(mat[i][j].isMine()==testArray[i][j]);
			}
		}
		
		boolean[][] testArray2 ={{},
				{},
				{}};
		
		
		//EXCEPTIONS
		tabla = new Board(testArray2);
		
		mat = tabla.getMatrix();
		
		for(int i=0; i < tabla.getLengthY();i++) {
			for(int j=0; j < tabla.getLengthX();j++) {
				assertTrue(mat[i][j].isMine()==testArray2[i][j]);
			}
		}
		
	}
	
	
	
}