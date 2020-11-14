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
	
	
	public Game() {
		
	}
	
	public boolean checkInput(String input, int t) {
		
		boolean r=false;
		
		input = input.replaceAll("\\s+", ""); //Delete all spaces
		input= input.toLowerCase();
		
		if(t==1) {
			Pattern p = Pattern.compile("\\d{1},\\d{1}");
			
			if(p.matcher(input).matches()) {
				int num1= Integer.parseInt(String.valueOf(input.charAt(0)));
				int num2= Integer.parseInt(String.valueOf(input.charAt(2)));
				
				if((num1>=0 && num1<=40) && (num2>=0 && num2<=40)) {
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
	        
	        System.out.println("Este es un juego con gràficos basados en consola, por lo que necesitarà usar su teclado.\n"
	        		+ "Primeramente deberá seleccionar que casilla desea modificar para a continuación decidir que hacer con ella.\n"
	        		+ "La tecla F pone una bandera i la tecla D destapa una casilla."
	        		+ "Listo? [Pulse s/n]: \n\n"); //Si es que si limpio consola i empiezo mostrando ya e tablero, si es que no me despido i corto el juego.
	        
	        System.out.println("A jugar...!\n");
	     // visuals.DrawBoard(board);
	        
	        do {
		        System.out.println("Introduce la casilla a destapar. [En formato coordenadas] -> x,y: ");
		        pos = reader.nextLine();  //HAY QUE COMPROVAR QUE EL VALOR SEA FACTIBLE. CON VALOR ME REFIERO AL INPUT ENTERO O MAS ADELANTE AL PRIMER Y TERCER CHAR
		        
		        System.out.println("Que desea hacer con esta casilla? [Formato]-> F/D: ");
		        action = reader.nextLine(); //APLICAR FUNCION COMPROBADORA Y QUE EXTRAIGA EL INT
		        
		        if(action=="F") {
		        	exists=board.setFlag(pos.charAt(0), pos.charAt(2));
		        	if(exists) player.increaseFlagNum();
		        	else player.decreaseFlagNum();
		        	System.out.println("Bandera puesta!\n");
		        }
		        else if(action=="D") {
		        uncovered= board.uncoverPosition(pos.charAt(0), pos.charAt(2));
		       
		        if(uncovered==-1) {
		        	itsPossibleToPlay=false;
		        	System.out.println("BOOM! Has perdido.\n");
		        } else {
		        	player.increaseScore(uncovered); //COMPROBAR SI YA ESTAN TODAS DESTAPADAS
		        	System.out.println("Casilla/s destapada/s!\n");
		        }
		        
		        }
		        
		        System.out.println("Tu puntuacion és: "+player.getScore());
		        visuals.DrawBoard(board);
	         }
	         while ( itsPossibleToPlay== true );

	    }

}
