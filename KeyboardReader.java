



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KeyboardReader {
	protected KeyboardReader() {
		keyboardInput = new BufferedReader(new InputStreamReader(System.in));		
		
	} protected void run() {
		// Does nothing at the moment TODO
	}
	
	/**
	 * 
	 */
	private BufferedReader keyboardInput;
	
	/**
	 * Prints out:
	 * > 
	 * It's the marker showing the user an input is available.
	 */
	private void printInputSymbol() {
		System.out.print("> ");
	}
	
	/**
	 * Prints out printOutInputSymbol, then reads the user input and
	 * returns it in the form of a string.
	 */
	protected String stringLine() throws IOException {
		printInputSymbol();
		return keyboardInput.readLine();
	}
	
	

}
