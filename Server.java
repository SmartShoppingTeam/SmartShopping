import java.io.*;
import java.net.*;

public class Server extends ServerSocket {
	Socket client;
	private ObjectOutputStream out;
	/**
	* Creates a Server that listens on portnumber
	*/
	public Server(int portnumber) throws IOException{
		super(portnumber);
		client = accept();
		out = new ObjectOutputStream(client.getOutputStream());
		System.out.println("Connected to user");
		boolean failed = true;
		while(failed) {
			String req = listenForRequest(); // We wait for a value from client.
			System.out.println("Sending user");
			failed = sendUser(readUserDataFromFile(req));
		}
		try {
			Thread.sleep(20000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Session complete, shutting down.");
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
		System.out.println("Sending user: " + user);
		if(user != null) {
			out.writeObject("VU");
			out.flush();
			out.writeObject(user);
			out.flush();
			return false;
		}
		out.writeObject("NVU");
		return true;
	}

	/**
	* Reads UserData from a file with 
	*/
	private UserData readUserDataFromFile(String userhash) {
		userhash = userhash.replace("userID: ", "");
		UserData user = null;
		try {
			ObjectInputStream readFromFile = new ObjectInputStream(new FileInputStream(new File("UserData" + File.separator + userhash + ".usr")));
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