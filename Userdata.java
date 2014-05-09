import java.io.Serializable;
import java.util.*;

public class UserData implements Serializable {
	public ArrayList<Purchase> purchases;

	public UserData() {
		this.purchases = new ArrayList<Purchase>();
	}
	public void addPurchase(Purchase p) {
		purchases.add(p);
		Collections.sort(purchases);
	}

	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}
}