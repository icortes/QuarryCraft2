package enemy;
import quarry.Character;
import quarry.QCraft2;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import quarry.EnemyPlatformControlScheme;
import quarry.EnemyPlatformControler;
import quarry.HP;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.SoundManager;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.HitTestListener;

public abstract class Enemies extends GSprite {
	
	private double bd;
	private double maxHealth;
	private double currentHealth;
	private HP hb = new HP();
	private GObject object;

	public Enemies(List<Image> list, double maxHlth, double bulletDamage) {
		super(list);
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
		bd = bulletDamage;
		addListener(new BoundaryRemovalListener());
		HitTestListener htl = new HitTestListener(Character.class) {

			@Override
			public void invoke(GObject target, Context context) {
				List<Character> chara = context.hitTestClass(Character.class);
				for(Character e : chara)
					e.setCurrentHealth(e.getCurrentHealth() - bd);
					target.removeSelf();
            }
		};
		addListener(htl);
		
		
		
	}

	public abstract double getSlowness();

	@Override
	public void preparePaint(Graphics2D g) {
		super.preparePaint(g);
		GObject.antialias(g);
		goodImageTransforms(g);
	}

	public double getCurrrentHealth() {
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
