package PracticaTest;

import java.util.Scanner;

public interface inputIO {

	Scanner reader = new Scanner(System.in);
	
	private String getKeyboardInput() {
		return reader.nextLine(); 
	}
	

}
