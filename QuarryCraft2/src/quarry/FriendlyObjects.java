package quarry;
import java.awt.Graphics2D;
import java.awt.Image;
import jgame.GObject;
import jgame.GSprite;
import quarry.HP;


public abstract class FriendlyObjects extends GSprite {
	private double maxHealth;
	private double currentHealth;
	private HP hb = new HP();
	private GObject object;
	
	public FriendlyObjects(Image image, double maxHlth) {
		maxHealth = maxHlth;
		currentHealth = maxHealth;
		hb.setWidth(getWidth());
		addAtCenter(hb);
		hb.setY(this.getHeight() - hb.getHeight() / 2);
		hb.setHealthPercentage(1);
		double slowness = getSlowness();
	}

	public abstract double getSlowness();

	@Override
	public void preparePaint(Graphics2D g) {
		super.preparePaint(g);
		GObject.antialias(g);
		goodImageTransforms(g);
	}

	public double getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(double currentHealth) {

		this.currentHealth = currentHealth;
		hb.setHealthPercentage(this.currentHealth / maxHealth);
		if (currentHealth <= 0) {
			this.removeSelf();
		}
	}
}
