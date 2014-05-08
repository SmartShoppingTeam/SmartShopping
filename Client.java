
import java.io.IOException;






public class Client {
	public static void main(String[] args) {
		Client client = new Client();
		client.run();
		
	} protected Client() {
		keyboard = new KeyboardReader();
		connServ = new ConnectionToServer(getIpAddr(), getPortNumb());
		
		
	} protected void run() {
		userdata = connServ.run();
		System.out.println(userdata);		
	}
	
	/**
	 * 
	 */
	private UserData userdata;
	private KeyboardReader keyboard;
	private ConnectionToServer connServ;
	
	
	
	
	/**
	 * Prints an error message saying that something went wrong and
	 * that the program will force shutdown then it 
	 * shuts down the program.
	 */
	private void forceShutdown() {
		System.err.println("Something went wrong!" + "\n" +
				"Forcing a Shutdown!!!");
		System.exit(1);
	}
	
	
	/**
	 * Asks the user to type in the ip address and
	 * then returns the input in the form of a string.
	 */
	private String getIpAddr() {
		System.out.println("Type in the ip address to the server");
		String ipAddr = "";
		try {
			ipAddr = keyboard.stringLine();
		} catch (IOException e) {
			forceShutdown();
		}
		return ipAddr;
	}
	
	/**
	 * Asks the user to type in the port number and
	 * then returns the input in the form of a integer.
	 */
	private int getPortNumb() {
		System.out.println("Type in the port number to the server");
		int portNumb = 0;
		try {
			portNumb = Integer.parseInt(keyboard.stringLine());
		} catch (IOException e) {
			forceShutdown();
		}
		return portNumb;
	}
	
	

}
