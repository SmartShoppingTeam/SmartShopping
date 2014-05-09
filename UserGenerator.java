import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class UserGenerator {
	public static void saveUserToFile(UserData user, String userName, String password) throws IOException{
		File file = new File("UserData" + File.separator + UserLogin.hashUserdata(userName, password) + ".usr");
		file.createNewFile();
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
		stream.writeObject(user);
		stream.close();
	}

	public static void main(String[] args) {
		try {
			UserData me = new UserData();
			me.addPurchase(new Purchase(500, 20, Calendar.getInstance()));
			saveUserToFile(me, "PiratPelle", "sudd");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	
}