package enemy;

import quarry.Character;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import quarry.HP;
import quarry.SolidGround;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.listener.LocalClickListener;

public abstract class Enemies extends GSprite {

	private double maxHealth;
	private double currentHealth;
	private HP hb = new HP();
	private GObject object;

	public Enemies(Image image, double maxHlth) {
		super(image);
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

	public void controlObject(GObject target, Context context) {
		// Ensure that this is locked to one object
		if (object == null) {
			object = target;
		} else if (object != target) {
			throw new IllegalArgumentException(
					"This PlatformController already belongs to " + object);
		}
		boolean onSolidGround = false;

		List<SolidGround> solidGrounds = context
				.getInstancesOfClass(SolidGround.class);

		for (SolidGround solidGround : solidGrounds) {

			GObject groundObject = (GObject) solidGround;
			if (target.hitTest(groundObject)) {
				onSolidGround = true;
				break;
			}
			if (onSolidGround) {
				List<Character> enemies = context
						.getInstancesOfClass(Character.class);
				double minimumDistance = Integer.MAX_VALUE;
				Character closest = null;

				for (Character e : enemies) {
					double d = e.distanceTo(target);
					if (d < minimumDistance) {
						minimumDistance = d;
						closest = e;
					}
				}
				if (closest != null) {
					target.face(closest);

				}

			}
		}
	}
}
