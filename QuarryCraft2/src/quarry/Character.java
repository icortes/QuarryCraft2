package quarry;

import java.util.List;

import quarry.PlatformControlScheme;
import quarry.PlatformController;
import quarry.SolidGround;
import soil.Soil;
import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ControlScheme;
import jgame.controller.KeyboardLocationController;
import jgame.listener.HitTestListener;
import jgame.listener.ParentBoundsListener;

public class Character extends GSprite {
	public Character() {
		super(ImageCache.forClass(QCraft2.class).get("hero.png"));

		PlatformController klc = new PlatformController(
				PlatformControlScheme.WASD, -10, -20, 3);
		addController(klc);
		 
		
	}
}
