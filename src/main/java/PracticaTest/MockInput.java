package PracticaTest;

public class MockInput implements inputIO {

	String[] usrInput;
	int index = 0;
	
	MockInput (String[] UserInputs) {
		this.usrInput = UserInputs;
	}
	
	@Override
	public String getKeyboardInput() {
		
		String str = usrInput[index];
		index++;
		return str;
		
	}
	
}
