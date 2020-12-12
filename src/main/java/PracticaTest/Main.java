package PracticaTest;

public class Main {

	public static void main(String[] args) {
		//matriz de minas para mock testing
		boolean[][] testArray1 = {  {false, false, false, false, false, false, false}, 
									{false, false, false, false, false, false, false}, 
									{false, false, false, false, false, false, false}, 
									{false, false, false, false, false, false, false}, 
									{false, false, false, false, false, false, false}, 
									{false, false, false, false, false, false, false}, 
									{false, false, false, false, false, false, false}};

		String[] inputs = {"5,5","d"};
		
		Board b = new Board(testArray1);
		Player p = new Player();
		
		//no hay control de errores en MockInuput, aseguraos de meter
		//la cantidad de comandos en "String[] inputs" precisa para el 
		//tablero que monteis
		
		MockInput in = new MockInput(inputs);
		
		
		//EJECUCI�N ESTANDAR
		//Game juego = new Game();
		
		//EJECUCI�N MOCK
		Game juego = new Game(p, b, in);
		
	}
	
}
