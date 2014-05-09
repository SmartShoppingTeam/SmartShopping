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
			addPurchase(me, 200, 110, 2014, 1, 2);
			addPurchase(me, 230, 333, 2011, 3, 18);
			addPurchase(me, 20, 131, 2012, 4, 26);
			addPurchase(me, 100, 99, 2019, 9, 4);
			addPurchase(me, 900, 374, 2000, 7, 3);
			addPurchase(me, 250, 34, 2003, 2, 6);
			addPurchase(me, 90, 86, 2020, 11, 11);
			addPurchase(me, 330, 67, 2010, 0, 13);
			addPurchase(me, 299, 123, 2012, 8, 15);
			addPurchase(me, 223, 98, 2011, 7, 27);
			addPurchase(me, 145, 36, 2013, 4, 19);
			addPurchase(me, 123, 200, 2014, 3, 3);
			addPurchase(me, 29, 1, 2014, 0, 29);

			saveUserToFile(me, "PiratPelle", "sudd");
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