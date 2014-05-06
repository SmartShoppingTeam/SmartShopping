import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class ConnectToServer {
	protected ConnectToServer(String ipAddr, int portNumb) {
//		userdata = new Userdata();
		login = new UserLogin();
//		keyboard = new KeyboardReader();
		establishConnection(ipAddr, portNumb);
		try {
			if(! validateUser(login.run())) {
				closeConnectionAndExit();
			}
		} catch (IOException e) {
			System.err.print("Couldn't Validate User" + "\n");
//			+ "Shutting Down");
//			System.exit(1);
			forceShutdown();
		}
	} protected Userdata run() {
		userdata = receiveObject();
		closeConnection();
		return userdata;
	}
	
	/**
	 * 
	 */
	private Userdata userdata;
	private UserLogin login;
//	private KeyboardReader keyboard;
	
		
	private Socket conn;
	private BufferedReader in;
	private PrintWriter out;
	private ObjectInputStream objIn;
		
	
	
	/**
	 * Tries to connect to the server while the user socket is not connected.
	 * Initializes all of the transmit and receive commands.
	 * Catches exception if no host was found or IOException. 	 
	 */
	private void establishConnection(String ipAddr, int portNumb) {
		while(! conn.isConnected()) {
			try {
				conn = new Socket(ipAddr, portNumb);
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				out = new PrintWriter(conn.getOutputStream());
				objIn = new ObjectInputStream(conn.getInputStream());
			} catch (UnknownHostException e) {
	            System.err.println("Don't know about host " + ipAddr);
	            System.exit(1);
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to " + ipAddr);
	            System.exit(1);
	        }
		}
	}
	
	/**
	 * Closes the socket and then shuts down the program.
	 * (Don't use for FORCED SHUTDOWN)
	 */
	private void closeConnectionAndExit() {
		try {
			conn.close();
		} catch (IOException e) {
			forceShutdown();
		}
		System.exit(0);
	}
	
	/**
	 * Closes the socket and then shuts down the program.
	 * (Don't use for FORCED SHUTDOWN)
	 */
	private void closeConnection() {
		try {
			conn.close();
		} catch (IOException e) {
			forceShutdown();
		}		
	}
	
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
	 * Sends the server the userID and receives either
	 *  - VU = Valid User
	 *  or
	 *  - NVU = Not Valid User
	 *  if neither of those answers are received it ....
	 */
	private boolean validateUser(String userID) {
		out.println("userID: " + userID);
		String answer = "";
		
		try {
			answer = in.readLine();
			
			if (answer.equals("VU")) {	// VU = Valid User
				return true;
			} else if (answer.equals("NVU")) {	// NVU = Not Valid User
				return false;
			} else {
				// Do Something TODO
				// Mabye error msg and system exit. 
			}
		} catch (IOException e) {
			forceShutdown();
		}
		
		/*if (answer.equals("VU")) {	// VU = Valid User
			return true;
		} else if (answer.equals("NVU")) {	// NVU = Not Valid User
			return false;
		} else {
			// Do Something TODO
			// Mabye error msg and system exit. 
		}*/		
		
		return false;
	}
	
	/**
	 * Tries to receive an object sent over the socket.
	 */
	private Userdata receiveObject() {
		Userdata userdataTemp = null;
		try {
			userdataTemp = (Userdata) objIn.readObject();
		} catch (ClassNotFoundException e) {
			forceShutdown();
		} catch (IOException e) {
			forceShutdown();
		}
		return userdataTemp;
	}
	
	

}
