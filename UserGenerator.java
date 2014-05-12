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
			addPurchase(me, 200, 401, 2014, 1, 2);
			addPurchase(me, 23, 333, 2011, 3, 18);
			addPurchase(me, 520, 603, 2012, 4, 26);
			addPurchase(me, 10, 30, 2007, 9, 4);
			addPurchase(me, 90, 37, 2000, 7, 3);
			addPurchase(me, 25, 50, 2003, 2, 6);
			addPurchase(me, 190, 40, 2002, 11, 11);
			addPurchase(me, 33, 20, 2010, 0, 13);
			addPurchase(me, 29, 350, 2012, 8, 15);
			addPurchase(me, 23, 302, 2011, 7, 27);
			addPurchase(me, 15, 360, 2013, 4, 19);
			addPurchase(me, 12, 153, 2014, 3, 3);

			saveUserToFile(me, "Simple", "Mordor");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	

	private static void addPurchase(UserData data, int cost, int envImpact, int year, int month, int day) {
		Calendar time = Calendar.getInstance();
		time.set(year, month, day);
		data.addPurchase(new Purchase(cost, envImpact, time));
	}
}