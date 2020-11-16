package PracticaTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	
	@Test
	public void testClearBoard() {
		Board tabla = new Board();
		
		tabla.generateMineMap(40);
		
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
		assertTrue(tabla.getState(0, 0)==-2);
		assertFalse(tabla.setFlag(0, 0));
		assertTrue(tabla.getState(0, 0)==0);
		
	}
	
	@Test
	public void testFullUncover() {
		 boolean[][] testArray =	{{false ,  false ,  false ,  false ,  false ,  false ,  false	}, 
									{false ,  true ,  true  ,  true ,  true ,  true ,  false 	}, 
									{false ,  true ,  false  ,  false ,  false  ,  true ,  false 	}, 
									{false ,  true ,  false ,  false ,  false ,  true  ,  false	}, 
									{false ,  true ,  false ,  false ,  false ,  true ,  false	}, 
									{false ,  true ,  true  ,  true ,  true ,  true ,  false	}, 
									{false ,  false ,  false ,  false ,  false  ,  false  ,  false }};
					
					
		 Board tabla = new Board(testArray);
		  
		 tabla.uncoverPosition(3, 3);
		  
		int[][] checkerArray =	{{0, 0, 0, 0, 0, 0, 0}, 
								{0, 0, 0, 0, 0, 0, 0}, 
								{0, 0, 5, 3, 5, 0, 0}, 
								{0, 0, 3, -1, 3, 0, 0}, 
								{0, 0, 5, 3, 5, 0, 0}, 
								{0, 0, 0, 0, 0, 0, 0}, 
								{0, 0, 0, 0, 0, 0, 0}};
		
		for(int i=0; i < tabla.getLengthY();i++)
			for(int j=0; j < tabla.getLengthX();j++) {
				assertTrue(tabla.getState(j, i)==checkerArray[i][j]);	
			}
		
						
						
		boolean[][] testArray1 =	{{true ,  true ,  true ,  false ,  true ,  true ,  true	}, 
									{true ,  true ,  false  ,  false ,  false ,  true ,  true 	}, 
									{true ,  false ,  false  ,  false ,  false  ,  false ,  true 	}, 
									{false,  false ,  false ,  false ,  false ,  false  ,  false	}, 
									{true ,  false ,  false ,  false ,  false ,  false ,  true	}, 
									{true ,  true ,  false  ,  false ,  false ,  true ,  true	}, 
									{true ,  true ,  true ,  false ,  true  ,  true  ,  true }};
							
		tabla = new Board(testArray1);
		  
		tabla.uncoverPosition(3, 3);
		
		//uncover3,3
		int[][] checkerArray1 =	{{0, 0, 0,  0,  0, 0, 0}, 
								{0, 0,  3,  2,  3, 0, 0}, 
								{0, 3,  1, -1,  1, 3, 0}, 
								{0, 2, -1, -1, -1, 2, 0}, 
								{0, 3,  1, -1,  1, 3, 0}, 
								{0, 0,  3,  2,  3, 0, 0}, 
								{0, 0,  0,  0,  0, 0, 0}};
						
		for(int i=0; i < tabla.getLengthY();i++)
			for(int j=0; j < tabla.getLengthX();j++) {
				assertTrue(tabla.getState(j, i)==checkerArray1[i][j]);	
			}		
						
		
		  boolean[][] testArray2 =	{{false, true ,  false ,  false ,  false ,  false ,  false	}, 
					{false,  true ,  false,  false ,  false ,  false ,  false 	}, 
					{false,  true ,  false,  false ,  false  ,  false ,  false}, 
					{false,  true ,  false,  false ,  false ,  false  ,  false}, 
					{false,  true ,  false,  false ,  false ,  false ,  false	}, 
					{true ,  true ,  true ,  true ,  true ,  true ,  true	}, 
					{false,  true ,  false,  false ,  false  ,  false  ,  false }};
		
		tabla = new Board(testArray2);
		  
		tabla.uncoverPosition(6, 0);
							
		//uncover6,0		
		int[][] checkerArray2 =	{{0, 0, 2, -1, -1, -1, -1}, 
								 {0, 0, 3, -1, -1, -1, -1}, 
								 {0, 0, 3, -1, -1, -1, -1}, 
								 {0, 0, 3, -1, -1, -1, -1}, 
								 {0, 0, 5, 3, 3, 3, 2}, 
								 {0, 0, 0, 0, 0, 0, 0}, 
								 {0, 0, 0, 0, 0, 0, 0}};
		
		for(int i=0; i < tabla.getLengthY();i++)
			for(int j=0; j < tabla.getLengthX();j++) {
				boolean xd = tabla.getState(j, i)==checkerArray2[i][j];
				assertTrue(xd);
			}
		
		
		boolean[][] testArray3 =	{{false ,  false ,  false ,  false ,  false ,  false ,  false	}, 
									{false ,  false ,  false  ,  false ,  false ,  false ,  false 	}, 
									{false ,  false ,  true  ,  true ,  true  ,  false ,  false}, 
									{false,  false ,  true ,  false ,  true ,  false  ,  false}, 
									{false ,  false ,  true ,  true ,  true ,  false ,  false	}, 
									{false ,  false ,  false  ,  false ,  false ,  false ,  false	}, 
									{false ,  false ,  false ,  false ,  false  ,  false  ,  false }};
						
		tabla = new Board(testArray3);
		  
		tabla.uncoverPosition(3, 3);
		
		int[][] checkerArray3_1 =	{{0, 0, 0, 0, 0, 0, 0}, 
									 {0, 0, 0, 0, 0, 0, 0}, 
									 {0, 0, 0, 0, 0, 0, 0}, 
									 {0, 0, 0, 8, 0, 0, 0}, 
									 {0, 0, 0, 0, 0, 0, 0}, 
									 {0, 0, 0, 0, 0, 0, 0}, 
									 {0, 0, 0, 0, 0, 0, 0}};
		
		
		for(int i=0; i < tabla.getLengthY();i++)
			for(int j=0; j < tabla.getLengthX();j++) {
				assertTrue(tabla.getState(j, i)==checkerArray3_1[i][j]);	
			}
		
		tabla.uncoverPosition(0, 0);
		
		int[][] checkerArray3_2 =	{{-1, -1, -1, -1, -1, -1, -1}, 
									 {-1, 1, 2, 3, 2, 1, -1}, 
									 {-1, 2, 0, 0, 0, 2, -1}, 
									 {-1, 3, 0, 8, 0, 3, -1}, 
									 {-1, 2, 0, 0, 0, 2, -1}, 
									 {-1, 1, 2, 3, 2, 1, -1}, 
									 {-1, -1, -1, -1, -1, -1, -1}};

		for(int i=0; i < tabla.getLengthY();i++)
			for(int j=0; j < tabla.getLengthX();j++) {
				assertTrue(tabla.getState(j, i)==checkerArray3_2[i][j]);	
			}
		  
		
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
		
//		assertFalse(tabla.isMine(-1, -1));
//		assertFalse(tabla.isMine(5, 3));
		
	}
	
	@Test
	public void testGetAdjacentMines() {
		
		boolean[][] testArray ={{true,false,false,true,false},
								{false,true,true,true,true},
								{false,true,true,true,false},
								{true,true,true,true,true},
								{false,true,false,true,true}};

		Board tabla = new Board(testArray);
		
		assertTrue(tabla.proxyGetAdjacentMines(0, 0)==1);
		assertTrue(tabla.proxyGetAdjacentMines(4, 0)==3);
		assertTrue(tabla.proxyGetAdjacentMines(2, 2)==8);
		
		assertTrue(tabla.proxyGetAdjacentMines(0, 4)==3);
		assertTrue(tabla.proxyGetAdjacentMines(2, 4)==5);
		
		
		boolean[][] testArray1 ={{true,false},
								{false,true}};
		
		tabla = new Board(testArray1);
		
		assertTrue(tabla.proxyGetAdjacentMines(0, 0)==1);
		assertTrue(tabla.proxyGetAdjacentMines(0, 1)==2);
		assertTrue(tabla.proxyGetAdjacentMines(1, 0)==2);
		assertTrue(tabla.proxyGetAdjacentMines(1, 1)==1);
		
		
	}
	
	
