




import java.io.IOException;



public class UserLogin {
	protected UserLogin() {
		keyboard = new KeyboardReader();
		
	} protected String run() throws IOException {
		System.out.println("Hello!");
		System.out.println("Type in your username.");
		String username = keyboard.stringLine();
		System.out.println("Type in your password.");
		String password = keyboard.stringLine();
		return hashUserdata(username, password);
	} 
	
	/**
	 * 
	 */
	private KeyboardReader keyboard;
	
	
	/**
	 * Creates a key by combining the users username and password.
	 * Returns it in the form of a string.
	 */	
	private String hashUserdata(String username, String password) {		
		return Integer.toString((username+password).hashCode());
	}	
}
