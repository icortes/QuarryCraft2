package enemy;


import java.awt.Graphics2D;
import java.awt.Image;
import quarry.EnemyPlatformControlScheme;
import quarry.EnemyPlatformControler;
import quarry.HP;
import jgame.GObject;
import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;

public abstract class Enemies extends GSprite {

	private double maxHealth;
	private double currentHealth;
	private HP hb = new HP();
	private GObject object;

	public Enemies(Image image, double maxHlth) {
		super(image);
		maxHealth = maxHlth;
		currentHealth = maxHealth;

		EnemyPlatformControler klc = new EnemyPlatformControler(
				EnemyPlatformControlScheme.ARROWS_SPACE, -1, -10, 3);
		addController(klc);
		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		addListener(brl);
		
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
