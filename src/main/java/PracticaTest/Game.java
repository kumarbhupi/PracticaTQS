package PracticaTest;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {

	/*THIS IS THE GAME CLASS. 
	 * Here we control the flux of the game.
	 * mine->[true or false] tells us if there is a mine. Default: no mine.
	 * state->[1 or 2 or 3] tells us if the square is cover(1) uncover(2) or with a flag(3). Default: cover.
	 * adjacent ->[int] tells us how many adjacent mines there are. Default: 0.*/ //CAMBIAR EL COMENTARIO!

	static Player player;
	static Board board;
	static BoardVisuals visuals;

	
	static int inputX, inputY;
	
	public Game() {

	}

	public static boolean checkInput(String input, int t) {

		boolean r=false;

		input = input.replaceAll("\\s+", ""); //Delete all spaces
		input= input.toLowerCase();
		
		if(t==1) {
			Pattern p = Pattern.compile("\\d{2},\\d{2}||\\d{1},\\d{1}||\\d{1},\\d{2}||\\d{2},\\d{1}");

			if(p.matcher(input).matches() && !input.isBlank()) {
				String [] nums= input.split(",");
				
				inputX= Integer.parseInt(nums[0]);
				inputY= Integer.parseInt(nums[1]);

				if((inputX>=1 && inputX<=18) && (inputY>=1 && inputY<=14)) {
					r=true;
				}
			}
		}

		else if(t==2) {
			Pattern p = Pattern.compile("[fd]");

			if(p.matcher(input).matches() && !input.isBlank()) {
				r=true;
			}
		}
		return r;
	}
	

	public static void main(String[] args) {
		
		player= new Player();
		board = new Board();
		visuals = new BoardVisuals();
		boolean itsPossibleToPlay=true;
		Scanner reader = new Scanner(System.in);
		boolean exists;
		int uncovered=0; 
		String pos;
		String action;

		System.out.println("------------------------------ BIENVENIDO AL BUSCAMINAS ! ----------------------------------------------"); 

		System.out.println("Este es un juego con graficos basados en consola, por lo que necesitara usar su teclado.\n"
				+ "Primeramente debera seleccionar que casilla desea modificar para a continuacion decidir que hacer con ella.\n"
				+ "La tecla F pone una bandera i la tecla D destapa una casilla.\n");

		System.out.println("A jugar...!\n");
		board.generateMineMap(40);
		visuals.DrawBoard(board);

		do {
			System.out.println("Introduce la casilla a destapar. [En formato coordenadas] -> x,y: ");
			pos = reader.nextLine();  //HAY QUE COMPROVAR QUE EL VALOR SEA FACTIBLE. CON VALOR ME REFIERO AL INPUT ENTERO O MAS ADELANTE AL PRIMER Y TERCER CHAR
			if (checkInput(pos, 1)) {
				System.out.println("Que desea hacer con esta casilla? [Formato]-> F/D: ");
				action = reader.nextLine(); //APLICAR FUNCION COMPROBADORA Y QUE EXTRAIGA EL INT
				
				if (checkInput(action, 2)) {
					if(action.equals("f")) {
						exists=board.setFlag(inputX-1, inputY-1);
						if(!exists) player.increaseFlagNum();
						else player.decreaseFlagNum();
						System.out.println("Bandera puesta!\n");
					}
					else if(action.equals("d")) {
						uncovered= board.uncoverPosition(inputX-1, inputY-1);
						if(uncovered==-1) {
							itsPossibleToPlay=false;
							System.out.println("\n\nBOOM! Has perdido.\n");
						} else {
							player.increaseScore(uncovered);
							itsPossibleToPlay = !board.isAllUncovered();//COMPROBAR SI YA ESTAN TODAS DESTAPADAS
							System.out.println("Casilla/s destapada/s!\n");
						}

					}

					System.out.println("Tu puntuacion es: "+player.getScore() + "\n");
					
					if(itsPossibleToPlay==true)
						visuals.DrawBoard(board);
					
					System.out.println();

				} else {
					
					System.out.println("ERROR: Formato de la accion incorrecto. Asegurese de pulsar F (Bandera) o D (Destapar)");
				}
				
			} else {
				
				System.out.println("ERROR: Coordenadas incorrectas. Asegurese que los valores estan dentro del tablero (fila:1-18 y columna:1-14) y el formato sea x,y");
			}
		}
		while ( itsPossibleToPlay== true );
	}
	


}