//	0 = up
//	1 = down
//	2 = left
//	3 = right
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCheckBounds() {
		
		
		boolean[][] testArray ={{true,false,false,false,false},
								{false,false,true,false,false},
								{false,false,false,false,true}};

		Board tabla = new Board(testArray); 
		//esquina superior izq
		assertFalse(tabla.proxyCheckBounds(0, 0, 0));
		assertFalse(tabla.proxyCheckBounds(0, 0, 2));
		assertTrue(tabla.proxyCheckBounds(0, 0, 1));
		assertTrue(tabla.proxyCheckBounds(0, 0, 3));
		
		//esquina superior der
		assertFalse(tabla.proxyCheckBounds(4, 0, 0));
		assertFalse(tabla.proxyCheckBounds(4, 0, 3));
		assertTrue(tabla.proxyCheckBounds(4, 0, 1));
		assertTrue(tabla.proxyCheckBounds(4, 0, 2));

		
		//esquina inferior der
		assertFalse(tabla.proxyCheckBounds(4, 2, 1));
		assertFalse(tabla.proxyCheckBounds(4, 2, 3));
		assertTrue(tabla.proxyCheckBounds(4, 2, 0));
		assertTrue(tabla.proxyCheckBounds(4, 2, 2));
		
		//esquina inferior izq
		assertFalse(tabla.proxyCheckBounds(0, 2, 1));
		assertFalse(tabla.proxyCheckBounds(0, 2, 2));
		assertTrue(tabla.proxyCheckBounds(0, 2, 0));
		assertTrue(tabla.proxyCheckBounds(0, 2, 3));
		
		
		//centro
		
		assertTrue(tabla.proxyCheckBounds(2, 1, 0));
		assertTrue(tabla.proxyCheckBounds(2, 1, 1));
		assertTrue(tabla.proxyCheckBounds(2, 1, 2));
		assertTrue(tabla.proxyCheckBounds(2, 1, 3));
		
		assertTrue(tabla.proxyCheckBounds(2, 1, 4));
		
	}	
	
