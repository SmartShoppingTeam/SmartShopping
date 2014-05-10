import javax.swing.*;
import java.awt.*;
import java.util.*;

public abstract class GraphPanel extends JPanel{
	private ArrayList<Purchase> purchases;
	private String desc;
	Font font;
	public GraphPanel(UserData userData, String desc) {
		this.purchases = userData.getPurchases();
		this.desc = desc;
		setPreferredSize(new Dimension(400, 400));
		setMinimumSize(new Dimension(400, 400));
		font = new Font("Comic Sans MS Bold", 10, 20);
	} 

	public void paintComponent(Graphics g) {
		g.setFont(font);
		int x = 0, y = getHeight();
		super.paintComponent(g);
			for(int i = 0; i < purchases.size(); i++) {
				int newX = scaleX(purchases.get(i).getDate().getTime());
				int newY = getHeight() - calculateYCoord(purchases.get(i));
				g.drawLine(x, y, newX, newY);
				g.fillOval(newX-3, newY-3, 6, 6);
				x = newX;
				y = newY;
			}
		g.drawString(desc, 5, 30);
		g.drawString("Time", getWidth() - 50, getHeight() - 10);
		repaint();
	}

	public int scaleX(long in) {
		in -= purchases.get(0).getDate().getTime();
		long divisor = (purchases.get(purchases.size() - 1).getDate().getTime() - purchases.get(0).getDate().getTime()) / (getWidth() - 50);
		in /= (divisor + 1);
		return (int)in + 30;
	}

	public static int scaleXTest(long in) {
		in -= 10000;
		long divisor = 1000000000 / 100;
		in /= divisor;
		return (int)in;
	}

	public abstract int calculateYCoord(Purchase purchase);

	public static void main(String[] args) {
		System.out.println(scaleXTest(500000000));
	}
}