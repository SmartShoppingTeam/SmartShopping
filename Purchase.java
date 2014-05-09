import java.util.*;
import java.io.Serializable;

class Purchase implements Serializable{
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
	public int getEnvironmenEffect() {
		return environmentEffect;
	}

	public Date getDate() {
		return date.getTime();
	}
}