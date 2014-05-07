import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserGenerator {
	public static void saveUserToFile(UserData user, String userName) throws IOException{
		File file = new File(userName + ".usr");
		file.createNewFile();
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
		stream.writeObject(user);
		stream.close();
	}

	public static void main(String[] args) {
		// Todo: Do stuffles
	}
}