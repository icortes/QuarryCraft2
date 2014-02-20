package quarry;

import java.util.List;

import enemy.Enemies;
import quarry.PlatformControlScheme;
import quarry.PlatformController;
import quarry.QCraft2.View;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.HitTestListener;
import jgame.listener.ParentBoundsListener;

public class Character extends GSprite {
	public Character() {
		super(ImageCache.forClass(QCraft2.class).get("hero.png"));

		PlatformController klc = new PlatformController(
				PlatformControlScheme.WASD, -10, -20, 3);
		addController(klc);

		HitTestListener htl = new HitTestListener(Enemies.class) {

			@Override
			public void invoke(GObject target, Context context) {
				List<Enemies> enemies = context.hitTestClass(Enemies.class);
				for (Enemies e : enemies)
					target.removeSelf();
			}
		};
		addListener(htl);

	}

}
