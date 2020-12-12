package PracticaTest;

public class InputUser implements inputIO {

	@Override
	public String getKeyboardInput() {
		return reader.nextLine(); 
	}

}