//	@Test(expected = IndexOutOfBoundsException.class)
//	public void testCheckBoundsOOB() { 
//		
//		boolean[][] testArray ={{true,false,false,false,false},
//								{false,false,true,false,false},
//								{false,false,false,false,true}};
//
//		Board tabla = new Board(testArray); 
//		
//		assertTrue(tabla.proxyCheckBounds(0, -1, 0));
//		assertTrue(tabla.proxyCheckBounds(-1, 0, 0));
//		assertTrue(tabla.proxyCheckBounds(-1, -1, 0));
//		
//		assertTrue(tabla.proxyCheckBounds(5, 0, 0));
//		assertTrue(tabla.proxyCheckBounds(4, -1, 0));
//		assertTrue(tabla.proxyCheckBounds(5, -1, 0));
//		
//		
//		assertTrue(tabla.proxyCheckBounds(0, 3, 0));
//		assertTrue(tabla.proxyCheckBounds(-1, 2, 0));
//		assertTrue(tabla.proxyCheckBounds(-1, 3, 0));
//		
//		assertTrue(tabla.proxyCheckBounds(4, 3, 0));
//		assertTrue(tabla.proxyCheckBounds(5, 2, 0));
//		assertTrue(tabla.proxyCheckBounds(5, 3, 0));
//		
//		
//	}
	
	
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
		
		
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetStateOOB() {
		
		boolean[][] testArray ={{true,false,false,false,false},
								{false,false,true,false,false},
								{false,false,false,false,true}};
		
		
		Board tabla = new Board(testArray);
		
		
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
		
		assertTrue(tabla.getState(-1, -1)==8);
		
	}
	
	
	@Test(expected = Exception.class)
	public void testGetLengthFunctions() { // getLengthX() y getLengthY()
		
		boolean[][] testArray ={{true,false,false,false,false},
								{false,false,true,false,false},
								{false,false,false,false,true}};
		
		boolean[][] testArray2 ={};
		boolean[][] testArray3 ={{}};
		
		Board tabla = new Board(testArray);
		
		assertTrue(tabla.getLengthX()==5);
		assertTrue(tabla.getLengthY()==3);
		
		
		//EXCEPTIONS
		
		tabla = new Board(testArray2);
		
		assertTrue(tabla.getLengthX()==0);
		assertTrue(tabla.getLengthY()==0);
		
		tabla = new Board(testArray3);
		
		assertTrue(tabla.getLengthX()==0);
		assertTrue(tabla.getLengthY()==1);
		
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
	
	@Test
	public void testRemaining() {
		
		boolean[][] testArray ={{false,false,false,false,false},
								{false,false,false,false,false},
								{false,false,false,false,false}};
		
		boolean[][] testArray1 ={{false,false,true,false,false},
								{false,true,false,true,false},
								{true,false,false,false,true}};
		
		boolean[][] testArray2 ={{true,true,true,true,true},
								{true,true,false,false,false},
								{true,true,false,false,false}};
		
		
		Board tabla = new Board(testArray);
		
		assertFalse(tabla.isAllUncovered());
		
		tabla.uncoverPosition(0, 0);
		
		assertTrue(tabla.isAllUncovered());
		
		tabla = new Board(testArray1);
		
		assertFalse(tabla.isAllUncovered());
		
		tabla.uncoverPosition(0, 0);
		assertFalse(tabla.isAllUncovered());
		tabla.uncoverPosition(1, 0);
		assertFalse(tabla.isAllUncovered());
		tabla.uncoverPosition(0, 1);
		assertFalse(tabla.isAllUncovered());
		
		
		tabla.uncoverPosition(2, 1);
		assertFalse(tabla.isAllUncovered());
		tabla.uncoverPosition(2, 2);
		assertFalse(tabla.isAllUncovered());
		tabla.uncoverPosition(1, 2);
		assertFalse(tabla.isAllUncovered());
		tabla.uncoverPosition(3, 2);
		assertFalse(tabla.isAllUncovered());
		
		
		tabla.uncoverPosition(3, 0);
		assertFalse(tabla.isAllUncovered());
		tabla.uncoverPosition(4, 0);
		assertFalse(tabla.isAllUncovered());
		tabla.uncoverPosition(4, 1);
		assertTrue(tabla.isAllUncovered());

		
		tabla = new Board(testArray2);
		
		assertFalse(tabla.isAllUncovered());
		
		tabla.uncoverPosition(3, 2);
		assertTrue(tabla.isAllUncovered());
		
	}
	
}
