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

	public int getAmount() {
		return amount;
	}

	public int getEnvironmenEffect() {
		return environmentEffect;
	}

	public Date getDate() {
		return date.getTime();
	}

}