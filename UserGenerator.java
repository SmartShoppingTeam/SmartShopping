import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserGenerator {
	public static void saveUserToFile(UserData user, String userName, String password) throws IOException{
		File file = new File(UserLogin.hashUserdata(userName, password) + ".usr");
		file.createNewFile();
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
		stream.writeObject(user);
		stream.close();
	}

	public static void main(String[] args) {
		try {
			UserData me = new UserData();
			saveUserToFile(me, "God King Zorblax", "password123");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	
}