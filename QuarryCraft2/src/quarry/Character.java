package quarry;

import java.awt.Graphics2D;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.Interpolation;
import jgame.controller.MovementTween;
import jgame.controller.ScaleTween;
import jgame.listener.HitTestListener;
import quarry.QCraft2.View;
import enemy.Enemies;

public class Character extends GSprite {
	private double maxHealth;
	private double currentHealth;
	private HP hb = new HP();
	private GObject object;

	public Character() {
		
		super(ImageCache.getSequentialImages("HeroSequence/h", 1, 20,
				".png"));
		PlatformController klc = new PlatformController(
				PlatformControlScheme.WASD, -10, -20, 3);
		addController(klc);
	
		
		


		maxHealth = 1000;
		currentHealth = maxHealth;
		hb.setWidth(getWidth());
		addAtCenter(hb);
		hb.setY(this.getHeight() - hb.getHeight() / 2);
		hb.setHealthPercentage(1);
		
		double slowness = getSlowness();

		HitTestListener htl = new HitTestListener(Enemies.class) {

			@Override
			public void invoke(GObject target, Context context) {
				List<Enemies> enemies = context.hitTestClass(Enemies.class);
				for (Enemies e : enemies)
				
					e.removeSelf();
			}
		};
		addListener(htl);
		
		
		HitTestListener htk = new HitTestListener(NextSlide.class) {

			@Override
			public void invoke(GObject target, Context context) {
				List<NextSlide> wallSlide = context.hitTestClass(NextSlide.class);
				for (NextSlide e : wallSlide)
					context.setCurrentGameView(View.NEXTSLIDE);
			}
		};
		addListener(htk);

	}

	public double getSlowness() {
		return 0;
	}

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
