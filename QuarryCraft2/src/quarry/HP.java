package quarry;

import java.awt.Color;
import java.awt.Graphics2D;

import jgame.GObject;

public class HP extends GObject {
	private static final int BORDER = 3;
	private double healthPercentage = 1;

	public HP() {
		this.setSize(50, 10);

	}

	@Override
	public void paint(Graphics2D g) {

		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getIntWidth(), getIntHeight());

		float hbHue = (float) Math.pow(healthPercentage, 2) / 3f;
		g.setColor(Color.getHSBColor(hbHue, .6f, .7f));
		g.fillRect(BORDER, BORDER,
				(int) ((getWidth() * healthPercentage) - BORDER * 2),
				getIntHeight() - BORDER * 2);
	}

	public void setHealthPercentage(double healthPercentage) {
		this.healthPercentage = healthPercentage;
	}

	public double getHealthPercentage() {
		return healthPercentage;
	}
}

