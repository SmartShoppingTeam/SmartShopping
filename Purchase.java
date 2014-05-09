import java.util.*;
import java.io.Serializable;

class Purchase implements Serializable, Comparable{
	private int amount;
	private int environmentEffect;
	private Calendar date;

	public Purchase(int amount, int environmentEffect, Calendar date) {
		this.amount = amount;
		this.environmentEffect = environmentEffect;
		this.date = date;
	}

	/**
	* @return The cost of the purchase
	*/
	public int getAmount() {
		return amount;
	}

	/**
	* @return An indicator of environmental effect of this purchase.
	*/
	public int getEnvironmentEffect() {
		return environmentEffect;
	}

	public Date getDate() {
		return date.getTime();
	}

	@Override
	public int compareTo(Object other) {
		if(other instanceof Purchase) {
			// int temp = (int)(-((Purchase)other).getDate().getTime() + getDate().getTime());
			// System.out.println(((Purchase)(other)).getDate().toString());
			// System.out.println(getDate().toString());
			// System.out.println(temp);
			// return temp;
			long l = ((Purchase)other).getDate().getTime();
			return new Long(getDate().getTime()).compareTo(new Long(l));
		}
		System.out.println("hey");
		return 0; // Bad things happens. 
	}
}