import java.io.*;
import java.net.*;

public class Server extends ServerSocket {
	Socket client;
	/**
	* Creates a Server that listens on portnumber
	*/
	public Server(int portnumber) throws IOException{
		super(portnumber);
		client = accept();
		boolean failed = true;
		while(failed) {
			String req = listenForRequest(); // We wait for a value from client.
			failed = sendUser(readUserData(req));
		}
		try {
			Thread.sleep(20000);
		} catch(InterruptedException e) {
			System.exit(0);
		}
		close();
	}

	/**
	* Waits for client to send a request.
	* @return The request sent by client.
	*/
	private String listenForRequest() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		return reader.readLine();
	}

	/**
	* Sends a UserData object to the client. If user is null an error message will be sent.
	* @return Whether or not user is null.
	*/
	private boolean sendUser(UserData user) throws IOException{
		ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
		if(user != null) {
			out.writeObject(user);
			return true;
		}
		out.writeObject("User does not exist");
		return false;
	}

	/**
	* Reads UserData from a file with 
	*/
	private UserData readUserData(String username) {
		UserData user = null;
		try {
			ObjectInputStream readFromFile = new ObjectInputStream(new FileInputStream(username + ".txt"));
			user = (UserData)readFromFile.readObject();
			readFromFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static void main(String[] args) {
		try {
			new Server(8080);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}