import javax.swing.*;
import java.util.*;
import java.awt.*;

public class GraphFrame extends JFrame {
	public GraphFrame(UserData data) {
		super("Smart Shopper");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);

		GraphPanel pan = new GraphPanel(data, "Environmental effect") {
			public int calculateYCoord(Purchase purchase) {
				double divisor = (double)purchase.getEnvironmentEffect() / (getHeight() + 1);
				return (int)(50 + purchase.getEnvironmentEffect() / (divisor + 1));
			}
		};

		GraphPanel pan2 = new GraphPanel(data, "Cost of purchase") {
			public int calculateYCoord(Purchase purchase) {
				double divisor = (double)purchase.getAmount() / (getHeight() -50);
				return (int)(purchase.getAmount() / (divisor + 1));
			}
		};
		JSplitPane pane = new JSplitPane();
		pane.setLeftComponent(pan);
		pane.setRightComponent(pan2);
		add(pane);
		revalidate();
	}

	public static void main(String[] args) {
		UserData data = new UserData();
		Calendar time = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		Calendar time3 = Calendar.getInstance();
		Calendar time4 = Calendar.getInstance();
		Calendar time5 = Calendar.getInstance();
		Calendar time6 = Calendar.getInstance();
		data.addPurchase(new Purchase(400, 30, time));
		time2.set(2011, 11, 1);
		data.addPurchase(new Purchase(4000, 5, time2));
		time3.set(2012, 6, 5);
		data.addPurchase(new Purchase(800, 50, time3));
		time4.set(2014, 6, 5);
		data.addPurchase(new Purchase(8000, 100, time4));
		time5.set(2018, 7, 5);
		data.addPurchase(new Purchase(15, 10, time5));
		time6.set(2024, 6, 5);
		data.addPurchase(new Purchase(800, 88, time6));

		GraphFrame frame = new GraphFrame(data);
		
	}
}